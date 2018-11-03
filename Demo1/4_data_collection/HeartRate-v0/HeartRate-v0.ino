#include <Adafruit_SSD1306.h>
#define OLED_Address 0x3C
Adafruit_SSD1306 oled(1);

// Please apply STEADY pressure on the heart side of the sensor. Since this sensor is too sensitive, any change in the pressure applied WILL affect change in results.

int x=0;
int lastx=0;
int lasty=0;
int LastTime=0;
bool BPMTiming=false;
bool BeatComplete=false;
int BPM=0;

#define UpperThreshold 550
#define LowerThreshold 500

void setup() {
  oled.begin(SSD1306_SWITCHCAPVCC, OLED_Address);
  oled.clearDisplay();
  oled.setTextSize(2);
}


void loop() 
{
  if(x>127)  
  {
    oled.clearDisplay();
    x=0;
    lastx=x;
  }

  int value=analogRead(0);
  oled.setTextColor(WHITE);
  int y=60-(value/16);
  oled.writeLine(lastx,lasty,x,y,WHITE);
  lasty=y;
  lastx=x;
  // calc bpm

  if(value>UpperThreshold)
  {
    if(BeatComplete)
    {
      BPM=millis()-LastTime;
      BPM=int(60/(float(BPM)/1000));
      BPMTiming=false;
      BeatComplete=false;
    }
    if(BPMTiming==false)
    {
      LastTime=millis();
      BPMTiming=true;
    }
  }
  if((value<LowerThreshold)&(BPMTiming))
    BeatComplete=true;
    // display bpm
  oled.writeFillRect(0,50,128,16,BLACK);
  oled.setCursor(0,50);
  oled.print(BPM);
  oled.print(" BPM");
  oled.display();
  x++;
}
