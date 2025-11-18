/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author pxand
 */
public class ServicioBingo {
    private IGestorBingo gestor;

    public ServicioBingo(IGestorBingo gestor) {
        this.gestor = gestor;
    }
    
    public void setModoJuego(String modo){
        gestor.setModoJuego(modo);
    }
    
    public String getModoJuego(){
        return gestor.getModoJuego();
    }
    
    public String getModoLlenado(){
        return gestor.getModoLlenado();
    }
    
    public void setModoLlenado(String modo){
        gestor.setModoLlenado(modo);
    }
    
    public CartonBingo crearCarton(String id,String modo){
        CartonBingo carton = new CartonBingo(id);
        return carton;
    }
    
    public boolean esCartonValido(CartonBingo carton){
        return carton.esValido();
    }
    
    public void anadirCarton(CartonBingo carton){
        gestor.anadirCarton(carton);
    }
    
    public void eliminarCarton(String id){
        gestor.eliminarCarton(id);
    }
    
    public void llamarNumero(int num){
        gestor.llamarNumero(num);
    }
    
    public void desmarcarNumero(int num){
        gestor.desmarcarNumero(num);
    }
    
    public Set<Integer> getNumerosSacados(){
        return gestor.getNumerosSacados();
    }
    
    public boolean validarNumero(int num){
        return num>=1 && num <=75 && !getNumerosSacados().contains(num);
    }
    
    public int sacarNumero(){
        return gestor.sacarNumero();
    }
    
    public List<CartonBingo> revisarVictoria(){
        List<CartonBingo> ganadores = new ArrayList<>();
        for (CartonBingo carton : gestor.getCartones()) {
            if (gestor.revisarVictoria(carton)) {
                ganadores.add(carton);
            }
        }
        return ganadores;
    }
    
    public void reiniciarJuego(){
        gestor.reiniciarJuego();
    }
}
