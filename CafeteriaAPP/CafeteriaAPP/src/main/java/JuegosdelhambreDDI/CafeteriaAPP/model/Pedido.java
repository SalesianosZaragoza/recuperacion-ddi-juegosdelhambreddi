package JuegosdelhambreDDI.CafeteriaAPP.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Pedido {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer numPedido;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trabajador_id")
    private Trabajador trabajador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "consumicion_id")
    private List<Consumicion> consumicion;


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    public Integer getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Integer numPedido) {
        this.numPedido = numPedido;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
    
    public List<Consumicion> getConsumicion() {
        return this.consumicion;
    }

    public void setConsumicion(List<Consumicion> consumicion) {
        this.consumicion = consumicion;
    }




}