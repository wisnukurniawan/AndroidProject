package com.wisnu_krn.codelabsfirebase.presentation;

import android.text.TextUtils;

import com.wisnu_krn.codelabsfirebase.data.Article;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by private on 05/11/2016.
 */

public class AddPresenter {
    private AddView mView;

    public AddPresenter(AddView view) {
        mView = view;
    }

    public void saveLink(String URL) {

    }

    public Observable<Article> scrapingURL(final String URL) {
        return Observable.create(new Observable.OnSubscribe<Article>() {
            @Override public void call(Subscriber<? super Article> subscriber) {
                try {
                    

                    Document doc = Jsoup.connect(URL).get();

                    String redirectedUrl = null;
                    Elements meta = doc.select("html head meta");
                    if (meta.attr("http-equiv").contains("REFRESH")) {
                        redirectedUrl = meta.attr("content").split("=")[1];
                    } else {
                        if (doc.toString().contains("window.location.href")) {
                            meta = doc.select("script");
                            for (Element script : meta) {
                                String s = script.data();
                                if (!s.isEmpty() && s.startsWith("window.location.href")) {
                                    int start = s.indexOf("=");
                                    int end = s.indexOf(";");
                                    if (start > 0 && end > start) {
                                        s = s.substring(start + 1, end);
                                        s = s.replace("'", "").replace("\"", "");
                                        redirectedUrl = s.trim();
                                        break;
                                    }
                                }
                            }
                        }
                    }

                    String title = getMetaTag(doc, "og:title");
                    String img = getMetaTag(doc, "og:image");

                    if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(img)) {
                        subscriber.onNext(new Article.Builder().uId(firebaseUser.getUid())
                                .title(title)
                                .image(img)
                                .url(URL)
                                .build());
                        subscriber.onCompleted();
                    } else {
                        subscriber.onError(new Throwable("Empty title or img"));
                    }
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    private String getMetaTag(Document document, String attr) {
        Elements elements = document.select("meta[name=" + attr + "]");
        for (Element element : elements) {
            final String s = element.attr("content");
            if (s != null) return s;
        }
        elements = document.select("meta[property=" + attr + "]");
        for (Element element : elements) {
            final String s = element.attr("content");
            if (s != null) return s;
        }
        return null;
    }
}
