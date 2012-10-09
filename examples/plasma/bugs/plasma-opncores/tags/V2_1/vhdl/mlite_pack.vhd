---------------------------------------------------------------------
-- TITLE: Plasma Misc. Package
-- AUTHOR: Steve Rhoads (rhoadss@yahoo.com)
-- DATE CREATED: 2/15/01
-- FILENAME: mlite_pack.vhd
-- PROJECT: Plasma CPU core
-- COPYRIGHT: Software placed into the public domain by the author.
--    Software 'as is' without warranty.  Author liable for nothing.
-- DESCRIPTION:
--    Data types, constants, and add functions needed for the Plasma CPU.
---------------------------------------------------------------------
library ieee;
use ieee.std_logic_1164.all;

package mlite_pack is
   constant ZERO          : std_logic_vector(31 downto 0) :=
      "00000000000000000000000000000000";
   constant ONES          : std_logic_vector(31 downto 0) :=
      "11111111111111111111111111111111";
   --make HIGH_Z equal to ZERO if compiler complains
   constant HIGH_Z        : std_logic_vector(31 downto 0) :=
      "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";
  
--   type alu_function_type is (alu_nothing, alu_add, alu_subtract, 
--      alu_less_than, alu_less_than_signed, 
--      alu_or, alu_and, alu_xor, alu_nor);
   subtype alu_function_type is std_logic_vector(3 downto 0);
   constant alu_nothing   : alu_function_type := "0000";
   constant alu_add       : alu_function_type := "0001";
   constant alu_subtract  : alu_function_type := "0010";
   constant alu_less_than : alu_function_type := "0011";
   constant alu_less_than_signed : alu_function_type := "0100";
   constant alu_or        : alu_function_type := "0101";
   constant alu_and       : alu_function_type := "0110";
   constant alu_xor       : alu_function_type := "0111";
   constant alu_nor       : alu_function_type := "1000";

--   type shift_function_type is (
--      shift_nothing, shift_left_unsigned,
--      shift_right_signed, do_right_unsigned);
   subtype shift_function_type is std_logic_vector(1 downto 0);
   constant shift_nothing        : shift_function_type := "00";
   constant shift_left_unsigned  : shift_function_type := "01";
   constant shift_right_signed   : shift_function_type := "11";
   constant shift_right_unsigned : shift_function_type := "10";

--   type mult_function_type is (
--      mult_nothing, mult_read_lo, mult_read_hi, mult_write_lo, 
--      mult_write_hi, mult_mult, mult_divide, mult_signed_divide);
   subtype mult_function_type is std_logic_vector(3 downto 0);
   constant mult_nothing       : mult_function_type := "0000";
   constant mult_read_lo       : mult_function_type := "0001";
   constant mult_read_hi       : mult_function_type := "0010";
   constant mult_write_lo      : mult_function_type := "0011";
   constant mult_write_hi      : mult_function_type := "0100";
   constant mult_mult          : mult_function_type := "0101";
   constant mult_signed_mult   : mult_function_type := "0110";
   constant mult_divide        : mult_function_type := "0111";
   constant mult_signed_divide : mult_function_type := "1000";

--   type a_source_type is (from_reg_source, from_imm10_6);
   subtype a_source_type is std_logic_vector(1 downto 0);
   constant a_from_reg_source : a_source_type := "00";
   constant a_from_imm10_6    : a_source_type := "01";
   constant a_from_pc         : a_source_type := "10";

--   type b_source_type is (from_reg_target, from_imm, from_signed_imm);
   subtype b_source_type is std_logic_vector(1 downto 0);
   constant b_from_reg_target : b_source_type := "00";
   constant b_from_imm        : b_source_type := "01";
   constant b_from_signed_imm : b_source_type := "10";
   constant b_from_immX4      : b_source_type := "11";

--   type c_source_type is (from_null, from_alu, from_shift, 
--      from_mult, from_memory, from_pc, from_imm_shift16,
--      from_reg_source_nez, from_reg_source_eqz);
   subtype c_source_type is std_logic_vector(2 downto 0);
   constant c_from_null       : c_source_type := "000";
   constant c_from_alu        : c_source_type := "001";
   constant c_from_shift      : c_source_type := "001"; --same as alu
   constant c_from_mult       : c_source_type := "001"; --same as alu
   constant c_from_memory     : c_source_type := "010";
   constant c_from_pc         : c_source_type := "011";
   constant c_from_pc_plus4   : c_source_type := "100";
   constant c_from_imm_shift16: c_source_type := "101";
   constant c_from_reg_sourcen: c_source_type := "110";

--   type pc_source_type is (from_inc4, from_opcode25_0, from_branch, from_lbranch);
   subtype pc_source_type is std_logic_vector(1 downto 0);
   constant from_inc4       : pc_source_type := "00";
   constant from_opcode25_0 : pc_source_type := "01";
   constant from_branch     : pc_source_type := "10";
   constant from_lbranch    : pc_source_type := "11";

   subtype branch_function_type is std_logic_vector(2 downto 0);
   constant branch_ltz : branch_function_type := "000";
   constant branch_lez : branch_function_type := "001";
   constant branch_eq  : branch_function_type := "010";
   constant branch_ne  : branch_function_type := "011";
   constant branch_gez : branch_function_type := "100";
   constant branch_gtz : branch_function_type := "101";
   constant branch_yes : branch_function_type := "110";

   -- mode(32=1,16=2,8=3), signed, write
   subtype mem_source_type is std_logic_vector(3 downto 0);
   constant mem_fetch   : mem_source_type := "0000";
   constant mem_read32  : mem_source_type := "0100";
   constant mem_write32 : mem_source_type := "0101";
   constant mem_read16  : mem_source_type := "1000";
   constant mem_read16s : mem_source_type := "1010";
   constant mem_write16 : mem_source_type := "1001";
   constant mem_read8   : mem_source_type := "1100";
   constant mem_read8s  : mem_source_type := "1110";
   constant mem_write8  : mem_source_type := "1101";

   function bv_to_integer(bv: in std_logic_vector) return integer;
   function bv_adder(a     : in std_logic_vector(32 downto 0);
                     b     : in std_logic_vector(32 downto 0);
                     do_add: in std_logic) return std_logic_vector;
   function bv_adder_lookahead(
                     a     : in std_logic_vector(32 downto 0);
                     b     : in std_logic_vector(32 downto 0);
                     do_add: in std_logic) return std_logic_vector;
   function bv_negate(a : in std_logic_vector) return std_logic_vector;
   function bv_increment(a : in std_logic_vector(31 downto 2)
                     ) return std_logic_vector;
   function bv_inc6(a : in std_logic_vector
                     ) return std_logic_vector;

   -- For Altera
   COMPONENT lpm_add_sub
      GENERIC (
         lpm_width     : NATURAL;
         lpm_direction : STRING := "UNUSED";
         lpm_type      : STRING;
         lpm_hint      : STRING);
      PORT (
         dataa   : IN STD_LOGIC_VECTOR (lpm_width-1 DOWNTO 0);
         add_sub : IN STD_LOGIC ;
         datab   : IN STD_LOGIC_VECTOR (lpm_width-1 DOWNTO 0);
         result  : OUT STD_LOGIC_VECTOR (lpm_width-1 DOWNTO 0));
   END COMPONENT;

   -- For Altera
   COMPONENT lpm_ram_dp
      GENERIC (
         lpm_width        : NATURAL;
         lpm_widthad      : NATURAL;
         rden_used        : STRING;
         intended_device_family	: STRING;
         lpm_indata       : STRING;
         lpm_wraddress_control		: STRING;
         lpm_rdaddress_control		: STRING;
         lpm_outdata      : STRING;
         use_eab          : STRING;
         lpm_type         : STRING);
      PORT (
         wren      : IN STD_LOGIC ;
         wrclock   : IN STD_LOGIC ;
         q         : OUT STD_LOGIC_VECTOR (lpm_width-1 DOWNTO 0);
         data      : IN STD_LOGIC_VECTOR (lpm_width-1 DOWNTO 0);
         rdaddress : IN STD_LOGIC_VECTOR (lpm_widthad-1 DOWNTO 0);
         wraddress : IN STD_LOGIC_VECTOR (lpm_widthad-1 DOWNTO 0));
   END COMPONENT;

   -- For Altera
   component LPM_RAM_DQ
      generic (
         LPM_WIDTH    : natural;    -- MUST be greater than 0
         LPM_WIDTHAD  : natural;    -- MUST be greater than 0
         LPM_NUMWORDS : natural := 0;
         LPM_INDATA   : string := "REGISTERED";
         LPM_ADDRESS_CONTROL: string := "REGISTERED";
         LPM_OUTDATA  : string := "REGISTERED";
         LPM_FILE     : string := "UNUSED";
         LPM_TYPE     : string := "LPM_RAM_DQ";
         USE_EAB      : string := "OFF";
         INTENDED_DEVICE_FAMILY  : string := "UNUSED";
         LPM_HINT     : string := "UNUSED");
		port (
         DATA     : in std_logic_vector(LPM_WIDTH-1 downto 0);
         ADDRESS  : in std_logic_vector(LPM_WIDTHAD-1 downto 0);
         INCLOCK  : in std_logic := '0';
         OUTCLOCK : in std_logic := '0';
         WE       : in std_logic;
         Q        : out std_logic_vector(LPM_WIDTH-1 downto 0));
   end component;

   -- For Xilinx
   component ramb4_s16_s16
      port (
         clka  : in std_logic;
         rsta  : in std_logic;
         addra : in std_logic_vector;
         dia   : in std_logic_vector;
         ena   : in std_logic;
         wea   : in std_logic;
         doa   : out std_logic_vector;

         clkb  : in std_logic;
         rstb  : in std_logic;
         addrb : in std_logic_vector;
         dib   : in std_logic_vector;
         enb   : in std_logic;
         web   : in std_logic);
   end component;

   -- For Xilinx
   component reg_file_dp_ram
     port (
       addra : IN  std_logic_VECTOR(4 downto 0);
       addrb : IN  std_logic_VECTOR(4 downto 0);
       clka  : IN  std_logic;
       clkb  : IN  std_logic;
       dinb  : IN  std_logic_VECTOR(31 downto 0);
       douta : OUT std_logic_VECTOR(31 downto 0);
       web   : IN  std_logic);
   end component;

   -- For Xilinx
   component reg_file_dp_ram_xc4000xla
     port (
       A      : IN  std_logic_vector(4 DOWNTO 0);
       DI     : IN  std_logic_vector(31 DOWNTO 0);
       WR_EN  : IN  std_logic;
       WR_CLK : IN  std_logic;
       DPRA   : IN  std_logic_vector(4 DOWNTO 0);
       SPO    : OUT std_logic_vector(31 DOWNTO 0);
       DPO    : OUT std_logic_vector(31 DOWNTO 0));
   end component;
   
   component pc_next
      port(clk          : in std_logic;
           reset_in     : in std_logic;
           pc_new       : in std_logic_vector(31 downto 2);
           take_branch  : in std_logic;
           pause_in     : in std_logic;
           opcode25_0   : in std_logic_vector(25 downto 0);
           pc_source    : in pc_source_type;
           pc_out       : out std_logic_vector(31 downto 0);
           pc_out_plus4 : out std_logic_vector(31 downto 0));
   end component;

   component mem_ctrl
      generic(ACCURATE_TIMING : boolean := false);
      port(clk          : in std_logic;
           reset_in     : in std_logic;
           pause_in     : in std_logic;
           nullify_op   : in std_logic;
           address_pc   : in std_logic_vector(31 downto 0);
           opcode_out   : out std_logic_vector(31 downto 0);

           address_data : in std_logic_vector(31 downto 0);
           mem_source   : in mem_source_type;
           data_write   : in std_logic_vector(31 downto 0);
           data_read    : out std_logic_vector(31 downto 0);
           pause_out    : out std_logic;
        
           mem_address  : out std_logic_vector(31 downto 0);
           mem_data_w   : out std_logic_vector(31 downto 0);
           mem_data_r   : in std_logic_vector(31 downto 0);
           mem_byte_sel : out std_logic_vector(3 downto 0);
           mem_write    : out std_logic);
   end component;

   component control 
      port(opcode       : in  std_logic_vector(31 downto 0);
           intr_signal  : in  std_logic;
           rs_index     : out std_logic_vector(5 downto 0);
           rt_index     : out std_logic_vector(5 downto 0);
           rd_index     : out std_logic_vector(5 downto 0);
           imm_out      : out std_logic_vector(15 downto 0);
           alu_func     : out alu_function_type;
           shift_func   : out shift_function_type;
           mult_func    : out mult_function_type;
           branch_func  : out branch_function_type;
           a_source_out : out a_source_type;
           b_source_out : out b_source_type;
           c_source_out : out c_source_type;
           pc_source_out: out pc_source_type;
           mem_source_out:out mem_source_type);
   end component;

   component reg_bank
      generic(memory_type : string := "TRI_PORT");
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
   end component;

   component bus_mux 
      port(imm_in       : in  std_logic_vector(15 downto 0);
           reg_source   : in  std_logic_vector(31 downto 0);
           a_mux        : in  a_source_type;
           a_out        : out std_logic_vector(31 downto 0);

           reg_target   : in  std_logic_vector(31 downto 0);
           b_mux        : in  b_source_type;
           b_out        : out std_logic_vector(31 downto 0);

           c_bus        : in  std_logic_vector(31 downto 0);
           c_memory     : in  std_logic_vector(31 downto 0);
           c_pc         : in  std_logic_vector(31 downto 0);
           c_pc_plus4   : in  std_logic_vector(31 downto 0);
           c_mux        : in  c_source_type;
           reg_dest_out : out std_logic_vector(31 downto 0);

           branch_func  : in  branch_function_type;
           take_branch  : out std_logic);
   end component;

   component alu
      generic(adder_type : string := "GENERIC";
              alu_type   : string := "GENERIC");
      port(a_in         : in  std_logic_vector(31 downto 0);
           b_in         : in  std_logic_vector(31 downto 0);
           alu_function : in  alu_function_type;
           c_alu        : out std_logic_vector(31 downto 0));
   end component;

   component shifter
      generic( shifter_type : string := "GENERIC" );
      port(value        : in  std_logic_vector(31 downto 0);
           shift_amount : in  std_logic_vector(4 downto 0);
           shift_func   : in  shift_function_type;
           c_shift      : out std_logic_vector(31 downto 0));
   end component;

   component mult
     generic (
       adder_type : string := "GENERIC";
       mult_type  : string := "GENERIC"); 
     port (
       clk       : in  std_logic;
       a, b      : in  std_logic_vector(31 downto 0);
       mult_func : in  mult_function_type;
       c_mult    : out std_logic_vector(31 downto 0);
       pause_out : out std_logic); 
   end component;

   component pipeline
      port(clk            : in  std_logic;
           reset          : in  std_logic;
           a_bus          : in  std_logic_vector(31 downto 0);
           a_busD         : out std_logic_vector(31 downto 0);
           b_bus          : in  std_logic_vector(31 downto 0);
           b_busD         : out std_logic_vector(31 downto 0);
           alu_func       : in  alu_function_type;
           alu_funcD      : out alu_function_type;
           shift_func     : in  shift_function_type;
           shift_funcD    : out shift_function_type;
           mult_func      : in  mult_function_type;
           mult_funcD     : out mult_function_type;
           reg_dest       : in  std_logic_vector(31 downto 0);
           reg_destD      : out std_logic_vector(31 downto 0);
           rd_index       : in  std_logic_vector(5 downto 0);
           rd_indexD      : out std_logic_vector(5 downto 0);

           rs_index       : in  std_logic_vector(5 downto 0);
           rt_index       : in  std_logic_vector(5 downto 0);
           pc_source      : in  pc_source_type;
           mem_source     : in  mem_source_type;
           a_source       : in  a_source_type;
           b_source       : in  b_source_type;
           c_source       : in  c_source_type;
           c_bus          : in  std_logic_vector(31 downto 0);
           pause_any      : in  std_logic;
           pause_pipeline : out std_logic);
   end component;

   component mlite_cpu
      generic(memory_type     : string := "ALTERA";
              mult_type       : string := "GENERIC";
              shifter_type    : string := "GENERIC";
              pipeline_stages : natural := 3);
      port(clk         : in std_logic;
           reset_in    : in std_logic;
           intr_in     : in std_logic;

           mem_address : out std_logic_vector(31 downto 0);
           mem_data_w  : out std_logic_vector(31 downto 0);
           mem_data_r  : in std_logic_vector(31 downto 0);
           mem_byte_sel: out std_logic_vector(3 downto 0); 
           mem_write   : out std_logic;
           mem_pause   : in std_logic);
   end component;

   component ram
      generic(memory_type : string := "GENERIC");
      port(clk          : in std_logic;
           mem_byte_sel : in std_logic_vector(3 downto 0);
           mem_write    : in std_logic;
           mem_address  : in std_logic_vector(31 downto 0);
           mem_data_w   : in std_logic_vector(31 downto 0);
           mem_data_r   : out std_logic_vector(31 downto 0));
   end component; --ram

   component uart
      generic(log_file : string := "UNUSED");
      port(clk        : in std_logic;
           reset      : in std_logic;
           uart_sel   : in std_logic;
           data       : in std_logic_vector(7 downto 0);
           uart_read  : in std_logic;
           uart_write : out std_logic;
           pause      : out std_logic);
   end component; --uart

   component plasma
      generic(memory_type : string := "GENERIC";
              log_file    : string := "UNUSED");
      port(clk_in           : in std_logic;
           reset_in         : in std_logic;
           intr_in          : in std_logic;

           uart_read        : in std_logic;
           uart_write       : out std_logic;

           mem_address_out  : out std_logic_vector(31 downto 0);
           mem_data         : out std_logic_vector(31 downto 0);
           mem_byte_sel_out : out std_logic_vector(3 downto 0); 
           mem_write_out    : out std_logic;
           mem_pause_in     : in std_logic);
   end component; --plasma

   component plasma_if
      generic(memory_type : string := "ALTERA";
              log_file    : string := "UNUSED");
      port(clk_in     : in std_logic;
           reset_n    : in std_logic;
           uart_read  : in std_logic;
           uart_write : out std_logic;

           address    : out std_logic_vector(31 downto 0);
           data       : out std_logic_vector(31 downto 0);
           we_n       : out std_logic;
           oe_n       : out std_logic;
           be_n       : out std_logic_vector(3 downto 0);
           sram0_cs_n : out std_logic;
           sram1_cs_n : out std_logic);
   end component; --plasma_if

end; --package mlite_pack

package body mlite_pack is

function bv_to_integer(bv: in std_logic_vector) return integer is
   variable result : integer;
   variable b      : integer;
begin
   result := 0;
   b := 0;
   for index in bv'range loop
      if bv(index) = '1' then
         b := 1;
      else
         b := 0;
      end if;
      result := result * 2 + b;
   end loop;
   return result;
end; --function bv_to_integer


function bv_adder(a     : in std_logic_vector(32 downto 0);
                  b     : in std_logic_vector(32 downto 0);
                  do_add: in std_logic) return std_logic_vector is
   variable carry_in : std_logic;
   variable bb       : std_logic_vector(32 downto 0);
   variable result   : std_logic_vector(32 downto 0);
begin
   result := '0' & ZERO;
   if do_add = '1' then
      bb := b;
      carry_in := '0';
   else
      bb := not b;
      carry_in := '1';
   end if;
   for index in 0 to 32 loop
      result(index) := a(index) xor bb(index) xor carry_in;
      carry_in := (carry_in and (a(index) or bb(index))) or
                  (a(index) and bb(index));
   end loop;
   return result;
end; --function


function bv_adder_lookahead(
                  a     : in std_logic_vector(32 downto 0);
                  b     : in std_logic_vector(32 downto 0);
                  do_add: in std_logic) return std_logic_vector is
   variable carry    : std_logic_vector(32 downto 0);
   variable p, g     : std_logic_vector(32 downto 0);
   variable bb       : std_logic_vector(32 downto 0);
   variable result   : std_logic_vector(32 downto 0);
   variable i        : natural;
begin
   carry := '0' & ZERO;
   if do_add = '1' then
      bb := b;
      carry(0) := '0';
   else
      bb := not b;
      carry(0) := '1';
   end if;

   p := a or bb;   --propogate
   g := a and bb;  --generate
   for index in 0 to 7 loop
      i := index*4;
      carry(i+1) := g(i) or 
                    (p(i) and carry(i));
      i := index*4+1;
      carry(i+1) := g(i) or 
                    (p(i) and g(i-1)) or
                    ((p(i) and p(i-1)) and carry(i-1));
      i := index*4+2;
      carry(i+1) := g(i) or
                    (p(i) and g(i-1)) or
                    (p(i) and p(i-1) and g(i-2)) or
                    ((p(i) and p(i-1) and p(i-2)) and carry(i-2));
      i := index*4+3;
      carry(i+1) := g(i) or 
                    (p(i) and g(i-1)) or
                    (p(i) and p(i-1) and g(i-2)) or
                    (p(i) and p(i-1) and p(i-2) and g(i-3)) or
                    (((p(i) and p(i-1)) and (p(i-2) and p(i-3))) 
                       and carry(i-3));
   end loop;
   result := (a xor bb) xor carry;
   return result;
end; --function


function bv_negate(a : in std_logic_vector) return std_logic_vector is
   variable carry_in : std_logic;
   variable not_a    : std_logic_vector(31 downto 0);
   variable result   : std_logic_vector(31 downto 0);
begin
   result := ZERO;
   not_a := not a;
   carry_in := '1';
   for index in a'reverse_range loop
      result(index) := not_a(index) xor carry_in;
      carry_in := carry_in and not_a(index);
   end loop;
   return result;
end; --function


function bv_increment(a : in std_logic_vector(31 downto 2)
                     ) return std_logic_vector is
   variable carry_in : std_logic;
   variable result   : std_logic_vector(31 downto 2);
begin
   result := ZERO(31 downto 2);
   carry_in := '1';
   for index in 2 to 31 loop
      result(index) := a(index) xor carry_in;
      carry_in := a(index) and carry_in;
   end loop;
   return result;
end; --function


function bv_inc6(a : in std_logic_vector
                     ) return std_logic_vector is
   variable carry_in : std_logic;
   variable result   : std_logic_vector(5 downto 0);
begin
   result := "000000";
   carry_in := '1';
   for index in 0 to 5 loop
      result(index) := a(index) xor carry_in;
      carry_in := a(index) and carry_in;
   end loop;
   return result;
end; --function

end; --package body


