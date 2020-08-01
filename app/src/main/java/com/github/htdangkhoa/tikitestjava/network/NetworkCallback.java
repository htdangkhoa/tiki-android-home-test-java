package com.github.htdangkhoa.tikitestjava.network;

import com.github.htdangkhoa.tikitestjava.model.ResponseModel;

public interface NetworkCallback<T> {
    void onSuccess(ResponseModel<T> res);

    void onError(Exception e);

    void onLoading(boolean isLoading);
}
