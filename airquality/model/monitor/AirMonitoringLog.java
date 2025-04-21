package br.com.fiap.airquality.model.monitor;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "air_monitoring_logs")
@Getter
@Setter
public class AirMonitoringLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAirMonitoringLogId")
    @SequenceGenerator(name = "seqAirMonitoringLogId", sequenceName = "SEQ_AIR_MONITORING_LOG_ID", allocationSize = 1)
    @Column(name = "id")
    private Long Id;

    @Column(name = "device_id")
    private Long deviceId;

    @Column(name = "from_email")
    private String fromEmail;

    @Column(name = "to_email")
    private String toEmail;

    private String subject;

    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp time;

}