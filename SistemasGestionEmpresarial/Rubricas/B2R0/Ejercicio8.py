lista = [2, 3, 4, 5]


def suma(lista):
    acum = 0
    for i in range(0, len(lista)):
        acum += lista[i]
    print(acum)

    
suma(lista)