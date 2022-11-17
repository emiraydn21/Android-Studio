package com.example.myawesomequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private TextView textViewSoru;
    private TextView textViewSkor;
    private TextView textViewSoruSayısı;
    private TextView textViewGeriSayım;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private Button buttonSonrakiniOnayla;

    private List<Soru> soruList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewSoru = findViewById(R.id.text_view_soru);
        textViewSkor = findViewById(R.id.text_view_skor);
        textViewSoruSayısı = findViewById(R.id.text_view_soru_sayisi);
        textViewGeriSayım = findViewById(R.id.text_view_gerisayım);
        rbGroup = findViewById(R.id.radyo_grubu);
        rb1 = findViewById(R.id.radyo_dugmesi1);
        rb2 = findViewById(R.id.radyo_düğmesi2);
        rb3 = findViewById(R.id.radyo_düğmesi3);
        buttonSonrakiniOnayla = findViewById(R.id.button_onayla_sonrakini);

        BilgiYarismasiDBYardimcisi dbYardimcisi = new BilgiYarismasiDBYardimcisi(this);
        soruList = dbYardimcisi.getsAllSorular();


    }
}

