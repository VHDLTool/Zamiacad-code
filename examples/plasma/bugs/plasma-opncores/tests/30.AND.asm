
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:

   #a: AND
   
   li   $2,0xffff
   li   $3,0xffff
   and   $4,$2,$3
   li $3, 0xffff
   bne $4, $3, halt
   nop
   nop
   
   li   $2,0xffff
   li   $3,0
   and   $4,$2,$3
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

