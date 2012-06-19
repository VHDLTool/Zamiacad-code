
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:

   #m: JALR
	li $t0,'0' # bad code
   la    $3,load_passing_code
   jalr  $3
	nop
   SW $t0,512($0)	# end of test
	j halt
	
load_passing_code:
	li $t0,'1' # good code
   jr    $31
   nop
	li $t0,1 # bad code
   
 halt: 
   SW $t0,512($0)	# end of test
	j halt
   
   .set reorder
	.end	entry

