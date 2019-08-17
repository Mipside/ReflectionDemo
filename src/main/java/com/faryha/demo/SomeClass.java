package com.faryha.demo;

public class SomeClass {
    public int someIntField;
    public String someStringField;
    private String somePrivateStringField;

    //getter for private field
    public String getSomePrivateStringField() {
        return somePrivateStringField;
    }


    public void method() {
        System.out.println("hello in method");
    }
}
