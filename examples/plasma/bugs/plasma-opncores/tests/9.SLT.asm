
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:
	
   #i: SLT
   li   $2,10
   li   $3,12
   slt   $4,$2,$3
   
   li   $5,1
   BNE $5,$4,halt
   nop
   
   slt   $4,$3,$2
   BNE $0,$4,halt
   nop
   
	#signal "test COMPLETED" by writing magic '1' (ascii 49) to address 0x200, 
	#which is shifted to 0x80 before shown up at the TBENCH bus
	li $t0,'1' 
	SW $t0,512($0)
   
halt:	
   j    halt # this jump will not be executed


   .set reorder
	.end	entry

