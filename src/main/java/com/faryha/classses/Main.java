package com.faryha.classses;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        //====== getting fields type and name by class name
        System.out.println("Please print some path: ");
        Scanner scanner = new Scanner(System.in);
        String className = scanner.next();        //input: com.faryha.classses.Human

        Class aClass = Class.forName(className);
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getType() + " " + field.getName()); //int age ; class java.lang.String name
        }

        //======
        Class types[] = new Class[fields.length];
        for (int i = 0; i < types.length; i++) {
            types[i] = fields[i].getType();
        }

        // get all types of fields in certain constructor, creating new values for objects constructor
        Constructor constructor = aClass.getDeclaredConstructor(types);
        for (Class parameterType : constructor.getParameterTypes()) {
            Integer intValue = 0;
            String stringValue = "";
            for (int i = 0; i < fields.length; i++) {
                if (types[i].getName().equals("int")) {
                    intValue = scanner.nextInt();
                } else if (types[i].getName().equals("java.lang.String")) {
                    stringValue = scanner.next();
                }
            }

            Object arguments[] = {intValue, stringValue};
            Object object = constructor.newInstance(arguments);
            System.out.println("new object: " + object);
        }
    }
}
