int led = 9;
int led2 = 10;

int brillo = 0;
int brillo2 = 255; 

int cantDes = 5;    
int cantDes2 = 5;   

// the setup routine runs once when you press reset:
void setup() {
  // declare pin 9 to be an output:
  pinMode(led, OUTPUT);
  pinMode(led2, OUTPUT);
}

// the loop routine runs over and over again forever:
void loop() {
  // set the brightness of pin 9:
  analogWrite(led, brillo);
  analogWrite(led2, brillo2);

  // change the brightness for next time through the loop:
  brillo = brillo + cantDes;
  brillo2 = brillo2 - cantDes2;

  // reverse the direction of the fading at the ends of the fade:
  if (brillo <= 0 || brillo >= 255) {
    cantDes = -cantDes;
  }
  if (brillo2 <= 0 || brillo2 >= 255) {
    cantDes2 = -cantDes2;
  }
  // wait for 30 milliseconds to see the dimming effect
  delay(30);
}
