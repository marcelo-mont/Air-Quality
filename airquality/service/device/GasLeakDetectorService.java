package br.com.fiap.airquality.service.device;

import br.com.fiap.airquality.exception.EntryNotFoundException;
import br.com.fiap.airquality.model.device.impl.GasLeakDetector;
import br.com.fiap.airquality.model.device.impl.OzoneMonitoringInstrument;
import br.com.fiap.airquality.repository.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GasLeakDetectorService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public GasLeakDetectorService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public GasLeakDetector create(GasLeakDetector gasLeakDetector) {
        return deviceRepository.save(gasLeakDetector);
    }

    public GasLeakDetector findById(Long id) {
        return (GasLeakDetector) deviceRepository.findById(id)
                .orElseThrow(EntryNotFoundException::new);
    }

    public List<GasLeakDetector> findAll() {
        return new ArrayList<>(deviceRepository.findAll()
                .stream()
                .map(device -> (GasLeakDetector) device)
                .toList());
    }

    public void delete(Long id) {
        deviceRepository.delete(
                deviceRepository.findById(id)
                        .orElseThrow(EntryNotFoundException::new));
    }

    public GasLeakDetector update(GasLeakDetector gasLeakDetector) {

        GasLeakDetector optionalGasLeakDetector =
                (GasLeakDetector) deviceRepository
                        .findById(gasLeakDetector.getId())
                        .orElseThrow(EntryNotFoundException::new);

        if (optionalGasLeakDetector != null) {
            return deviceRepository.save(gasLeakDetector);
        }

        else {
            throw new EntryNotFoundException();
        }

    }

}
