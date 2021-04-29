package com.example.about;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

public class AboutActivity extends AppCompatActivity {
    TextView txt;
    Toolbar tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        txt = findViewById(R.id.about_contains);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txt.setText(Html.fromHtml(getString(R.string.about_us_content), Html.FROM_HTML_MODE_COMPACT));
        } else {
            txt.setText(Html.fromHtml(getString(R.string.about_us_content)));
        }
        tb = findViewById(R.id.toolbar);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(AboutActivity.this,ConductActivity.class);
                startActivity(d);

            }
        });

    }
}