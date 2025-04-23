package com.coppel.omnicanal.dispositivoiniciosesion.services;

import com.coppel.omnicanal.dispositivoiniciosesion.dto.DispositivoDto;
import org.springframework.stereotype.Service;

@Service
public interface DispositivoService {
    DispositivoDto saveDevice(DispositivoDto device);

    boolean validateDevice(String idDispositivo, String logonId);

    boolean firstDevice(String logonId);
}
