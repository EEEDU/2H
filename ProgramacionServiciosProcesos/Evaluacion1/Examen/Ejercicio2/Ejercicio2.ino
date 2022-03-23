const int semaforo1rojo = 8;
const int semaforo1amarillo = 9;
const int semaforo1verde = 10;

const int semaforo2rojo = 11;
const int semaforo2amarillo = 12;
const int semaforo2verde = 13;

const int pulsador1 = 2;
const int pulsador2 = 3;

int valorPulsador1;
int valorPulsador2;

int valorVerde1;
int valorRojo1;
int valorVerde2;
int valorRojo2;

const int espera = 1000;

bool primera = true;

void setup() {
  // put your setup code here, to run once:
  pinMode(semaforo1rojo, OUTPUT);
  pinMode(semaforo1amarillo, OUTPUT);
  pinMode(semaforo1verde, OUTPUT);
  pinMode(semaforo2rojo, OUTPUT);
  pinMode(semaforo2amarillo, OUTPUT);
  pinMode(semaforo2verde, OUTPUT);

  pinMode(pulsador1, INPUT);
  pinMode(pulsador2, INPUT);
}

void loop() {
  // put your main code here, to run repeatedly:

  valorVerde1 = digitalRead(semaforo1verde);
  valorRojo1 = digitalRead(semaforo1rojo);
  valorVerde2 = digitalRead(semaforo2verde);
  valorRojo2 = digitalRead(semaforo2rojo);

  if (primera){
    digitalWrite(semaforo1verde, HIGH);
    digitalWrite(semaforo2rojo, HIGH);
    primera = false;
  }
  
  valorPulsador1 = digitalRead(pulsador1);
  if (valorPulsador1 == HIGH && valorVerde2 == HIGH && valorRojo1 == HIGH){
    digitalWrite(semaforo1verde, LOW);
    digitalWrite(semaforo1rojo, HIGH);
    digitalWrite(semaforo2verde, HIGH);
    digitalWrite(semaforo2rojo, LOW);
    delay(espera);
    digitalWrite(semaforo1rojo,LOW);
    digitalWrite(semaforo1amarillo, HIGH);
    digitalWrite(semaforo2verde, LOW);
    digitalWrite(semaforo2amarillo, HIGH);
    delay(espera);
    digitalWrite(semaforo1amarillo,LOW);
    digitalWrite(semaforo1verde, HIGH);
    digitalWrite(semaforo2amarillo,LOW);
    digitalWrite(semaforo2rojo, HIGH);
    
  }

  valorPulsador2 = digitalRead(pulsador2);
  if (valorPulsador2 == HIGH && valorVerde1 == HIGH && valorRojo2 == HIGH){
    digitalWrite(semaforo2verde, LOW);
    digitalWrite(semaforo2rojo, HIGH);
    digitalWrite(semaforo1verde, HIGH);
    digitalWrite(semaforo1rojo, LOW);
    delay(espera);
    digitalWrite(semaforo2rojo,LOW);
    digitalWrite(semaforo2amarillo, HIGH);
    digitalWrite(semaforo1verde, LOW);
    digitalWrite(semaforo1amarillo, HIGH);
    delay(espera);
    digitalWrite(semaforo2amarillo,LOW);
    digitalWrite(semaforo2verde, HIGH);
    digitalWrite(semaforo1amarillo,LOW);
    digitalWrite(semaforo1rojo, HIGH);
  }
  

}
