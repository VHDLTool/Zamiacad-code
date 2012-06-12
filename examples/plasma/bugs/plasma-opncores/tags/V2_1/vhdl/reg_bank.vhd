---------------------------------------------------------------------
-- TITLE: Register Bank
-- AUTHOR: Steve Rhoads (rhoadss@yahoo.com)
-- DATE CREATED: 2/2/01
-- FILENAME: reg_bank.vhd
-- PROJECT: Plasma CPU core
-- COPYRIGHT: Software placed into the public domain by the author.
--    Software 'as is' without warranty.  Author liable for nothing.
-- DESCRIPTION:
--    Implements a register bank with 32 registers that are 32-bits wide.
--    There are two read-ports and one write port.
---------------------------------------------------------------------
library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_unsigned.all;
use work.mlite_pack.all;

entity reg_bank is
   generic(memory_type : string := "GENERIC");
   port(clk            : in  std_logic;
        reset_in       : in  std_logic;
        pause          : in  std_logic;
        rs_index       : in  std_logic_vector(5 downto 0);
        rt_index       : in  std_logic_vector(5 downto 0);
        rd_index       : in  std_logic_vector(5 downto 0);
        reg_source_out : out std_logic_vector(31 downto 0);
        reg_target_out : out std_logic_vector(31 downto 0);
        reg_dest_new   : in  std_logic_vector(31 downto 0);
        intr_enable    : out std_logic);
end; --entity reg_bank


--------------------------------------------------------------------
-- The ram_block architecture attempts to use TWO dual-port memories.
-- Different FPGAs and ASICs need different implementations.
-- Choose one of the RAM implementations below.
-- I need feedback on this section!
--------------------------------------------------------------------
architecture ram_block of reg_bank is
   signal intr_enable_reg : std_logic;
   type ram_type is array(31 downto 0) of std_logic_vector(31 downto 0);
   
   --controls access to dual-port memories
   signal addr_a1, addr_a2, addr_b : std_logic_vector(4 downto 0);
   signal data_out1, data_out2     : std_logic_vector(31 downto 0);
   signal write_enable             : std_logic;
--   signal sig_false                : std_logic := '0';
--   signal sig_true                 : std_logic := '1';
--   signal zero_sig                 : std_logic_vector(15 downto 0) := ZERO(15 downto 0);

begin
  
reg_proc: process(clk, rs_index, rt_index, rd_index, reg_dest_new, 
      intr_enable_reg, data_out1, data_out2, reset_in, pause)
begin
   --setup for first dual-port memory
   if rs_index = "101110" then  --reg_epc CP0 14
      addr_a1 <= "00000";
   else
      addr_a1 <= rs_index(4 downto 0);
   end if;
   case rs_index is
   when "000000" => reg_source_out <= ZERO;
   when "101100" => reg_source_out <= ZERO(31 downto 1) & intr_enable_reg;
   when "111111" => --interrupt vector address = 0x3c 
                    reg_source_out <= ZERO(31 downto 8) & "00111100";
   when others   => reg_source_out <= data_out1;
   end case;

   --setup for second dual-port memory
   addr_a2 <= rt_index(4 downto 0);
   case rt_index is
   when "000000" => reg_target_out <= ZERO;
   when others   => reg_target_out <= data_out2;
   end case;

   --setup second port (write port) for both dual-port memories
   if rd_index /= "000000" and rd_index /= "101100" and pause = '0' then
      write_enable <= '1';
   else
      write_enable <= '0';
   end if;
   if rd_index = "101110" then  --reg_epc CP0 14
      addr_b <= "00000";
   else
      addr_b <= rd_index(4 downto 0);
   end if;

   if reset_in = '1' then
      intr_enable_reg <= '0';
   elsif rising_edge(clk) then
      if rd_index = "101110" then     --reg_epc CP0 14
         intr_enable_reg <= '0';      --disable interrupts
      elsif rd_index = "101100" then
         intr_enable_reg <= reg_dest_new(0);
      end if;
   end if;

   intr_enable <= intr_enable_reg;
end process;


--------------------------------------------------------------
---- Pick only ONE of the dual-port RAM implementations below!
--------------------------------------------------------------

-- synopsys synthesis_off

   -- Option #1
   -- One tri-port RAM, two read-ports, one write-port
   -- 32 registers 32-bits wide
   tri_port_mem:
   if memory_type = "GENERIC" generate
      ram_proc: process(clk, addr_a1, addr_a2, addr_b, reg_dest_new, 
            write_enable)
      variable tri_port_ram : ram_type;
      begin
         data_out1 <= tri_port_ram(conv_integer(addr_a1));
         data_out2 <= tri_port_ram(conv_integer(addr_a2));
         if rising_edge(clk) then
            if write_enable = '1' then
               tri_port_ram(conv_integer(addr_b)) := reg_dest_new;
            end if;
         end if;
      end process;
   end generate; --tri_port_mem


   -- Option #2
   -- Two dual-port RAMs, each with one read-port and one write-port
   -- According to the Xilinx answers database record #4075 this 
   -- architecture may cause Synplify to infer synchronous dual-port 
   -- RAM using RAM16x1D.  
   dual_port_mem:
   if memory_type = "DUAL_PORT" generate
      ram_proc2: process(clk, addr_a1, addr_a2, addr_b, reg_dest_new, 
            write_enable)
      variable dual_port_ram1 : ram_type;
      variable dual_port_ram2 : ram_type;
      begin
         data_out1 <= dual_port_ram1(conv_integer(addr_a1));
         data_out2 <= dual_port_ram2(conv_integer(addr_a2));
         if rising_edge(clk) then
            if write_enable = '1' then
               dual_port_ram1(conv_integer(addr_b)) := reg_dest_new;
               dual_port_ram2(conv_integer(addr_b)) := reg_dest_new;
            end if;
         end if;
      end process;
   end generate; --dual_port_mem

  -- synopsys synthesis_on

  dual_port_mem_coregen:
   if memory_type = "DUAL_PORT_XILINX" generate
     
      reg_file_dp_ram_1: reg_file_dp_ram
        port map (
          addra => addr_a1,
          addrb => addr_b,
          clka  => clk,
          clkb  => clk,
          dinb  => reg_dest_new,
          douta => data_out1,
          web   => write_enable);

      reg_file_dp_ram_2: reg_file_dp_ram
        port map (
          addra => addr_a2,
          addrb => addr_b,
          clka  => clk,
          clkb  => clk,
          dinb  => reg_dest_new,
          douta => data_out2,
          web   => write_enable);

   end generate; --dual_port_mem

   dual_port_mem_xc4000xla: if memory_type = "DUAL_PORT_XILINX_XC4000XLA" generate
     
     reg_file_dp_ram_1: reg_file_dp_ram_xc4000xla
       port map (
         A      => addr_b,
         DI     => reg_dest_new,
         WR_EN  => write_enable,
         WR_CLK => clk,
         DPRA   => addr_a1,
         SPO    => open,
         DPO    => data_out1);
     
     reg_file_dp_ram_2: reg_file_dp_ram_xc4000xla
       port map (
         A      => addr_b,
         DI     => reg_dest_new,
         WR_EN  => write_enable,
         WR_CLK => clk,
         DPRA   => addr_a2,
         SPO    => open,
         DPO    => data_out2);

   end generate; --dual_port_mem

   -- Option #3
   -- Generic Two-Port Synchronous RAM
   -- generic_tpram can be obtained from:
   -- http://www.opencores.org/cvsweb.shtml/generic_memories/
   -- Supports ASICs (Artisan, Avant, and Virage) and Xilinx FPGA
--   generic_mem:
--   if memory_type = "OPENCORES_MEM" generate
--      bank1 : generic_tpram port map (
--         clk_a  => clk,
--         rst_a  => '0',
--         ce_a   => '1',
--         we_a   => '0',
--         oe_a   => '1',
--         addr_a => addr_a1,
--         di_a   => ZERO,
--         do_a   => data_out1,
--
--         clk_b  => clk,
--         rst_b  => '0',
--         ce_b   => '1',
--         we_b   => write_enable,
--         oe_b   => '0',
--         addr_b => addr_b,
--         di_a   => reg_dest_new);
--
--      bank2 : generic_tpram port map (
--         clk_a  => clk,
--         rst_a  => '0',
--         ce_a   => '1',
--         we_a   => '0',
--         oe_a   => '1',
--         addr_a => addr_a2,
--         di_a   => ZERO,
--         do_a   => data_out2,
--
--         clk_b  => clk,
--         rst_b  => '0',
--         ce_b   => '1',
--         we_b   => write_enable,
--         oe_b   => '0',
--         addr_b => addr_b,
--         di_a   => reg_dest_new);
--   end generate; --generic_mem


   -- Option #4
   -- Xilinx mode using four 16x16 banks
--   xilinx_mem:
--   if memory_type = "XILINX" generate
--      bank1_high: ramb4_s16_s16 port map (
--         clka  => clk,
--         rsta  => sig_false,
--         addra => addr_a1,
--         dia   => zero_sig,
--         ena   => sig_true,
--         wea   => sig_false,
--         doa   => data_out1(31 downto 16),
--
--         clkb  => clk,
--         rstb  => sig_false,
--         addrb => addr_b,
--         dib   => reg_dest_new(31 downto 16),
--         enb   => sig_true,
--         web   => write_enable);
--
--      bank1_low: ramb4_s16_s16 port map (
--         clka  => clk,
--         rsta  => sig_false,
--         addra => addr_a1,
--         dia   => zero_sig,
--         ena   => sig_true,
--         wea   => sig_false,
--         doa   => data_out1(15 downto 0),
--
--         clkb  => clk,
--         rstb  => sig_false,
--         addrb => addr_b,
--         dib   => reg_dest_new(15 downto 0),
--         enb   => sig_true,
--         web   => write_enable);
--
--      bank2_high: ramb4_s16_s16 port map (
--         clka  => clk,
--         rsta  => sig_false,
--         addra => addr_a2,
--         dia   => zero_sig,
--         ena   => sig_true,
--         wea   => sig_false,
--         doa   => data_out2(31 downto 16),
--
--         clkb  => clk,
--         rstb  => sig_false,
--         addrb => addr_b,
--         dib   => reg_dest_new(31 downto 16),
--         enb   => sig_true,
--         web   => write_enable);
--
--      bank2_low: ramb4_s16_s16 port map (
--         clka  => clk,
--         rsta  => sig_false,
--         addra => addr_a2,
--         dia   => zero_sig,
--         ena   => sig_true,
--         wea   => sig_false,
--         doa   => data_out2(15 downto 0),
--
--         clkb  => clk,
--         rstb  => sig_false,
--         addrb => addr_b,
--         dib   => reg_dest_new(15 downto 0),
--         enb   => sig_true,
--         web   => write_enable);
--   end generate; --xilinx_mem


   -- Option #5
   -- Altera LPM_RAM_DP
   -- Xilinx users may need to comment out this section!!!
   altera_mem:
   if memory_type = "ALTERA" generate
      lpm_ram_dp_component1 : lpm_ram_dp
      GENERIC MAP (
         lpm_width => 32,
         lpm_widthad => 5,
         rden_used => "FALSE",
         intended_device_family => "UNUSED",
         lpm_indata => "REGISTERED",
         lpm_wraddress_control => "REGISTERED",
         lpm_rdaddress_control => "UNREGISTERED",
         lpm_outdata => "UNREGISTERED",
         use_eab => "ON",
         lpm_type => "LPM_RAM_DP"
      )
      PORT MAP (
         wren => write_enable,
         wrclock => clk,
         data => reg_dest_new,
         rdaddress => addr_a1,
         wraddress => addr_b,
         q => data_out1
      );
      lpm_ram_dp_component2 : lpm_ram_dp
      GENERIC MAP (
         lpm_width => 32,
         lpm_widthad => 5,
         rden_used => "FALSE",
         intended_device_family => "UNUSED",
         lpm_indata => "REGISTERED",
         lpm_wraddress_control => "REGISTERED",
         lpm_rdaddress_control => "UNREGISTERED",
         lpm_outdata => "UNREGISTERED",
         use_eab => "ON",
         lpm_type => "LPM_RAM_DP"
      )
      PORT MAP (
         wren => write_enable,
         wrclock => clk,
         data => reg_dest_new,
         rdaddress => addr_a2,
         wraddress => addr_b,
         q => data_out2
      );
   end generate; --altera_mem

end; --architecture ram_block

