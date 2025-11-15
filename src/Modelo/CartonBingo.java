/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

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

    public void setNumeros(int i ,int j ,int num) {
        numeros[i][j]= num;
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
    
}
