package JuegosdelhambreDDI.CafeteriaAPP.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Refresco {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "refresco_sequence" )
    @SequenceGenerator(
        name = "refresco_sequence",
        sequenceName = "refresco_sequence",
        initialValue = 7,
        allocationSize = 1
    )
    private Integer id;

    @Column(name = "NOMREFRESCO")
    private String nomRefresco;

    // @Column(nullable = false)
    // private Integer cantidad;

    @Column(nullable = false)
    private Double precio;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getNomRefresco() {
        return nomRefresco;
    }

    public void setNomRefresco(final String nomRefresco) {
        this.nomRefresco = nomRefresco;
    }

    // public Integer getCantidad() {
    //     return cantidad;
    // }

    // public void setCantidad(final Integer cantidad) {
    //     this.cantidad = cantidad;
    // }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(final Double precio) {
        this.precio = precio;
    }

    //FALTA RELACION CON BEBIDAS

}
