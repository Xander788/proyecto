/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Vista;

/**
 *
 * @author danny
 */
public interface IVista <Entidad> {

    public static int YES_OPTION = 0;
    public static int NO_OPTION = 1;

    void limpiar();

    void cambiarEstado(boolean estado);

    default void habilitarCampos() {
        cambiarEstado(true);
    }

    default void desabilitarCampos() {
        cambiarEstado(false);

    }

    void mostrarDatosA(Entidad entidad);

    boolean confirmar(String msg, String titulo);

    void mostrarMensaje(String msg, String titulo);

    void mostrarError(String msg);

    String solicitar(String msg, String titulo);
    
// NEcesito mandarte a commit 
}
