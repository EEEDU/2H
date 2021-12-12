# BIORRITMOS
from datetime import date
import math

cicloFisico = 23
cicloEmocional = 28
cicloIntelectual = 33
cicloIntuicion = 38

hoy = date.today()

diaNacimiento = int(input("Dime tu dia de nacimiento: "))
if (diaNacimiento <= 0 or diaNacimiento >= 32):
    print("*ERROR**")
    exit()
mesNacimiento = int(input("Dime tu mes de nacimiento: "))
if (mesNacimiento <= 0 or mesNacimiento >= 13):
    print("*ERROR**")
    exit()
anoNacimiento = int(input("Dime tu año de nacimiento: "))
if (anoNacimiento <= 2000 or anoNacimiento > hoy.year):
    print("*ERROR**")
    exit()

fechaNacimiento = date(anoNacimiento, mesNacimiento, diaNacimiento)

sumaDias = hoy - fechaNacimiento

fisico = math.sin((2*math.pi*sumaDias.days) / cicloFisico)
fisico *= 100
emocional = math.sin((2*math.pi*sumaDias.days) / cicloEmocional)
emocional *= 100
intelectual = math.sin((2*math.pi*sumaDias.days) / cicloIntelectual)
intelectual *= 100
intuicion = math.sin((2*math.pi*sumaDias.days) / cicloIntuicion)
intuicion *= 100

print("Tu nivel fisico es:", '% .2f' % fisico)
print("Tu nivel emocional es:", '% .2f' % emocional)
print("Tu nivel intelectual es:", '% .2f' % intelectual)
print("Tu nivel intuicion es:", '% .2f' % intuicion)
