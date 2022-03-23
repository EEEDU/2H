const int led_verde = 13;
const int led_amarillo = 11;
const int led_rojo = 9;
const int pulsador = 5;

int valor = 0;
int estado = 0;

void setup() {
  // put your setup code here, to run once:
  pinMode(led_verde, OUTPUT);
  pinMode(led_amarillo, OUTPUT);
  pinMode(led_rojo, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  valor = digitalRead(pulsador);
  if(valor == HIGH){
    estado = 1;
  } 
  else {
    estado = 0;
  }
  
  if(estado == HIGH){
    digitalWrite(led_verde, HIGH);
    delay(5000);
    digitalWrite(led_verde, LOW);
    digitalWrite(led_amarillo, HIGH);
    delay(1000);
    digitalWrite(led_amarillo, LOW);
    digitalWrite(led_rojo, HIGH);
    delay(3000);
    digitalWrite(led_rojo, LOW);    
  }
}
