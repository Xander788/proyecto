/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Vista;

import Modelo.CartonBingo;
import java.util.List;

/**
 *
 * @author danny
 */
public interface IVista {

   void mostrarMensaje(String msg, String titulo);
    void mostrarError(String msg);
    boolean confirmar(String msg, String titulo);

    // Métodos para el Bingo
    void mostrarCarton(CartonBingo carton);
    void actualizarTombolaV(int numero);
    void desmarcarTombolaV(int numero);
    void limpiarTombolaV();
    void marcarGanadoresV(List<CartonBingo> ganadores);
    

    
// NEcesito mandarte a commit 
}
