@echo off

as -o asm.o %1
ld -Ttext 0x10000000 -eentry -Map test.map -s -N -o test.axf asm.o
objdump --disassemble test.axf > test.lst

rem Convert_bin changes test.axf into code.txt which is used by the VHDL.
CONVERT_BIN = convert_bin
move /Y code.txt ..