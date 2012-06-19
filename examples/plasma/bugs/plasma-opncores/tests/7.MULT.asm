
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:
	
   #g: MULT
   li   $2,5
   li   $3,13
   mult  $2,$3
   nop
   
   #check LO
   mflo  $4
   nop
	
   li   $5,5*13
   BNE $4,$5,halt
   nop
   
   #check HI
   mfhi  $4

   li   $5,0
   BNE $4,$5,halt
   nop
   
	#signal "test COMPLETED" by writing magic '1' (ascii 49) to address 0x200, 
	#which is shifted to 0x80 before shown up at the TBENCH bus
	li $t0,'1' 
   
halt:	
	SW $t0,512($0)
   j    halt # this jump will not be executed


   .set reorder
	.end	entry

