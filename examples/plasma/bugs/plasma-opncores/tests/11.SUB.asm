
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:
	
   #m SUB
   li   $3,70
   li   $4,5
   sub   $2,$3,$4
   
   li   $5,65
   BNE $5,$2,halt
   nop
   
	#signal "test COMPLETED" by writing magic '1' (ascii 49) to address 0x200, 
	#which is shifted to 0x80 before shown up at the TBENCH bus
	li $t0,'1' 
   
halt:	
	SW $t0,512($0)
   j    halt # this jump will not be executed


   .set reorder
	.end	entry

