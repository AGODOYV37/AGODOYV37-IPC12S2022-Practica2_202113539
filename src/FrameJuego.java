import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class FrameJuego extends JFrame implements KeyListener {
    JuegoPanel j = new JuegoPanel();
    public static JLabel nTSerpiente;
    public static  JLabel nTIntervalo;

    public static boolean ocultar = false;
    FrameJuego(){
        JuegoPanel PJuego = new JuegoPanel();


        JComboBox difCBox = new JComboBox();
        difCBox.setBounds(800,100,150,20);
        difCBox.setBackground(Color.WHITE);
        String[] arrayAux = {"Fácil","Medio","Difícil"};
        JComboBox comboBoxAux = new JComboBox(arrayAux);
        difCBox.setModel(comboBoxAux.getModel());

        JButton nuevoJuegoBtn = new JButton();
        nuevoJuegoBtn.setFocusable(false);
        nuevoJuegoBtn.setBackground(Color.WHITE);
        nuevoJuegoBtn.setText("Nuevo Juego");
        nuevoJuegoBtn.setBounds(1000,90,150,50);
        nuevoJuegoBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));

        nuevoJuegoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                switch (difCBox.getSelectedIndex()){
                    case (0):
                        JuegoPanel.dificultad='F';
                        JuegoPanel.corriendo=true;
                        break;
                    case (1):
                        JuegoPanel.dificultad='M';
                        JuegoPanel.corriendo=true;
                        break;
                    case (2):
                        JuegoPanel.dificultad='D';
                        JuegoPanel.corriendo=true;
                        break;



                }

            }
        });

        nTSerpiente = new JLabel();
        nTSerpiente.setBounds(970,200,100,20);
        nTSerpiente.setText("0");

        JLabel TSerpiente = new JLabel();
        TSerpiente.setBounds(925,230,120,20);
        TSerpiente.setText("Tamaño serpiente");

        nTIntervalo = new JLabel();
        nTIntervalo.setBounds(960,300,100,20);
        nTIntervalo.setText("1000");

        JLabel TIntervalo = new JLabel();
        TIntervalo.setBounds(949,330,100,20);
        TIntervalo.setText("Intervalo");

        JButton arribaBtn = new JButton();
        arribaBtn.setFocusable(false);
        arribaBtn.setBackground(Color.WHITE);
        arribaBtn.setText("Arriba");
        arribaBtn.setBounds(930,500,80,65);
        arribaBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));

        arribaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    JuegoPanel.direccion = 'U';
                    JuegoPanel.historial.append(" Arriba,");

            }
        });

        JButton abajoBtn = new JButton();
        abajoBtn.setFocusable(false);
        abajoBtn.setBackground(Color.WHITE);
        abajoBtn.setText("Abajo");
        abajoBtn.setBounds(930,580,80,65);
        abajoBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));

        abajoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    JuegoPanel.direccion = 'D';
                    JuegoPanel.historial.append(" Abajo,");

            }
        });

        JButton izqBtn = new JButton();
        izqBtn.setFocusable(false);
        izqBtn.setBackground(Color.WHITE);
        izqBtn.setText("Izq");
        izqBtn.setBounds(840,580,80,65);
        izqBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));

        izqBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    JuegoPanel.direccion = 'L';
                    JuegoPanel.historial.append(" Izquierda,");

            }
        });

        JButton derBtn = new JButton();
        derBtn.setFocusable(false);
        derBtn.setBackground(Color.WHITE);
        derBtn.setText("Der");
        derBtn.setBounds(1020,580,80,65);
        derBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));

        derBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    JuegoPanel.direccion = 'R';
                    JuegoPanel.historial.append(" Derecha,");

            }
        });



        this.setTitle("Serpiente");
        this.setLayout(null);
        this.setSize(1200,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.add(PJuego);
        this.add(difCBox);
        this.add(nuevoJuegoBtn);
        this.add(nTSerpiente);
        this.add(TSerpiente);
        this.add(nTIntervalo);
        this.add(TIntervalo);
        this.add(arribaBtn);
        this.add(abajoBtn);
        this.add(izqBtn);
        this.add(derBtn);
        this.addKeyListener(this);



    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()){
            case 'a':

                JuegoPanel.direccion = 'L';

                break;

            case 'd':

                JuegoPanel.direccion = 'R';

                break;

            case'w':

                JuegoPanel.direccion = 'U';

                break;

            case 's':

                JuegoPanel.direccion = 'D';

                break;




        }

    }

    @Override
    public void keyPressed(KeyEvent e) {


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
