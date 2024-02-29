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

    @Column(name = "NOMPRODUCTO")
    private String nomProducto;

    @Column
    private Integer cantidad;

    @Column
    private Double precio;

    public Cafe() {
    }

    public Cafe(Integer id, String nomProducto, Integer cantidad, Double precio) {
        this.id = id;
        this.nomProducto = nomProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(final String nomProducto) {
        this.nomProducto = nomProducto;
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

    //faltaria la relacion con las bebidas

}
