	.data
	.eqv 	print_string, 4
	.eqv	read_double,7
str1:	.asciiz	"\nIntroduza um valor para calcular a sua raiz quadrada: "
x0:	.double 1.0
x1:	.double 0.5
x2:	.double 0.0
	.text
	.globl main
	
main:
		addiu	$sp,$sp,-4
		sw	$ra,0($sp)
		
		la	$a0,str1
		li	$v0,print_string
		syscall
		
		li	$v0,read_double
		syscall	
		mov.d	$f12,$f0
		jal	sqrt
		
		mov.d	$f12,$f0
		li	$v0,3
		syscall
		
		lw	$ra,0($sp)
		addiu	$sp,$sp,4
		jr	$ra




#################################################
# Mapa de registos
# val: $f12
# aux: $f2
# xn: $f4
# i: $t0
sqrt:
	mov.d	$f10,$f12
	la	$t1,x0
	l.d	$f4,0($t1)
	la	$t1,x2
	l.d	$f6,0($t1)
	li	$t0,0
	
sqrt_if:
	c.le.d	$f10,$f6
	bc1t	sqrt_else

sqrt_do:
	mov.d	$f2,$f4
	div.d	$f4,$f10,$f2
	add.d	$f4,$f4,$f2
	la	$t1,x1
	l.d	$f8,0($t1)
	mul.d	$f4,$f8,$f4
	
while:
	c.eq.d	$f2,$f4
	bc1t	endif
	addi	$t0,$t0,1
	bge	$t0,25,endif
	j	sqrt_do
		
sqrt_else:
	mov.d	$f4,$f6
endif:
	mov.d	$f0,$f4
	jr	$ra
		