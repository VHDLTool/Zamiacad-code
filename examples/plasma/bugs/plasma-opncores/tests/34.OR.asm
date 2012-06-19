
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:

   #e: OR
   ori   $2,$0,'e'
   sb    $2,0($20)
   ori   $2,$0,0x40
   ori   $3,$0,0x01
   or    $4,$2,$3
   
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

