package de.telran.generic.sender;

public class WhatsApp extends ReportText{

    @Override
    public boolean sendReport(String report) {
        System.out.println("Отправили на WhatsApp отчет");
        return true;
    }
}
