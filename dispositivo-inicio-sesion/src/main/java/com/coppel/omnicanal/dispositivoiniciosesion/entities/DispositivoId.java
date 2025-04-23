package com.coppel.omnicanal.dispositivoiniciosesion.entities;

import java.io.Serializable;
import java.util.Objects;

public class DispositivoId implements Serializable {
        private String idDispositivo;
        private String logonId;

        public DispositivoId(){

        }

        public DispositivoId(String idDispositivo, String logonId){
            this.idDispositivo = idDispositivo;
            this.logonId = logonId;
        }
        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            DispositivoId deviceId = (DispositivoId) o;
            return idDispositivo.equals(deviceId.idDispositivo) && logonId.equals(deviceId.logonId);
        }

        @Override
        public int hashCode(){
           return Objects.hash(idDispositivo,logonId);
        }
}

