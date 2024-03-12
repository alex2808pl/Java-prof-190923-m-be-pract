package de.telran.spring.decoupled.factory;

import de.telran.spring.decoupled.MessageRenderer;
import de.telran.spring.decoupled.MessageProvider;

public class HelloWorldDecoupledWithFactory {
    public static void main(String[] args) {
        MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer();
        MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
