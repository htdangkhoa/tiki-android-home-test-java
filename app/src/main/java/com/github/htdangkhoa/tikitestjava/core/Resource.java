package com.github.htdangkhoa.tikitestjava.core;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by Thang Tran on 3/19/19.
 * Copyright © 2019 HamadoTeam. All rights reserved.
 */

public class Resource<T> {
    @NonNull
    public final Status status;
    @Nullable
    public final T data;
    @Nullable
    public final String message;

    private Resource(@NonNull Status status, @Nullable T data,
                     @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> success(@NonNull T data) {
        return new Resource<>(Status.SUCCESS, data, null);
    }

    public static <T> Resource<T> error(String msg) {
        return new Resource<>(Status.ERROR, null, msg);
    }

    public static <T> Resource<T> loading() {
        return new Resource<>(Status.LOADING, null, null);
    }

    public static <T> Resource<T> nothing() {
        return new Resource<>(Status.NOTHING, null, null);
    }

    public enum Status {SUCCESS, ERROR, LOADING, NOTHING}
}
