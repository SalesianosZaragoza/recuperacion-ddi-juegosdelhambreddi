package JuegosdelhambreDDI.CafeteriaAPP.model;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Column(name = "nombre")
    private String nombre;
	@Column(name = "apellidos")
    private String apellidos;
	@Column(name = "password")
    private String password;
	@Column(name = "email")
	private String email;
    @Column(name = "esCliente")
	@ColumnDefault("false")
	private Boolean esCliente;
	@Column(name = "esLogin")
	@ColumnDefault("false")
	private Boolean esLogin;
    // Constructor, getters, and setters

    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    // }

	/*Genera todos los getter y setter */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	// @Column(name="password", nullable=false, length=50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEsCliente() {
        return esCliente;
    }

    public void setEsCliente(Boolean esCliente) {
        this.esCliente = esCliente;
    }

    public Boolean getEsLogin() {
        return esLogin;
    }

    public void setEsLogin(Boolean esLogin) {
        this.esLogin = esLogin;
    }
}
