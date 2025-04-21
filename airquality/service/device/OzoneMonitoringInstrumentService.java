package br.com.fiap.airquality.service.device;

import br.com.fiap.airquality.exception.EntryNotFoundException;
import br.com.fiap.airquality.model.device.impl.OzoneMonitoringInstrument;
import br.com.fiap.airquality.model.monitor.AirMonitoringStation;
import br.com.fiap.airquality.repository.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OzoneMonitoringInstrumentService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public OzoneMonitoringInstrumentService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public OzoneMonitoringInstrument create(OzoneMonitoringInstrument ozoneMonitoringInstrument) {
        return deviceRepository.save(ozoneMonitoringInstrument);
    }

    public OzoneMonitoringInstrument findById(Long id) {
        return (OzoneMonitoringInstrument) deviceRepository.findById(id)
                .orElseThrow(EntryNotFoundException::new);
    }

    public List<OzoneMonitoringInstrument> findAll() {
        return new ArrayList<>(deviceRepository.findAll()
                .stream()
                .map(device -> (OzoneMonitoringInstrument) device)
                .toList());
    }

    public void delete(Long id) {
        deviceRepository.delete(
                deviceRepository.findById(id)
                        .orElseThrow(EntryNotFoundException::new));
    }

    public OzoneMonitoringInstrument update(OzoneMonitoringInstrument ozoneMonitoringInstrument) {

        OzoneMonitoringInstrument optionalOzoneMonitoringInstrument =
                (OzoneMonitoringInstrument) deviceRepository
                .findById(ozoneMonitoringInstrument.getId())
                        .orElseThrow(EntryNotFoundException::new);

        if (optionalOzoneMonitoringInstrument != null) {
            return deviceRepository.save(ozoneMonitoringInstrument);
        }

        else {
            throw new EntryNotFoundException();
        }

    }

}
