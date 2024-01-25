package JuegosdelhambreDDI.CafeteriaAPP.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;




@Entity
public class Bebida {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer id;


    @Column(nullable = false)
    private String cantidad;

    @Column(nullable = false)
    private double precio;

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_id")// , nullable = true
    private Cafe cafe;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "refresco_id")// , nullable = true
    private Refresco refresco;


    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(final Cafe cafe) {
        this.cafe = cafe;
    }

    public Refresco getRefresco() {
        return refresco;
    }

    public void setRefresco(final Refresco refresco) {
        this.refresco = refresco;
    }
//FALTARIA LA RELACION CON CONSUMICION
   
}

