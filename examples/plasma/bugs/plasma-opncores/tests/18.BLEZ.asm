
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:
	
   #g: BLEZ
   ori   $2,$0,100
   blez  $2,halt
   nop
   
   li    $2,0xffff1234
   blez  $2,pass1
   nop
halt:
	SW $t0,512($0)	# terminate
	j halt
   nop
	
pass1:	
	li $t0,'1' # success value
	SW $t0,512($0)	# terminate
   j halt

   .set reorder
	.end	entry

