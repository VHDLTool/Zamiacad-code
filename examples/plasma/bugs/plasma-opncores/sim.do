
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
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/bugs/plasma-opncores/trunk/vhdl/mlite_pack.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/bugs/plasma-opncores/trunk/vhdl/alu.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/bugs/plasma-opncores/trunk/vhdl/bus_mux.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/bugs/plasma-opncores/trunk/vhdl/control.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/bugs/plasma-opncores/trunk/vhdl/mem_ctrl.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/bugs/plasma-opncores/trunk/vhdl/mlite_cpu.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/bugs/plasma-opncores/trunk/vhdl/mult.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/bugs/plasma-opncores/trunk/vhdl/pc_next.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/bugs/plasma-opncores/trunk/vhdl/pipeline.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/bugs/plasma-opncores/trunk/vhdl/ram.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/bugs/plasma-opncores/trunk/vhdl/reg_bank.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/bugs/plasma-opncores/trunk/vhdl/shifter.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/bugs/plasma-opncores/trunk/vhdl/uart.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/bugs/plasma-opncores/trunk/vhdl/plasma.vhd
vcom c:/Users/valentin/workspace/zamiacad/examples/plasma/bugs/plasma-opncores/trunk/vhdl/tbench.vhd

cp /cygdrive/c/Users/valentin/workspace/zamiacad/examples/plasma/bugs/plasma-opncores/trunk/vhdl/code.txt .

#vsim -coverage -novopt -t 1ps -lib work tb_processor
vsim -novopt -t 1ps -lib work TBENCH

#add wave -noupdate -divider "Sys Signals"
#add wave -noupdate -format Literal -label "Zero"  T1_CPU/U1_CPU/RS_INDEX

add wave -noupdate -radix hexadecimal ADDRESS
#add wave U1_PLASMA/U1_CPU/U3_CONTROL/CONTROL_PROC/
add wave -noupdate -label "OP" U1_PLASMA/U1_CPU/U3_CONTROL/CONTROL_PROC/op
add wave -noupdate -label "func" U1_PLASMA/U1_CPU/U3_CONTROL/CONTROL_PROC/func
add wave -noupdate -label "rs"  -radix hexadecimal U1_PLASMA/U1_CPU/U3_CONTROL/CONTROL_PROC/rs
add wave -noupdate -label "rt"  -radix hexadecimal U1_PLASMA/U1_CPU/U3_CONTROL/CONTROL_PROC/rt
add wave -noupdate -label "rd"  -radix hexadecimal U1_PLASMA/U1_CPU/U3_CONTROL/CONTROL_PROC/rd
add wave -noupdate -label "a_source" -radix hexadecimal U1_PLASMA/U1_CPU/U3_CONTROL/CONTROL_PROC/a_source
add wave -noupdate -label "b_source" -radix hexadecimal U1_PLASMA/U1_CPU/U3_CONTROL/CONTROL_PROC/b_source
add wave -noupdate -label "pc_source" -radix hexadecimal U1_PLASMA/U1_CPU/U3_CONTROL/CONTROL_PROC/pc_source
add wave -noupdate -label "branch_function" U1_PLASMA/U1_CPU/U3_CONTROL/CONTROL_PROC/branch_function
add wave -noupdate -label "mem_source" U1_PLASMA/U1_CPU/U3_CONTROL/CONTROL_PROC/mem_source

add wave -noupdate -label "a_bus" -radix hexadecimal U1_PLASMA/U1_CPU/A_BUS
add wave -noupdate -label "b_bus" -radix hexadecimal U1_PLASMA/U1_CPU/b_BUS
add wave -noupdate -label "c_bus" -radix hexadecimal U1_PLASMA/U1_CPU/c_BUS
run 200 us

configure wave -timelineunits ns
WaveRestoreZoom {1900 ns} {3600 ns}
