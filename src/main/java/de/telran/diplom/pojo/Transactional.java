package de.telran.diplom.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class Transactional implements Serializable {
    private long id;
    private String description;
    private String type;
    private LocalDate createdAt;
    private Double amount;
    private Account debitAccountId;
    private Account creditAccountId;
}
