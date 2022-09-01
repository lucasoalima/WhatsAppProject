package com.example.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.EventListener;

public class MainActivity extends AppCompatActivity {

    private Button enviarButton;
    private TextView number;
    private TextView message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enviarButton = findViewById(R.id.enviarButton);
        number = findViewById(R.id.number);
        message = findViewById(R.id.message);

        enviarButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View View) {


                        String text = message.getText().toString();
                        String numberPhone = number.getText().toString();

                        String url = LinkWhatsapp(text, numberPhone);

                        openWebPage(url);

                    }
                }
        );
    }


                    public String LinkWhatsapp(String text, String number) {
                       text = text.replace(" ", "%20");

                        if (number.length() <= 11) {
                            number = number.replace(number, "55" + number);
                        }
                        String result = "https://wa.me/" + number + "?text=" + text;
                        return result;
                    }


                    public void openWebPage(String url) {
                        Uri webpage = Uri.parse(url);
                        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                        startActivity(intent);
                    }
                }
