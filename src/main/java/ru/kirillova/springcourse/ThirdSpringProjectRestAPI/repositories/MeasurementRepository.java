package ru.kirillova.springcourse.ThirdSpringProjectRestAPI.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import ru.kirillova.springcourse.ThirdSpringProjectRestAPI.models.*;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
}
