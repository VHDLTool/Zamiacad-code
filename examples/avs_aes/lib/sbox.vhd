------------------------------------------------------------------------------
-- This file is part of the project	 avs_aes
-- see: http://opencores.org/project,avs_aes
--
-- description: 
-- Sbox implements a lookup ROM for nonlinear substitution of a Bytearray.
-- This is only the entity for either arch1 (which is pure VHDL) or M4K which
-- is an Altera M4K-Blockram implementation.
--
-------------------------------------------------------------------------------!
--
-- Author(s):
--	   Thomas Ruschival -- ruschi@opencores.org (www.ruschival.de)
--
--------------------------------------------------------------------------------
-- Copyright (c) 2009, Authors and opencores.org
-- All rights reserved.
--
-- Redistribution and use in source and binary forms, with or without modification,
-- are permitted provided that the following conditions are met:
--	  * Redistributions of source code must retain the above copyright notice,
--	  this list of conditions and the following disclaimer.
--	  * Redistributions in binary form must reproduce the above copyright notice,
--	  this list of conditions and the following disclaimer in the documentation
--	  and/or other materials provided with the distribution.
--	  * Neither the name of the organization nor the names of its contributors
--	  may be used to endorse or promote products derived from this software without
--	  specific prior written permission.
-- THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
-- AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
-- IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
-- ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
-- LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY,
-- OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
-- SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
-- INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
-- CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
-- ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
-- THE POSSIBILITY OF SUCH DAMAGE
-------------------------------------------------------------------------------
-- version management:
-- $Author$
-- $Date$
-- $Revision$			
-------------------------------------------------------------------------------
library ieee;
use ieee.std_logic_1164.all;

-------------------------------------------------------------------------------
-- The interface is 2x8Bit because Altera megafunction is supposed to be at max
-- 8Bit dual port ROM (and I relied on a altera quartus generated component
-- before) see architecture m4k
-------------------------------------------------------------------------------
entity sbox is
	generic (
		INVERSE : BOOLEAN := false		-- is this the inverse or the forward
										-- lookup table.
										-- TRUE -> inverse sbox
										-- FALSE -> forward sbox
		); 
	port(
		clk		  : in	STD_LOGIC;		-- system clock
		address_a : in	STD_LOGIC_VECTOR (7 downto 0);	-- 1st byte
		address_b : in	STD_LOGIC_VECTOR (7 downto 0);	-- 2nd byte
		q_a		  : out STD_LOGIC_VECTOR (7 downto 0);	-- substituted 1st byte
		q_b		  : out STD_LOGIC_VECTOR (7 downto 0)	-- substituted 2nd byte
		);
end sbox;

