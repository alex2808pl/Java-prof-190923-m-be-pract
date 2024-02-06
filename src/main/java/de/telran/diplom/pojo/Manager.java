package de.telran.diplom.pojo;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class Manager implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private StatusManager status;
    private LocalDate createdAt;
    private LocalDate updateAt;

    public Manager(long id, String firstName, String lastName, StatusManager status, LocalDate createdAt, LocalDate updateAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Manager manager = (Manager) o;
//        return id == manager.id && Objects.equals(firstName, manager.firstName) && Objects.equals(lastName, manager.lastName) && status == manager.status && Objects.equals(createdAt, manager.createdAt) && Objects.equals(updateAt, manager.updateAt);
//    }
//

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manager manager = (Manager) o;

        if (id != manager.id) return false;
        if (!Objects.equals(firstName, manager.firstName)) return false;
        if (!Objects.equals(lastName, manager.lastName)) return false;
        if (status != manager.status) return false;
        if (!Objects.equals(createdAt, manager.createdAt)) return false;
        return Objects.equals(updateAt, manager.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, status, createdAt, updateAt);
//        return Objects.hash(id);
    }
}