package org.goodev.dagger.course.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context mContext;

    public ContextModule(Context context) {
        mContext = context;
    }

    @Provides
    Context getContext() {
        return mContext;
    }
}
