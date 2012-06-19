
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:

   #b: SLLV
   li    $2,0x40414243
   li   $3,31
   sllv  $3,$2,$3

   li    $4,2147483648 # expected result
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

