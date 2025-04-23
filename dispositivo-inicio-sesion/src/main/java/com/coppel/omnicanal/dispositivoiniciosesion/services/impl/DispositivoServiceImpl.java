package com.coppel.omnicanal.dispositivoiniciosesion.services.impl;

import com.coppel.omnicanal.dispositivoiniciosesion.dto.DispositivoDto;
import com.coppel.omnicanal.dispositivoiniciosesion.mappers.DeviceMapper;
import com.coppel.omnicanal.dispositivoiniciosesion.repositories.DispositivoRepository;
import com.coppel.omnicanal.dispositivoiniciosesion.services.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispositivoServiceImpl implements DispositivoService {
    @Autowired
    private DispositivoRepository deviceRepository;

    @Override
    public DispositivoDto saveDevice(final DispositivoDto nuevoDispositivo) {
        final var device = DeviceMapper.mapDispositivoDto(nuevoDispositivo);
        return DeviceMapper.mapDispositivo(this.deviceRepository.save(device));
    }

    @Override
    public boolean validateDevice(String idDispositivo, String logonId) {
        return this.deviceRepository.existsByIdDispositivoAndLogonId(idDispositivo, logonId);
    }

    @Override
    public boolean firstDevice(String logonId){
        int count = this.deviceRepository.countByLogonId(logonId);
        return count == 0;
    }
}
