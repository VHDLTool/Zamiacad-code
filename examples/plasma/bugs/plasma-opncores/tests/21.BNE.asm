
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:

	li $t0,'0' # bad value
	
   #j: BNE
   li   $2,0
   bne   $2,$0,halt
   nop
   li   $2,100
   bne   $2,$0,passed
   nop

	j halt
   nop
passed:

	li $t0,'1' # success value
	
halt:
   SW $t0,512($0)	# terminate
	j halt
   nop
	
   
   .set reorder
	.end	entry

