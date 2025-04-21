package br.com.fiap.airquality.repository.monitor;

import br.com.fiap.airquality.model.monitor.AirMonitoringLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface AirMonitoringLogRepository extends JpaRepository<AirMonitoringLog, Long> {

    @Query("SELECT a FROM AirMonitoringLog a WHERE a.time BETWEEN :min AND :max ORDER BY a.time DESC")
    List<AirMonitoringLog> findByDateRange(
            @Param("min") Timestamp min,
            @Param("max") Timestamp max
    );

}
