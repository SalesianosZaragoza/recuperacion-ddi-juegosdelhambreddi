package JuegosdelhambreDDI.CafeteriaAPP.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
public class Comida {
    
        @Id
        @Column(nullable = false, updatable = false)
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "primary_sequence"
        )
        private Integer id;

        @Column(nullable = false)
        private String nomComida;

        @Column(nullable = false)
        private Integer cantidad;

        @Column(nullable = false)
        private Double precio;

        //@ManyToOne(fetch = FetchType.LAZY)
        //@JoinColumn(name = "consumicion_id")
        //private Consumicion consumicion;

        public Integer getId() {
            return id;
        }
        
        public void setId(Integer id) {
            this.id = id;
        }

        public String getNomProducto() {
            return nomComida;
        }

        public void setNomProducto(String nomProducto) {
            this.nomComida = nomProducto;
        }

        public Integer getCantidad() {
            return cantidad;
        }

        public void setCantidad(Integer cantidad) {
            this.cantidad = cantidad;
        }

        public Double getPrecio() {
            return precio;
        }

        public void setPrecio(Double precio) {
            this.precio = precio;
        }

        //hacer el metodo para la relacion con las consumiciones

    // public Consumicion getConsumicion() {
    //     return consumicion;
    // }

    // public void setConsumicion(Consumicion consumicion) {
    //     this.consumicion = consumicion;
    // }


}







