package br.com.fiap.airquality.controller.device;

import br.com.fiap.airquality.model.device.impl.GasLeakDetector;
import br.com.fiap.airquality.service.device.GasLeakDetectorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/air_quality")
public class GasLeakDetectorController {

    private final GasLeakDetectorService gasLeakDetectorService;

    @Autowired
    public GasLeakDetectorController(GasLeakDetectorService gasLeakDetectorService) {
        this.gasLeakDetectorService = gasLeakDetectorService;
    }

    @PostMapping("/gas_leak_detector")
    @Transactional
    public GasLeakDetector create(@RequestBody GasLeakDetector gasLeakDetector) {
        return gasLeakDetectorService.create(gasLeakDetector);
    }

    @GetMapping("/gas_leak_detector")
    @ResponseStatus(HttpStatus.OK)
    public List<GasLeakDetector> findAll(){
        return gasLeakDetectorService.findAll();
    }

    @GetMapping("/gas_leak_detector/{id}")
    public GasLeakDetector findById(@PathVariable Long id){
        return gasLeakDetectorService.findById(id);
    }

    @DeleteMapping("/gas_leak_detector/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        gasLeakDetectorService.delete(id);
    }

    @PutMapping("/gas_leak_detector")
    @ResponseStatus(HttpStatus.OK)
    public GasLeakDetector update(@RequestBody GasLeakDetector gasLeakDetector){
        return gasLeakDetectorService.update(gasLeakDetector);
    }

}
