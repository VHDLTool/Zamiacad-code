
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:

   #n: JR
	li $t0,'0' # bad code
   la    $3,$pass
   
   # fix the pass address because asm assumes base address 0x10000000 whereas program is linked
   #  at offset 0 and register correction seems unnoticed by linker. So reset the MSB by hand.
   and $3, 0xFFFF 
   
   jr    $3
   nop
   
halt:
   SW $t0,512($0)	# end of test
   nop
	j halt
	nop
   
$pass:
	
	li $t0,'1' # ok code
	j halt
   nop
   
   .set reorder
	.end	entry

