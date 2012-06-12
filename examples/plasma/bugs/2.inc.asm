
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:
	XOR $t0,$t0,$t0
main:	
	addiu   $t0,$t0,1
   
	
   j    main
   nop                      #nops required to place ISR at 0x3c
   nop

   .set reorder
	.end	entry

