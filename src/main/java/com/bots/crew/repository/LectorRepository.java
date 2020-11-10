package com.bots.crew.repository;

import com.bots.crew.model.Lector;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectorRepository extends JpaRepository<Lector, Long> {

    List<Lector> findLectorsByNameContainsOrSurnameContains(String part1, String part2);
}
