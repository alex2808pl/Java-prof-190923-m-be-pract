package de.telran.multithread.exchange;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class SimpleExchangeAuto {
    @SneakyThrows
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        //Формируем груз для 1 грузовика
        String[] p1 = new String[]{"{посылка A->D}", "{посылка A->C}"};

        //Формируем груз для 2 грузовика
        String[] p2 = new String[]{"{посылка B->C}", "{посылка B->D}"};


        //Отправляем 1 грузовик А -> D
        new Thread(new Truck(1, "A", "D", p1, exchanger)).start();

        Thread.sleep(100);

        //Отправляем 2 грузовик В -> С
        new Thread(new Truck(2, "B", "C", p2, exchanger)).start();
    }
}
class Truck implements Runnable {
    private int number;
    private String departure;
    private String destination;
    private String[] parcels;
    private Exchanger<String> exchanger;

    public Truck(int number, String departure, String destination, String[] parcels, Exchanger<String> exchanger) {
        this.number = number;
        this.departure = departure;
        this.destination = destination;
        this.parcels = parcels;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        Random r = new Random();
        try {
            System.out.println("В грузовик " + number + " погрузили: " + parcels[0] + " и " + parcels[1]);
            System.out.println("Грузовик " + number + " выехал из пункта " + departure + " в пункт " + destination + " с остановкой в пункте E");

            Thread.sleep(r.nextInt(2,5)* 1000L); // имитация времени поездки

            System.out.println("Грузовик " + number + " приехал в пункт Е -> "+System.currentTimeMillis());

            //При вызове exchange() поток блокируется и ждет пока другой
            // поток вызовет exchange(), после этого произойдет обмен посылками
            parcels[1] = exchanger.exchange(parcels[1]);

            System.out.println("В грузовик " + number + " переместили посылку для пункта " + destination);

            Thread.sleep(r.nextInt(2,5)* 1000L); //имитация времени второй половины дороги

            System.out.println("Грузовик " + number + " приехал в " + destination + " и доставил: " + parcels[0] + " и " + parcels[1]);
        } catch (InterruptedException e) {
        }
    }
}
