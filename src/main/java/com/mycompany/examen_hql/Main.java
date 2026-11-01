/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examen_hql;

import ut4.controlador.HoloNetControl;
import ut4.modelo.CazaLigero;
import ut4.modelo.Nave;
import java.util.List;

/**
 *
 * @author Pablo Miguel Martínez
 */
public class Main {

    public static void main(String[] args) {
        HoloNetControl control = new HoloNetControl();

        System.out.println("=== DESAFÍO 1: Cazas operativos por bando ===");
        List<CazaLigero> cazas = control.obtenerCazasOperativosPorBando("Alianza Rebelde");
        for (CazaLigero c : cazas) {
            System.out.println(c.getNombre() + " - " + c.getEstado_sistema());
        }
        
        System.out.println("=== DESAFÍO 2: Flota en estado crítico ===");
        List<Nave> flota = control.obtenerFlotaCriticaPolimorfica();
        for (Nave n : flota) {
            System.out.println(n.getNombre() + " - " + n.getClass().getSimpleName());
        }
        
        System.out.println("=== DESAFÍO 3: Reporte general ===");
        List<Object[]> reporte = control.obtenerReporteGeneralFiltrado();
        for (Object[] fila : reporte) {
            System.out.println("Nave: " + fila[0] + " | Tipo: " + fila[1] + " | Planeta: " + fila[2]);
        }
    }
}
