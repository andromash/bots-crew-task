package com.bots.crew.service.impl;

import com.bots.crew.model.Head;
import com.bots.crew.repository.HeadRepository;
import com.bots.crew.service.HeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeadServiceImpl implements HeadService {
    private final HeadRepository headRepository;

    @Autowired
    public HeadServiceImpl(HeadRepository headRepository) {
        this.headRepository = headRepository;
    }

    @Override
    public Head add(Head head) {
        return headRepository.save(head);
    }
}
