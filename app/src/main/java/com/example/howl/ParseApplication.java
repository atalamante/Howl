package com.example.howl;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("FiHnGFJLGccdr21hau9HWPdfxMGSzOxQzqH03dW8")
                .clientKey("xccXGO8BEESNlVlwdm53TLO6pgALYUuOYVbILxDs")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
