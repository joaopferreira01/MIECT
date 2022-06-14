		.data
	array:	.word	str1,str2,str3
	str1:	.asciiz "Array"
	str2:	.asciiz "de"
	str3:	.asciiz "ponteiros"
		.eqv print_int10,1
		.eqv print_string,4
		.eqv print_char,11
		.eqv SIZE,3
	str5:	.asciiz ":"	
	str4:	.asciiz "\nString #"
		.text
		.globl main

	# Mapa de registos
	#  t0 - i
	#  t1 - j
	#  t2 - *i
	#  t3 - *j
main:
	li	$t0,0

for:
	bge	$t0,SIZE,efor
	li	$v0,print_string
	la	$a0,str4
	syscall
	
	li	$v0,print_char
	move	$a0,$t0
	syscall
	
	li	$v0,print_string
	la	$a0,str5
	syscall
	
	li	$t1,0
	
while:
	sll	$t2,$t0,2
	la	$t3,array
	addu	$t4,$t3,$t2
	lw	$t5,0($t4)
	addu	$t6,$t5,$t1
	lb	$t7,0($t6)
	beq	$t7,'\0',endw
	li	$v0,print_char
	move 	$a0,$t7
	syscall
	li	$v0,print_char
	li	$a0,'-'
	syscall	
	addi	$t1,$t1,1
	j	while
	
endw:	

	addi	$t0,$t0,1
	j	for
	
efor:
	jr	$ra
	