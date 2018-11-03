Data Collection: 

WARNING : 

Please be aware that the heart rate result provided CANNOT be used for medical purpose. Please consult your physician IMMINENTLY if you feel something wrong while using the device.

CONFIGURATION :
    
    For this project, we are using custom build heart rate monitor device instead of pre-made smartwatches. 
    The hardware are the following:
    - Arduino board: Arduino uno | OCROBOT Alpha 8F328P-U
    - Sensor:        Max30102    | PulseSensor | KY-039
    - OLED display:  SSD1306  
    - Bluetooth:     HC-05 JY-MCU
    
    For Arduino board+ PulseSensor + SSD1306 OLED display, use file "HeartRate-v0". 
    
    For Arduino board + Max30102 + SSD1306 OLED display, use file "HeartRate-v1". 
    
    The KY-039 Finger Measuring Heartbeat Sensor is not used in this project because it is not as stable as the other two. However, KY-039 can be an option for the data input.
    
OPERATING :
    
   + To begin, you need to add the "Adafruit_GFX.h" and "Adafruit_SSD1306.h" library to the ide. These two are required to boot the OLED screen. You may need to change the preset size of the screen before including the library to get the best result.
    
   + For "HeartRate-v1", another library "heartRate.h" is required in order to provide a precise result of heartbeat detection. This is an implementation of Maxim's PBA (Penpheral Beat Amplitude) algorithm. Check the reference in the section 'COPYRIGHT AND LICENSING' for more information.
    
   + To use "HeartRate-v0":
    
        1) Correctly connect all components and connect to PC which has   Arduino studio.
        
        2) Open "HeartRate-v0.ino", compile and upload to the board.
        
        3) Wait for the device to initialize, when the light on PulseSensor is green and the OLED screen showing '0 BPM', put your finger on the PulseSensor and apply steady pressure. You may need to change the section touching the sensor in order to get the best reading.
        
        4) The current BPM information will be displayed both on the OLED screen and in the Serial Monitor.
    
   + To use "HeartRate-v1":
    
        1) Correctly connect all components and connect to PC which has   Arduino studio.
        
        2) Open "HeartRate-v1.ino", make sure both libraries had been downloaded to the ide and then compile the code then upload to the board.
        
        3) Wait for the device to initialize, when the red light on the sensor turns on and the OLED screen showing '0 BPM', put your finger on the sensor and apply steady pressure. Here I suggest using a rubber band attached to the sensor to help to generate constant pressure. You may need to change the section touching the sensor in order to get the best reading.
        
        4) The current BPM information will be displayed both on the OLED screen and in the Serial Monitor.

    + To Shut Down unplug the power cable of the device.
    
    + To Reset the device press the botton on the board.
    
FILE MANIFEST :

    +HeartRate-v0
        -HeartRate-v0.ino
    +HeartRate-v1
        -HeartRate-v1.ino
        -License.ino
    +i2cScanner
        -i2cScanner.ino
    
COPYRIGHT AND LICENSING:
    
    For details of the Maxim's PBA (Penpheral Beat Amplitude) algorithm, please Reference: https://fruct.org/publications/fruct13/files/Lau.pdf
    
    To understand the optical heart rate detection, please Reference:
    http://www.ti.com/lit/an/slaa655/slaa655.pdf
    
    For the usage of Max30102 device and software, please check the "License" in the folder "HeartRate-v1".

CONTACT INFORMATION :

    - Programmer : Zihao Ding (Rx0Banshee)
    - Project Website: https://github.com/vpranathy/Health-Monitor
    - Project Homepage: http://healthmonitoringhomepage-env.5ndteffiz2.us-east-2.elasticbeanstalk.com/
    
KNOWN BUGS AND TROUBLESHOOTING :

    - PulseSensor may not give any output. <= Check connection, apply constant pressure, replace the sensor.
    
    - For "HeartRate-v1", OLED screen not displaying correct BPM. <= Wait for program update, will fix in future.
    
    - Return 'No device found' <= Run i2cScanner attached in the project to see if all devices are connected correctly. Manually add the i2c address to the program file.

ACKNOWLEDGMENTS :
    Please check "user_documentation.pdf"

NEWS :
    This is the v0.1 of the Custom build heart rate device.

    

    