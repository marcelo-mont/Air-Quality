package br.com.fiap.airquality.controller.monitor;

import br.com.fiap.airquality.model.monitor.AirMonitoringLog;
import br.com.fiap.airquality.service.monitor.AirMonitoringLogService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/air_quality")
public class AirMonitoringLogController {

    private final AirMonitoringLogService airMonitoringLogService;

    @Autowired
    public AirMonitoringLogController(AirMonitoringLogService airMonitoringLogService) {
        this.airMonitoringLogService = airMonitoringLogService;
    }

    @PostMapping("/log")
    @Transactional
    public AirMonitoringLog create(@RequestBody AirMonitoringLog airMonitoringLog) {
        return airMonitoringLogService.create(airMonitoringLog);
    }

    @GetMapping("/log")
    @ResponseStatus(HttpStatus.OK)
    public List<AirMonitoringLog> findAll(){
        return airMonitoringLogService.findAll();
    }

    @GetMapping("/log/{id}")
    public AirMonitoringLog findById(@PathVariable Long id){
        return airMonitoringLogService.findById(id);
    }

    @RequestMapping(value = "/log", params = {"minDate", "maxDate"})
    @ResponseStatus(HttpStatus.OK)
    public List<AirMonitoringLog> findByDateRange(
            @RequestParam Timestamp minDate,
            @RequestParam Timestamp maxDate) {
        return airMonitoringLogService.findByDateRange(minDate, maxDate);
    }

    @DeleteMapping("/log/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        airMonitoringLogService.delete(id);
    }

    @PutMapping("/log")
    @ResponseStatus(HttpStatus.OK)
    public AirMonitoringLog update(@RequestBody AirMonitoringLog airMonitoringLog){
        return airMonitoringLogService.update(airMonitoringLog);
    }

}
