
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:

   #g: XOR
   ori   $2,$0,0xf043
   ori   $3,$0,0xf002
   xor   $4,$2,$3

   li    $3,0x41 # expected result
   bne $4, $3, halt 
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

