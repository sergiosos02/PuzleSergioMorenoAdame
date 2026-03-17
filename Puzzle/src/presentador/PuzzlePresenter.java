package presentador;

import modelo.Tablero;
import vista.PuzzleGUI;

public class PuzzlePresenter {

    private Tablero modelo;
    private PuzzleGUI vista;

    // Constructor del presentador, recibe el modelo y la vista
    public PuzzlePresenter(Tablero m, PuzzleGUI v){

        this.modelo = m;
        this.vista = v;

        actualizarVista();
    }

    // Método que se llama cuando el usuario pulsa un botón en la vista, recibe la fila y columna del botón pulsado
    public void botonPulsado(int fila,int col){

        if(modelo.mover(fila,col)){

            actualizarVista();

            if(modelo.estaResuelto()){
                vista.mostrarVictoria();
                vista.bloquear();
            }
        }
    }

    // Método privado para actualizar la vista con el estado actual del modelo
    private void actualizarVista(){

        for(int f=0; f<3; f++){
            for(int c=0; c<3; c++){

                int valor = modelo.getValor(f,c);

                if(valor == 0){
                    vista.actualizarBoton(f,c,"");
                }else{
                    vista.actualizarBoton(f,c,String.valueOf(valor));
                }
            }
        }
    }
}