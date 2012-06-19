
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:
	
   #b: BAL
   bal   $BAL1
   nop

halt:	
   	SW $t0,512($0) 
   j    halt # this jump will not be executed
   nop
	
$BAL1:
	li $t0,'1' # success code
   jr    $31
   nop
   	li $t0,'0'
halt2:
   	SW $t0,512($0) 
	j halt2
	
   .set reorder
	.end	entry

