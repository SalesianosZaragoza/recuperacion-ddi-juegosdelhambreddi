package JuegosdelhambreDDI.CafeteriaAPP.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Cafe {

    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column(name = "NOMCAFE")
    private String nomcafe;

    @Column
    private Integer cantidad;

    @Column
    private Double precio;

    public Cafe() {
    }

    public Cafe(Integer id, String nomCafe, Integer cantidad, Double precio) {
        this.id = id;
        this.nomcafe = nomCafe;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getNomcafe() {
        return nomcafe;
    }

    public void setNomcafe(final String nomCafe) {
        this.nomcafe = nomCafe;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(final Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(final Double precio) {
        this.precio = precio;
    }

   //HOLA

}
