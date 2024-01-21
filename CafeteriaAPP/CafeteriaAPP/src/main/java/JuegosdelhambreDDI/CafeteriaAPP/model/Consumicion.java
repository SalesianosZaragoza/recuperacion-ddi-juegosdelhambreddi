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
public class Consumicion {

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
private double precio;



public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public double getPrecio() {
    return precio;
}

public void setPrecio(double precio) {
    this.precio = precio;
}

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "cliente_id")
    // private Cliente cliente;
    // public Cliente getCliente() {
    //     return cliente;
    // }

    // public void setCliente(Cliente cliente) {
    //     this.cliente = cliente;
    // }   

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comida_id")
    private Comida comida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bebida_id")
    private Bebida bebida;


    public Comida getComida() {
        return comida;
    }   

    public void setComidaIdComida(Comida comida) {
        this.comida = comida;
    } 

    public Bebida getBebida() {
        return bebida;
    }   

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }   

    //FALTARIA LA RELACION CON PEDIDO




    
}
