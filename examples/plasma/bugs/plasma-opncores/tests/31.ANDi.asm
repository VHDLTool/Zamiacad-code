
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:

   #b: ANDI
   li   $2,0xffff
   andi $4, $2, 0xffff
   bne $4, $2, halt
   nop
   nop
   
   li   $2,0xffff
   andi   $4,$2, 0
   bne $4, $0, halt
   nop
   nop
   li $t0, '1'
halt:
   SW $t0,512($0)	# end of test
   nop 
	j halt
	nop
   
   .set reorder
	.end	entry

