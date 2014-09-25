
  package wbx.quanyidong;
import java.awt.Component;
import java.awt.Container;
 
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
  
public class Boxaa extends JFrame{
     
    private JButton btn1 = new JButton("Button1");
    private JButton btn2 = new JButton("Button2");
    private JButton btn3 = new JButton("Button3 what a fine day");
    private JButton btn4 = new JButton("Button4 what a fine da");
    private JButton btn5 = new JButton("Button5 what a fine d");
    private JButton btn6 = new JButton("Button6 what a fines");
     
    Boxaa()
    {
        super();
        initComponent();
    }
    private void initComponent()
    {
        Container container = this.getContentPane();
        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
        JPanel a = new JPanel();
         a.setLayout(new BoxLayout(a,BoxLayout.X_AXIS));
        
        a.add(btn1);
        a.add(btn2);

        container.add(a);
        container.add(btn3);
        container.add(btn4);
        container.add(btn5);
        container.add(btn6);
    }
     
    public static void main(String[] args)
    {
        Boxaa frame = new Boxaa();
        frame.pack();
        frame.setVisible(true);
    }
     
}
