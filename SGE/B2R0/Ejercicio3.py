import random

aleatorio = random.randint(0, 20)
acertar = False;
nIntentos = 0;

while acertar == False:
    numero = int(input("Dime un numero: "))
    nIntentos += 1
    
    if numero > aleatorio:
        print("Menos")
    elif numero < aleatorio:
        print("Mas")
    else:
        print("Felicidades, has acertado con ", nIntentos, "intentos")
        acertar = True
    