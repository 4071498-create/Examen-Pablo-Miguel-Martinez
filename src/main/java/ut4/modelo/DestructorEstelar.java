/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut4.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 *
 * @author Pablo Miguel Martínez
 */

@Entity
@DiscriminatorValue("DESTRUCTOR")
public class DestructorEstelar extends Nave {
    @Column(name = "capacidad_escudos")
    private int capacidad_escudos;
    
    public DestructorEstelar(){}

    public DestructorEstelar(int capacidad_escudos, String nombre, String modelo, EstadosSistema estado_sistema, Planeta planeta_origen) {
        super(nombre, modelo, estado_sistema, planeta_origen);
        this.capacidad_escudos = capacidad_escudos;
    }

    public int getCapacidad_escudos() {
        return capacidad_escudos;
    }

    public void setCapacidad_escudos(int capacidad_escudos) {
        this.capacidad_escudos = capacidad_escudos;
    }
    
    
}