#include <Wire.h>
#include "MAX30105.h"
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>

#define OLED_Address 0x3C
Adafruit_SSD1306 oled(1);

#include "heartRate.h"
// pls apply STEADY pressure on the heart side of the sensor. Since this sensor is too sensitive, any change in the pressure applied WILL affect change in results.
// For usage of MAX30105, please check the License attached.

MAX30105 particleSensor;

const byte RATE_SIZE = 10; 
byte rates[RATE_SIZE]; 
byte rateSpot = 0;
long lastBeat = 0; //Time at which the last beat occurred

float beatsPerMinute;
int beatAvg;

void setup()
{
  Serial.begin(115200);
  Serial.println("Initializing...");
   oled.begin(SSD1306_SWITCHCAPVCC, OLED_Address);
   oled.clearDisplay();
  // Initialize sensor
  if (!particleSensor.begin(Wire, I2C_SPEED_FAST)) //Use default I2C port, 400kHz speed
  {
    Serial.println("MAX30105 not found");
    while (1);
  }
  Serial.println("Place finger.");

  particleSensor.setup(); //Configure sensor with default settings
  particleSensor.setPulseAmplitudeRed(0x0A); //Turn Red LED to low 
  particleSensor.setPulseAmplitudeGreen(0); 
}

void loop()
{
  long irValue = particleSensor.getIR();

  if (checkForBeat(irValue) == true)
  {
    //We sensed a beat!
    long delta = millis() - lastBeat;
    lastBeat = millis();

    beatsPerMinute = 60 / (delta / 1000.0);

    if (beatsPerMinute < 255 && beatsPerMinute > 20)
    {
      rates[rateSpot++] = (byte)beatsPerMinute; //Store this reading in the array
      rateSpot %= RATE_SIZE; //Wrap variable

      //Take average of readings
      beatAvg = 0;
      for (byte x = 0 ; x < RATE_SIZE ; x++)
        beatAvg += rates[x];
      beatAvg /= RATE_SIZE;
    }
  }

  Serial.print("IR=");
  Serial.print(irValue);
  Serial.print(", BPM=");
  Serial.print(beatsPerMinute);
  Serial.print(", Avg BPM=");
  Serial.print(beatAvg);

  if (irValue < 50000)
    Serial.print(" No finger?");

  Serial.println();
  oled.clearDisplay();
  oled.setTextColor(WHITE);
  // oled.writeFillRect(0,50,128,16,BLACK);
  oled.setCursor(0,0);
  oled.println("Avg BPM:");
  oled.print(beatAvg);
  oled.display();
}
