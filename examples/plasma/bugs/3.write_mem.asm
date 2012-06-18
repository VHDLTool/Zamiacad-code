
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:
	XOR $t0,$t0,$t0
	
	
	#signal "test COMPLETED" by writing magic 11 to address 0x200, 
	#which is shifted to 0x80 before shown up at the TBENCH bus
	SW $t0,512($t0)
	ori $t0, 11
   
main:	
   j    main
   nop                      #nops required to place ISR at 0x3c
   nop

   .set reorder
	.end	entry

