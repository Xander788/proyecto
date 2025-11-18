/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import java.util.List;
import java.util.Set;

/**
 *
 * @author pxand
 */
public interface IGestorBingo {
    void anadirCarton(CartonBingo carton);
    void eliminarCarton(String id);
    List<CartonBingo> getCartones();
    void setModoJuego(String modo);
    String getModoJuego();
    void setModoLlenado(String modo);
    String getModoLlenado();
    void llamarNumero(int num);
    void desmarcarNumero(int num);
    Set<Integer> getNumerosSacados();
    boolean revisarVictoria(CartonBingo carton);
    void reiniciarJuego();
    int sacarNumero();
    
}
