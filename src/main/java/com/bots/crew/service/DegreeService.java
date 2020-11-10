package com.bots.crew.service;

import com.bots.crew.model.Degree;
import java.util.List;

public interface DegreeService {

    Degree add(Degree degree);

    List<Degree> provideGlobalSearch(String part);

    List<Degree> getAll();
}
