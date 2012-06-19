@echo off
del *.txt

for %%X in ("%~dp0\*.asm") do (
	asm %%X
	move /Y code.txt %~dp0%%~nX.txt
)
