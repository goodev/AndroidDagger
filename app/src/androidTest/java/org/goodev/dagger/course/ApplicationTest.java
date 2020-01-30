package org.goodev.dagger.course;

import org.junit.Test;

import androidx.test.core.app.ActivityScenario;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class ApplicationTest {
    @Test
    public void runApp() {
        ActivityScenario.launch(MainActivity.class);

        // Should be in Registration/EnterDetails because the user is not registered
        onView(withText("Register to Dagger World!")).check(matches(isDisplayed()));
        onView(withId(R.id.username)).perform(typeText("username"), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("password"), closeSoftKeyboard());
        onView(withId(R.id.next)).perform(click());

        // Registration/T&Cs
        onView(withText("Terms and Conditions")).check(matches(isDisplayed()));
        onView(withText("REGISTER")).perform(click());

        // Main
        onView(withText("Hello username!")).check(matches(isDisplayed()));
        onView(withText("SETTINGS")).perform(click());

        // Settings
        onView(withText("REFRESH NOTIFICATIONS")).check(matches(isDisplayed()));
        onView(withText("LOGOUT")).perform(click());

        // Login
        onView(withText("Welcome to Dagger World!")).check(matches(isDisplayed()));
        onView(withId(R.id.password)).perform(typeText("password"), closeSoftKeyboard());
        onView(withText("LOGIN")).perform(click());

        // Main
        onView(withText("Hello username!")).check(matches(isDisplayed()));
        onView(withText("SETTINGS")).perform(click());

        // Settings
        onView(withText("REFRESH NOTIFICATIONS")).check(matches(isDisplayed()));
        onView(withText("LOGOUT")).perform(click());

        // Login
        onView(withText("Welcome to Dagger World!")).check(matches(isDisplayed()));
        onView(withId(R.id.unregister)).perform(click());

        // Registration
        onView(withText("Register to Dagger World!")).check(matches(isDisplayed()));
    }
}
