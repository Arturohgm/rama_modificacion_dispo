package com.coppel.omnicanal.dispositivoiniciosesion.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la informacion de los dispositivos.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DispositivoDto {

    @Schema(description = "ID del dispositivo", name = "id_disositivo", type = "String",
            example = "36874156")
    @JsonProperty("idDispositivo")
    private String idDispositivo;

    @Schema(description = "Nombre del dispositivo", name = "nombre_dispositivo", type = "String",
            example = "Samsung S10")
    @JsonProperty("nombreDispositivo")
    private String nombreDispositivo;

    @Schema(description = "Usuario de la cuenta", name = "logon_id", type = "String",
            example = "juan@gmail.com")
    @JsonProperty("logonId")
    private String logonId;

    @Schema(description = "Nombre de la ciudad", name = "ciudad", type = "String",
            example = "6672541256")
    @JsonProperty("ciudad")
    private String ciudad;
}
