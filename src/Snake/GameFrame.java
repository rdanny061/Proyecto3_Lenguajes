package Snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jpl7.Query;
import org.jpl7.Term;

/**
 *
 * @author Danny Rojas Arguedas
 */
public class GameFrame extends javax.swing.JFrame implements Runnable {

    public static ImageIcon block = new ImageIcon("src\\Images\\block.png");
    public static ImageIcon path = new ImageIcon("src\\Images\\path.png");
    public static ImageIcon apple = new ImageIcon("src\\Images\\apple.png");
    public static ImageIcon snake = new ImageIcon("src\\Images\\snake.png");

    Thread hiloPrincipal;
    public static boolean snakeVivo = false;

    public static String cabezaSnake;

    Cuadro[][] botones = new Cuadro[6][6];

    ArrayList<Cuadro> listaManzanas = new ArrayList();
    ArrayList<Cuadro> listaManzanas2 = new ArrayList(); //lista de los botones donde hay manzanas

    List<String> solucionario = new ArrayList<>();

    public GameFrame(int cantManzanas, int mapa) {
        initComponents();
        cuadros();
        //int mapa = randomNumber(1, 3);
        System.out.println(mapa);
        generarMapa(mapa);
        conexiones();
        colocarManzanas(cantManzanas);
        verBlocks();
    }

    //metodo que realiza las conexiones
    public void conexiones() {
        String t1 = "consult('Snake.pl')";
        Query q1 = new Query(t1);
        System.out.println("" + (q1.hasSolution() ? "Conectado" : "No conectado"));

        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                if (botones[fila][columna].tipo == null) {
                    if (fila == 0 && columna == 0) {
                        if (botones[fila][columna + 1].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila][columna + 1].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                        if (botones[fila + 1][columna].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila + 1][columna].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                    } else if (fila == 5 && columna == 0) {
                        if (botones[fila][columna + 1].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila][columna + 1].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                        if (botones[fila - 1][columna].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila - 1][columna].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                    } else if (fila == 0 && columna == 5) {
                        if (botones[fila][columna - 1].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila][columna - 1].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                        if (botones[fila + 1][columna].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila + 1][columna].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                    } else if (fila == 5 && columna == 5) {
                        if (botones[fila][columna - 1].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila][columna - 1].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                        if (botones[fila - 1][columna].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila - 1][columna].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                    } else if (columna == 0) {
                        if (botones[fila + 1][columna].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila + 1][columna].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                        if (botones[fila - 1][columna].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila - 1][columna].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                        if (botones[fila][columna + 1].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila][columna + 1].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                    } else if (columna == 5) {
                        if (botones[fila + 1][columna].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila + 1][columna].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                        if (botones[fila - 1][columna].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila - 1][columna].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                        if (botones[fila][columna - 1].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila][columna - 1].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                    } else if (fila == 0) {
                        if (botones[fila][columna + 1].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila][columna + 1].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                        if (botones[fila][columna - 1].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila][columna - 1].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                        if (botones[fila + 1][columna].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila + 1][columna].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                    } else if (fila == 5) {
                        if (botones[fila][columna + 1].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila][columna + 1].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                        if (botones[fila][columna - 1].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila][columna - 1].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                        if (botones[fila - 1][columna].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila - 1][columna].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                    } else {
                        if (botones[fila][columna + 1].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila][columna + 1].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                        if (botones[fila][columna - 1].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila][columna - 1].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                        if (botones[fila - 1][columna].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila - 1][columna].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                        if (botones[fila + 1][columna].tipo == null) {
                            String t2 = "crearConexion(" + botones[fila][columna].nombre + "," + botones[fila + 1][columna].nombre + ")";
                            Query q2 = new Query(t2);
                            System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
                        }
                    }
                }
            }
        }
        String t2 = "verConexiones()";
        Query q2 = new Query(t2);
        System.out.println("" + (q2.hasSolution() ? "Insertado" : "No insertado"));
    }

    //metodo que coloca las n manzanas en el mapa
    public void colocarManzanas(int cantidadManzanas) {
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                if (botones[fila][columna].tipo == null) {
                    listaManzanas.add(botones[fila][columna]);
                }
            }
        }
        while (cantidadManzanas != 0) {
            int mapa = randomNumber(0, listaManzanas.size() - 1);
            int x = listaManzanas.get(mapa).x;
            int y = listaManzanas.get(mapa).y;
            listaManzanas2.add(botones[x][y]);
            botones[x][y].setIcon(apple);
            botones[x][y].tipo = "Apple";
            listaManzanas.remove(mapa);
            cantidadManzanas--;
        }
    }

    public void verBlocks() {
        for (int i = 0; i < listaManzanas.size(); i++) {
            System.out.println(listaManzanas.get(i).x + "," + listaManzanas.get(i).y);
        }
    }

    //metodo para obtener un numero random
    public static int randomNumber(int min, int max) {
        int x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }

    //metodo para generar la matriz de botones
    public void cuadros() {
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                botones[fila][columna] = new Cuadro(80 * columna, 80 * fila, 80, 80, fila, columna);
                botones[fila][columna].setIcon(path);
                //botones[fila][columna].nombre(fila, columna);
                jPanel1.add(botones[fila][columna]);
            }
        }
    }

    //metodo para dibujar los mapas
    public void generarMapa(int mapa) {
        switch (mapa) {
            case 1:
                botones[0][0].tipo = "Block";
                botones[0][0].setIcon(block);
                botones[1][0].tipo = "Block";
                botones[1][0].setIcon(block);
                botones[1][2].tipo = "Block";
                botones[1][2].setIcon(block);
                botones[1][4].tipo = "Block";
                botones[1][4].setIcon(block);
                botones[1][5].tipo = "Block";
                botones[1][5].setIcon(block);
                botones[2][2].tipo = "Block";
                botones[2][2].setIcon(block);
                botones[2][5].tipo = "Block";
                botones[2][5].setIcon(block);
                botones[3][0].tipo = "Block";
                botones[3][0].setIcon(block);
                botones[3][2].tipo = "Block";
                botones[3][2].setIcon(block);
                botones[4][0].tipo = "Block";
                botones[4][0].setIcon(block);
                botones[4][2].tipo = "Block";
                botones[4][2].setIcon(block);
                botones[4][4].tipo = "Block";
                botones[4][4].setIcon(block);
                botones[5][4].tipo = "Block";
                botones[5][4].setIcon(block);
                break;
            case 2:
                botones[0][0].tipo = "Block";
                botones[0][0].setIcon(block);
                botones[0][1].tipo = "Block";
                botones[0][1].setIcon(block);
                botones[0][2].tipo = "Block";
                botones[0][2].setIcon(block);
                botones[0][4].tipo = "Block";
                botones[0][4].setIcon(block);
                botones[0][5].tipo = "Block";
                botones[0][5].setIcon(block);
                botones[1][0].tipo = "Block";
                botones[1][0].setIcon(block);
                botones[1][5].tipo = "Block";
                botones[1][5].setIcon(block);
                botones[2][0].tipo = "Block";
                botones[2][0].setIcon(block);
                botones[2][2].tipo = "Block";
                botones[2][2].setIcon(block);
                botones[3][3].tipo = "Block";
                botones[3][3].setIcon(block);
                botones[3][5].tipo = "Block";
                botones[3][5].setIcon(block);
                botones[4][0].tipo = "Block";
                botones[4][0].setIcon(block);
                botones[4][5].tipo = "Block";
                botones[4][5].setIcon(block);
                botones[5][0].tipo = "Block";
                botones[5][0].setIcon(block);
                botones[5][1].tipo = "Block";
                botones[5][1].setIcon(block);
                botones[5][3].tipo = "Block";
                botones[5][3].setIcon(block);
                botones[5][4].tipo = "Block";
                botones[5][4].setIcon(block);
                botones[5][5].tipo = "Block";
                botones[5][5].setIcon(block);
                break;
            case 3:
                botones[0][0].tipo = "Block";
                botones[0][0].setIcon(block);
                botones[0][2].tipo = "Block";
                botones[0][2].setIcon(block);
                botones[0][3].tipo = "Block";
                botones[0][3].setIcon(block);
                botones[0][5].tipo = "Block";
                botones[0][5].setIcon(block);
                botones[2][0].tipo = "Block";
                botones[2][0].setIcon(block);
                botones[2][2].tipo = "Block";
                botones[2][2].setIcon(block);
                botones[2][3].tipo = "Block";
                botones[2][3].setIcon(block);
                botones[2][5].tipo = "Block";
                botones[2][5].setIcon(block);
                botones[3][0].tipo = "Block";
                botones[3][0].setIcon(block);
                botones[3][2].tipo = "Block";
                botones[3][2].setIcon(block);
                botones[3][3].tipo = "Block";
                botones[3][3].setIcon(block);
                botones[3][5].tipo = "Block";
                botones[3][5].setIcon(block);
                botones[5][0].tipo = "Block";
                botones[5][0].setIcon(block);
                botones[5][2].tipo = "Block";
                botones[5][2].setIcon(block);
                botones[5][3].tipo = "Block";
                botones[5][3].setIcon(block);
                botones[5][5].tipo = "Block";
                botones[5][5].setIcon(block);
                break;
            default:
                break;
        }
    }

    Runnable hilo = new Runnable() {
        public void run() {
            //Boolean bandera = false;

            int xAnterior = -1;
            int yAnterior = -1;

            for (int k = 0; k < solucionario.size(); k++) {
                if (xAnterior != -1 && yAnterior != -1) {
                    if (botones[xAnterior][yAnterior].tipo == null) {
                        botones[xAnterior][yAnterior].setIcon(path);
                    } else if ("Apple".equals(botones[xAnterior][yAnterior].tipo)) {
                        botones[xAnterior][yAnterior].setIcon(apple);
                    }
                }

                String[] parts = solucionario.get(k).split(",");
                String xtemp = parts[0];
                String ytemp = parts[1];

                int x = Integer.parseInt("" + xtemp.charAt(4));
                int y = Integer.parseInt("" + ytemp.charAt(1));

                System.out.println("x: " + x + " y: " + y);

                botones[x][y].setIcon(snake);
                cabezaSnake = botones[x][y].nombre;

                if (k + 1 == solucionario.size()) {
                    xAnterior = -1;
                    yAnterior = -1;
                    System.out.println("meta");
                    botones[x][y].tipo = null;
                    //botones[x][y].setIcon(path);

                    for (int i = 0; i < listaManzanas2.size(); i++) {
                        if (listaManzanas2.get(i).x == x && listaManzanas2.get(i).y == y) {
                            listaManzanas2.remove(i);
                        }
                    }
                    ruta();
                    hiloPrincipal = new Thread(hilo);
                    hiloPrincipal.start();
                }

                xAnterior = x;
                yAnterior = y;
//                if (bandera == false) {
//                    for (int fila = 0; fila < 10; fila++) {
//                        for (int columna = 0; columna < 10; columna++) {
//                            if (botones[fila][columna].getName().equals(solucionario.get(k))) {
//                                botones[fila][columna].setIcon(path);
//                                break;
//                            }
//                        }
//                    }
//                    for (int fila = 0; fila < 10; fila++) {
//                        for (int columna = 0; columna < 10; columna++) {
//                            if ((k + 1) != (solucionario.size() - 1)) {
//                                if (botones[fila][columna].getName().equals(solucionario.get(k + 1))) {
//                                    botones[fila][columna].setIcon(snake);
//                                }
//                            } else if ((k + 1) == (solucionario.size() - 1)) {
//                                if (botones[fila][columna].getName().equals(solucionario.get(k + 1))) {
//                                    botones[fila][columna].setIcon(snake);
//                                    bandera = true;
//                                }
//                            }
//                        }
//                    }
//                } else if (bandera == true) {
//                    JOptionPane.showMessageDialog(null, "El perro ha atrapado al gato");
//                    for (int fila = 0; fila < 10; fila++) {
//                        for (int columna = 0; columna < 10; columna++) {
//                            botones[fila][columna].setIcon(path);
//                        }
//                    }
//                    solucionario.clear();
////                    listaConexiones.clear();
////                    contador = 0;
////                    jButton4.setEnabled(false);
////                    jButton5.setEnabled(false);
//                    jButton1.setEnabled(true);
//                }
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
//                refresh();

            }
        }
    };

//    public void refresh() {
//        this.invalidate();
//        this.validate();
//        this.repaint();
//    }
    public void ruta() {
        solucionario.clear();
        int random = randomNumber(0, listaManzanas2.size() - 1);
        String manzana = listaManzanas2.get(random).nombre;
        System.out.println("cabezaSnake: " + cabezaSnake);
        System.out.println("manzana: " + manzana);
        String t1 = "consult('Snake.pl')";
        Query q1 = new Query(t1);
        System.out.println("" + (q1.hasSolution() ? "Conectado" : "No conectado"));
        String t2 = "respuesta(" + cabezaSnake + "," + manzana + ",X)";
        Query q2 = new Query(t2);
        Map<String, Term>[] solutions = q2.allSolutions();

        for (int i = 0; i < solutions.length; i++) {
            Term term = solutions[i].get("X");
            for (Term oneTerm : term.toTermArray()) {
                System.out.println("en Ruta: " + oneTerm.toString());
                solucionario.add(oneTerm.toString());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (snakeVivo == true) {
            ruta();
            hiloPrincipal = new Thread(hilo);
            hiloPrincipal.start();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione donde pone la culebra.");
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
