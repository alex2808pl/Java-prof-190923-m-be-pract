package de.telran.generic.sender;

public abstract class ReportText implements SendMessage{

    @Override
    public String generateReport(String data) {
        String mes = "Генерю отчет в ТХТ с данных data для класса "+this.getClass().getName();
        System.out.println(mes);
        return mes;
    }

    @Override
    public abstract boolean sendReport(String report);
}
