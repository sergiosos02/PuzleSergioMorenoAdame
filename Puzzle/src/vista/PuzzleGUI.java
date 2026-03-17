package vista;

import javax.swing.*;
import java.awt.*;
import presentador.PuzzlePresenter;

public class PuzzleGUI extends JFrame {

    private JButton[][] botones = new JButton[3][3];
    private PuzzlePresenter presentador;

    public PuzzleGUI() {

        setTitle("Puzzle Deslizante 3x3");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,3));

        for(int f=0; f<3; f++){
            for(int c=0; c<3; c++){

                botones[f][c] = new JButton();
                int fila = f;
                int col = c;

                botones[f][c].addActionListener(e ->
                        presentador.botonPulsado(fila,col));

                add(botones[f][c]);
            }
        }

        setVisible(true);
    }

    public void setPresentador(PuzzlePresenter p){
        this.presentador = p;
    }

    public void actualizarBoton(int fila,int col,String texto){
        botones[fila][col].setText(texto);
    }

    public void bloquear(){
        for(int f=0;f<3;f++){
            for(int c=0;c<3;c++){
                botones[f][c].setEnabled(false);
            }
        }
    }

    public void mostrarVictoria(){
        JOptionPane.showMessageDialog(this,"¡Has ganado!");
    }
}