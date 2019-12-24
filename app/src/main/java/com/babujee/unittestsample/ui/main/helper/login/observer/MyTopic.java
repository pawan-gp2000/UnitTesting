package com.babujee.unittestsample.ui.main.helper.login.observer;

import com.babujee.unittestsample.ui.main.helper.Subject;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject {

    private List<Observer> observers;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();

    public MyTopic() {
        observers = new ArrayList<>();


    }
    @Override
    public void register(Observer obj) {
        if(obj == null) throw new NullPointerException("Null observer");

        synchronized (MUTEX) {
            if(!observers.contains(obj)) observers.add(obj);
        }

    }

    @Override
    public void unregister(Observer obj) {
        synchronized (MUTEX) {
            observers.remove(obj);
        }

    }

    @Override
    public void notifyObservers() {
        List<Observer> observesLocal = null;
        synchronized (MUTEX) {
            if(!changed) { return; }
            observesLocal = new ArrayList<>(observers);
            changed = false;
        }

        for (Observer obj : observesLocal) {
            obj.update();
        }

    }

    @Override
    public Object getUpdate(Observer obj) {
        return message;
    }

    public void postMessage(String msg) {
        System.out.println("Message posted to topic: " + msg);
        message = msg;
        changed = true;
        notifyObservers();
    }
}
