/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author pxand
 */
public class CartonBingo {
    private String id;
    private int[][] numeros;
    private boolean[][] marcados;

    public CartonBingo(String id) {
        this.id = id;
        this.numeros = new int[5][5];
        this.marcados = new boolean[5][5];       
        this.marcados[2][2] = true;
        this.numeros[2][2] = -1;
    }

    public String getId() {
        return id;
    }

    public int[][] getNumeros() {
        return numeros;
    }

    public boolean[][] getMarcados() {
        return marcados;
    }

    public void setNumeros(int[][] numeros) {
        this.numeros = numeros;
    }
    
    public void marcarNumero(int num){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (numeros[i][j]== num) {
                    marcados[i][j]= true;
                }
            }
        }
    }
    
    public void desmarcarNumero(int num){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (numeros[i][j]== num) {
                    marcados[i][j]= false;
                }
            }
        }
    }
    
    public void reiniciarCarton() {
        marcados = new boolean[5][5];
        marcados[2][2] = true;
    }
    
    public boolean esValido() {
        Set<Integer> unique = new HashSet<>();
        for (int fila = 0; fila < 5; fila++) {
            for (int col = 0; col < 5; col++) {
                if (fila == 2 && col == 2) continue;
                int num = numeros[fila][col];
                if (num < 1 || num > 75 || unique.contains(num)) return false;
                unique.add(num);
                int min = col * 15 + 1;
                int max = (col + 1) * 15;
                if (num < min || num > max) return false;
            }
        }
        return unique.size() == 25;
    }

    public void generarNumeros() {
        Random rand = new Random();
        for (int col = 0; col < 5; col++) {
            int inicio = col * 15 + 1;
            int fin = inicio + 14;
            List<Integer> disponibles = new ArrayList<>();
            for (int n = inicio; n <= fin; n++) {
                disponibles.add(n);
            }

            for (int fila = 0; fila < 5; fila++) {
                if (fila == 2 && col == 2) {
                    numeros[fila][col] = 0;
                    continue;
                }
                int idx = rand.nextInt(disponibles.size());
                numeros[fila][col] = disponibles.get(idx);
                disponibles.remove(idx);
            }
        }
    }
    
    
    
}
