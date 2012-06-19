
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:

   #f: SRLV
   li    $2,0x40414243
   li   $3,16
   srlv  $4,$2,$3
   
   #check
   li $2,  0x4041 # correct value
   bne $2, $4, halt
   nop
   
   li    $2,0x84000000
   li   $3,25
   srlv  $4,$2,$3
   
   #check
   li $2,  0x42 # correct value
   bne $2, $4, halt
   nop
   
   li $t0, '1' # test passed code

halt:
   SW $t0,512($0)	# end of test
   nop 
	j halt
	nop
   
   .set reorder
	.end	entry

