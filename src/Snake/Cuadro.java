package Snake;

import static Snake.GameFrame.snakeVivo;
import static Snake.GameFrame.snake;
import static Snake.GameFrame.cabezaSnake;
import static Snake.GameFrame.colaSnake;
import static Snake.GameFrame.listaPocisionesCulebra;
import static Snake.GameFrame.botones;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Danny Rojas Arguedas
 */

public class Cuadro extends JButton implements ActionListener, Serializable {

    protected int x, y;
    protected String tipo;
    protected String nombre;

    public Cuadro(int posx, int posy, int ancho, int alto, int x, int y) {
        this.x = x;
        this.y = y;
        this.nombre = x + "-" + y;
        setBounds(posx, posy, ancho, alto);
        Font font1 = new Font("Dialog", Font.PLAIN, 22);
        setFont(font1);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (snakeVivo == false) {
            if (!"Block".equals(this.tipo)) {
                this.setIcon(snake);
                JOptionPane.showMessageDialog(this, "(" + this.x + "," + this.y + ")\n Tipo: " + this.tipo);
                snakeVivo = true;
                cabezaSnake = this.nombre;
                colaSnake = this.nombre;
                listaPocisionesCulebra.add(botones[this.x][this.y]);
            } else {
                JOptionPane.showMessageDialog(this, "Debe colocarlo en un lugar disponible");
            }
        }
    }

}
