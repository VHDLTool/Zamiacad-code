
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:

   #c: SRA
   
   #compute
   li    $2,0x40414243
   sra   $3,$2,16  

   #check
   li $2,  0x4041 # correct value
   move $t0, $2 # correct answer
   bne $2, $3, halt
   nop
   
   #compute
   li    $2,0x84000000
   sra   $3,$2,25  

   #check
   li $2,  0xFFFFFFC2 # correct value
   move $t0, $2 # correct value
   bne $2, $3, halt
   nop
   
   li $t0, '1' # test passed code

halt:
   SW $t0,512($0)	# end of test
   nop 
	j halt
	nop
   
   .set reorder
	.end	entry

