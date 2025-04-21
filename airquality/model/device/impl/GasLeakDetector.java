package br.com.fiap.airquality.model.device.impl;

import br.com.fiap.airquality.model.device.Device;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "gas_leak_detectors")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class GasLeakDetector extends Device {

    @Column(name = "CO2_PPM")
    private Double co2Ppm;

    @Column(name = "HC_PPM")
    private Double hcPpm;

    @Column(name = "CH4_PPM")
    private Double ch4Ppm;

    @Column(name = "CO_PPM")
    private Double coPpm;

    @Column(name = "N2O_PPM")
    private Double n2oPpm;

    @Column(name = "NH3_PPM")
    private Double nh3Ppm;

    @Column(name = "NO_PPM")
    private Double noPpm;

}