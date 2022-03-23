const int rojo = 9;
const int amarillo = 10;
const int verde = 11;

const int pila = 1;

int potenciaPila;
float voltaje;

void setup() {
  // put your setup code here, to run once:
  pinMode(rojo, OUTPUT);
  pinMode(amarillo, OUTPUT);
  pinMode(verde, OUTPUT);

  //  Configurar el puerto serial
  Serial.begin(9600);  
}

void loop() {
  // put your main code here, to run repeatedly:
  
  potenciaPila = analogRead(pila);
  voltaje = 0.0049 * potenciaPila;

  if(voltaje >= 1.40){
    digitalWrite(verde, HIGH);
    digitalWrite(amarillo, LOW);
    digitalWrite(rojo, LOW);
  }
  if(voltaje < 1.40 && voltaje >= 0.5){
    digitalWrite(verde, LOW);
    digitalWrite(amarillo, HIGH);
    digitalWrite(rojo, LOW);
  }
  if(voltaje < 0.5){
    digitalWrite(verde, LOW);
    digitalWrite(amarillo, LOW);
    digitalWrite(rojo, HIGH);
  }
  
  Serial.print(voltaje);
  // Salto de línea
  Serial.print("\n");
  delay(500);
}
