
long valor;
const int led = 9; 

void setup() {
  //Inicializamos la comunicación serial
  Serial.begin(9600);
  
  pinMode(led, OUTPUT);
  
}
 
void loop() {
  valor = analogRead(A1);
  valor = valor / 4;
  
  analogWrite(led, valor);
  delay(30);
}
