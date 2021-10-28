palabra = input("Dime una palabra: ")
nRepeticiones = 0

for i in range(0, len(palabra) - 2):
    if palabra[i] == 'a':
        if palabra[i + 1] == 'a' and palabra[i + 2] == 'a':
            nRepeticiones += 1

print("La cadena aaa se ha repetido ", nRepeticiones, " veces")