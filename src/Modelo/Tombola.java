/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author pxand
 */
public class Tombola {
    private static Tombola instance;
    private List<Integer> numeros = new ArrayList<>();
    
    private Tombola() {
        reiniciar();
    }

    public static Tombola getInstance() {
        if (instance == null) {
            instance = new Tombola();
        }
        return instance;
    }
    
    public void reiniciar() {
        numeros.clear();
        for (int i = 1; i <= 75; i++) {
            numeros.add(i);
        }
        Collections.shuffle(numeros);
    }
    
    public int sacarNumero() {
        if (numeros.isEmpty()) {
            return -1;
        }
        return numeros.remove(0);
    }
}
