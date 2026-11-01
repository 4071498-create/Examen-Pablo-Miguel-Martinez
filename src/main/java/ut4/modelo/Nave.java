/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut4.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
/**
 *
 * @author Pablo Miguel Martínez
 */

/**
 * nave_id SERIAL PRIMARY KEY,
    tipo_nave VARCHAR(30) NOT NULL, -- Columna Discriminadora ('CAZA' o 'DESTRUCTOR')
    nombre VARCHAR(100) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    estado_sistema VARCHAR(20) NOT NULL, -- 'Critico', 'Estable', 'Mantenimiento'
    planeta_origen_id INT,
    potencia_fuego INT,            -- Específico de CazaLigero
    capacidad_escudos INT,         -- Específico de DestructorEstelar

    CONSTRAINT fk_planeta FOREIGN KEY (planeta_origen_id) 
        REFERENCES planetas(planeta_id) ON DELETE SET NULL
 */
@Entity 
@Table(name = "naves")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name = "tipo_nave", 
    discriminatorType = DiscriminatorType.STRING, 
    length = 30
)

public abstract class Nave implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Mapea el tipo 'SERIAL' de Postgres
    @Column(name = "nave_id") // Vincula el atributo con el nombre exacto de la columna
    private int nave_id;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_sistema", nullable = false, length = 20)
    private EstadosSistema estado_sistema;
    
    @ManyToOne(fetch = FetchType.LAZY) // LAZY evita cargar el planeta de la BD a menos que se invoque explícitamente
    @JoinColumn(name = "planeta_origen_id", foreignKey = @ForeignKey(name = "FK_NAVE_PLANETA"))
    private Planeta planeta_origen;
    
    //Constructor vacio
    public Nave (){}

    public Nave(String nombre, String modelo, EstadosSistema estado_sistema, Planeta planeta_origen) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.estado_sistema = estado_sistema;
        this.planeta_origen = planeta_origen;
    }

    public int getNave_id() {
        return nave_id;
    }

    public void setNave_id(int nave_id) {
        this.nave_id = nave_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public EstadosSistema getEstado_sistema() {
        return estado_sistema;
    }

    public void setEstado_sistema(EstadosSistema estado_sistema) {
        this.estado_sistema = estado_sistema;
    }

    public Planeta getPlaneta_origen() {
        return planeta_origen;
    }

    public void setPlaneta_origen(Planeta planeta_origen) {
        this.planeta_origen = planeta_origen;
    }
    
    
    
}
