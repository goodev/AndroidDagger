package org.goodev.dagger.course;

import org.goodev.dagger.course.storage.FakeStorage;
import org.goodev.dagger.course.storage.Storage;
import org.goodev.dagger.course.user.UserManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserManagerTest {

    private Storage storage;
    private UserManager userManager;

    @Before
    public void setup() {
        storage = new FakeStorage();
        userManager = new UserManager(storage);
    }

    @Test
    public void usernameReturnsWhatIsInTheStorage() {
        assertEquals("", userManager.getUsername());

        userManager.registerUser("username", "password");

        assertEquals("username", userManager.getUsername());
    }

    @Test
    public void isUserRegisteredBehavesAsExpected() {
        assertFalse(userManager.isUserRegistered());

        userManager.registerUser("username", "password");

        assertTrue(userManager.isUserRegistered());
    }

    @Test
    public void registerUserAddsUsernameAndPasswordToTheStorage() {
        assertFalse(userManager.isUserRegistered());
        assertFalse(userManager.isUserLoggedIn());

        userManager.registerUser("username", "password");

        assertTrue(userManager.isUserRegistered());
        assertTrue(userManager.isUserLoggedIn());
        assertEquals("username", storage.getString("registered_user"));
        assertEquals("password", storage.getString("usernamepassword"));
    }

    @Test
    public void loginSucceedsWhenUsernameIsRegisteredAndPasswordIsCorrect() {
        userManager.registerUser("username", "password");
        userManager.logout();

        assertTrue(userManager.loginUser("username", "password"));
        assertTrue(userManager.isUserLoggedIn());
    }

    @Test
    public void loginFailsWhenUsernameIsNotRegistered() {
        userManager.registerUser("username", "password");
        userManager.logout();

        assertFalse(userManager.loginUser("username2", "password"));
        assertFalse(userManager.isUserLoggedIn());
    }

    @Test
    public void loginFailsWhenUsernameIsRegisteredButPasswordIsIncorrect() {
        userManager.registerUser("username", "password");
        userManager.logout();

        assertFalse(userManager.loginUser("username", "password2"));
        assertFalse(userManager.isUserLoggedIn());
    }

    @Test
    public void unregisterBehavesAsExpected() {
        userManager.registerUser("username", "password");
        assertTrue(userManager.isUserLoggedIn());

        userManager.unregister();
        assertFalse(userManager.isUserLoggedIn());
        assertFalse(userManager.isUserRegistered());
    }
}
