const int zumbador = 9;

const int pinLDR = 1;
int valorLDR = 0; 

void setup() {
  // put your setup code here, to run once:
  pinMode(zumbador, OUTPUT);
  //  Configurar el puerto serial
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:


  valorLDR= analogRead(pinLDR);
  valorLDR /= 4;
  

  Serial.print(valorLDR);
  // Salto de línea
  Serial.print("\n");
  delay(500);

  analogWrite(zumbador, valorLDR);
}
