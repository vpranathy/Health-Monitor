Mobile Application :
 1) To test the PHP files used by the mobiles application, Open a web browser.
 2) Browse to the following links

    a: http://healthmonitoringsystem.us-east-2.elasticbeanstalk.com/mobile_connect.php
    b: http://healthmonitoringsystem.us-east-2.elasticbeanstalk.com/mobile_login.php
    c: http://healthmonitoringsystem.us-east-2.elasticbeanstalk.com/mobile_register.php
    d: http://healthmonitoringsystem.us-east-2.elasticbeanstalk.com/mobile_heartrate.php
 if all of the above URL's open without a connection error then the all the units for the mobile application is working fine.



Web Application:
  For this system page, we currently have 3 main pages, one is the user's information page, one is the data table page, and the other one is the Heart Rate Graph page. In order to test the user's information page, I attached the screenshot of the table of user from our AWS RDS database. For testing the data table page, I also attached the screenshot of the table of HeartData from database. Please check these two screenshots, they will be prefectly matched up.
However, in order to test the graph page, I use the IPython Notebook to plot the graphs which are based on the same date table I used in PHP files, and then I match the graphs in IPython Notebook and the graphs in our system page. They are also been prefectly matched up. I also attached the IPython Notebook file and the screenshot of the result in IPython Notebook.






Arduino :

    - Heart rate input :
    Unzip the Arduino.zip, the following files are included in the zip:
        -HeartRate-v0
        -i2cScanner
        -Readme.txt
    In order to test the custom build heart rate monitor, please first read the "README.txt". Then upload the "i2cScanner.ino" to the board to check the connection of the components and the related i2c port information. Next, make sure the libraries mentioned in the "README.txt" are included in the Arduino IDE. After that, upload the "HeartRate-v0.ino", wait for the device to initialize. Take another device which can precisely measure the heart rate and measure the BPM. Finally, use the same finger with the custom-built heart rate monitor, check the output BPM. 
    
    - Bluetooth connection :

    The blutooth_arduino folder in the main repository is the original code that we are developing for our Heart-rate modulator. However, we still have to resolve some bugs for the latest Android versions. We are facing some permission issues with the AppManifest.xml file.

    For the demo, we used a prebuilt app given in the reference and the apk is provided in the test Bluetooth_testing folder. The Arduino code used for Bluetooth testing is also provided in the folder. To test the Bluetooth functionality of the Arduino, install the LedController.apk in any android phone. Flash the Arduino code to any Arduino board. Flashing the code requires Arduino Studio IDE. Attach the HC-05 Bluetooth module to the Arduino.

    The circuit is simple and small, there are only a few connections to be made

    Arduino Pins Bluetooth Pins(HC-05)

    RX (Pin 0) ———-> TX TX (Pin 1) ———-> RX 5V ———-> VCC GND ———-> GND

    Connect the phone to the Bluetooth module, using inbuilt Bluetooth search in the android phone. Open the App, search for Paired Devices and connect. Turn led On and Off using the given GUI.

    Reference for the Android App used for testing: https://github.com/Mayoogh/Arduino-Bluetooth-Basic/tree/master/LED%20Controller%20APK




