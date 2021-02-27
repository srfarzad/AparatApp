package com.androidlearn.aparat.models;

public interface IMessageListener<T> {

    public void onSuccess(T responseMessage);

    public void onFailure(String errorResponseMessage);

}
