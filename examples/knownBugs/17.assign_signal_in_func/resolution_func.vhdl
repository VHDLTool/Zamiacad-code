entity SIG_IN_PROCEDURE_ARG_BAD is end entity;

architecture arch of SIG_IN_PROCEDURE_ARG_BAD is
	signal s1: bit;
begin
	process 
		procedure ASSIGN(signal S: inout bit) is begin
			S <= '1'; -- Must be compilation error in case of argument is mode IN 
		end procedure;
	begin
		ASSIGN(s1);
		wait for 0 ns;
		report "signal is " & bit'image(s1) & " now";
		wait;
		wait; 
	end process;
end architecture; 


-- it is surprising that this shit does not happen with (more
-- complex) vector assignment 
entity SIG_IN_PROCEDURE_ARG_OK is end entity;

architecture arch of SIG_IN_PROCEDURE_ARG_OK is
	signal s_vec: bit_vector(1 to 3);
begin
	process 
		procedure ASSIGN(signal S: INOUT bit_vector) is begin
			S(1) <= '1';
		end procedure;
	begin
		ASSIGN(s_vec);
		wait for 0 ns;
		report "after asignment, bit = " & bit'image(s_vec(1));
		wait; 
	end process;
end architecture; 