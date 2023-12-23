
package com.example.sga.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

//Anotaciones de Lombok generan codigo automatico
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
//Esta anotacion de JPA Transforma el POJO en una entidad
@Entity
//Defino NameQueries que utiliza esta clase
@NamedQueries({
    //Asigno un nombre al query y la sentencia se escribe en codigo JPQL
    @NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p ORDER BY p.idPersona")
})
//Le digo que se relaciona con la tabla persona (Por si hay algun problema o tienen nombres distintos)
@Table(name="persona")
public class Persona implements Serializable{
    private static final long serialVersionUID = 1L;
    
    //Defino que este es el equivalente a la primary key
    @Id
    //Le digo que en la tabla se genera de manera Automatica
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Ya que tienen nombres distinto, le paso como esta el nombre en la tabla
    @Column(name = "id_persona")
    private int idPersona;
    
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
}
