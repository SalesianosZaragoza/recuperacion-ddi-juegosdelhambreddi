package JuegosdelhambreDDI.CafeteriaAPP.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Cliente {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )

    private Integer id;

    @Column(nullable = false)
    private String nomCliente;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private Boolean logeado;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Boolean getLogeado() {
        return logeado;
    }

    public void setLogeado(final Boolean logeado) {
        this.logeado = logeado;
    }

    public String getnomCliente() {
        return nomCliente;
    }

    public void setnomCliente(final String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(final String apellido) {
        this.apellido = apellido;
    }


    //faltaria la relacion con la consumicion


}
