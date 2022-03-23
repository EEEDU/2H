class matriz:
    def __init__(self, rows, columns, matrix):
        self.rows = rows
        self.columns = columns
        self.matrix = map(lambda x: x + ([0] * (columns - len(x))), matrix + ([[0] * columns] * (rows - len(matrix))))
        self.matrix = list(self.matrix)
    
    def getNumberRows(self):
        return len(self.rows)
    
    def getNumberColumns(self):
        return len(self.columns)

    def setElement(self, element):
        self.rows = element
        self.columns = element
        self.matrix = [[]]
        self.matrix = map(lambda x: x + ([0] * (self.columns - len(x))), self.matrix + ([[0] * self.columns] * (self.rows - len(self.matrix))))
        self.matrix = list(self.matrix)

    def addMatrix(self, matSum):
        if self.rows == len(matSum) and self.columns == len(matSum[0]):
            for i in range (0, self.rows):
                for j in range (0, self.columns):
                    self.matrix[i][j] += matSum[i][j]
        else:
            print("la matriz inicial y la matriz sumador no tiene las mismas filas o columnas")
        print(self.matrix)

    def mulMatrix(self, matMul):
        if self.rows == len(matMul) and self.columns == len(matMul[0]):
            for i in range (0, self.rows):
                for j in range (0, self.columns):
                    self.matrix[i][j] *= matMul[i][j]
        else:
            print("la matriz inicial y la matriz multiplicadora no tiene las mismas filas o columnas")
        print(self.matrix)


filas = 2
columnas = 2
mat = [[]]
m1 = matriz(filas, columnas, mat)

matrizSuma = [[2, 2], [3, 4]]
m1.addMatrix(matrizSuma)

matrizMultiplica = [[2, 2], [3, 4]]
m1.mulMatrix(matrizMultiplica)