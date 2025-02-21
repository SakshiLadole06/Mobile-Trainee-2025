package com.example.taskandroid.taskwebview

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature
import com.example.taskandroid.R

class TaskWebViewMain : AppCompatActivity() {
    private lateinit var webView1 : WebView
    private lateinit var webView2 : WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_web_view_main)

        //Find ids
        webView1 = findViewById(R.id.webView1)
        webView2 = findViewById(R.id.webView2)

        webView1.loadUrl("https://www.google.com/")
        webView1.settings.javaScriptEnabled = true
        webView1.webViewClient = WebViewClient()
        webView1.settings.setSupportZoom(true)
        if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
            WebSettingsCompat.setAlgorithmicDarkeningAllowed(webView1.settings, true)
        }

        val htmlCode="<html><body><h1>Sakshi Ladole</h1></body></html>"
        webView2.loadData(htmlCode,"text/html","UTF-8")
        if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
//            WebSettingsCompat.setForceDark(webView2.settings, WebSettingsCompat.FORCE_DARK_ON) deprecated
            WebSettingsCompat.setAlgorithmicDarkeningAllowed(webView2.settings, true)
        }
    }

    override fun onBackPressed() {
        when {
            webView1.canGoBack() -> webView1.goBack()
            webView2.canGoBack() -> webView2.goBack()
            else -> super.onBackPressed()
        }
    }
}

//If you want to add color and style in your html code
/*
val htmlCode="<html>
                <body>
                   <style>\n" +
                        "body {background-color: grey;}\n" +
                        "h1   {color: black;}\n" +
                    "</style>
                    <h1>Sakshi Ladole</h1>
                </body>
            </html>"
*/