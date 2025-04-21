package br.com.fiap.airquality.model.device.impl;

import br.com.fiap.airquality.model.device.Device;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "air_quality_sensors")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class AirQualitySensor extends Device {

    private Double aqi;

    @Column(name = "temperature_celsius")
    private Double temperatureCelsius;

    @Column(name = "humidity_percentage")
    private Double humidityPercentage;

    @Column(name = "ECO2_PPM")
    private Double eco2Ppm;

    @Column(name = "TVOC_PPB")
    private Double tvocPpb;

}