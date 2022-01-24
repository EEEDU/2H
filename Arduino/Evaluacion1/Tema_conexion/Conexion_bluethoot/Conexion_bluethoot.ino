#include <SoftwareSerial.h> //Librería que permite establecer comunicación serie en otros pins.
//Aquí conectamos los pins RXD,TDX del módulo Bluetooth.
SoftwareSerial BT(10,11); //10 RX, 11 TX.
int led=8;
 
void setup()
{
  BT.begin(9600); //Velocidad del puerto del módulo Bluetooth
  Serial.begin(9600); //Abrimos la comunicación serie con el PC y establecemos velocidad

  pinMode(led, OUTPUT);
}
 
void loop()
{
  if(BT.available() > 0)
  {
    char estado = BT.read();
    
    Serial.print(estado);
    Serial.print("\n");
    
    if(estado == '1'){
      digitalWrite(led, HIGH);
    }
    else if(estado == '0'){
      digitalWrite(led, LOW);
    }
    
    delay(25);
  }
}

  
