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
@DiscriminatorValue("CAZA")
public class CazaLigero extends Nave {
    @Column(name = "potencia_fuego")
    private int potencia_fuego;
    
    public CazaLigero(){}

    public CazaLigero(int potencia_fuego, String nombre, String modelo, EstadosSistema estado_sistema, Planeta planeta_origen) {
        super(nombre, modelo, estado_sistema, planeta_origen);
        this.potencia_fuego = potencia_fuego;
    }

    public int getPotencia_fuego() {
        return potencia_fuego;
    }

    public void setPotencia_fuego(int potencia_fuego) {
        this.potencia_fuego = potencia_fuego;
    }
    
    
}