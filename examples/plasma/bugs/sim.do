
radix define Cmd {
# class0
6'b000000 "JMP",
6'b000001 "JC",
6'b000010 "JNC",
6'b000011 "JZ",
6'b000100 "JNZ",
6'b000101 "JS",
6'b000110 "JNS",
6'b000111 "JO",
6'b001000 "JNO",
6'b001001 "CALL",
6'b001010 "CALL_C",
6'b001011 "STOP",
6'b001100 "NOP",
6'b001101 "RET",
6'b001110 "RETCI",
6'b001111 "LOAD_R_R",
6'b010000 "LOAD_R_IMM",
6'b010001 "STORE_R_R",
6'b010010 "STORE_R_IMM",
6'b010011 "PUSH_R",
6'b010100 "POP_R",
# class1
6'b100000 "ADD_R_R",
6'b100001 "ADD_R_IMM",
6'b100010 "SUB_R_R",
6'b100011 "SUB_R_IMM",
6'b100100 "MOV_R_R",
6'b100101 "MOV_R_IMM",
6'b100110 "AND_R_R",
6'b100111 "AND_R_IMM",
6'b101000 "OR_R_R",
6'b101001 "OR_R_IMM",
6'b101010 "XOR_R_R",
6'b101011 "XOR_R_IMM",
6'b101100 "CMP_R_R",
6'b101101 "CMP_R_IMM",
6'b101110 "SHL_R",
6'b101111 "SHR_R",
6'b110000 "NOT_R",
-default hex
}

radix define Reg_addr {
4'b0000 "Reg00",
4'b0001 "Reg01",
4'b0010 "Reg02",
4'b0011 "Reg03",
4'b0100 "Reg04",
4'b0101 "Reg05",
4'b0110 "Reg06",
4'b0111 "Reg07",
4'b1000 "Reg08",
4'b1001 "Reg09",
4'b1010 "Reg10",
4'b1011 "Reg11",
4'b1100 "Reg12",
4'b1101 "Reg13",
4'b1110 "Reg14",
4'b1111 "Reg15",
-default hex
}

radix define deb_state {
3'b000 "inst_fetch",
3'b001 "inst_decode",
3'b010 "op_fetch",
3'b011 "mem_write",
3'b100 "execute",
3'b101 "irq",
3'b110 "stop",
-default hex  
}

# create library work
vlib work

#vcom +cover -93 -explicit
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/mlite_pack.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/alu.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/alu_tb.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/bus_mux.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/control.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/cpu_testbench.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/mem_ctrl.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/mlite2sram.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/mlite2uart.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/mlite_cpu.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/mult.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/pc_next.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/pipeline.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/ram.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/reg_bank.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/shifter.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/sram2mlite.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/uart.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/plasma.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/tbench.vhd

cp /cygdrive/c/Users/valentin/workspace/zamiacad/examples/plasma/code.txt .

#vsim -coverage -novopt -t 1ps -lib work tb_processor
vsim -novopt -t 1ps -lib work TBENCH

#add wave -noupdate -divider "Sys Signals"
#add wave -noupdate -format Literal -label "Zero"  T1_CPU/U1_CPU/RS_INDEX

add wave -noupdate -radix hexadecimal -label "OPCODE_OUT" T1_CPU/U1_CPU/U2_MEM_CTRL/OPCODE_OUT
add wave -noupdate -label "READ_ENABLE" T3_RAM/READ_ENABLE
add wave -noupdate -label "MEM_SEL" T3_RAM/MEM_SEL
add wave -noupdate -radix hexadecimal -label "MEM_DATA_R" T3_RAM/MEM_DATA_R
add wave -noupdate -radix hexadecimal -label "mem_data_r" T1_CPU/U1_CPU/U2_MEM_CTRL/MEM_DATA_R
add wave -noupdate -label "addr" T3_RAM/DEBUG_ADDR
add wave -noupdate -radix hexadecimal -label "OPCODE" T1_CPU/U1_CPU/OPCODE
add wave -noupdate -radix hexadecimal -label "OPCODE_REG" T1_CPU/U1_CPU/U2_MEM_CTRL/OPCODE_REG
add wave -noupdate -label "MEM_STATE_REG" T1_CPU/U1_CPU/U2_MEM_CTRL/MEM_STATE_REG
add wave -noupdate -label "MEM_SOURCE" T1_CPU/U1_CPU/U2_MEM_CTRL/MEM_SOURCE
add wave -noupdate -label "PAUSE_IN" T1_CPU/U1_CPU/U2_MEM_CTRL/PAUSE_IN
add wave -noupdate -label "CLK" T1_CPU/U1_CPU/U2_MEM_CTRL/CLK
add wave -noupdate -label "op" T1_CPU/U1_CPU/U3_CONTROL/OP_SIG
add wave -noupdate -label "func" T1_CPU/U1_CPU/U3_CONTROL/FUNC_SIG
add wave -noupdate -radix hexadecimal -label "rd" T1_CPU/U1_CPU/RD_INDEX
add wave -noupdate -radix hexadecimal -label "rt" T1_CPU/U1_CPU/RT_INDEX
add wave -noupdate -radix hexadecimal -label "rs" T1_CPU/U1_CPU/RS_INDEX


run 900 ns

configure wave -timelineunits ns
WaveRestoreZoom {100 ns} {600 ns}
