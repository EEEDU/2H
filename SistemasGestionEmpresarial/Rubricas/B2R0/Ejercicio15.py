archivo = open("Ejercicio15.txt")
texto = archivo.read()

texto = list(texto)

for i in range (0, len(texto)):
    if texto[i] == ' ':
        texto[i] = ''

texto = ''.join(texto)
print (texto)