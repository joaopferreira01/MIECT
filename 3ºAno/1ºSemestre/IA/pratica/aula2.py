import math
import functools

#Exercicio 4.1
impar = lambda x : x % 2 != 0 

#Exercicio 4.2
positivo = lambda x : x > 0

#Exercicio 4.3
comparar_modulo = lambda x, y : abs(x) < abs(y)

#Exercicio 4.4
cart2pol = lambda x, y : (math.sqrt(x**2 + y**2), math.atan2(y,x))

#Exercicio 4.5
ex5 = lambda f, g, h : lambda x, y, z : h(f(x,y),g(y,z))

#Exercicio 4.6
def quantificador_universal(lista, f):
    if lista == []:
        return True

    if f(lista[0]):
        return quantificador_universal(lista[1:], f)
    return False

def subconjunto(lista1, lista2):
    if lista1 == []:
        return True

    if lista1[0] in lista2:
        return subconjunto(lista1[1:], lista2)
    return False

print(subconjunto([0,1,2,3], [3,4,2,1]))

#Exercicio 4.9
def ordem(lista, f):
    if len(lista) == 1:
        return lista[0]

    menor = ordem(lista[1:], f)

    if f(lista[0], menor):
        return lista[0]
    return menor

#Exercicio 4.10
def filtrar_ordem(lista, f):
    if len(lista) == 1:
        return lista[0], []

    menor, resto = filtrar_ordem(lista[1:], f)

    if f(lista[0], menor):
        return lista[0], resto + [menor]
    return menor, [lista[0]] + resto

#Exercicio 5.2
def ordenar_seleccao(lista, ordem):
    if lista == []:
        return []

    menor, resto = filtrar_ordem(lista, ordem)

    return [menor] + ordenar_seleccao(resto, ordem)

