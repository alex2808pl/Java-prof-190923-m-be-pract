package de.telran.diplom.pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Client implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private StatusManager status;
    private LocalDate createdAt;
    private LocalDate updateAt;
    private String taxCode;
    private String eMail;
    private String address;
    private String phone;
    private Manager manager;

    public Client(long id, String firstName, String lastName, StatusManager status, LocalDate createdAt, LocalDate updateAt, String taxCode, String eMail, String address, String phone, Manager manager) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.taxCode = taxCode;
        this.eMail = eMail;
        this.address = address;
        this.phone = phone;
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != client.id) return false;
        if (!Objects.equals(firstName, client.firstName)) return false;
        if (!Objects.equals(lastName, client.lastName)) return false;
        if (status != client.status) return false;
        if (!Objects.equals(createdAt, client.createdAt)) return false;
        if (!Objects.equals(updateAt, client.updateAt)) return false;
        if (!Objects.equals(taxCode, client.taxCode)) return false;
        if (!Objects.equals(eMail, client.eMail)) return false;
        if (!Objects.equals(address, client.address)) return false;
        if (!Objects.equals(phone, client.phone)) return false;
        return Objects.equals(manager, client.manager);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        result = 31 * result + (taxCode != null ? taxCode.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                ", taxCode='" + taxCode + '\'' +
                ", eMail='" + eMail + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", manager=" + manager +
                '}';
    }
}
