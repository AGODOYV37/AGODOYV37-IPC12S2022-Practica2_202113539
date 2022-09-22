import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazPrincipal extends JFrame {
    private JPanel panelP;
    private JComboBox dificultadComboBox;
    private JButton nuevoJuegoBtn;
    private JLabel tamSerpiente;
    private JLabel intervalo;
    private JButton arribaBtn;
    private JButton abajoBtn;
    private JButton derBtn;
    private JButton izquierdaBtn;
    private JPanel pantallaPanel;

    JuegoPanel panel = new JuegoPanel();

public InterfazPrincipal(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(panelP);
    this.pack();
    this.setLocationRelativeTo(null);
    this.add(new JuegoPanel());
    nuevoJuegoBtn.setFocusable(false);
    nuevoJuegoBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
    arribaBtn.setFocusable(false);
    arribaBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
    abajoBtn.setFocusable(false);
    abajoBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
    derBtn.setFocusable(false);
    derBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
    izquierdaBtn.setFocusable(false);
    izquierdaBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
    pantallaPanel.add(panel);



}
}
