
package com.example.sga.domain;

import java.io.Serializable;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Persona implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private int idPersona;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    
}
