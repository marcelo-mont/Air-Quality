package br.com.fiap.airquality.model.monitor;

import br.com.fiap.airquality.model.device.Device;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "air_monitoring_stations")
@Getter
public class AirMonitoringStation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAirMonitoringStationId")
    @SequenceGenerator(name = "seqAirMonitoringStationId", sequenceName = "SEQ_AIR_MONITORING_STATION_ID", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @OneToMany
    private Set<Device> devices = new HashSet<>();

    private String country;

    private String city;

}
