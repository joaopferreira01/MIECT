# Mapa de Registos
#  t0 - *p
#  t1 - *(p+1)
#  t2 - 
#  t3 - 
#  t4 - houve_troca
#  t5 - p
#  t6 - pUltimo
#  t7 - aux

	.data
	.eqv	SIZE,10
	.eqv	FALSE,0
	.eqv	TRUE,1
str1:	.asciiz	"\nIntroduza numero: "
str2:	.asciiz	"\nConteudo do array: "
str3:	.asciiz	", "
	.align	2
lista:	.space	40
	.eqv	read_int,5
	.eqv	print_string,4
	.eqv	print_int10,1
	.text
	.globl	main
	
main:
	la 	$t5,lista		# p = lista
	li 	$t6,SIZE		# pultimo = SIZE
	sll	$t6,$t6,2		# $t6 = SIZE * 4
	addu	$t6,$t5,$t6		# $t6 = lista + SIZE * 4
	
Read_Loop:
	bge	$t5,$t6,EndReadLoop

##
#		DIZEM QUE NAO É IMPORTANTE PARA O TESTE
#
#
EndReadLoop	










	