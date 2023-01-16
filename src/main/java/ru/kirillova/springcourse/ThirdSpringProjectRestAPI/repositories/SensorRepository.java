package ru.kirillova.springcourse.ThirdSpringProjectRestAPI.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import ru.kirillova.springcourse.ThirdSpringProjectRestAPI.models.*;

import java.util.*;

@Repository
public interface SensorRepository extends JpaRepository<Sensor,Integer> {
    Optional<Sensor> findByName(String name);
}
