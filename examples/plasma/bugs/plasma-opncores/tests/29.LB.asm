
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:

   #a: LB
   li    $3,0x414243fc
   sw    $3,1000($0)
   nop 
   nop 
   nop 
   lw    $4,1000($0)
   nop 
   nop 
   nop 
   li $t0, '0'
   bne $4, $3, halt
   nop
   nop
   li $t0, '1'
halt:
   SW $t0,512($0)	# end of test
   nop 
   nop 
   nop 
	j halt
	nop
   
   .set reorder
	.end	entry

