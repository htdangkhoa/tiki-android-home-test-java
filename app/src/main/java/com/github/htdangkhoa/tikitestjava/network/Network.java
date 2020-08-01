package com.github.htdangkhoa.tikitestjava.network;

import android.os.Handler;
import android.os.Looper;

import androidx.core.os.HandlerCompat;

import com.github.htdangkhoa.tikitestjava.App;
import com.github.htdangkhoa.tikitestjava.model.ResponseModel;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import timber.log.Timber;

public class Network {
    private String HOST = "https://api.tiki.vn/%s";

    private ExecutorService executors;

    private Handler resultHandler;

    private Gson gson = new Gson();


    public Network() {
        this.executors = App.getExecutorService();

        resultHandler = App.getMainThreadHandler();
    }

    public void execute(String path, Type type, NetworkCallback callback) {
        execute(path, NetworkMethod.GET, type, callback);
    }

    public void execute(String path, NetworkMethod method, Type type, NetworkCallback callback) {
        if (callback != null) {
            resultHandler.post(() -> callback.onLoading(true));
        }

        executors.execute(() -> {
            try {
                URL url = new URL(String.format(HOST, path));

                Timber.w("----- URL -----: %s", url.toString());

                HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();

                httpConnection.setRequestMethod(method.name());
                httpConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                httpConnection.setRequestProperty("Accept", "*/*");

                InputStream is = httpConnection.getInputStream();

                Reader reader = new InputStreamReader(is);

                ResponseModel<List<?>> responseModel = gson.fromJson(reader, type);

                if (callback != null) {
                    resultHandler.post(() -> {
                        callback.onLoading(false);

                        callback.onSuccess(responseModel);
                    });
                }

                is.close();
            } catch (Exception e) {
                e.printStackTrace();

                if (callback != null) {
                    resultHandler.post(() -> {
                        callback.onLoading(false);

                        callback.onError(e);
                    });
                }
            }
        });
    }
}
