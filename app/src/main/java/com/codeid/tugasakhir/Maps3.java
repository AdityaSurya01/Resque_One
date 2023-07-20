package com.codeid.tugasakhir;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.codeid.tugasakhir.databinding.ActivityMaps1Binding;

public class Maps3 extends AppCompatActivity {

    private Button btnShowRoute;
    private WebView webView;
    private ActivityMaps1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMaps1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        btnShowRoute = findViewById(R.id.btn_show_route);
        webView = findViewById(R.id.web_view);

        // Mengaktifkan dukungan JavaScript di WebView
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        btnShowRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWebViewWithRoute();
            }
        });

        // ...
    }

    private void showWebViewWithRoute() {
        String destinationLatitude = "-7.675641016224819";
        String destinationLongitude = "109.66763558764265";
        String sourceLatitude = "-7.6756614246066315";
        String sourceLongitude = "109.64670528182462";

        // Membuat URL untuk menampilkan rute dari lokasi awal ke lokasi tujuan
        String url = "https://www.google.com/maps/dir/?api=1&origin=" +
                sourceLatitude + "," + sourceLongitude +
                "&destination=" + destinationLatitude + "," + destinationLongitude;

        // Memuat URL dalam WebView
        webView.setVisibility(View.VISIBLE);
        webView.loadUrl(url);
    }

}