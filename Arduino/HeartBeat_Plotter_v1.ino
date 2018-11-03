#include <Adafruit_SSD1306.h>
#include <Wire.h>
#include "MAX30105.h"
#include "heartRate.h"
MAX30105 particleSensor;

const byte RATE_SIZE = 10; //Increase this for more averaging. 
byte rates[RATE_SIZE]; //Array of heart rates
byte rateSpot = 0;
long lastBeat = 0; //Time at which the last beat occurred

float beatsPerMinute;
int beatAvg;
//============================================ Sensor
#define OLED_Address 0x3C
Adafruit_SSD1306 oled(1);

int x=0;
int lastx=0;
int lasty=0;  
int LastTime=0;
bool BPMTiming=false;
bool BeatComplete=false;
int BPM=0;
#define UpperThreshold 550
#define LowerThreshold 500
//========================================== OLED

void setup()
{
  oled.begin(SSD1306_SWITCHCAPVCC, OLED_Address);
  oled.clearDisplay();
  oled.setTextSize(2); //boot oled
  
  Serial.begin(115200);
  Serial.println("Initializing...");

  // Initialize sensor
  if (!particleSensor.begin(Wire, I2C_SPEED_FAST)) //Use default I2C port, 400kHz speed
  {
    Serial.println("MAX30105 was not found.");
    while (1);
  }

  //Setup the plotter
  byte ledBrightness = 0x1F; //Options: 0=Off to 255=50mA
  byte sampleAverage = 8; //Options: 1, 2, 4, 8, 16, 32
  byte ledMode = 3; //Options: 1 = Red only, 2 = Red + IR, 3 = Red + IR + Green
  byte sampleRate = 100; //Options: 50, 100, 200, 400, 800, 1000, 1600, 3200
  int pulseWidth = 411; //Options: 69, 118, 215, 411
  int adcRange = 4096; //Options: 2048, 4096, 8192, 16384

  particleSensor.setup(ledBrightness, sampleAverage, ledMode, sampleRate, pulseWidth, adcRange); //Configure sensor with these settings

  
  const byte avgAmount = 64; //Take an average of IR readings at power up
  long baseValue = 0;
  for (byte x = 0 ; x < avgAmount ; x++)
  {
    baseValue += particleSensor.getIR(); //Read the IR value
  }
  baseValue /= avgAmount;

 
  for (int x = 0 ; x < 500 ; x++) //Pre-populate the plotter so that the Y scale is close to IR values
    Serial.println(baseValue);
}

void loop()
{
 Serial.println(particleSensor.getIR()); //Send raw data to plotter
 long irValue = particleSensor.getIR();

  if (checkForBeat(irValue) == true)
  {
    
    long delta = millis() - lastBeat;
    lastBeat = millis();

    beatsPerMinute = 60 / (delta / 1000.0);

    if (beatsPerMinute < 255 && beatsPerMinute > 20)
    {
      rates[rateSpot++] = (byte)beatsPerMinute; //Store this reading in the array
      rateSpot %= RATE_SIZE; //Wrap variable

      
      beatAvg = 0;//Take average of readings
      for (byte x = 0 ; x < RATE_SIZE ; x++)
        beatAvg += rates[x];
      beatAvg /= RATE_SIZE;
    }
  }
  //Serial.print("IR=");
  //Serial.print(irValue);
  //Serial.print(", BPM=");
  //Serial.print(beatsPerMinute);
  //Serial.print(", Avg BPM=");
  //Serial.print(beatAvg);
 //if (irValue < 50000)
   // Serial.print(" No finger?");



   if(x>125 )  
  {
    oled.clearDisplay();
    x=0;
    lastx=x;
  }

  long delta = millis() - lastBeat;
  oled.setTextColor(WHITE);
  int y=60-(delta/16);
  oled.writeLine(lastx,lasty,x,y,WHITE);
  lasty=y;
  lastx=x;
  // calc bpm

    if(checkForBeat(irValue) == true)
    {
      BPM=millis()-LastTime;
      BPM=int(60/(float(BPM)/16));
      BPMTiming=false;
    }
    if(BPMTiming==false)
    {
      LastTime=millis();
      BPMTiming=true;
    }
 
    // display bpm
  
   oled.writeFillRect(0,50,128,16,BLACK);
  oled.setCursor(0,50);
  oled.print(beatAvg);
  oled.print(" BPM");
  oled.display();
  x++;
}






  
