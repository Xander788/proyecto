/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author danny
 */
public class TipoCartonFactory {
    public static ICartonFactory getFactory(String modo){
        if("automatico".equals(modo)){
            return new CartonAutomaticoFactoryM();
        }else{
            return new CartonManualFactory();
        }
    }
    
}
// contiene  el factory method para
//crear instancias de fábricas de cartones según el
//modo de juego seleccionado. Recibe un parámetro
//modo y retorna
