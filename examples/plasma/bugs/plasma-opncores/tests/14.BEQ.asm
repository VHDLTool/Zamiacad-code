
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:
	
   #c: BEQ
   ori   $2,$0,100
   ori   $3,$0,123
   ori   $4,$0,123
   beq   $2,$3,halt
   nop
   beq   $3,$4,pass
   nop
   
halt:	
	SW $t0,512($0)
   j    halt # this jump will not be executed
   nop
   
pass:

	#signal "test COMPLETED" by writing magic '1' (ascii 49) to address 0x200, 
	#which is shifted to 0x80 before shown up at the TBENCH bus
	li $t0,'1' 
	SW $t0,512($0)
   j halt

   .set reorder
	.end	entry

