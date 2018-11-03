Mobile Application :
 1) To test the php files used by the mobiles application, Open a web browser.
 2) Browse to the following links

    a: http://healthmonitoringsystem.us-east-2.elasticbeanstalk.com/mobile_connect.php
    b: http://healthmonitoringsystem.us-east-2.elasticbeanstalk.com/mobile_login.php
    c: http://healthmonitoringsystem.us-east-2.elasticbeanstalk.com/mobile_register.php
    d: http://healthmonitoringsystem.us-east-2.elasticbeanstalk.com/mobile_heartrate.php
 if all of the above url's open without a connection error then the all the units for the mobile application is working fine.



Web Application:








Arduino bluetooth:

The blutooth_arduino folder in the main repository is the original code that we are developing for our Heart-rate modulator. However, we still have to resolve some bugs for the latest Android versions. We are facing some permission issues with the AppManifest.xml file.

For the demo, we used a prebuilt app given in the reference and the apk is provided in the test Bluetooth_testing folder. The arduino code used for Bluetooth testing is also provided in the folder. To test the bluetooth functionality of the arduino, install the LedController.apk in any android phone. Flash the Arduino code in any arduino board. Flashing the code requires Arduino Studio IDE. Attach the HC-05 bluetoooth module to the arduino.

The circuit is simple and small, there is only few connections to be made

Arduino Pins Bluetooth Pins(HC-05)

RX (Pin 0) ———-> TX TX (Pin 1) ———-> RX 5V ———-> VCC GND ———-> GND

Connect the phone to the bluetooth module, using inbuilt bluetooth search in the android phone. Open the App, search for Paired Devices and connect. Turn led On and Off using the given GUI.

Reference for the Android App used for testing: https://github.com/Mayoogh/Arduino-Bluetooth-Basic/tree/master/LED%20Controller%20APK




