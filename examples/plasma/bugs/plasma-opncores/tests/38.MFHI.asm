
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:

   #a: MFHI
   li   $2,65
   mthi  $2
   mfhi  $3

   li    $4,65 # expected result
   bne $3, $4, halt 
   nop
   nop   

   li $t0, '1' # test passed code
halt:
   SW $t0,512($0)	# end of test
   nop 
	j halt
	nop
   
   .set reorder
	.end	entry

