package de.telran.generic.sender;

public class Telegram extends ReportText{
    @Override
    public boolean sendReport(String report) {
        System.out.println("Отправили на Telegram отчет");
        return true;
    }
}
