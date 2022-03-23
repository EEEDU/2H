palabra = input("Dime una palabra: ")

lista = []
lista = list(palabra)

listaDesorden = []

for i in range(0, len(palabra)):
    listaDesorden.append(lista[len(lista) - 1 - i])


palabraFinal = ''.join(listaDesorden)
print(palabraFinal)