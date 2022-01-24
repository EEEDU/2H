
int x = 50;
boolean subir = false;
void setup() {
  // initialize digital pin LED_BUILTIN as an output.
  pinMode(LED_BUILTIN, OUTPUT);
}

// the loop function runs over and over again forever
void loop() {
  digitalWrite(LED_BUILTIN, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(x);                       // wait for a second
  digitalWrite(LED_BUILTIN, LOW);    // turn the LED off by making the voltage LOW
  delay(x);                       // wait for a second
  
  if(subir){
    x = x + 50;
  }
  else{
    x = x - 50;
  }
  
  if(x >= 1000){
    subir = false;
  }
  else if(x <= 10){
    subir = true;
  }
}
