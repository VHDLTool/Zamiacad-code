
	.text
	.align	2
	.globl	entry
	.ent	entry
entry:
   .set noreorder

   j    entry
   nop                      #nops required to place ISR at 0x3c
   nop

   .set reorder
	.end	entry

