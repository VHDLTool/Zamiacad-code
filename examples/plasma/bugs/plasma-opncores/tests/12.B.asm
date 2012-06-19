
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:
	
   b     $B1
   nop
   
halt:	
	SW $t0,512($0)
   j    halt # this jump will not be executed
   nop
   
$B1:
   
	#signal "test COMPLETED" by writing magic '1' (ascii 49) to address 0x200, 
	#which is shifted to 0x80 before shown up at the TBENCH bus
	li $t0,'1' 
	SW $t0,512($0)
   
   b    halt # this jump will not be executed
   nop

   .set reorder
	.end	entry

