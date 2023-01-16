package ru.kirillova.springcourse.ThirdSpringProjectRestAPI.dto;

import javax.validation.constraints.*;

public class MeasurementDTO {
    @NotNull
    @Min(value = -100)
    @Max(value = 100)
    private Double value;

    @NotNull(message = "Raining field should not be empty")
    private Boolean raining;

    @NotNull(message = "Sensor field should not be empty")
    private SensorDTO sensor;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
