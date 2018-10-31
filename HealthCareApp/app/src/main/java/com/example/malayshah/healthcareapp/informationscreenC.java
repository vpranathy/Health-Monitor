package com.example.malayshah.healthcareapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import org.w3c.dom.Text;

public class informationscreenC extends AppCompatActivity {
    TextView tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informationscreen_c);
        tv3 = (TextView) findViewById(R.id.textView21);
        loadText();
    }
    private void loadText(){
        String s = "Transitioning from wakefulness to sleep involves complex signaling that affects heart rate, blood pressure and body temperature as well as other body parameters and functions. Average heart rate during sleep decreases by roughly 24 beats per minute in young adults and 14 beats per minute in" +
                " those older than age 80"+
                "Two main types of sleep occur as you slumber. These are known as REM and non-REM sleep. REM is an acronym for rapid eye movement" +
                ", which characterizes the type of sleep most closely associated with vivid dreams."
                +"In general, your heart rate is lower during non-REM sleep than it is when you are in REM sleep or awake. " +
                "Non-REM sleep normally accounts for approximately 75 to 80 percent of total sleep time in adults.REM sleep accounts for approximately 20 to 25 percent of total nightly sleep time in adults. "
                +" Your heart rate during REM sleep is typically higher and more variable than in non-REM sleep stages. This may be due to a combination of factors, including increased blood flow and activity in certain areas of the brain, and augmented nerve signals that speed the heart rate."
                +"";
        tv3.setMovementMethod(new ScrollingMovementMethod());
        tv3.setText(s);
    }
}
