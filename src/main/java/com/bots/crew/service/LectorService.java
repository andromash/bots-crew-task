package com.bots.crew.service;

import com.bots.crew.model.Lector;
import java.util.List;

public interface LectorService {

    Lector add(Lector lector);

    List<Lector> provideGlobalSearch(String part);
}
