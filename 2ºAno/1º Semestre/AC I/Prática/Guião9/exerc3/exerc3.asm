	.data
	.eqv SIZE 10 # 10*8
a:	.space 80
	.text
	.globl main
	
	# Mapa de registos
	# $t0 - i
	# $t1 - &a;
	# $t2 - aux;
	# $t3 = &(a[i]);
main:
	addiu	$sp,$sp,-4
	sw	$ra,0($sp)
	la	$t1,a
	li	$t0,0

for:
	bge	$t0,SIZE,endfor
	
	li	$v0,5				#		$v0 = 5;
	syscall					#		$v0 = read_int();
	mtc1	$v0, $f2			#		$f2 = $v0
	cvt.d.w	$f2, $f2			#		$f2 = (double)$v0
	
	sll	$t2,$t0,3			#		aux = i*8;
	addu	$t3,$t1,$t2			#		$t3 = &(a[i]);
	s.d	$f2,0($t3)			#		a[i} = (double)$v0;
	
	addi	$t0,$t0,1			#		i++;
	j	for
	
endfor:
	la	$a0,a
	li	$a1,SIZE
	jal	average
	mov.d	$f12, $f0			#	$f12 = $f0
	li	$v0, 3				#	$v0 = 3;
	syscall					#	print_double();
	
	
	lw	$ra,0($sp)
	addiu	$sp,$sp,4
	li	$v0,0
	jr	$ra
	
	