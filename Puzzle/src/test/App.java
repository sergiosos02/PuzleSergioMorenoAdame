package test;

import modelo.Tablero;
import vista.PuzzleGUI;
import presentador.PuzzlePresenter;

public class App {

    public static void main(String[] args) {

        Tablero modelo = new Tablero();

        PuzzleGUI vista = new PuzzleGUI();

        PuzzlePresenter presentador = new PuzzlePresenter(modelo,vista);

        vista.setPresentador(presentador);
    }
}