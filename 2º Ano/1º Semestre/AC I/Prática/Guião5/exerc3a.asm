	# Mapa de registos
	# ...
	# houve_troca	: $t4
	# i		: $t5
	# lista		: $t6
	# lista + i	: $t7
 		.data
 		.eqv FALSE,0
 		.eqv TRUE,1
 	str1: 	.asciiz "\nIntroduza um número: "
 	str2:	.asciiz "\nConteúdo do array: "
 	str3:	.asciiz "; "
 		.eqv print_string,4
 		.eqv print_int10,1
 		.eqv read_int,5
 		.align 2
 		.eqv SIZE,5
 	lista:	.space 20	# SIZE*4
 		.text
 		.globl main
main: 

Loop_leitura: 				# código para leitura de valores
	bge	$t5,SIZE,Fim_loop
	li	$v0,print_string
	la	$a0,str1
	syscall
	li	$v0,read_int
	syscall
 	la 	$t6,lista 		#
 	sll	$t7,$t5,2
 	addu	$t7,$t7,$t6
 	sw	$v0,0($t7)
 	addi	$t5,$t5,1
 	j	Loop_leitura
 	
Fim_loop:

do: 				# do {
 	li $t4,FALSE 		# houve_troca = FALSE;
 	li $t5,0 		# i = 0;
for: 
	bgtu $t5,SIZE,endfor	# while(i < SIZE-1){
if: 
	sll $t7,$t5,2 		# $t7 = i * 4
 	addu $t7,$t7,$t6 	# $t7 = &lista[i]
 	lw $t8,0($t7) 		# $t8 = lista[i]
 	lw $t9,4($t7) 		# $t9 = lista[i+1]
 	bge $t8,$t9,endif 	# if(lista[i] > lista[i+1]){
 	sw $t8,4($t7) 		# lista[i+1] = $t8
 	sw $t9,0($t7) 		# lista[i] = $t9
 	li $t4,TRUE 		#
 				# }
endif: 	
	addi $t5,$t5,1		# i++;
	j for
	
endfor:
	
 		 		# }
 	bne,$t4,TRUE,endw	# } while(houve_troca == TRUE);
 	j do
 	
 endw:
 	li $v0,print_string
 	la $a0,str2
 	syscall
 	li $t5,0		# i = 0
 	la $t6,lista
 	 			 			
# codigo de impressao do conteudo do array :
printfor:
	bge $t5,SIZE,endprint
	sll $t7,$t5,2		# i*4
	addu $t7,$t7,$t6
	lw $a0,0($t7)
	li $v0,print_int10
	syscall
	la $a0,str3
	li $v0,print_string
	syscall
	addi $t5,$t5,1
	j printfor
endprint:
 	jr 	$ra 		# termina o programa