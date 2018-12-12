 char* myStrings[]={"This is string 1", "This is string 2", "This is string 3",
"This is string 4", "This is string 5","This is string 6"};
 
 void setup()  
 {  
  Serial.begin(9600);  //Start bluetooth connection
 }  
 
 void loop()  
 {  
  if(Serial.available())  // If bluetooth connection is established
  {  
   char c = Serial.read();  // receive the data from android app. 
   if(c == 1){              // This is the trigger to tell arduino to start sending heartbeat data
    for (int i = 0; i < 6; i++){                         //logic to send the data 
      Serial.println(myStrings[i]);
      delay(500); 
    }  
   }
  } 
 } 
