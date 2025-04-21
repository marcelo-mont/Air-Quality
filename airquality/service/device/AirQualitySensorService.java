package br.com.fiap.airquality.service.device;

import br.com.fiap.airquality.exception.EntryNotFoundException;
import br.com.fiap.airquality.model.device.impl.AirQualitySensor;
import br.com.fiap.airquality.model.device.impl.GasLeakDetector;
import br.com.fiap.airquality.repository.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirQualitySensorService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public AirQualitySensorService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public AirQualitySensor create(AirQualitySensor airQualitySensor) {
        return deviceRepository.save(airQualitySensor);
    }

    public AirQualitySensor findById(Long id) {
        return (AirQualitySensor) deviceRepository.findById(id)
                .orElseThrow(EntryNotFoundException::new);
    }

    public List<AirQualitySensor> findAll() {
        return new ArrayList<>(deviceRepository.findAll()
                .stream()
                .map(device -> (AirQualitySensor) device)
                .toList());
    }

    public void delete(Long id) {
        deviceRepository.delete(
                deviceRepository.findById(id)
                        .orElseThrow(EntryNotFoundException::new));
    }

    public AirQualitySensor update(AirQualitySensor airQualitySensor) {

        AirQualitySensor optionalAirQualitySensor =
                (AirQualitySensor) deviceRepository
                        .findById(airQualitySensor.getId())
                        .orElseThrow(EntryNotFoundException::new);

        if (optionalAirQualitySensor != null) {
            return deviceRepository.save(airQualitySensor);
        }

        else {
            throw new EntryNotFoundException();
        }

    }

}
