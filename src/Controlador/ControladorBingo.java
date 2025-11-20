/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CartonBingo;
import Modelo.ServicioBingo;
import Vista.IVista;
import java.util.List;

/**
 *
 * @author pxand
 */
public class ControladorBingo {
    private final ServicioBingo servicio;
    private final IVista vista;
    private List<CartonBingo> ganadores;

    public ControladorBingo(ServicioBingo servicio, IVista vista){
        this.servicio = servicio;
        this.vista = vista;
    }
    
    public void cambiarModoJuego(String modo){
        try {
            servicio.setModoJuego(modo);
        } catch (Exception ex){
            vista.mostrarError(ex.getMessage());
        }
    }
    
    public void cambiarModoLlenado(String modo){
        try {
            servicio.setModoLlenado(modo);
        } catch (Exception ex){
            vista.mostrarError(ex.getMessage());
        }
    }

    public CartonBingo generarCarton(String id){
        try {
            String modo = servicio.getModoJuego();
            CartonBingo carton = servicio.crearCarton(id);
            carton.generarNumeros();
            servicio.anadirCarton(carton);
            vista.mostrarCarton(carton);
            return carton;
        } catch (Exception ex){
            vista.mostrarError(ex.getMessage());
            return null;
        }
    }

    public void agregarCartonManual( CartonBingo carton){
        try {
            servicio.anadirCarton(carton);
            vista.mostrarCarton(carton);
        } catch (Exception ex){
            vista.mostrarError(ex.getMessage());
        }
    }
    
    public void sacarNumero(){
        try {
            int num = servicio.sacarNumero();
            vista.actualizarTombolaV(num);
            ganadores = servicio.revisarVictoria();
            if (!ganadores.isEmpty()){
                vista.marcarGanadoresV(ganadores);
            }

        } catch (Exception ex){
            vista.mostrarError(ex.getMessage());
        }
    }

    
    public void llamarNumero(int num){
        try {
            servicio.llamarNumero(num);
            vista.actualizarTombolaV(num);
            
            ganadores = servicio.revisarVictoria();
            if (!ganadores.isEmpty()){
                vista.marcarGanadoresV(ganadores);
            }

        } catch (Exception ex){
            vista.mostrarError(ex.getMessage());
        }
    }
    
    public void desmarcarNumero(int num){
        try {
            servicio.desmarcarNumero(num);
            vista.desmarcarTombolaV(num);

        } catch (Exception ex){
            vista.mostrarError(ex.getMessage());
        }
    }

    public void reiniciarJuego() {
        try {
            if (!vista.confirmar("¿Desea reiniciar el juego?", "Confirmación")) {
                return;
            }
            servicio.reiniciarJuego();
            vista.limpiarTombolaV();
        } catch (Exception ex) {
            vista.mostrarError(ex.getMessage());
        }
    }
    
}
