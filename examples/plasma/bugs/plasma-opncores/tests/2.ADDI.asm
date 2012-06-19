
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:
	
   #a: ADD
   ori   $2,$0,5
   addi   $2,$2,60
   
   #check
   ori   $3,$0,65
   BNE $2,$3,halt
   nop
   
	#signal "test COMPLETED" by writing magic '1' (ascii 49) to address 0x200, 
	#which is shifted to 0x80 before shown up at the TBENCH bus
	li $15,'1' 
   
halt:	
	SW $15,512($0)
   j    halt # this jump will not be executed


   .set reorder
	.end	entry

