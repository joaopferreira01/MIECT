# Mapa de registos 
# $t0 : i
# $t1 : v
# $t2 : &(val[i])


		.data
	str1: 	.asciiz "Result is "
	str2:	.asciiz "Maximo/min são: "
	val:	.word 8,4,15,-1987,327,-9,27,16
		.eqv SIZE,8
		.eqv print_string,4
		.eqv print_int10,1
		.eqv print_char,11
		.eqv read_int,5
		.text
		.globl main

main:
	li	$t0,0

do1:
	la	$t2,val
	sll	$t3,$t0,2
	addu	$t4,$t2,$t3
	lw	$t1,0($t4)	# v = val[i]
	lw	$t5,16($t4)	# $t5 = val[i + SIZE/2]
	sw	$t5,0($t4)
	sw	$t1,16($t4)

while:
	addi	$t0,$t0,1
	bge	$t0,4,endw
	j	do1
	
endw:
	li	$v0,print_string
	la	$a0,str1
	syscall
	
	li	$t0,0
	
do2:
	sll	$t6,$t0,2
	addu	$t6,$t6,$t2
	li	$v0,print_int10
	lw	$a0,0($t6)
	syscall
	
	li	$v0,print_char
	li	$a0,','
	syscall

while1:
	addi	$t0,$t0,1
	bge	$t0,8,endw1
	j	do2
endw1:
	jr	$ra
	
