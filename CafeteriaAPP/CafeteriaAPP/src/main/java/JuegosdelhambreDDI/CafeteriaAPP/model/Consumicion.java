package JuegosdelhambreDDI.CafeteriaAPP.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Consumicion {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comida_id")
    private Comida comida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bebida_id")
    private Bebida bebida;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }   

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
