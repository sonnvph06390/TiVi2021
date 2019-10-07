package com.example.son.tivi2020;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ActivityResult extends AppCompatActivity {
    String link;
    private LinearLayout layoutResult;
    private WebView webviewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
            link = "https://tuvivannien.com/boi-ai-cap/ten-"+name+".html";

        initView();
        MyAsynTask myAsynTask = new MyAsynTask();
        myAsynTask.execute();
        webviewResult.setHorizontalScrollBarEnabled(false);
    }

    private void initView() {
        layoutResult = (LinearLayout) findViewById(R.id.layout_result);
        webviewResult = (WebView) findViewById(R.id.webview_result);
    }
    private class MyAsynTask extends AsyncTask<Void, Void, Document> {
        @Override
        protected Document doInBackground(Void... voids) {

            Document document = null;
            try {
                document = Jsoup.connect(link).get();
                document.getElementsByClass("header-area").remove();
                document.getElementsByClass("footer-area").remove();
                document.getElementsByClass("popular-news-widget mb-30").remove();
                document.getElementsByClass("newsletter-widget mb-50").remove();
                document.getElementsByClass("comment_area clearfix").remove();
                document.getElementsByClass("post-catagory").remove();
                document.getElementsByClass("post-title").remove();
                document.getElementsByTag("noscript").remove();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return document;
        }

        @Override
        protected void onPostExecute(Document document) {
            super.onPostExecute(document);
            webviewResult.loadDataWithBaseURL(link, document.toString(), "text/html", "utf-8", "");
            webviewResult.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

            webviewResult.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    view.loadUrl(link);
                    view.getSettings().setLoadsImagesAutomatically(false);
                    return super.shouldOverrideUrlLoading(view, request);
                }
            });
        }
    }
}
