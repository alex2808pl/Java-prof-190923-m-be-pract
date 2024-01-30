package de.telran.generic.sender;

public class PrepareData {
    public <T> String prepareData(T canal) {
        String mes = "Получаю данные для канала -> " + canal.toString();
        System.out.println(mes);
        return mes;
    }

}
// - метод prepareData у всех каналов одинаковый, получаем данные для подготовки уведомления.
