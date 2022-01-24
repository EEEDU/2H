int option;
int led = 9;
 
void setup(){
  Serial.begin(9600);
  pinMode(led, OUTPUT); 
}
 
void loop()
{
  //si existe datos disponibles los leemos
  if (Serial.available()>0)
  {
    //leemos la opción enviada
    for (option=Serial.parseInt(); option>0;option--)
    {
    digitalWrite (led, HIGH);
    delay (300);
    digitalWrite (led, LOW);
    delay (300);
    }
  }
}
