
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:

   #l: JAL
	li $t0,'0' # bad code
   jal   step1
   nop
   SW $t0,512($0)	# end of test
	j halt
	nop
	
step1:
	li $t0,'1' # good code
   jr    $31
   nop
	li $t0,1 # bad code
   
halt: 
   SW $t0,512($0)	# end of test
	j halt
	nop
   
   .set reorder
	.end	entry

