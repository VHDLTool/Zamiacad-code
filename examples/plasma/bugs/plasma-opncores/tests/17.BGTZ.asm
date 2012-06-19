
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:
	
   #f: BGTZ
   ori   $3,$0,100
   bgtz  $3,pass1
   nop
halt: 
	SW $t0,512($0)	# terminate
   nop
	j halt
   nop
   
pass1:

   li    $3,0xffff1234
   bgtz  $2,halt
   nop
   
	li $t0,'1' # success value
	SW $t0,512($0)	# terminate
	j halt

   .set reorder
	.end	entry

