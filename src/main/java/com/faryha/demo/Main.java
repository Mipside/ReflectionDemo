package com.faryha.demo;

import java.lang.reflect.Field;

/*
 * We need Reflection to get information about classes, their structure and fields. Namely, we use them like objects
 * Usually, it used in frameworks
 * */

public class Main {

    public static void main(String[] args) throws Exception {
        SomeClass someObject = new SomeClass();
        Class<SomeClass> someClassAsClass = (Class<SomeClass>) someObject.getClass();

        //===== 1: Getting certain field type in SomeClass
        Field someField = someClassAsClass.getField("someIntField");
        System.out.println("1: " + someField.getType() + "\n"); //int

        //===== 2: Getting fields types and names in SomeClass (without private fields):
        Field[] fields = someClassAsClass.getFields();
        for (Field field : fields) {
            System.out.println("2: " + field.getType() + " " + field.getName()); // int someField ,  class java.lang.String someStringField
        }

        //===== 3: Getting private field in SomeClass
        Field privateFiled = someClassAsClass.getDeclaredField("somePrivateStringField");
        System.out.println("\n3:" + privateFiled.getName()); // somePrivateStringField

        privateFiled.setAccessible(true);
        privateFiled.set(someObject, "Marsel");
        System.out.println("Private field after change: " + someObject.getSomePrivateStringField());

        //====== 4: Changing public field in SomeClass
        someField.set(someObject, 777);
        System.out.println("\n4: " + someObject.someIntField);
    }
}
