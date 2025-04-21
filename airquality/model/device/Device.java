package br.com.fiap.airquality.model.device;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "devices")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAirMonitoringDeviceId")
    @SequenceGenerator(name = "seqAirMonitoringDeviceId", sequenceName = "SEQ_AIR_MONITORING_DEVICE_ID", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    private String model;

    @Enumerated(EnumType.STRING)
    private DeviceStatus status;

}