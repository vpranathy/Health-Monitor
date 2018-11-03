void setup() {
  Serial.begin(9600);   //Sets the baud for serial data transmission                               
  pinMode(LED_BUILTIN, OUTPUT);  //Sets digital led as output
}

void loop()
{
  char c;
if(Serial.available())
  {
   c = Serial.read();
   if(c=='1') // Checks whether value of c is equal to 1
         digitalWrite(LED_BUILTIN, HIGH);   //If value is 1 then LED turns ON
   else if(data == '0')         //  Checks whether value of c is equal to 0
         digitalWrite(LED_BUILTIN, LOW);    //If value is 0 then LED turns OFF
  }

}
