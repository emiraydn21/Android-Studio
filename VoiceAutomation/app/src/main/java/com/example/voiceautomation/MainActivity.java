package com.example.voiceautomation;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Sesli Komutu Çağırmak İçin
        voiceautomation();
    }

    private void voiceautomation() {
        Intent voice = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        voice.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        voice.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        Intent intent = voice.putExtra(RecognizerIntent.EXTRA_PROMPT, "Kamerayı Aç Deyin...");
        startActivityForResult(voice, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            ArrayList<String> arrayList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (arrayList.get(0).toString().equals("Kamerayı aç")) {
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(camera);
            }
            if (arrayList.get(0).toString().equals("mesaj gönder")) {
                String telNo = "5433431204";//mesaj gönderilecek numara
                String mesaj = "Bu mesaj Emir tarafından otomatik olarak gönderilmiştir."; //mesaj

                /* Bu kısım direk mesaj atmak için	.Herhangi bir uygulama açmaz direk mesaj atar.
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(telNo, null, mesaj, null, null);
                */

                Intent mesajGonder = new Intent(Intent.ACTION_VIEW);
                mesajGonder.setData(Uri.parse("sms:" + telNo));
                mesajGonder.putExtra("sms_body", mesaj);
                startActivity(mesajGonder);
            }
            if (arrayList.get(0).toString().equals("Gmail aç")) {
                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Konu");//Email konusu
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Bu Mail Emir AYDIN tarafından gönderilmiştir.");//Email içeriği
                startActivity(Intent.createChooser(emailIntent, "E-mail Göndermek için Seçiniz:")); //birden fazla email uygulaması varsa seçmek için
                String aEmailList[] = {"emir.aydn21@gmail.com", "o.bir.cash_21@hotmail.com"};  //Mail gönderielecek kişi.Birden fazla ise virgülle ayırarak yazılır
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
                startActivity(emailIntent);
            }
            if (arrayList.get(0).toString().equals("web sitesini aç")) {
                String url = "http://www.google.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
            if (arrayList.get(0).toString().equals("Ahmet'i ara")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:05433431204"));
                startActivity(intent);
            }
        }
    }
}