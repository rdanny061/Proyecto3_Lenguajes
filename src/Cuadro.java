
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Danny Rojas Arguedas
 */
public class Cuadro extends JButton implements ActionListener{

    protected int x, y;
    protected String tipo;

    public Cuadro(int posx, int posy, int ancho, int alto, int x, int y) {
        this.x = x;
        this.y = y;
        setBounds(posx, posy, ancho, alto);
        Font font1= new Font("Dialog", Font.PLAIN, 22);
        setFont(font1);
        addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog(this, "Hola me precionaste, soy: "+this.x+","+this.y+ " soy un: "+this.tipo);
    }
    
}
