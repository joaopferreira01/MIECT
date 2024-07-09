	.data
	.text
	.globl main
main:   li $t0,0x862A5C1B
	srl $t3,$t0,1
	
	xor $t5,$t0,$t3 # gray = bin ^ (bin >> 1)
	jr $ra