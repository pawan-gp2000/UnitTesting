package com.babujee.unittestsample.ui.main.helper;

import com.babujee.unittestsample.ui.main.helper.login.observer.Observer;

public interface Subject {
    void register(Observer obj);
    void unregister(Observer obj);

    void notifyObservers();
    Object getUpdate(Observer obj);
}
