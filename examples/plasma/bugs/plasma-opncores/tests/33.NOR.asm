
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:

   #d: NOR
   li    $2,0xf0fff08e
   li    $3,0x0f0f0f30
   nor   $4,$2,$3
   
   li $3, 0x41	# expected result
   bne $4, $3 , halt 
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

