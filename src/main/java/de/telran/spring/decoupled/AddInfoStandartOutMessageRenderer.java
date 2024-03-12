package de.telran.spring.decoupled;

public class AddInfoStandartOutMessageRenderer implements MessageRenderer{
    private MessageProvider messageProvider;

    public AddInfoStandartOutMessageRenderer(){
        System.out.println(" --> AddInfoStandartOutMessageRenderer: constructor called");
    }

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class:"
                            + AddInfoStandartOutMessageRenderer.class.getName());
        }
        System.out.println("---------------------");
        System.out.println(messageProvider.getMessage());
        System.out.println("---------------------");
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        System.out.println(" --> StandardOutMessageRenderer: setting the provider");
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
