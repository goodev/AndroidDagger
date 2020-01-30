package org.goodev.dagger.course.storage;

import java.util.HashMap;
import java.util.Map;

public class FakeStorage implements Storage {
    private Map<String, String> mStorageMap = new HashMap<>();

    @Override
    public String getString(String key) {
        System.out.println("key = " + key);
        if (mStorageMap.containsKey(key)) {
            return mStorageMap.get(key);
        }
        return "";
    }

    @Override
    public void setString(String key, String value) {
        System.out.println("key = " + key + ", value = " + value);
        mStorageMap.put(key, value);
    }
}
