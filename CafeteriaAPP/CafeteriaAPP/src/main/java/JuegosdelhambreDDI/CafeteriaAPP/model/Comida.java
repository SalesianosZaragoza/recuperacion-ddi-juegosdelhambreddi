package JuegosdelhambreDDI.CafeteriaAPP.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;




@Entity
public class Comida {
    
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
        private String nomProducto;

        @Column(nullable = false)
        private Integer cantidad;

        @Column(nullable = false)
        private Double precio;

         @OneToMany(fetch = FetchType.LAZY)
         @JoinColumn(name = "consumicion_id")
         private Consumicion consumicion;

        public Integer getId() {
            return id;
        }
        
        public void setId(Integer id) {
            this.id = id;
        }

        public String getNomProducto() {
            return nomProducto;
        }

        public void setNomProducto(String nomProducto) {
            this.nomProducto = nomProducto;
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


}







