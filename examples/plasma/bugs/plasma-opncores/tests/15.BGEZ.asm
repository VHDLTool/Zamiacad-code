
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:
	
   #d: BGEZ
   li   $2,100
   bgez  $2,proceed
   nop
halt:	
	SW $t0,512($0)
   j    halt # this jump will not be executed
   nop
   
proceed:
   li    $2,0xffff1234
   bgez  $2,halt
   nop
   
	#signal "test COMPLETED" by writing magic '1' (ascii 49) to address 0x200, 
	#which is shifted to 0x80 before shown up at the TBENCH bus
	li $t0,'1' 
  
   j halt
   nop

   .set reorder
	.end	entry

