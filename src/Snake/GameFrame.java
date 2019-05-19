package Snake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public static String colaSnake;

    int cantidadManzanasComidas = 0;

    public static Cuadro[][] botones = new Cuadro[6][6];

    ArrayList<Cuadro> listaManzanas = new ArrayList();
    ArrayList<Cuadro> listaManzanas2 = new ArrayList(); //lista de los botones donde hay manzanas
    public static ArrayList<Cuadro> listaPocisionesCulebra = new ArrayList();

    List<String> soluciones = new ArrayList<>();

    int cantManzanas; //cantidad de manzanas solicitadas por el usuario

    public GameFrame(int cantManzanas2, int mapa) {
        initComponents();
        cuadros();
        System.out.println(mapa);
        generarMapa(mapa);
        conexiones();
        cantManzanas = cantManzanas2;
        colocarManzanas();
        //verBlocks();
        manzanasComidasLabel.setText("" + cantidadManzanasComidas);
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
    public void colocarManzanas() {
        System.out.println("Manzs: " + cantManzanas);
        manzanasFaltantesLabel.setText("" + cantManzanas);
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                if (botones[fila][columna].tipo == null) {
                    listaManzanas.add(botones[fila][columna]);
                }
            }
        }
//        while (cantidadManzanas != 0) {
        if (cantManzanas > 0) {
            int mapa = randomNumber(0, listaManzanas.size() - 1);
            int x = listaManzanas.get(mapa).x;
            int y = listaManzanas.get(mapa).y;
            listaManzanas2.add(botones[x][y]);
            botones[x][y].setIcon(apple);
            botones[x][y].tipo = "Apple";
            listaManzanas.remove(mapa);
            cantManzanas--;
        }
        listaManzanas.clear();
//        }
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
        @Override
        public void run() {
            //Boolean bandera = false;
            while (listaManzanas2.size() > 0) {
                ruta();
                int xAnterior = -1;
                int yAnterior = -1;

                for (int k = 0; k < soluciones.size(); k++) {
                    String[] parts = soluciones.get(k).split(",");
                    int x = Integer.parseInt("" + parts[0].charAt(4));
                    int y = Integer.parseInt("" + parts[1].charAt(1));

                    System.out.println("x: " + x + " y: " + y);

                    listaPocisionesCulebra.add(botones[x][y]);
                    pintarCuerpoCulebra();

                    cabezaSnake = botones[x][y].nombre;

                    if (k + 1 == soluciones.size()) {
                        xAnterior = -1;
                        yAnterior = -1;
                        System.out.println("meta");
                        botones[x][y].tipo = null; //deja de ser manzana

                        for (int i = 0; i < listaManzanas2.size(); i++) {
                            if (listaManzanas2.get(i).x == x && listaManzanas2.get(i).y == y) {
                                listaManzanas2.remove(i);
                                cantidadManzanasComidas++;
                                manzanasComidasLabel.setText("" + cantidadManzanasComidas);

                                //hiloPrincipal.stop();
                            }
                        }
                        colocarManzanas();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                        soluciones.clear();
                    }
                    xAnterior = x;
                    yAnterior = y;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                }
            }
            JOptionPane.showMessageDialog(rootPane, "Juego terminado");
            hiloPrincipal.stop();

        }
    };

    public void pintarCuerpoCulebra() {

        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                if (!"Block".equals(botones[fila][columna].tipo) && !"Apple".equals(botones[fila][columna].tipo)) {
                    botones[fila][columna].setIcon(path);
                }
            }
        }
        Collections.reverse(listaPocisionesCulebra);
        for (int i = 0; i <= cantidadManzanasComidas; i++) {
            botones[listaPocisionesCulebra.get(i).x][listaPocisionesCulebra.get(i).y].setIcon(snake);
        }
        Collections.reverse(listaPocisionesCulebra);
    }

    public void ruta() {
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
                soluciones.add(oneTerm.toString());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        manzanasFaltantesLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        manzanasComidasLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

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

        startButton.setBackground(new java.awt.Color(51, 204, 0));
        startButton.setText("Iniciar");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        salirButton.setBackground(new java.awt.Color(204, 0, 0));
        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Manzanas Faltantes:");

        manzanasFaltantesLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Manzanas Comidas:");

        manzanasComidasLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(manzanasFaltantesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(manzanasComidasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28))))
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(startButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salirButton)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(manzanasFaltantesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(manzanasComidasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(salirButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        if (snakeVivo == true) {
            hiloPrincipal = new Thread(hilo);
            startButton.setEnabled(false);
            hiloPrincipal.start();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione donde pone la culebra.");
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel manzanasComidasLabel;
    private javax.swing.JLabel manzanasFaltantesLabel;
    private javax.swing.JButton salirButton;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
    }
}
