# Mapa de registos 
# $t0 : val
# $t1 : n
# $t2 : min
# $t3 : max

		.data
	str1: 	.asciiz "Digite ate 20 inteiros (zero para terminar): "
	str2:	.asciiz "Maximo/min são: "
		.eqv read_int,5
		.eqv print_string,4
		.eqv print_int10,1
		.eqv print_char,11
		.text
		.globl main
		
main:
	li	$t1,0
	li	$t2,0x7FFFFFFF
	li	$t3,0x80000000
	
	li	$v0,print_string
	la	$a0,str1
	syscall
	
do:	
	li	$v0,read_int
	syscall
	move	$t0,$v0
	beqz	$t0,endif

if1:
	ble	$t0,$t3,if2
	move	$t3,$t0

if2:
	bge	$t0,$t2,endif
	move	$t2,$t0
	
endif:
	addi	$t1,$t1,1
	
while:
	bge	$t1,20,endw
	beqz	$t0,endw
	j	do
	
endw:
	li	$v0,print_string
	la	$a0,str2
	syscall
	
	li	$v0,print_int10
	move	$a0,$t3
	syscall
	
	li	$v0,print_char
	li	$a0,':'
	syscall
	
	li	$v0,print_int10
	move	$a0,$t2
	syscall
