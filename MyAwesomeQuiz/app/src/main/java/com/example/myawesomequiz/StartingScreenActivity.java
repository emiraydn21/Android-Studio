package com.example.myawesomequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartingScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_screen);

        Button buttonBaşlaTest = findViewById(R.id.button_başla_test);
        buttonBaşlaTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaşlaTest();
            }
        });
    }

    private void BaşlaTest(){
        Intent intent = new Intent(StartingScreenActivity.this, QuizActivity.class);
        startActivity(intent);

    }
}


