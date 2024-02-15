package de.telran.diplom.service;

import de.telran.diplom.pojo.Transactional;
import de.telran.diplom.repository.DataRepository;

import java.io.IOException;

public class TransactionalService {
    DataRepository<Transactional> repository;

    public TransactionalService(DataRepository<Transactional> repository) {
        this.repository = repository;
    }

    public boolean save(Transactional tr) throws IOException {
        boolean isSave = repository.save(tr);
        if(!isSave)
            throw new IOException("Ошибка сохранения информации");
        return isSave;
    }

    public Transactional read () {
        return repository.read();
    }


}
