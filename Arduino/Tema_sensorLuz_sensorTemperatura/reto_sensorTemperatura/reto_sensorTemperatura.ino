// Pin donde se conectan los leds
int pinLed = 11;

// Pin analogico de entrada para el LDR
int pinSensor = 1;
 
// Variable donde se almacena el valor del LDR
float temperatura;  
 
void setup()
{
  // Configuramos como salidas los pines donde se conectan los led
  pinMode(pinLed, OUTPUT);
  
  //  Configurar el puerto serial
  Serial.begin(9600);
}
 
void loop()
{
  // Apagar todos los leds siempre que se inicia el ciclo
  digitalWrite(pinLed, LOW);
 
  // Guardamos el valor leído del ADC en una variable
  // El valor leido por el ADC (voltaje) aumenta de manera directamente proporcional
  // con respecto a la luz percibida por el LDR
  temperatura = analogRead(pinSensor);
  temperatura = (5.0 * temperatura * 100.0)/1024.0; 
  // Devolver el valor leido a nuestro monitor serial en el IDE de Arduino
  Serial.print(temperatura);
  // Salto de línea
  Serial.print("\n");

  if (temperatura >= 25){
    digitalWrite(pinLed, HIGH);
  }
  if (temperatura <= 23){
    digitalWrite(pinLed, LOW);
  }
  
  // Esperar unos milisegundos antes de actualizar
  delay(200);
}
