package de.telran.spring.decoupled;

public class HelloWorldDecupled {
    public static void main(String[] args) {
        MessageRenderer mr = new StandartOutMessageRenderer();
        MessageProvider mp = new HelloWorldMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
