int led_rojo1 = 8;
int led_rojo2 = 9;
int led_especial = 10;
int led_rojo3 = 11;
int led_rojo4 = 12;

int pulsador = 3;

int valor = 0;
int valorPulsador;
int velocidad = 1000;

boolean acertar = false;

void setup() {
  // put your setup code here, to run once:
  pinMode(led_rojo1, OUTPUT);
  pinMode(led_rojo2, OUTPUT);
  pinMode(led_especial, OUTPUT);
  pinMode(led_rojo3, OUTPUT);
  pinMode(led_rojo4, OUTPUT);
  
  pinMode(pulsador, INPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  
  digitalWrite(led_rojo1, HIGH);
  delay(velocidad);
  digitalWrite(led_rojo1, LOW);
  digitalWrite(led_rojo2, HIGH);
  delay(velocidad);
  digitalWrite(led_rojo2, LOW);
  digitalWrite(led_especial, HIGH);
  delay(velocidad / 2);
  valorPulsador = digitalRead(pulsador);
  if (valorPulsador == HIGH){
    delay(200);
    digitalWrite(led_especial, LOW);
    delay(200);
    digitalWrite(led_especial, HIGH);
    delay(200);
    digitalWrite(led_especial, LOW);
    delay(200);
    digitalWrite(led_especial, HIGH);
  }
  delay(velocidad / 2);
  digitalWrite(led_especial, LOW);
  digitalWrite(led_rojo3, HIGH);
  delay(velocidad);
  digitalWrite(led_rojo3, LOW);
  digitalWrite(led_rojo4, HIGH);
  delay(velocidad);
  digitalWrite(led_rojo4, LOW);
  
}
