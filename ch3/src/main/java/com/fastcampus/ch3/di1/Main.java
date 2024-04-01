package com.fastcampus.ch3.di1;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

class Car {
    @Autowired
    Engine engine;
    @Autowired
    Door door;

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }
}
class SportsCar extends Car {}
class Truck extends Car {}
class Engine {}
class Door {}


public class Main {
    public static void main(String[] args) throws Exception {
        Car car = new SportsCar();
        Car car2 = getCar();
        Car car3 = (Car)getObject("car");
        Engine engine = (Engine)getObject("engine");
        System.out.println("engine = " + engine);
        System.out.println("car2 = " + car2);
    }

    static Object getObject(String key) throws Exception {
//        if(key.equals("car")) {
//            return new SportsCar();
//        } else if(key.equals("engine")) {
//            return new Engine();
//        } else if(key.equals("door")) {
//            return new Door();
//        }
//        return null;
        Properties prop = new Properties();
        Class clazz = null; // 지정된 클래스이름이 해당하는 클래스 객체를 얻는다.
        try {
            prop.load(new FileReader("config.txt"));
            String className = prop.getProperty(key); // 지정한 key의 value를 반환
            clazz = Class.forName(className);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return clazz.newInstance(); // new SportsCar();
    }

    static Car getCar() {
        return new SportsCar();
    }
}
