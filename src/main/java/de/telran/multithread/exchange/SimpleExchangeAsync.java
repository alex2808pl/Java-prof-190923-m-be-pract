package de.telran.multithread.exchange;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Exchanger;

import static java.util.concurrent.CompletableFuture.runAsync;

public class SimpleExchangeAsync {
    private static final int BUFFER_SIZE = 10;
    public static void main(String[] args) {
            Exchanger<Queue<String>> readerExchanger = new Exchanger<>();
            Exchanger<Queue<String>> writerExchanger = new Exchanger<>();

            Runnable reader = () -> {
                Queue<String> readerBuffer = new ConcurrentLinkedQueue<>();
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                while (true) {
                    readerBuffer.add(UUID.randomUUID().toString());
                    if (readerBuffer.size() >= BUFFER_SIZE) {
                        try {
                            readerBuffer = readerExchanger.exchange(readerBuffer);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            };

            Runnable processor = () -> {
                Queue<String> processorBuffer = new ConcurrentLinkedQueue<>();
                Queue<String> writerBuffer = new ConcurrentLinkedQueue<>();
                try {
                    processorBuffer = readerExchanger.exchange(processorBuffer);
                    while (true) {
                        writerBuffer.add(processorBuffer.poll());
                        if (processorBuffer.isEmpty()) {
                            processorBuffer = readerExchanger.exchange(processorBuffer);
                            writerBuffer = writerExchanger.exchange(writerBuffer);
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            };

            Runnable writer = () -> {
                Queue<String> writerBuffer = new ConcurrentLinkedQueue<>();
                try {
//                    Thread.sleep(1000);
                    writerBuffer = writerExchanger.exchange(writerBuffer);
                    while (true) {
                        System.out.println(writerBuffer.poll());
                        if (writerBuffer.isEmpty()) {
                            writerBuffer = writerExchanger.exchange(writerBuffer);
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
            CompletableFuture.allOf(
                    runAsync(reader),
                    runAsync(processor),
                    runAsync(writer)).join();
    }
}
