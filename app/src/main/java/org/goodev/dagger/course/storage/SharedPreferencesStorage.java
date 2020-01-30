package org.goodev.dagger.course.storage;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesStorage implements Storage {
    public static final String NAME = "goodev";
    private SharedPreferences mPref;

    public SharedPreferencesStorage(Context context) {
        mPref = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    @Override
    public String getString(String key) {
        return mPref.getString(key, "");
    }

    @Override
    public void setString(String key, String value) {
        mPref.edit().putString(key, value).apply();
    }
}
