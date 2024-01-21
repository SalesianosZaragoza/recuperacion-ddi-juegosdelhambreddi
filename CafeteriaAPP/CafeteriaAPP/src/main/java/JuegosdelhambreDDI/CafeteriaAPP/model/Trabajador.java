package JuegosdelhambreDDI.CafeteriaAPP.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Trabajador {

    @Id
    @Column(nullable = false, updatable = false)
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