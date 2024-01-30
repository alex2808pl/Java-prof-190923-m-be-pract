package de.telran.generic.sender;

public class EMail implements SendMessage{
    @Override
    public String generateReport(String data) {
        String mes = "Генерю отчет в HTML с данных data для класса "+this.getClass().getName();
        System.out.println(mes);
        return mes;
    }

    @Override
    public boolean sendReport(String report) {
        System.out.println("Отправили на EMail отчет");
        return true;
    }
}
