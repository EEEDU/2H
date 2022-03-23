const int led=9;
void setup() {
  // initialize digital pin LED_BUILTIN as an output.
  pinMode(led, OUTPUT);
}

// the loop function runs over and over again forever
void loop() {
  for (int i = 100; i <= 1000; i=i+100) {
    // turn the pin on:
    digitalWrite(led, HIGH);
    delay(i);
    // turn the pin off:
    digitalWrite(led, LOW);
    delay(i);
  }
}
