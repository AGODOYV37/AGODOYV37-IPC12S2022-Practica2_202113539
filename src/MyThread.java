import javax.swing.*;

public class MyThread extends Thread {
    public static int minuto=0;
   public static int segundos=0;
    @Override
    public void run(){
        try {

            while(Thread.currentThread().isAlive()) {
                Thread.sleep(1000);
               if (segundos==60){
                   segundos=0;
                   minuto++;
               }else {
                   segundos++;
               }

            }


        }catch (Exception e){

        }



    }

}
