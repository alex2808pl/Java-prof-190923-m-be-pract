package de.telran.generic.sender;

public interface SendMessage {
    String generateReport(String data);
    boolean sendReport(String report);
}
