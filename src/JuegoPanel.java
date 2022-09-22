import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class JuegoPanel extends JPanel implements ActionListener {

    static final int largoPantalla=600;
    static final int alturaPantalla=600;
    static final int tUnidad = 60;
    static final int unidadJuego = (largoPantalla*alturaPantalla)/tUnidad;
    public static int intervaloDelay = 1000;
    final int x[]=new int [unidadJuego];
    final int y[]=new int [unidadJuego];
    public static int partesSerpiente=1;
    int comidaIngerida;
    int comidaX;
    int comidaY;
    public static char direccion = 'R';

    public static char dificultad;
    public static boolean corriendo = false;
    public static Timer temporizador;
    public MyThread thread1 = new MyThread();

    public static StringBuilder historial = new StringBuilder();





    public String DificultadHT;
    Random random;


    JuegoPanel(){
        random = new Random();
        this.setBounds(50,80,600,600);
        //this.setPreferredSize(new Dimension(largoPantalla,alturaPantalla));
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
        iniciarJuego();


    }

    public void iniciarJuego(){
        nuevaComida();
        temporizador = new Timer(intervaloDelay,this);
        temporizador.start();
        thread1.start();

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        dibujar(g);

    }
    public void  dibujar(Graphics g) {
        if (corriendo){
            for (int i = 0; i < alturaPantalla / tUnidad; i++) {
                g.drawLine(i * tUnidad, 0, i * tUnidad, alturaPantalla);
                g.drawLine(0, i * tUnidad, largoPantalla, i * tUnidad);
            }
        g.setColor(Color.CYAN);
        g.fillRect(comidaX, comidaY, tUnidad, tUnidad);

        for (int i = 0; i < partesSerpiente; i++) {
            if (i == 0) {
                g.setColor(new Color(24, 99, 52));
                g.fillRect(x[i], y[i], tUnidad, tUnidad);
            } else {
                g.setColor(new Color(60, 199, 42));
                g.fillRect(x[i], y[i], tUnidad, tUnidad);
            }
        }


    }else{
            gameOver(g);
        }

    }
    public void nuevaComida(){
        comidaX=random.nextInt((int)(largoPantalla/tUnidad))*tUnidad;
        comidaY=random.nextInt((int)(alturaPantalla/tUnidad))*tUnidad;

    }
    public void movimiento(){
        for(int i=partesSerpiente;i>0;i--){
            x[i]=x[i-1];
            y[i]=y[i-1];
        }


        switch (direccion){
            case 'U':
                y[0]=y[0] - tUnidad;
                break;
            case 'D':
                y[0]=y[0] + tUnidad;
                break;
            case 'L':
                x[0]=x[0] - tUnidad;
                break;
            case 'R':
                x[0]=x[0] + tUnidad;
                break;

        }

    }
    public void revComida(){
        if((x[0] == comidaX)&&(y[0] == comidaY)){
            partesSerpiente++;
            comidaIngerida++;
            nuevaComida();
            switch (dificultad){
                case('F'):
                    intervaloDelay=(int)(intervaloDelay-(intervaloDelay*0.03));
                    DificultadHT="Fácil";
                    break;
                case('M'):
                    intervaloDelay=(int)(intervaloDelay-(intervaloDelay*0.06));
                    DificultadHT="Medio";
                    break;
                case('D'):
                    intervaloDelay=(int)(intervaloDelay-(intervaloDelay*0.09));
                    DificultadHT="Difícil";
                    break;

            }



            FrameJuego.nTSerpiente.setText(String.valueOf(partesSerpiente));
            FrameJuego.nTIntervalo.setText(String.valueOf(intervaloDelay));
            temporizador.setDelay(intervaloDelay);
            crearHtml();

            if (comidaIngerida==25){
                temporizador.stop();
                thread1.interrupt();
                JOptionPane.showMessageDialog(null, "La serpiente ha alcanzado su tamaño máximo", "Información", JOptionPane.INFORMATION_MESSAGE);
                abrirHtml();
                System.exit(0);
            }

        }




    }
    public void revColision(){

         /* for(int i=partesSerpiente;i>0;i--){
            if((x[0]==x[i])&&(y[0]==y[i])){
                corriendo=false;

        }

    } si la cabeza choca con el cuerpo*/


            //cabeza toca el borde izquierdo
            if(x[0]<0){
                corriendo=false;
            }
            //cabeza toca el borde derecho
            if(x[0]>largoPantalla){
                corriendo=false;
            }

            //cabeza toca el borde superior
            if(y[0]<0){
                corriendo=false;
            }
            //cabeza toca el borde inferior
            if(y[0]>alturaPantalla){
                corriendo=false;
            }
            if (!corriendo){
                temporizador.stop();
                thread1.interrupt();
                JOptionPane.showMessageDialog(null, "La serpiente ha chocado con un muro", "Advertencia", JOptionPane.WARNING_MESSAGE);
                abrirHtml();
                System.exit(0);
            }
        }


    public void gameOver(Graphics g){
       /* g.setColor(Color.BLACK);
        g.setFont(new Font("Impact",Font.BOLD,75));
        FontMetrics metrica = getFontMetrics(g.getFont());
        g.drawString("Game Over",(largoPantalla- metrica.stringWidth("Game Over"))/2,alturaPantalla/2);*/
       /* g.setColor(Color.BLACK);
        g.setFont(new Font("JetBrains Mono Medium",Font.BOLD,50));
        FontMetrics metrica = getFontMetrics(g.getFont());
        g.drawString("Puntaje:"+comidaIngerida,(largoPantalla- metrica.stringWidth("Puntaje:"+comidaIngerida))/2,alturaPantalla/2);*/




    }

    public void crearHtml(){
        String html = "<div><h1> Ángel Andrés Godoy Valdéz 202113539 </h1><p>Dificultad:"+DificultadHT+"</p><p>Tiempo transcurrido:"+"Minutos:"+MyThread.minuto+" Segundos:"+MyThread.segundos+"</p>" +
                "<p>Intervalo:"+intervaloDelay+"</p>"+
                "<p>Tamaño serpiente:"+partesSerpiente+"</p>"+
                "<p>Historial de movimiento:"+historial+"</p>"+
                "</div>";
        File f = new File("C:\\Users\\agodo\\Documents\\Cursos\\Java\\Proyectos\\Practica2\\src\\202113539.html");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(html);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void abrirHtml()  {

        File file = new File("C:\\Users\\agodo\\Documents\\Cursos\\Java\\Proyectos\\Practica2\\src\\202113539.html");
        try {
            Desktop.getDesktop().browse(file.toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(corriendo){
            movimiento();
            revComida();
           revColision();
        }
        repaint();


    }





}
