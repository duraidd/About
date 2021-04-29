package com.example.about;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toolbar;

public class syllabusActivity extends AppCompatActivity {
    TextView unitname;
    ConstraintLayout displaying_syllabus_layout;
    WebView syllabus_webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        displaying_syllabus_layout = findViewById(R.id.displaying_syllabus_layout);
        Toolbar syllabus_toolbar = findViewById(R.id.toolbar_syllabus);
        syllabus_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        unitname = findViewById(R.id.unit_name);

         syllabus_webView = findViewById(R.id.syllabus_webview);
        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                unitname.setText("Chemistry");
                syllabus_webView.setVisibility(View.VISIBLE);
                String a = "<p><strong><span style=\"font-size: medium;\">1.Tests of Significance &ndash; Basic Concepts and Large Sample Tests</span></strong><span style=\"font-size: small;\"><br />Introduction<br />1.1 Parameter and Statistic<br />1.2 Sampling Distribution<br />1.3 Standard Error<br />1.4 Null Hypothesis and Alternative Hypothesis<br />1.5 Errors in Statistical Hypotheses Testing<br />1.6 Level of Significance, Critical Region and Critical Value(s)<br />1.7 One-tailed and Two-tailed Tests<br />1.8 General Procedure for Test of Hypotheses<br />1.9 Test of Hypotheses for Population Mean (population Variance Is Known)<br />1.10 Test of Hypotheses for Population Mean (population Variance Is Unknown)<br />1.11 Test of Hypotheses for Equality of Means of Two Populations (population Variances Are Known)<br />1.12 Test of Hypotheses for Equality of Means of Two Populations (population Variances Are Unknown)<br />1.13 Test of Hypotheses for Population Proportion<br />1.14 Test of Hypotheses for Equality of Proportions of Two Populations</span></p> <p><strong><span style=\"font-size: medium;\">2.Tests Based on Sampling Distributions i</span></strong><span style=\"font-size: small;\"><br />Introduction<br />2.1 Student&rsquo;s T Distribution and Its Applications<br />2.2 Chi-square Distribution and Its Applications</span></p> <p><strong><span style=\"font-size: medium;\">3.Tests Based on Sampling Distributions &ndash; Ii</span></strong><span style=\"font-size: small;\"><br />Introduction<br />3.1 F -distribution and Its Applications<br />3.2 Test of Significance for Two Normal Population Variances<br />3.3 Analysis of Variance (anova)<br />3.4 Two-way Anova</span></p> <p><strong><span style=\"font-size: medium;\">4.Correlation Analysis</span></strong><span style=\"font-size: small;\"><br />Introduction<br />4.1 Definition of Correlation<br />4.2 Types of Correlation<br />4.3 Scatter Diagram<br />4.4 Karl Pearson&rsquo;s Correlation Coefficient<br />4.5 Spearman&rsquo;s Rank Correlation Coefficient<br />4.6 Yule&rsquo;s Coefficient of Association</span></p> <p><strong><span style=\"font-size: medium;\">5.Regression Analysis</span></strong><span style=\"font-size: small;\"><br />Introduction<br />5.1 Definition<br />5.2 Uses of Regression<br />5.3 Why Are There Two Regression Lines?<br />5.4 Method of Least Squares<br />5.5 Properties of Regression Coefficients<br />5.6 Difference Between Correlation and Regression</span></p> <p><strong><span style=\"font-size: medium;\">6.Index Numbers</span></strong><span style=\"font-size: small;\"><br />Introduction<br />6.1 Definition and Uses of Index Numbers<br />6.2 Types of Index Numbers<br />6.3 Methods of Constructing Index Numbers<br />6.4 Weighted Index Numbers<br />6.5 Consumer Price Index Numbers</span></p> <p><strong><span style=\"font-size: medium;\">7.Time Series and Forecasting</span></strong><span style=\"font-size: small;\"><br />Introduction<br />7.1 Definition<br />7.2 Components of Time Series<br />7.3 Measeurements of Components<br />7.4 Forecasting</span></p> <p><strong><span style=\"font-size: medium;\">8.Vital Statistics and Official Statistics</span></strong><span style=\"font-size: small;\"><br />8.1 Vital Statistics<br />8.2 Official Statistics</span></p> <p><strong><span style=\"font-size: medium;\">9.Project Work</span></strong><span style=\"font-size: small;\"><br />Introduction<br />9.1 Designing a Project<br />9.2 Project Work Plan<br />9.3 Questionnaire Development Process<br />9.4 Features of a Project Report</span></p>";
                syllabus_webView.loadDataWithBaseURL(null, a, "text/html", "utf-8", null);
                syllabus_webView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        return true;
                    }
                });
                syllabus_webView.setLongClickable(false);
            }
        }, secondsDelayed * 1000);

    }
}
