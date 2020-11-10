package com.bots.crew.repository;

import com.bots.crew.model.Degree;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepository extends JpaRepository<Degree, Long> {

    List<Degree> findDegreeByNameContains(String part);
}
