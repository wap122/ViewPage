package com.example.minhl.viewpage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minhl on 11/07/2017.
 */

public class MyTopic implements Subject {

    private final Object MUTEX = new Object();
    public List<Observer> observers;
    private String fullName;
    private boolean changed;

    public MyTopic() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        if (obj == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if (!observers.contains(obj)) observers.add(obj);
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
        List<Observer> observersLocal = null;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX) {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.observers);
            this.changed = false;
        }
        for (Observer obj : observersLocal) {
            obj.update(fullName);
        }

    }

    @Override
    public Object getUpdate(Observer obj) {
        return null;
    }

    //method to post message to the topic
    public void sendItem(String fullName) {
        this.fullName = fullName;
        this.changed = true;
        notifyObservers();
    }

}
