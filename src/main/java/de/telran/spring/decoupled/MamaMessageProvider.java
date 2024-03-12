package de.telran.spring.decoupled;

public class MamaMessageProvider implements MessageProvider{

    public MamaMessageProvider(){
        System.out.println(" --> MamaMessageProvider: constructor called");
    }
    @Override
    public String getMessage() {
        return "Мама привет";
    }
}
