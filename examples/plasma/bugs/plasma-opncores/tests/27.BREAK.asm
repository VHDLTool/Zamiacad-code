	.text 
	.align	2
	.globl	entry
	.ent	entry
   .set noreorder

entry:
	j start
	
	#pad to 0x3c
	j halt
	j halt
	j halt
	j halt
	j halt
	j halt
	j halt
	j halt
	j halt
	j halt
	j halt
	j halt
	nop
	nop
	
#this is address 0x3C
service:
   mfc0  $26,$12            #C0=status
   nop
   nop
   SW $26,1000($0)	# end of test
   nop
   nop
   mfc0  $26,$13            #C0=cause
   nop
   nop
   SW $26,1000($0)	# end of test
   nop
   nop
   mfc0  $26,$14            #C0_EPC=14 (Exception PC)
   nop
   nop
   SW $26,1000($0)	# end of test
   nop
   nop

   jr    $26
	li $t0,'1' # ok code
   nop
   nop
   
	
	li $t0,1 # bad code
   SW $t0,512($0)	# end of test
   nop
   j halt
   nop

   
start:

	break
	nop 
	nop
halt:
   SW $t0,512($0)	# end of test
   nop
	j halt
	nop
   
   
   .set reorder
	.end	entry

