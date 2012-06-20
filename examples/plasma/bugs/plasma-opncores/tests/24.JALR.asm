
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:

   #m: JALR
   
	li $t0,'0' # bad code
   la    $3,load_passing_code
   
   # fix the pass address because asm assumes base address 0x10000000 whereas program is linked
   #  at offset 0 and register correction seems unnoticed by linker. So reset the MSB by hand.
   and $3, 0xFFFF 
	jalr  $3
	
	nop
	SW $t0,512($0)	# end of test
	j halt
	
load_passing_code:
   jr    $31
	li $t0,'1' # good code in delay slot
	
	li $t0,1 # bad code
   
 halt: 
   SW $t0,512($0)	# end of test
	j halt
   
   .set reorder
	.end	entry

