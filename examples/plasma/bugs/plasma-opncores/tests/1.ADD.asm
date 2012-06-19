
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:
	
   #a: ADD
   ori   $3,$0,5
   ori   $4,$0,60
   add   $2,$3,$4
   
   #check
   ori   $3,$0,65
   BNE $2,$3,halt
   nop
   
	#signal "test COMPLETED" by writing magic '1' (ascii 49) to address 0x200, 
	#which is shifted to 0x80 before shown up at the TBENCH bus
	li $t0,'1' 
   
halt:	
	SW $t0,512($0)
   j    halt # this jump will not be executed


   .set reorder
	.end	entry

