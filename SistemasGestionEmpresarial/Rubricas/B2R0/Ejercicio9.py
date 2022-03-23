palabra = input("Dime una palabra: ")

lista = []
lista = list(palabra)

letra = input("Dime una letra: ")

def indexContains(tabla, cadena):
    pasar = False

    for i in range (0, len(tabla)):
        if tabla[i] == cadena:
            pasar = True
            print(i + 1)
            
    if pasar == False:
        print(-1)

indexContains(lista, letra)