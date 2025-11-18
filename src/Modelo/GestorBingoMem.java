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
public class GestorBingoMem implements IGestorBingo{
    private List<CartonBingo> cartones;
    private Set<Integer> numerosSacados;
    private Tombola tombola;
    private String modoJuego;
    private String modoLlenado;
    
    @Override
    public void anadirCarton(CartonBingo carton) {
        cartones.add(carton);
    }

    public GestorBingoMem() {
        this.cartones = new ArrayList<>();
        this.numerosSacados = new HashSet<>();
        this.tombola = Tombola.getInstance();
        this.modoJuego = "normal";
        this.modoLlenado = "manual";       
    }

    @Override
    public void eliminarCarton(String id) {
        CartonBingo encontrado = null;

        for (CartonBingo c : cartones) {
            if (c.getId().equals(id)) {
                encontrado = c;
                break;
            }
        }

        if (encontrado != null) {
            cartones.remove(encontrado);
        }
    }

    @Override
    public List<CartonBingo> getCartones() {
        return cartones;
    }

    @Override
    public void setModoJuego(String modo) {
        this.modoJuego = modo;
    }

    @Override
    public String getModoJuego() {
        return modoJuego;
    }

    @Override
    public void llamarNumero(int num) {
        if (!numerosSacados.contains(num)) {
            numerosSacados.add(num);
            for (CartonBingo carton : cartones) {
                carton.marcarNumero(num);
            }
        }
    }

    @Override
    public void desmarcarNumero(int num) {
        numerosSacados.remove(num);
        tombola.meterNumero(num);
        for (CartonBingo carton : cartones) {
            carton.desmarcarNumero(num);
        }
    }

    @Override
    public Set<Integer> getNumerosSacados() {
        return numerosSacados;
    }
       

    @Override
    public boolean revisarVictoria(CartonBingo carton) {
        boolean[][] sacado = carton.getMarcados();
        switch (modoJuego) {
            case "Normal":
                return checkHorizontal(sacado) || checkVertical(sacado) || checkDiagonal(sacado) || checkCuatroEsquinas(sacado);
            case "Cuatro Esquinas":
                return checkCuatroEsquinas(sacado);
            case "Carton Lleno":
                return checkCartonLleno(sacado);
            default:
                return false;
        }
    }

    @Override
    public void reiniciarJuego() {
        numerosSacados.clear();
        tombola.reiniciar();
        for (CartonBingo carton : cartones) {
            carton.reiniciarCarton();
        }
    }

    @Override
    public int sacarNumero() {
        int num = tombola.sacarNumero();
        if (!numerosSacados.contains(num)) {
            numerosSacados.add(num);
            for (CartonBingo carton : cartones) {
                carton.marcarNumero(num);
            }
        }
        return num;
    }
    
    private boolean checkHorizontal(boolean[][] sacado) {
        for (int i = 0; i < 5; i++) {
            boolean win = true;
            for (int j = 0; j < 5; j++) {
                if (!sacado[i][j]) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        return false;
    }

    private boolean checkVertical(boolean[][] sacado) {
        for (int j = 0; j < 5; j++) {
            boolean win = true;
            for (int i = 0; i < 5; i++) {
                if (!sacado[i][j]) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        return false;
    }

    private boolean checkDiagonal(boolean[][] sacado) {
        boolean win1 = true, win2 = true;
        for (int i = 0; i < 5; i++) {
            if (!sacado[i][i]) win1 = false;
            if (!sacado[i][4 - i]) win2 = false;
        }
        return win1 || win2;
    }

    private boolean checkCuatroEsquinas(boolean[][] sacado) {
        return sacado[0][0] && sacado[0][4] && sacado[4][0] && sacado[4][4];
    }

    private boolean checkCartonLleno(boolean[][] sacado) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 2 && j == 2) continue;
                if (!sacado[i][j]) return false;
            }
        }
        return true;
    }

    @Override
    public void setModoLlenado(String modo) {
      this.modoLlenado = modo;
    }

    @Override
    public String getModoLlenado() {
        return modoLlenado;
    }
    
}
