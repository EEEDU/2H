palabra = input("Dime una palabra: ")

lista = list(palabra)

ultima = lista[len(palabra) - 1]
lista[len(palabra) - 1] = lista[0]
lista[0] = ultima

palabraFinal = ''.join(lista)
print(palabraFinal)