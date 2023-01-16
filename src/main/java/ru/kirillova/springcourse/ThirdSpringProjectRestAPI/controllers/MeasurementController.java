package ru.kirillova.springcourse.ThirdSpringProjectRestAPI.controllers;

import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import ru.kirillova.springcourse.ThirdSpringProjectRestAPI.dto.*;
import ru.kirillova.springcourse.ThirdSpringProjectRestAPI.models.*;
import ru.kirillova.springcourse.ThirdSpringProjectRestAPI.services.*;
import ru.kirillova.springcourse.ThirdSpringProjectRestAPI.util.*;

import javax.validation.*;
import java.util.*;
import java.util.stream.*;

import static ru.kirillova.springcourse.ThirdSpringProjectRestAPI.util.ErrorsUtil.returnErrorsToClient;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;
    private final MeasurementValidator measurementValidator;
    private final ModelMapper modelMapper;

    @Autowired
    public MeasurementController(MeasurementService measurementService,
                                 MeasurementValidator measurementValidator,
                                 ModelMapper modelMapper) {
        this.measurementService = measurementService;
        this.measurementValidator = measurementValidator;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid MeasurementDTO measurementDTO,
                                          BindingResult bindingResult) {
        Measurement measurementToAdd = convertToModel(measurementDTO);

        measurementValidator.validate(measurementToAdd, bindingResult);

        if (bindingResult.hasErrors())
            returnErrorsToClient(bindingResult);

        measurementService.save(measurementToAdd);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public MeasurementsResponse  measurements() {
        // Обычно список из элементов оборачивается в один объект для пересылки
        return new MeasurementsResponse(measurementService.findAll().stream().map(this::convertToDTO)
                .collect(Collectors.toList()));    }

    @GetMapping("/rainyDaysCount")
    public long rainyDaysCount() {
        return measurementService.findAll().stream().filter(Measurement::isRaining).count();
    }

    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> handleException(MeasurementException e) {
        MeasurementErrorResponse response = new MeasurementErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private MeasurementDTO convertToDTO(Measurement measurement) {
        return modelMapper.map(measurement, MeasurementDTO.class);

    }

    private Measurement convertToModel(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);

    }
}
