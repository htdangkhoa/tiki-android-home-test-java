package com.github.htdangkhoa.tikitestjava.core;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

/**
 * Created by Thang Tran on 3/19/19.
 * Copyright © 2019 HamadoTeam. All rights reserved.
 */

public abstract class ObserverResource<T> implements Observer<Resource<T>> {
    @Override
    public void onChanged(@Nullable Resource<T> tResource) {
        handleResource(tResource);
    }

    private void handleResource(@Nullable Resource<T> resource) {
        if (resource == null) {
            resource = Resource.error("No data!");
        }
        switch (resource.status) {
            case SUCCESS:
                if (resource.data != null) {
                    onSuccess(resource.data);
                    onLoading(false);
                    break;
                }
            case ERROR:
                onError(resource.message);
                onLoading(false);
                break;
            case LOADING:
                onLoading(true);
        }
    }

    public abstract void onSuccess(@NonNull T data);

    public void onError(String message) {
    }

    //for children override
    public void onLoading(boolean show) {
    }
}
