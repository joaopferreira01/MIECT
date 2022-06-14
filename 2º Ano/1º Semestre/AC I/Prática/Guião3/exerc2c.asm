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
# $t4 - variável para controlo de zeros
	
	li 	$t2,0
	li 	$t3,0
	li 	$t4,0

Loop:
	bge 	$t2,32,EndLoop		# while( i < 32 )
	andi 	$t1,$t0,0x80000000	# isola bit 31 ( 31 downto 0 ) 0000 0000 0000 0000 0000 0000 0000 000(1)
	srl	$t1,$t1,31		# vai ao primeiro bit (1)
	addi	$a0,$t1,0x00000030	# adiciona 0 ao primeiro bit
	ori	$v0,$0,print_char
	syscall
	
	addi 	$t3,$t3,1
	bne 	$t3,4,endif
	
	ori 	$a0,$0,0x00000020
	ori 	$v0,$0,print_char
	syscall
	
	li 	$t3,0	
	
endif:
	addi 	$t2,$t2,1		# i++
	sll	$t0,$t0,1		# value = value << 1; // Salta para o bit seguinte
	
	j	Loop

EndLoop:
	jr 	$ra
	
