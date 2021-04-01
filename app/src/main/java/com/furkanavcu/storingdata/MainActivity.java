package com.furkanavcu.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.PlainTextAge);
        textView = findViewById(R.id.textViewAge);


        sharedPreferences = this.getSharedPreferences("com.furkanavcu.storingdata", Context.MODE_PRIVATE);


        int storedAgeValue=sharedPreferences.getInt("storedAge",0);
        if (storedAgeValue==0){
            textView.setText("Your Age:");
        }else {
            textView.setText("Your Age : "+storedAgeValue);
        }
    }

    public void saveButtonActivate(View view) {
        if (!editText.getText().toString().matches("")) {
            int userAge = Integer.parseInt(editText.getText().toString());
            textView.setText("Your Age: " + userAge);
            sharedPreferences.edit().putInt("storedAge",userAge).apply();
        }

    }

    public void buttonDeleteActivate(View view){
        int storedDataOfAge=sharedPreferences.getInt("storedAge",0);
        if (storedDataOfAge !=0){
            sharedPreferences.edit().remove("storedAge").apply();
            textView.setText("Your Age: ");
        }
    }
}