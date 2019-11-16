package com.androidstudioprojects.parseinstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("meghan-codepath") // should correspond to APP_ID env variable
                .clientKey("SonicX")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("https://meghan-codepath.herokuapp.com/parse").build());
    }
}
