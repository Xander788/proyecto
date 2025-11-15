/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pxand
 */
public class CartonManualFactory implements ICartonFactory{

    @Override
    public CartonBingo crearCarton(String id, String mode) {
        return new CartonBingo(id);
    }
    
}
