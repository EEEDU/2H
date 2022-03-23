const int led_verde = 13;
const int led_amarillo = 11;
const int led_rojo = 9;

const int pulsador = 5;
const int pulsador2 = 3;

int valor1 = 0;
int valor2 = 0;

int valor_verde = 0;
int valor_amarillo = 0;
int valor_rojo = 0;

void setup() {
  // put your setup code here, to run once:
  pinMode(led_verde, OUTPUT);
  pinMode(led_amarillo, OUTPUT);
  pinMode(led_rojo, OUTPUT);
  pinMode(pulsador, INPUT);
  pinMode(pulsador2, INPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  valor1 = digitalRead(pulsador);
  valor2 = digitalRead(pulsador2);
  
  valor_verde = digitalRead(led_verde);
  valor_amarillo = digitalRead(led_amarillo);
  valor_rojo = digitalRead(led_rojo);
  
  if(valor1 == HIGH && valor2 == LOW && valor_verde == LOW){
    digitalWrite(led_verde, HIGH);  
    delay(500);
  } 
  if(valor1 == HIGH && valor2 == LOW && valor_verde == HIGH){
    digitalWrite(led_verde, LOW);
    delay(500);
  }

  if(valor1 == LOW && valor2 == HIGH && valor_amarillo == LOW){
    digitalWrite(led_amarillo, HIGH);  
    delay(500);
  } 
  if(valor1 == LOW && valor2 == HIGH && valor_amarillo == HIGH){
    digitalWrite(led_amarillo, LOW);
    delay(500);
  }

  if(valor1 == HIGH && valor2 == HIGH && valor_rojo == LOW){
    digitalWrite(led_rojo, HIGH); 
    delay(500); 
  } 
  if(valor1 == HIGH && valor2 == HIGH && valor_rojo == HIGH){
    digitalWrite(led_rojo, LOW);
    delay(500); 
  }
  
}
