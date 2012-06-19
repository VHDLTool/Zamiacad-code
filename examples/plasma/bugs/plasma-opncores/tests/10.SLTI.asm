
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:
	
   #j: SLTI
   li   $2,10
   slti  $4,$2,12
   
   li   $5,1
   BNE $5,$4,halt
   nop
   
   slti  $4,$2,8
   BNE $0,$4,halt
   nop
   
	#signal "test COMPLETED" by writing magic '1' (ascii 49) to address 0x200, 
	#which is shifted to 0x80 before shown up at the TBENCH bus
	li $t0,'1' 
   
halt:	
	SW $t0,512($0)
   j    halt # this jump will not be executed
   nop


   .set reorder
	.end	entry

