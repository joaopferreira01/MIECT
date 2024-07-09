# Mapa de registos 
# 
# $t0 - value
# $t1 - bit
# $t2 - i
# $t3 - variável para os espaços entre os bits
	.data
str1: 	.asciiz "Introduza um numero: "
str2:	.asciiz "\nO valor em binário e': "
	.eqv print_string,4
	.eqv read_int,5
	.eqv print_char,11
	.text
	.globl main
	
main:
	li 	$t0,0
	li	$t1,0
	li	$t2,0
	li 	$t3,0
	
	li 	$v0,print_string
	la	$a0,str1
	syscall				# print_string(str1)
	
	li 	$v0,read_int
	syscall				
	move 	$t0,$v0			# value = read_int()
	
	li 	$v0,print_string
	la	$a0,str2
	syscall
	
for:
	bge	$t2,32,endfor		# while( i < 32 )
	andi	$t1,$t0,0x80000000

	beqz	$t1,else		# if(bit != 0)
	
	li 	$a0,'1'
	li	$v0,print_char
	syscall
	
	j endif
	
else: 
	li 	$a0,'0'
	li	$v0,print_char
	syscall
	
endif:
	addi 	$t2,$t2,1		# i++
	sll 	$t0,$t0,1 		# value = value << 1;

	j for
	
endfor:
	li	$a0,'\n'
	li	$v0,print_char
	syscall	
	jr $ra

	
