package ru.kirillova.springcourse.ThirdSpringProjectRestAPI.services;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import ru.kirillova.springcourse.ThirdSpringProjectRestAPI.models.*;
import ru.kirillova.springcourse.ThirdSpringProjectRestAPI.repositories.*;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class SensorService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public Optional<Sensor> findByName(String name) {
        return sensorRepository.findByName(name);
    }

    @Transactional
    public void save(Sensor sensor) {
        sensorRepository.save(sensor);
    }

}
