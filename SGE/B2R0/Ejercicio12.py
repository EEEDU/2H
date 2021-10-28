class cuenta:
    def __init__(self, titular, cantidad):
        self.titular = titular
        self.cantidad = cantidad

    def ingresar (self, can):
        if can > 0:
            self.cantidad += can
            print("Ahora la cuenta de ", self.titular, " tiene ", self.cantidad, " €")
        else:
            print("No se puede ingresar una cantidad negativa")

    def retirar (self, can):
        if self.cantidad > can:
            self.cantidad -= can
            print("Ahora la cuenta de ", self.titular, " tiene ", self.cantidad, " €")
        else:
            print("Lo siento no tienes tanto dinero")

titular = input("Como te llamas? ")
cantidad = float(input("Cuanto dinero tienes? "))
cliente = cuenta(titular, cantidad)

def opciones():
    opciones = input("\nSi quieres ingresar pulsa I \nSi quieres retirar pulsa R")
    if opciones == 'I' or opciones == 'i':
        cantidadIngresar = float(input("Cuanto dinero quieres ingresar? "))
        cliente.ingresar(cantidadIngresar)
    elif opciones == 'R' or opciones == 'r':
        cantidadRetirar = float(input("Cuanto dinero quieres retirar? "))
        cliente.retirar(cantidadRetirar)
    else:
        print("**ERROR** No se detecta ninguna operacion")

seguir = True
while seguir == True:
    preguntarSeguir = input("\nQuieres realizar alguna operacion? \nSi quieres seguir pulsa S \nSi quieres terminar pulsa N")
    if preguntarSeguir == 'S' or preguntarSeguir == 's':
        opciones()
    else:
        seguir = False
