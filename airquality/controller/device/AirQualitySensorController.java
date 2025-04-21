package br.com.fiap.airquality.controller.device;

import br.com.fiap.airquality.model.device.impl.AirQualitySensor;
import br.com.fiap.airquality.service.device.AirQualitySensorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/air_quality")
public class AirQualitySensorController {

    private final AirQualitySensorService airQualitySensorService;

    @Autowired
    public AirQualitySensorController(AirQualitySensorService airQualitySensorService) {
        this.airQualitySensorService = airQualitySensorService;
    }

    @PostMapping("/air_quality_sensor")
    @Transactional
    public AirQualitySensor create(@RequestBody AirQualitySensor airQualitySensor) {
        return airQualitySensorService.create(airQualitySensor);
    }

    @GetMapping("/air_quality_sensor")
    @ResponseStatus(HttpStatus.OK)
    public List<AirQualitySensor> findAll(){
        return airQualitySensorService.findAll();
    }

    @GetMapping("/air_quality_sensor/{id}")
    public AirQualitySensor findById(@PathVariable Long id){
        return airQualitySensorService.findById(id);
    }

    @DeleteMapping("/air_quality_sensor/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        airQualitySensorService.delete(id);
    }

    @PutMapping("/air_quality_sensor")
    @ResponseStatus(HttpStatus.OK)
    public AirQualitySensor update(@RequestBody AirQualitySensor airQualitySensor){
        return airQualitySensorService.update(airQualitySensor);
    }

}
