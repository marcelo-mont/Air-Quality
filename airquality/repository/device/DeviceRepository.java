package br.com.fiap.airquality.repository.device;

import br.com.fiap.airquality.model.device.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
