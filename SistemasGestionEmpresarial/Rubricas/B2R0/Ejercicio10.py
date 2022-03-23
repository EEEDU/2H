lista = []

for i in range(0, 5):
    lista.append(input("Dime una palabra: "))

def mayorYmenor(tabla):
    largo = []
    masLargo = 0
    menosLargo = 0

    for i in range (0, len(tabla)):
        largo.append(len(tabla[i]))

    for i in range (0, len(largo)):
        if largo[i] > largo[masLargo]:
            masLargo = i
    for i in range (0, len(largo)):
        if largo[i] < largo[menosLargo]:
            menosLargo = i

    print("El string mas largo es: ", tabla[masLargo])
    print("El string menos largo es: ", tabla[menosLargo])

mayorYmenor(lista)