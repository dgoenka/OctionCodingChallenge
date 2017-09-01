package com.divyanshgoenka.octioncodingchallenge;

import android.app.Application;

/**
 * Created by divyanshgoenka on 26/08/17.
 */

public class OctionCodingChallengeApplication extends Application {

    private static OctionCodingChallengeApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static OctionCodingChallengeApplication getInstance() {
        return instance;
    }
}
