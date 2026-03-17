package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tablero {

	// El tablero se representa como una matriz de enteros, donde el número 0 representa el hueco vacío.
    private int[][] tablero = new int[3][3];

    public Tablero() {
        inicializar();
    }

    // Método para inicializar el tablero con números del 1 al 8 y un hueco vacío (0), en orden aleatorio.
    public void inicializar() {

        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            numeros.add(i);
        }

        // Mezclamos la lista de números para obtener una configuración aleatoria del tablero.
        Collections.shuffle(numeros);

        int index = 0;

        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                tablero[fila][columna] = numeros.get(index++);
            }
        }
    }

    // Método para obtener el valor en una posición específica del tablero.
    public int getValor(int fila, int col) {
        return tablero[fila][col];
    }

    // Método privado para buscar la posición del hueco vacío (0) en el tablero.
    private int[] buscarHueco() {

        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                if (tablero[f][c] == 0) {
                    return new int[]{f, c};
                }
            }
        }
        return null;
    }

    // Método para mover una ficha a la posición del hueco vacío, si es un movimiento válido (es decir, si la ficha está adyacente al hueco).
    public boolean mover(int fila, int column) {

        int[] hueco = buscarHueco();

        int distancia = Math.abs(hueco[0] - fila) + Math.abs(hueco[1] - column);

        if (distancia == 1) {

            int temp = tablero[fila][column];
            tablero[fila][column] = 0;
            tablero[hueco[0]][hueco[1]] = temp;

            return true;
        }

        return false;
    }

    // Método para verificar si el tablero está en la configuración resuelta (números del 1 al 8 en orden, con el hueco vacío al final).
    public boolean estaResuelto() {

        int contador = 1;

        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {

                if (f == 2 && c == 2) {
                    return tablero[f][c] == 0;
                }

                if (tablero[f][c] != contador++) {
                    return false;
                }
            }
        }

        return true;
    }
}