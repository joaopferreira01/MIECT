	# Mapa de registos
	# str: $s0
	# val: $s1
	# O main é, neste caso, uma sub-rotina intermédia
 	.data
str: 	.space 33
 	.eqv STR_MAX_SIZE,33
 	.eqv read_int,5
 	.eqv print_string,4
str1:	.asciiz "\n"
 	.text
 	.globl main
main: 
	addiu 	$sp,$sp,-8 			# reserva espaço na stack
  						# guarda registos $sx na stack
	sw 	$ra,0($sp)			# guarda $ra na stack
	sw	$s0,4($sp)
do: 						# do {
	li 	$v0,read_int
	syscall 				#
	move 	$s0,$v0 			# val = read_int()
	
	
	move	$a0,$s0
	li	$a1,2
	la	$a2,str
	jal	itoa				# itoa(val, 2, str);
	
	move	$a0,$v0
	li	$v0,print_string
	syscall					# print_string(itoa(val, 2, str));
	
	move	$a0, $s0			#
	li 	$a1, 8				#
	la	$a2, str			#
	jal	itoa				# itoa(val, 8, str);
	move	$a0, $v0			#
	li	$v0, print_string		#	
	syscall					# print_string(itoa(val, 8, str));
	
	move	$a0, $s0			#
	li 	$a1, 16				#
	la	$a2, str			#
	jal	itoa				# itoa(val, 16, str);
	move	$a0, $v0			#
	li	$v0, print_string		#	
	syscall					# print_string(itoa(val, 16, str));
	
while:	
	bne 	$s1,0,do 			# } while(val != 0)
	li 	$v0,0 				# return 0;
	 					# repoe registos $sx
	lw	$ra, 0($sp)			#
	lw	$s0, 4($sp)			#
	addiu	$sp, $sp, 8			#
	jr	$ra				# }