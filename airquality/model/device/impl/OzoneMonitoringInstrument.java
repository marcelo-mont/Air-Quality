package br.com.fiap.airquality.model.device.impl;

import br.com.fiap.airquality.model.device.Device;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ozone_monitoring_instruments")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class OzoneMonitoringInstrument extends Device {

    @Column(name = "orbit_height_km")
    private Double orbitHeightKm;

    @Column(name = "no2_10e15_molecules_cm_2")
    private Double no2x10e15moleculesPerCm2;

    @Column(name = "so2_10e15_molecules_cm_2")
    private Double so2x10e15moleculesPerCm2;

    @Column(name = "bro_10e15_molecules_cm_2")
    private Double bro2x10e15moleculesPerCm2;

    @Column(name = "hcho_10e15_molecules_cm_2")
    private Double hcho2x10e15moleculesPerCm2;

    @Column(name = "aerosol_aod")
    private Double aerosolAod;

}
