package com.coppel.omnicanal.dispositivoiniciosesion.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ctl_dispositivosiniciosesion")
@XmlRootElement
@NoArgsConstructor
@Getter
@Setter
@IdClass(DispositivoId.class)
public class Dispositivo {

    @Id
    @Column(name = "id_dispositivo")
    private String idDispositivo;

    @Column(name = "nombre_dispositivo")
    private String nombreDispositivo;

    @Id
    @Column(name = "logon_id")
    private String logonId;

    @Column(name = "ciudad")
    private String ciudad;
}
