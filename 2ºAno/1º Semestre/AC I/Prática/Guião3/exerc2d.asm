	.data
str1: .asciiz "\nIntroduza um número: "
str2: .asciiz "\nValor em binário: "
	.eqv print_string,4
	.eqv read_int,5
	.eqv print_char,11

	.text
	.globl main
main:
	li 	$v0,print_string
	la 	$a0,str1
	syscall
	
	li	$v0,read_int
	syscall
	move	$t0,$v0
	
	li	$v0,print_string
	la	$a0,str2
	
	
	# Mapa de registos 
# 
# $t0 - value
# $t1 - bit
# $t2 - i
# $t3 - variável para os espaços entre os bits
# $t4 - flag
	
	li 	$t2,0
	li 	$t3,0
	li 	$t4,0
	
For: 
	bge	$t2,32,Exit
	srl	$t1,$t0,31
	beq	$t4,1,flagfor
	beq	$t1,1,flagfor
	
	j endif0
	
flagfor:
	li 	$t4,1
	rem 	$t3,$t2,4
	bne	$t3,$0,endif1
	li	$a0,' '
	li	$v0,print_char
	syscall

endif1:
	addi	$t1,$t1,0x30
	or	$a0,$t1,$0
	li	$v0,print_char
	syscall
	
endif0:
	sll 	$t0,$t0,1
	addi	$t2,$t2,1
	j 	For	
	
Exit:
	jr $ra
