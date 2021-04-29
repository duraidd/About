package com.example.about;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import com.google.android.material.card.MaterialCardView;

public class ConductActivity extends AppCompatActivity {
    EditText feedback;
    TextView txt;
    MaterialCardView card;
    Button feed_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conduct);
        txt = findViewById(R.id.callus);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txt.setText(Html.fromHtml(getString(R.string.call_us), Html.FROM_HTML_MODE_COMPACT));
        } else {
            txt.setText(Html.fromHtml(getString(R.string.call_us)));
        }
        card = findViewById(R.id.chat_with_us);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:9702470579"));
                startActivity(i);
            }
        });
        feedback = findViewById(R.id.feedback_text);
        feed_btn = findViewById(R.id.feedback_send_btn);
        feed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String durai = "netcom.durai@gmail.com";
                final String pwd = "Netcom123";
                String messageToSend = feedback.getText().toString();
                System.out.println(messageToSend+"SSSSSSSSSSSS");
                Properties properties = new Properties();
                properties.put("mail.smtp.auth",true);
                properties.put("mail.smtp.starttls.enable",true);
                properties.put("mail.smtp.host","smtp.gmail.com");
                properties.put("mail.smtp.port",587);
                Session session=Session.getInstance(properties,new javax.mail.Authenticator(){
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(durai,pwd);
                    }
                });
                try {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(durai));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("netcom.ganesh@gmail.com"));
                    message.setSubject("sending feedback");
                    message.setText(messageToSend);
                    Transport.send(message);
                    Toast.makeText(getApplicationContext(),"feeback received",Toast.LENGTH_SHORT).show();
                }catch (MessagingException e){
                    throw new RuntimeException(e);
                }

            }
        });
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Toolbar toolbar_conduct = findViewById(R.id.toolbar_conduct);
        toolbar_conduct.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(ConductActivity.this,syllabusActivity.class);
                startActivity(d);
            }
        });
    }
}