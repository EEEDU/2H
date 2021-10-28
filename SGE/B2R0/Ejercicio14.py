print("Elige una opcion")
print("Pulsa 1 si quieres volcar de una lista con todos los números pares comprendidos entre 0 y 100.")
print("Pulsa 2 si quieres mostrar por pantalla el contenido del fichero de texto creado.")
print("Pulsa 3 si quieres salir.")
opciones = input()

if opciones == '1':
    lista = []
    for i in range (0, 101, 2):
        lista.append(i)
    print (lista)

elif opciones == '2':
    archivo = open("Ejercicio14.txt")
    print(archivo.read())
    archivo.close()

else:
    exit()