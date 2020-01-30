package org.goodev.dagger.course;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

public class LiveDataTestUtil {
    /**
     * 从 LiveData 对象中获取返回的值。 这里等待2秒钟好让 LiveData 的中的对象发布。
     * 当通过 onChanged 监听到发布的对象后，就停止监听。
     */
    public static <T> T getValue(LiveData<T> liveData) throws InterruptedException {
        Object[] data = new Object[1];
        CountDownLatch latch = new CountDownLatch(1);
        Observer<T> observer = new Observer<T>() {
            @Override
            public void onChanged(T t) {
                data[0] = t;
                latch.countDown();
                liveData.removeObserver(this);
            }
        };
        liveData.observeForever(observer);
        latch.await(2, TimeUnit.SECONDS);

        return (T) data[0];
    }
}
