package com.babujee.unittestsample.ui.main.helper.login.observer;

import com.babujee.unittestsample.ui.main.helper.Subject;

public class MyTopicSubscriber implements Observer {
    private String name;
    private Subject topic;

    public MyTopicSubscriber(String nm) {
        name = nm;
    }

    @Override
    public void update() {
        String msg = (String)topic.getUpdate(MyTopicSubscriber.this);
        if(msg == null) {
            System.out.println(name + " :: No new Msg");
        } else {
            System.out.println(name + " :: Consuming msg");
        }

    }

    @Override
    public void setSubject(Subject sub) {
        topic = sub;

    }
}
