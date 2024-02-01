package de.telran.serialized.manual;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Address implements Serializable {

    private static final int VER = 2;
    private  int countryCode;
    private  String city;
    private  String street;

    private  int houseNumber;

    public Address(int countryCode, String city, String street, int houseNumber) {
        this.countryCode = countryCode;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "countryCode=" + countryCode +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeInt(VER);
        oos.writeInt(countryCode);
        oos.writeUTF(city);
        oos.writeUTF(street);
        if(VER > 1) oos.writeInt(houseNumber);
    }

    private void readObject(ObjectInputStream ois) throws IOException {
        int ver = ois.readInt();
        if (ver == 1) {
            countryCode = ois.readInt();
            city = ois.readUTF();
            street = ois.readUTF();
            houseNumber = 0;
        } else if (ver == 2) {
            countryCode = ois.readInt();
            city = ois.readUTF();
            street = ois.readUTF();
            houseNumber = ois.readInt();
        } else {
            throw new IOException("Неизвестная версия: " + ver);
        }
    }

}
