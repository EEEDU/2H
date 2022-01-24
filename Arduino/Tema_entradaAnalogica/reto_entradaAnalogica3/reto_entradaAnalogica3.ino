
long valor;
const int led1 = 8; 
const int led2 = 9; 
const int led3 = 10; 
const int led4 = 11; 
const int led5 = 12; 
const int led6 = 13; 

void setup() {
    //Inicializamos la comunicación serial
    Serial.begin(9600);

    pinMode(led1, OUTPUT);
    pinMode(led2, OUTPUT);
    pinMode(led3, OUTPUT);
    pinMode(led4, OUTPUT);
    pinMode(led5, OUTPUT);
    pinMode(led6, OUTPUT);
  
}
 
void loop() {
    valor = analogRead(A1);
  /*    
  for (int i = 1; i == 7; i++){
      if (valor / i >= 170){
        digitalWrite(led+i, HIGH);
        }
    }
    */
    
    if (valor / 1 >= 170){
        digitalWrite(led1, HIGH);
    }
    if (valor / 2 >= 170){
        digitalWrite(led2, HIGH);
    }
    if (valor / 3 >= 170){
        digitalWrite(led3, HIGH);
    }
    if (valor / 4 >= 170){
        digitalWrite(led4, HIGH);
    }
    if (valor / 5 >= 170){
        digitalWrite(led5, HIGH);
    }
    if (valor / 6 >= 170){
        digitalWrite(led6, HIGH);
    }
    
    if (valor / 1 <= 170){
        digitalWrite(led1, LOW);
    }
    if (valor / 2 <= 170){
        digitalWrite(led2, LOW);
    }
    if (valor / 3 <= 170){
        digitalWrite(led3, LOW);
    }
    if (valor / 4 <= 170){
        digitalWrite(led4, LOW);
    }
    if (valor / 5 <= 170){
        digitalWrite(led5, LOW);
    }
    if (valor / 6 < 170){
        digitalWrite(led6, LOW);
    }
    delay(30);
}
