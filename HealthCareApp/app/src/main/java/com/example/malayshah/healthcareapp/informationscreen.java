package com.example.malayshah.healthcareapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import org.w3c.dom.Text;

public class informationscreen extends AppCompatActivity {
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informationscreen);
        tv1 = (TextView) findViewById(R.id.textView13);
        loadText();
    }
    private void loadText(){
        String s = "The American Heart Association and the Centers for Disease Control and Prevention recommend a general target heart rate of:\n" +
                "\n" +
                "Moderate exercise intensity: 50 to about 70 percent of your maximum heart rate\n" +
                "Vigorous exercise intensity: 70 to about 85 percent of your maximum heart rate\n" +
                "\n" +
                "If you're not fit or you're just beginning an exercise program, aim for the lower end of your target zone. Then, gradually build up the intensity. If you're healthy and want a vigorous intensity, opt for the higher end of the zone.\n" +
                "How to determine your target zone\n" +
                "\n" +
                "Use an online calculator to determine your desired target heart rate zone. Or, here's a simple way to do the math yourself. If you're aiming for a target heart rate in the vigorous range of 70 to 85 percent, you would calculate it like this:\n" +
                "\n" +
                "Subtract your age from 220 to get your maximum heart rate.\n" +
                "Calculate your resting heart rate by counting your heart beats per minute when you are at rest, such as first thing in the morning. It's usually somewhere between 60 and 100 beats per minute for the average adult.\n" +
                "Calculate your heart rate reserve (HRR) by subtracting your resting heart rate from your maximum heart rate. Your HRR is your resting heart rate subtracted from your maximum heart rate.\n" +
                "Multiply your HRR by 0.7 (70 percent). Add your resting heart rate to this number.\n" +
                "Multiply your HRR by 0.85 (85 percent). Add your resting heart rate to this number.\n" +
                "These two numbers are your training zone heart rate for vigorous intensity exercise. Your heart rate during exercise should be between these two numbers.\n" +
                "\n" +
                "For example, say your age is 45 and you want to figure out your target training heart rate zone for vigorous exercise. Subtract 45 from 220 to get 175 — this is your maximum heart rate. Next, calculate your HRR by subtracting your resting heart rate of 80 beats per minute from 175. Your HRR is 95. Multiply 95 by 0.7 to get 66.5, then add your resting heart rate of 80 to get 146.5. Now multiply 95 by 0.85 to get 80.75, then add your resting heart rate of 80 to get 160.75. So your target for your vigorous intensity training zone heart rate should be between 146.5 and 160.75 beats per minute.";
        tv1.setMovementMethod(new ScrollingMovementMethod());
        tv1.setText(s);
    }
}
