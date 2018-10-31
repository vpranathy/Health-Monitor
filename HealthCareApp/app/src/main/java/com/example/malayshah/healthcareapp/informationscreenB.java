package com.example.malayshah.healthcareapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class informationscreenB extends AppCompatActivity {
    TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informationscreen_b);
        tv2 = (TextView) findViewById(R.id.textView18);
        loadText();
    }
    private void loadText(){
        String s = "research found it’s important to choose the right music for the topic you’re studying. Budding mathematicians should introduce classical music to their play list. Research found that in order to stimulate learning and enhance concentration, " +
                "students who listened to classical music (with 60-70 beats per minute) while studying scored on average 12 per cent more in their Maths exams. ‘The melody and tone range in classical music, like Beethoven’s Fur Elise, helped students to study for longer and retain more information,’ she says. " +
                "‘Music in this range induces a state of relaxation where the mind is calm but alert, the imagination is stimulated and concentration is heightened (similar to a meditative state). And this is thought to be the best for learning.’ And for those studying Science, Humanities and Languages, " +
                "‘The left side of the brain is used to process factual information and solve problems, which are key skills in these topics,’ she says. ‘Listening to music with 50-80 beats per minute has a calming effect on the mind that is conducive to logical thought, allowing the brain to learn and remember new facts.’";

        Twitter: https://twitter.com/MetroUK | Facebook: https://www.facebook.com/MetroUK/;
        tv2.setMovementMethod(new ScrollingMovementMethod());
        tv2.setText(s);
    }
}

