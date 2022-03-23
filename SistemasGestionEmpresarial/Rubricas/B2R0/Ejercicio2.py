numeros = []

igual = 0
mayor = 0
menor = 0

for i in range(0, 10):
    numeros.append(int(input("Dime un numero: ")))

for i in range(0, 10):
    if numeros[i] > 0:
        mayor += 1
    elif numeros[i] < 0:
        menor += 1 
    else:
        igual += 1

print("Numero de veces que es mayor que 0: ", mayor)
print("Numero de veces que es menor que 0: ", menor)
print("Numero de veces que es igual que 0: ", igual)