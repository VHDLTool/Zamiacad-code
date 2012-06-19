
	.text
	.align	2
	.globl	entry
	.ent	entry
	
   .set noreorder
entry:

	li $t0,'0' # bad value
	
   #i: BLTZAL
   li    $3, -11
   bltzal $3,pass1
   nop
	
	#resume here on jr
	
   bltzal $0,err
   nop
	j halt # ok, jump to end
   nop 
   
err:
	li $t0, 3
   
halt:
	SW $t0,512($0)	# terminate
	j halt
   nop
	
pass1:

	li $t0,'1' # success value
	jr $31
      nop   
	li $t0, 1 # bad value
	SW $t0,512($0)	# terminate
   nop   
	j halt
   nop   
   
   .set reorder
	.end	entry

