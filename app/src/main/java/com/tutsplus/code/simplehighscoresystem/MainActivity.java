package com.tutsplus.code.simplehighscoresystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //test
        HighscoreManager hm = new HighscoreManager();
        hm.addScore("Bart",240);
        hm.addScore("Marge",300);
        hm.addScore("Maggie",220);
        hm.addScore("Homer",100);
        hm.addScore("Lisa", 270);

        System.out.print(hm.getHighscoreString());

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(hm.getHighscoreString());
    }


}
