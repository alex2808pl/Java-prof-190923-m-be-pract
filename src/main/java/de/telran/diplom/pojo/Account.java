package de.telran.diplom.pojo;

import java.io.Serializable;
import java.time.LocalDate;

public class Account implements Serializable {
    private long id;
    private String name;
    private String type;
    private StatusManager status;
    private LocalDate createdAt;
    private LocalDate updateAt;
    private Double balance;
    private String currencyCode;
    private String address;
    private Client client;


}
