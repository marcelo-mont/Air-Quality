package br.com.fiap.airquality.service.monitor;

import br.com.fiap.airquality.exception.EntryNotFoundException;
import br.com.fiap.airquality.model.monitor.AirMonitoringLog;
import br.com.fiap.airquality.repository.monitor.AirMonitoringLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AirMonitoringLogService {

    private final AirMonitoringLogRepository airMonitoringLogRepository;

    @Autowired
    public AirMonitoringLogService(AirMonitoringLogRepository airMonitoringLogRepository) {
        this.airMonitoringLogRepository = airMonitoringLogRepository;
    }

    public AirMonitoringLog create(AirMonitoringLog airMonitoringLog) {
        return airMonitoringLogRepository.save(airMonitoringLog);
    }

    public AirMonitoringLog findById(Long id) {
        return airMonitoringLogRepository.findById(id).orElseThrow(EntryNotFoundException::new);
    }

    public List<AirMonitoringLog> findAll() {
        return new ArrayList<>(airMonitoringLogRepository.findAll());
    }

    public List<AirMonitoringLog> findByDateRange(Timestamp minTime, Timestamp maxTime){
        return airMonitoringLogRepository
                .findByDateRange(minTime, maxTime);
    }

    public void delete(Long id) {
        airMonitoringLogRepository.delete(
                airMonitoringLogRepository.findById(id)
                        .orElseThrow(EntryNotFoundException::new));
    }

    public AirMonitoringLog update(AirMonitoringLog airMonitoringLog) {

        Optional<AirMonitoringLog> optionalAirMonitoringStation = airMonitoringLogRepository.findById(airMonitoringLog.getId());

        if (optionalAirMonitoringStation.isPresent()) {
            return airMonitoringLogRepository.save(airMonitoringLog);
        }

        else {
            throw new EntryNotFoundException();
        }

    }
}
