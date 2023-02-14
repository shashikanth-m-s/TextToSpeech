package com.sms.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    EditText textValues;
    Button speech;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textValues=findViewById(R.id.textValues);
        speech=findViewById(R.id.speech);

        textToSpeech=new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    textToSpeech.setLanguage(Locale.ENGLISH
                    );
                } else {
                    Log.e("failed", "onInit: failed");
                }

            }
        });
        speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=textValues.getText().toString();
                textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}