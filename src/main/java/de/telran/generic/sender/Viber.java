package de.telran.generic.sender;

public class Viber extends ReportText{
    @Override
    public boolean sendReport(String report) {
        System.out.println("Отправили на Viber отчет");
        return true;
    }
}
