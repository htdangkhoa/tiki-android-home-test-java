package com.github.htdangkhoa.tikitestjava;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.core.os.HandlerCompat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import timber.log.Timber;

public class App extends Application {
    private static ExecutorService executorService = Executors.newFixedThreadPool(4);

    private static Handler mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());
    }

    public static ExecutorService getExecutorService() {
        return executorService;
    }

    public static Handler getMainThreadHandler() {
        return mainThreadHandler;
    }
}
