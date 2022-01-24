long valor;
const int led = 9; 

void setup() {
  //Inicializamos la comunicación serial
  Serial.begin(9600);
  
  pinMode(led, OUTPUT);
  
}
 
void loop() {
  valor = analogRead(A1);
  valor = 1200 - valor;
  
  digitalWrite(led, HIGH);
  delay(valor);
  digitalWrite(led, LOW);
  delay(valor);
}
