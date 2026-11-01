/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut4.controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ut4.modelo.CazaLigero;
import ut4.modelo.Nave;
import java.util.List;

/**
 *
 * @author Pablo Miguel Martínez
 */
public class HoloNetControl {
    private static final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    
    public List<CazaLigero> obtenerCazasOperativosPorBando(String bando){
        try (Session session = sf.openSession()){
            String hql = "FROM Nave n INNER JOIN n.planeta_origen p " + "WHERE TYPE(n) = CazaLigero " + "AND p.afiliacion = :bando " + "AND n.estado_sistema <> 'Mantenimiento'";
            return session.createQuery(hql, CazaLigero.class).setParameter("bando", bando).getResultList();
        }
    }
    
    public List<Nave> obtenerFlotaCriticaPolimorfica(){
        try (Session session = sf.openSession()){
            String hql = "FROM Nave n INNER JOIN FETCH n.planeta_origen p " + "WHERE n.estado_sistema = 'Critico'";
            return session.createQuery(hql, Nave.class).getResultList();
        }
    }
    
    public List<Object[]> obtenerReporteGeneralFiltrado(){
        try (Session session = sf.openSession()){
            String hql = "SELECT n.nombre, TYPE(n), p.nombre " + "FROM Nave n LEFT JOIN n.planeta_origen p";
            return session.createQuery(hql, Object[].class).getResultList();
        }
    }
}
