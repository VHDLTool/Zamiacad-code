
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:

   #c: LUI
   lui   $2,0x41
   li  $3,0x41
   sll $3, $3, 16
   bne $2, $3 , halt # loading upper is the same as shifting left 16 bits
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

