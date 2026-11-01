/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut4.modelo;

import jakarta.persistence.*;
import java.io.Serializable;
import org.hibernate.annotations.ColumnDefault;

/**
    planeta_id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    clima VARCHAR(50),
    afiliacion VARCHAR(50) DEFAULT 'Neutral'
 */

/**
 *
 * @author Pablo Miguel Martínez
 */

@Entity
@Table(name = "planetas")
public class Planeta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planeta_id")
    private int planeta_id;
    
    @Column(name = "nombre", nullable = false, unique = true, length = 100)
    private String nombre;
    
    @Column(name = "clima", length = 50)
    private String clima;
    
    @ColumnDefault ("'Neutral'")
    @Column(name = "afiliacion", length = 50)
    private String afiliacion;
    
    // mappedBy: Indica "vete a la clase Nave y busca el atributo privado llamado planeta_Origen"
    // cascade: Si borramos un planeta, podemos arrastrar o desvincular sus naves asociadas
    @OneToMany(mappedBy = "planeta_origen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private java.util.List<Nave> listaNaves = new java.util.ArrayList<>();
    
    //Constructor vacio obligatorio
    public Planeta() {}

    public Planeta(int planeta_id, String nombre, String clima, String afiliacion) {
        this.planeta_id = planeta_id;
        this.nombre = nombre;
        this.clima = clima;
        this.afiliacion = afiliacion;
    }

    public int getPlaneta_id() {
        return planeta_id;
    }

    public void setPlaneta_id(int planeta_id) {
        this.planeta_id = planeta_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getAfiliacion() {
        return afiliacion;
    }

    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }
    
    
}
