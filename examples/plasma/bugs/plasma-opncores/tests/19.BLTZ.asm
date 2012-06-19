
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:
	
   #h: BLTZ
   li   $2,100
   bltz  $2,halt
   nop
   
   li    $3,0xffff1234
   bltz  $3,pass1
   nop
   
halt:
	SW $t0,512($0)	# terminate
	j halt
   nop
	
pass1:

   bltz  $0,halt
   nop
   
	li $t0,'1' # success value
	SW $t0,512($0)	# terminate
   j halt
   nop

   .set reorder
	.end	entry

