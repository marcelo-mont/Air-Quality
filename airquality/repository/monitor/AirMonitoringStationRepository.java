package br.com.fiap.airquality.repository.monitor;

import br.com.fiap.airquality.model.monitor.AirMonitoringStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirMonitoringStationRepository extends JpaRepository<AirMonitoringStation, Long> {
}
