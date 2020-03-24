package com.example.precious;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button messageButton;
    private EditText messageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageButton = findViewById(R.id.message_button);
        messageText = findViewById(R.id.editText);
        //messageButton.setOnClickListener();
    }

    public void myMessage(View view){
        if (messageText.getText().toString().isEmpty()){
            Toast.makeText(this, "Please say your mind...", Toast.LENGTH_SHORT).show();
        }
        else{
            String whatsAppNumber = "2348055008721";
            String message = messageText.getText().toString();

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_VIEW);
            String url = "https://api.whatsapp.com/send?phone=" + whatsAppNumber + "&text=" + message;
            sendIntent.setData(Uri.parse(url));

            //Probably optional
            //sendIntent.setPackage("com.whatsapp");

            startActivity(sendIntent);
        }

    }
}
