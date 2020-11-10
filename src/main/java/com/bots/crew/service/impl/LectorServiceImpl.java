package com.bots.crew.service.impl;

import com.bots.crew.model.Lector;
import com.bots.crew.repository.LectorRepository;
import com.bots.crew.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    @Autowired
    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public Lector add(Lector lector) {
        return lectorRepository.save(lector);
    }
}
