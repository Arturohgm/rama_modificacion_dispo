package com.coppel.omnicanal.dispositivoiniciosesion.repositories;

import com.coppel.omnicanal.dispositivoiniciosesion.entities.Dispositivo;
import com.coppel.omnicanal.dispositivoiniciosesion.entities.DispositivoId;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * DispositivoRepository.
 */
@Repository
public interface DispositivoRepository extends CrudRepository<Dispositivo, DispositivoId> {

    boolean existsByIdDispositivoAndLogonId(String idDispositivo,String logonId);

    int countByLogonId(String logonId);
}