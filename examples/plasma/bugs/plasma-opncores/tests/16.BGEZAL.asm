
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:
	
	li $t0,'0' # failure value
	
   li    $3,0xffff1234
   bgezal $3,halt
   nop
   
   bgezal $0,pass1
   nop
	
halt:	
	SW $t0,512($0)
	j halt
   nop
pass1:
	li $t0,'1' # success value
	jr $31
   nop
	li $t0,'0' # bad value
   
   j halt

   .set reorder
	.end	entry

