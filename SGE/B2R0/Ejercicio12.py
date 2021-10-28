class cuenta:
    def __init__(self, titular, *cantidad):
        self.titular = titular
        self.cantidad = cantidad
    
    def get_titular(self):
        return self.titular

    def set_titular(self, tit):
        self.titular = tit

    def get_cantiad(self):
        return self.cantidad

    def set_cantidad(self, can):
        self.cantidad = can

    def ingresar (self, can):
        if can > 0:
            self.set_cantidad(self.get_cantiad() + can)
            print("Ahora la cuenta de ", self.get_titular(), " tiene ", self.get_cantiad(), " €")
        else:
            print("No se puede ingresar una cantidad negativa")

    def retirar (self, can):
        if self.get_cantidad() > can:
            self.set_cantidad(self.get_cantiad() - can)
            print("Ahora la cuenta de ", self.get_titular(), " tiene ", self.get_cantiad(), " €")
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
