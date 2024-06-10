import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons extends JFrame implements ActionListener {

    JButton jButton1;
    JButton jButton2;

    JButton jButton3;
    JButton jButton4;


    public Buttons(){

        setTitle("ONE");
        setSize(500,500);
        setLayout(new GridLayout(4,1));

        jButton1=new JButton("eoq");
        jButton2=new JButton("epq");

        jButton3=new JButton("eoq با کمبود");
        jButton4=new JButton("epq با کمبود");


        add(jButton1,0,0,1,1);
        add(jButton2,0,1,1,1);
        add(jButton3,0,2,1,1);
        add(jButton4,0,3,1,1);


        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);

    }

    private void add(JComponent component,int x,int y,int w,int h){
        GridBagConstraints constraints=new GridBagConstraints();
        constraints.gridx=x;
        constraints.gridy=y;
        constraints.gridwidth=w;
        constraints.gridheight=h;
        getContentPane().add(component,constraints);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jButton1){
            dispose();//close this window
            new Eoq().setVisible(true);
        }
        else if (e.getSource()==jButton2){
            dispose();//close this window
            new Epq().setVisible(true);
        }
        else if (e.getSource()==jButton3){
            dispose();
            new EoqWithShortage().setVisible(true);
        }
        else if (e.getSource()==jButton4){
            dispose();
            new EpqWithShortage().setVisible(true);
        }


    }
}
