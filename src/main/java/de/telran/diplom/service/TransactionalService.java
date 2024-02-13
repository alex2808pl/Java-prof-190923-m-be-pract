package de.telran.diplom.service;

import de.telran.diplom.pojo.Transactional;
import de.telran.diplom.repository.DataRepository;

public class TransactionalService {
    DataRepository<Transactional> repository;

    public TransactionalService(DataRepository<Transactional> repository) {
        this.repository = repository;
    }

    public boolean save(Transactional tr) {
        return repository.save(tr);
    }

    public Transactional read () {
        return repository.read();
    }


}
