package com.bots.crew.service.impl;

import com.bots.crew.model.Degree;
import com.bots.crew.repository.DegreeRepository;
import com.bots.crew.service.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DegreeServiceImpl implements DegreeService {
    private final DegreeRepository degreeRepository;

    @Autowired
    public DegreeServiceImpl(DegreeRepository degreeRepository) {
        this.degreeRepository = degreeRepository;
    }

    @Override
    public Degree add(Degree degree) {
        return degreeRepository.save(degree);
    }
}
