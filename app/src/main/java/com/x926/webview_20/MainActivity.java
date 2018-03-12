package com.x926.webview_20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    WebDriver driver = new RemoteWebDriver(DesiredCapabilities.android());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.browser);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setSupportZoom(true);
        SimpleWebViewClient webViewClient = new SimpleWebViewClient();
        webView.setWebViewClient(webViewClient);

        webView.loadUrl("https://www.google.com");
    }

    public void onClickMethod(View view) {
        TextView textView = findViewById(R.id.textView);
        try {
            driver.findElement(By.xpath("//input[@label='Поиск в Google']")).click();
            textView.setText("Кнопка ссылку");
        } catch (Exception e) {
            textView.setText("Не удалось нажать ссылку");
        }

    }
    private class SimpleWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            return false;
        }
    }
}
