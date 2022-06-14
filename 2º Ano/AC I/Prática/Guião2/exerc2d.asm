	# Mapa 
	# t0 - gray
	# t1 - num 
	# t2 - bin
	# t3 - helper	
	.data
	.text
	.globl main
main: 	li $t0,6
	move $t1,$t0		# num = gray
	
	srl $t3,$t1,4		# num = num ^ (num >> 4)
	xor $t1,$t1,$t3		# $t1 = $t0 xor $t1  
	
	srl $t3,$t1,2		# shift right $t1 = $t0 >> 2
	xor $t1,$t1,$t3		# $t1 = $t0 xor $t1
	
	srl $t3,$t1,1		# shift right $t1 = $t0 >> 1
	xor $t1,$t1,$t3		# $t1 = $t0 xor $t1 
	
	move $t2,$t1
		
	jr $ra