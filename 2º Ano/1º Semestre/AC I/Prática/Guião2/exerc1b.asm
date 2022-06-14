	.data
	.text
	.globl main 
main :  ori $t0,$0,0xFFFFFFFF 
	ori $t1,$0,0x0000FF1E
	ori $t2,$0,0x00000614 
	ori $t3,$0,0x0000E543
	xor $t4,$t1,$t0
	xor $t5,$t2,$t0
	xor $t6,$t3,$t0  
	
	jr $ra 