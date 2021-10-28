salarios = [[700, 900, 1300] , [1000, 950, 1080], [1300, 930, 1200]]
empleados = ["Javier María", "Antonio Muñoz", "Isabel Allende"]

for i in range(0, len(empleados)):
    print(empleados[i], " -> ", salarios[i][0], " + ", salarios[i][1], " + ", salarios[i][2], " = ", salarios[i][0] + salarios[i][1] + salarios[i][2], " €")