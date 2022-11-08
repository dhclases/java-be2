package com.dh.demo;
class GenericsClass<T> {
    // variable del T ipo
    private final T data;
    private final int a=0;

    public GenericsClass(T data) {
        this.data = data;
    }

    // metodo que retorna el tipo T
    public T getData() {
        return this.data;
    }
}