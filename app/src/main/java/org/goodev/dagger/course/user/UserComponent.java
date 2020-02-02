package org.goodev.dagger.course.user;

import org.goodev.dagger.course.MainActivity;
import org.goodev.dagger.course.settings.SettingsActivity;

import dagger.Subcomponent;

/**
 * 和已登录用户相关的子部件
 */
@LoggedUserScope
@Subcomponent
public interface UserComponent {

    @Subcomponent.Factory
    interface Factory {
        UserComponent create();
    }

    void inject(MainActivity activity);

    void inject(SettingsActivity activity);
}
