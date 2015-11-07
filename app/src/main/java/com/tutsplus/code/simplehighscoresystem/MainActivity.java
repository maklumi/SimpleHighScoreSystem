package com.tutsplus.code.simplehighscoresystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    HighscoreManager hm;
    TextView textView;
    EditText editText;
    Button buttonOK, buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //test
        hm = new HighscoreManager();
        hm.addScore("Bart",240);
        hm.addScore("Marge",300);
        hm.addScore("Maggie",220);
        hm.addScore("Homer",100);
        hm.addScore("Lisa", 270);

        System.out.print(hm.getHighscoreString());

        textView = (TextView)findViewById(R.id.textView);
        textView.setText(hm.getHighscoreString());

        editText = (EditText)findViewById(R.id.editText);
       /* editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    MasukNama(editText);
                    return true;
                }
                return false;
            }
        });*/
        buttonCancel = (Button)findViewById(R.id.buttonCancel);
        buttonOK = (Button)findViewById(R.id.buttonOK);

    }

    public void MasukNama(View view) {
        String namaMasukan = "";
        namaMasukan = editText.getText().toString();

        hm.addScore(namaMasukan, 250);
        System.out.print(hm.getHighscoreString());
        textView.setText(hm.getHighscoreString());
        Log.i("Minimum score", hm.getMinNumberCanEnterTopTen() + "");

    }

    public void Batal(View view) {
        //// TODO: 6/11/2015 return to calling activity
    }

}
