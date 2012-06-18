entity PROCRET is end entity;

architecture ARCH of PROCRET is
signal t : time := 1 ns;
begin
	process
		procedure P(msg: string) is begin 
			assert false;
			assert false report "hehe" severity WARNING;
			report msg severity NOTE; 
			report msg severity WARNING; 
			report msg severity ERROR; 
			--report msg severity FAILURE;   
		end procedure;
		variable bool : boolean := true;
		variable tv, tv2: time := 10 ns;      
	begin
		P("call1");  
		P("call2");         

		-- fails with "Simulation exception IGStaticValue: Discrete type expected here" 
--		assert tv = 10 ns report "now1 != 10 ns" severity NOTE;		
		
		-- t <= tv fails with "Simulation exception IGStaticValue: Discrete 
		--type expected here" but only after wait.   
--		wait for 10 ns;
--		t <= tv;

--		report time'image(now); -- time'image is not supported
		wait;
	end process;
	
end architecture; 