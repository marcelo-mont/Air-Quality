package br.com.fiap.airquality.controller.monitor;

import br.com.fiap.airquality.model.monitor.AirMonitoringStation;
import br.com.fiap.airquality.service.monitor.AirMonitoringStationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/air_quality")
public class AirMonitoringStationController {

    private final AirMonitoringStationService airMonitoringStationService;

    @Autowired
    public AirMonitoringStationController(AirMonitoringStationService airMonitoringStationService) {
        this.airMonitoringStationService = airMonitoringStationService;
    }

    @PostMapping("/station")
    @Transactional
    public AirMonitoringStation create(@RequestBody AirMonitoringStation airMonitoringStation) {
        return airMonitoringStationService.create(airMonitoringStation);
    }

    @PatchMapping("/station/add_device")
    @Transactional
    public AirMonitoringStation addDevice(@RequestParam Long stationId, @RequestParam Long deviceId) {
        return airMonitoringStationService.addDevice(stationId, deviceId);
    }

    @GetMapping("/station")
    @ResponseStatus(HttpStatus.OK)
    public List<AirMonitoringStation> findAll(){
        return airMonitoringStationService.findAll();
    }

    @GetMapping("/station/{id}")
    public AirMonitoringStation findById(@PathVariable Long id){
        return airMonitoringStationService.findById(id);
    }

    @DeleteMapping("/station/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        airMonitoringStationService.delete(id);
    }

    @PutMapping("/station")
    @ResponseStatus(HttpStatus.OK)
    public AirMonitoringStation update(@RequestBody AirMonitoringStation airMonitoringStation){
        return airMonitoringStationService.update(airMonitoringStation);
    }

}
