package org.goodev.dagger.course.storage;

public interface Storage {
    String getString(String key);

    void setString(String key, String value);
}
