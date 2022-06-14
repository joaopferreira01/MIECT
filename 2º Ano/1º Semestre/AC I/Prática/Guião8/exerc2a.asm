	# Mapa de registos
	# n: $a0 -> $s0
	# b: $a1 -> $s1
	# s: $a2 -> $s2
	# p: $s3
	# digit: $t0
	# Sub-rotina intermédia
	.text
	.globl itoa
itoa: 
	addiu 	$sp,$sp,-20 	# reserva espaço na stack
	sw	$ra,0($sp)
	sw 	$s0,4($sp) 	# guarda registos $sx e $ra
	sw 	$s1,8($sp)
	sw 	$s2,12($sp)
	sw 	$s3,16($sp)
			 	# copia n, b e s para registos
	move 	$s0,$a0		# s0 = n
	move	$s1,$a1		# s1 = b
	move	$s2,$a2		# "callee-saved"
	move 	$s3,$a2 	# s3 = s;
do: 				# do {
	rem	$t0,$s0,$s1
	div	$s0,$s1
	mflo	$s0
	move	$a0,$t0
	jal	toascii
	sb	$v0,0($s3)
	addiu	$s3,$s3,1	
							
while:				#
	bgt 	$s0,0,do	# } while(n > 0);
	sb 	$0,0($s2) 	# *p = 0;
	move	$a0,$s2 			#
	jal 	strrev 		# strrev( s );
	move	$a0,$s2		# return s;
	lw	$ra, 0($sp)	#	ir buscar o $ra
	lw	$s0, 4($sp)	#	repor registos $sX na pilha
	lw	$s1, 8($sp)	#
	lw	$s2, 12($sp)	#
	lw	$s3, 16($sp)	#
	addiu 	$sp, $sp, 20	#	repor o tamanho da pilha
	jr	$ra		# } fim do programa