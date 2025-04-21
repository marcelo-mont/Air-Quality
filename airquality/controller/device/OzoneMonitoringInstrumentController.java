package br.com.fiap.airquality.controller.device;

import br.com.fiap.airquality.model.device.impl.OzoneMonitoringInstrument;
import br.com.fiap.airquality.service.device.OzoneMonitoringInstrumentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/air_quality")
public class OzoneMonitoringInstrumentController {

    private final OzoneMonitoringInstrumentService ozoneMonitoringInstrumentService;

    @Autowired
    public OzoneMonitoringInstrumentController(OzoneMonitoringInstrumentService ozoneMonitoringInstrumentService) {
        this.ozoneMonitoringInstrumentService = ozoneMonitoringInstrumentService;
    }

    @PostMapping("/ozone_monitoring_instrument")
    @Transactional
    public OzoneMonitoringInstrument create(@RequestBody OzoneMonitoringInstrument ozoneMonitoringInstrument) {
        return ozoneMonitoringInstrumentService.create(ozoneMonitoringInstrument);
    }

    @GetMapping("/ozone_monitoring_instrument")
    @ResponseStatus(HttpStatus.OK)
    public List<OzoneMonitoringInstrument> findAll(){
        return ozoneMonitoringInstrumentService.findAll();
    }

    @GetMapping("/ozone_monitoring_instrument/{id}")
    public OzoneMonitoringInstrument findById(@PathVariable Long id){
        return ozoneMonitoringInstrumentService.findById(id);
    }

    @DeleteMapping("/ozone_monitoring_instrument/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        ozoneMonitoringInstrumentService.delete(id);
    }

    @PutMapping("/ozone_monitoring_instrument")
    @ResponseStatus(HttpStatus.OK)
    public OzoneMonitoringInstrument update(@RequestBody OzoneMonitoringInstrument ozoneMonitoringInstrument){
        return ozoneMonitoringInstrumentService.update(ozoneMonitoringInstrument);
    }

}
