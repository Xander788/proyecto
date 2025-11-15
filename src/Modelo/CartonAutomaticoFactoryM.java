/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import static java.lang.Math.random;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author danny
 */
public class CartonAutomaticoFactoryM implements ICartonFactory {

    private Random aleatorio = new Random();
    
    @Override
    public CartonBingo crearCarton(String id, String mode) {

        CartonBingo carton = new CartonBingo(id);

        for (int j = 0; j < 5; j++) {
            Set<Integer> numeroColumnas = new HashSet<>(); 
            int minimo = j * 15 + 1;
            int maximo = (j + 1) * 15;
            for (int i = 0; i < 5; i++) {
                if (i == 2 && j == 2) {
                    continue;
                }
                
                int numero;
                do {
                    
                    numero = aleatorio.nextInt(maximo - minimo + 1) + minimo;
               
                } while (numeroColumnas.contains(numero));
                
                numeroColumnas.add(numero);
                carton.setNumeros(i, j, numero);
            }
        }
        return carton;
    }

}
