package de.telran.spring.decoupled;

import de.telran.spring.decoupled.MessageProvider;

public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
