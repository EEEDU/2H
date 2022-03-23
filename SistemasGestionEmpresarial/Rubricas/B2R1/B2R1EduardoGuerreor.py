seguir = True

while seguir:
    archivo = input("Dime la ubicacion del archivo: ")
    palabra = input("Dime una palabra: ")
    lineaPalbra = []
    datos = []
    datosSeparados = []
    with open(archivo) as fname:
        lineas = fname.readlines()
        for linea in lineas:
            datos.append(linea.strip('\n'))



    for i in range (0, len(datos) -1):
        if(palabra in datos[i]):
            lineaPalbra.append(i + 1)
    if(len(lineaPalbra) == 0):
        print("Esta palabra no se encuentra en el archivo")
    elif(len(lineaPalbra) == 1):
        print ("la palabra se encuentra en la linea: ", lineaPalbra)
    else:
        print ("la palabra se encuentra en las lineas: ", lineaPalbra)

    pregunta = input("Desea seguir(s/n)")
    if(pregunta != 's'):
        seguir = False;