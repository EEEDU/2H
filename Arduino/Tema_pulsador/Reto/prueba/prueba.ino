int led_rojo1 = 8;
int led_rojo2 = 9;
int led_especial = 10;
int led_rojo3 = 11;
int led_rojo4 = 12;

int pulsador = 3;

int valor = 1;
int ledState = HIGH;         // the current state of the output pin
int buttonState;             // the current reading from the input pin
int lastButtonState = LOW;   // the previous reading from the input pin

// the following variables are unsigned longs because the time, measured in
// milliseconds, will quickly become a bigger number than can be stored in an int.
unsigned long lastDebounceTime = 0;  // the last time the output pin was toggled
unsigned long debounceDelay = 50;    // the debounce time; increase if the output flickers

void setup() {
  pinMode(led_rojo1, OUTPUT);
  pinMode(led_rojo2, OUTPUT);
  pinMode(led_especial, OUTPUT);
  pinMode(led_rojo3, OUTPUT);
  pinMode(led_rojo4, OUTPUT);
  
  pinMode(pulsador, INPUT);
}

void loop() {
  // read the state of the switch into a local variable:
  int reading = digitalRead(pulsador);
  
  if (reading != lastButtonState) {
    lastDebounceTime = millis();
  }

  if ((millis() - lastDebounceTime) > debounceDelay) {

    if (reading != buttonState) {
      buttonState = reading;


      if (buttonState == HIGH) {
        ledState = !ledState;
      }
    }
  }

  if(valor == 1){
    digitalWrite(led_rojo1, HIGH);
    delay(200);
    digitalWrite(led_rojo2, LOW);
  }

  lastButtonState = reading;
}
