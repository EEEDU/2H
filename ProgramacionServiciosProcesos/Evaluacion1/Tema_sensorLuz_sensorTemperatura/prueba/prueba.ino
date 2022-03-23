// Pin donde se conectan los leds
int pinLed1 = 8;
int pinLed2 = 9;
int pinLed3 = 10;
int pinLed4 = 11;
int pinLed5 = 12;
int pinLed6 = 13;

// Pin analogico de entrada para el LDR
int pinLDR = 1;
 
// Variable donde se almacena el valor del LDR
int valorLDR = 0;  
 
void setup()
{
  // Configuramos como salidas los pines donde se conectan los led
  pinMode(pinLed1, OUTPUT);
  pinMode(pinLed2, OUTPUT);
  pinMode(pinLed3, OUTPUT);
  pinMode(pinLed4, OUTPUT);
  pinMode(pinLed5, OUTPUT);
  pinMode(pinLed6, OUTPUT);
  
  //  Configurar el puerto serial
  Serial.begin(9600);
}
 
void loop()
{
  // Apagar todos los leds siempre que se inicia el ciclo
  digitalWrite(pinLed1, LOW);
  digitalWrite(pinLed2, LOW);
  digitalWrite(pinLed3, LOW);
  digitalWrite(pinLed4, LOW);
  digitalWrite(pinLed5, LOW);
  digitalWrite(pinLed6, LOW);
 
  // Guardamos el valor leído del ADC en una variable
  // El valor leido por el ADC (voltaje) aumenta de manera directamente proporcional
  // con respecto a la luz percibida por el LDR
  valorLDR= analogRead(pinLDR);
  
  // Devolver el valor leido a nuestro monitor serial en el IDE de Arduino
  Serial.println(valorLDR);
 
  // Encender los leds apropiados de acuerdo al valor de ADC
  if(valorLDR / 1 > 170)
  {
    digitalWrite(pinLed1, HIGH);
  }
  if(valorLDR / 2 > 170)
  {
    digitalWrite(pinLed2, HIGH);
  }
  if(valorLDR / 3 > 170)
  {
    digitalWrite(pinLed3, HIGH);
  }
  if(valorLDR / 4 > 170)
  {
    digitalWrite(pinLed4, HIGH);
  }
  if(valorLDR / 5 > 170)
  {
    digitalWrite(pinLed5, HIGH);
  }
  if(valorLDR / 6 > 170)
  {
    digitalWrite(pinLed6, HIGH);
  }
  
  // Esperar unos milisegundos antes de actualizar
  delay(200);
}
