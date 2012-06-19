
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:

   #k: J
	li $t0,'0' # bad code
   j     pass
   nop	# this not is important
   SW $t0,512($0)	# terminate
	nop
pass:
	li $t0,'1' # good code
   
halt: 
   SW $t0,512($0)	# terminate
	j halt
   
   .set reorder
	.end	entry

