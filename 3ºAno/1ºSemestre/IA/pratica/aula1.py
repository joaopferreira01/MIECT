#Exercicio 1.1
def comprimento(lista):
	if lista == []:
		return 0
	return 1 + comprimento(lista[1:])

#Exercicio 1.2
def soma(lista):
	if lista == []:
		return 0
	return lista[0] + soma(lista[1:])

#Exercicio 1.3
def existe(lista, elem):
	if lista == []:
		return False
	if(lista[0] == elem):
		return True
	return existe(lista[1:], elem)

#Exercicio 1.4
def concat(l1, l2):
	if l2 == []:
		return l1
	return concat(l1 + l2[:1], l2[1:])			# concat(l1 + l2[0], l2[tudo menos index 0]
	
#Exercicio 1.5
def inverte(lista):
	if lista == []:
		return lista
	return [lista[-1]] + inverte(lista[:-1]) 

#Exercicio 1.6
def capicua(lista):
	if lista == []:
		return True
	if(lista[0] != lista[-1]):
		return False
	return capicua(lista[1:-1])					# retira o primeiro e o ultimo e compara os dois

#Exercicio 1.7
def concat_listas(lista):
	if lista == []:
		return lista
	return lista[:1][0] + concat_listas(lista[1:])

#Exercicio 1.8
def substitui(lista, original, novo):
	if lista == []:
		return []
	if lista[0] == original:
		return [novo] + substitui(lista[1:], original, novo)
	else:
		return [lista[0]] + substitui(lista[1:], original, novo)

#Exercicio 1.9
def fusao_ordenada(lista1, lista2):
	if lista1 == []:
		return lista2
	if lista2 == []:
		return lista1
	if lista1[0] < lista2[0]:
		return [lista1[0]] + fusao_ordenada(lista1[1:], lista2)
	return [lista2[0]] + fusao_ordenada(lista1, lista2[1:])

#Exercicio 1.10
def lista_subconjuntos(lista):
	if lista == []:
		return [[]]
	x = lista_subconjuntos(lista[1:])
	return x + [[lista[0]] + y for y in x]

#Exercicio 2.1
def separar(lista):
	if lista == []:
		return ([],[])
	x, y = lista[0]
	xr, yr = separar(lista[1:])
	return ([x] + xr, [y] + yr)
	pass

#Exercicio 2.2 (DUVIDA)
def remove_e_conta(lista, elem):
	if lista == []:
		return ([], 0)
	counter = 0
	if lista[0] == elem:
		lista.pop(0)
		res = list(remove_e_conta(lista, elem))
		return (res[0], res[1] + 1)

	res = list(remove_e_conta(lista[1:],elem))
	lis =[]
	if res:
		lis = [lista[0]] + res[0]
		cont = res[1]
	return (lis,cont)

#Exercicio 3.1
def cabeca(lista):
	try:
		return lista[0]
	except:
		return None

#Exercicio 3.2
def cauda(lista):
	try:
		return lista[1:]
	except:
		return None

#Exercicio 3.3
def juntar(l1, l2):
	if len(l1) != len(l2):
		return None
	if l1 and l2:
		return juntar(l1[:-1], l2[:-1]) + [(l1[-1], l2[-1])]
	if not l1 and not l2:
		return []
	return None
	
		
#Exercicio 3.4 (DUVIDA)			% alterei o assert count
def menor(lista):
	if len(lista) == 0:
		return None
	if len(lista) == 1:
		return lista[0]
	return min(lista[0], menor (lista[1:]))


#Exercicio 3.6
def max_min(lista):
	pass
