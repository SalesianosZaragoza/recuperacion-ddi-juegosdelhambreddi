package JuegosdelhambreDDI.CafeteriaAPP.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Trabajador {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String  getNombre() {
        return nombre;
    }

    public void setNombre(String  nombre) {
        this.nombre = nombre;
    }

    public String  getApellidos() {
        return apellidos;
    }

    public void setApellidos(String  apellidos) {
        this.apellidos = apellidos;
    }
//Falta la relacion con los pedidos

}