
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:

   #f: ORI
   ori   $2,$0,0x40
   ori   $4,$2,0x01
   
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

