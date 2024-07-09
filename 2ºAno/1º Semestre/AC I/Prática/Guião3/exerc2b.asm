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
	
	
	li 	$v0,print_string
	la	$a0,str1
	syscall				# print_string(str1)
	
	li 	$v0,read_int
	syscall				
	move 	$t0,$v0			# value = read_int()
	
	li 	$v0,print_string
	la	$a0,str2
	syscall
	

	
	
endremif:
	bgeu	$t2,32,endfor		# while( i < 32 )
	andi	$t1,$t0,0x80000000	# isola bit 31 ( 31 downto 0 ) 0000 0000 0000 0000 0000 0000 0000 0001
	
	beqz	$t1,for
	
	li 	$a0,'1'
	li	$v0,print_char
	syscall	
	

for:
	rem 	$t3,$t2,4		# Faz i/4
	
	bne	$t3,$0,else		# if( i/4 != 0 ) jump to endremif
	
	li	$a0,' '			# Cria o espaço entre os bits
	li	$v0,print_char		
	syscall				# Print	
	
else: 
	bgeu	$t2,31,endfor
	li 	$a0,'0'
	li	$v0,print_char
	syscall
	
	
endif:
	addi 	$t2,$t2,1		# i++
	sll 	$t0,$t0,1 		# value = value << 1; // Salta para o bit seguinte

	j endremif
	
endfor:
	li	$a0,'\n'
	li	$v0,print_char
	syscall
	jr $ra

	
