
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HP
 */
public class zadaca1 extends JApplet implements ActionListener {
  

    private JPanel pnlglavna, pnl1, pnl11, pnl12, pnl12g, pnl12d, pnl2, pnl21, pnl3, pnl31;
    private JLabel lbld, lblg, lbladd, lbltip, lblpreg, lbluplata;
    private JComboBox cb1, cb2;
    private JTextField txt1, txt2;
    private JRadioButton r1, r2, r3, r4, r5;
    private JButton btn1, btn2, btn3, btn4;
    private JTextArea ta;
    private JSlider sl;
    private String text;
    
    @Override
    public void init() {
        pnlglavna= new JPanel(new GridLayout(1,3));
        
        pnl1=new JPanel(new BorderLayout());
        pnl1.setBorder(new TitledBorder("Dodavanje na tim"));
        pnl11= new JPanel(new GridLayout(6,1));
        lbld= new JLabel("Domakini: ");
        cb1 = new JComboBox();
        lblg= new JLabel("Gosti: ");
        cb2 = new JComboBox();
        lbladd= new JLabel("Dodadi tim: ");
        txt1 = new JTextField();
        pnl11.add(lbld);
        pnl11.add(cb1);
        pnl11.add(lblg);
        pnl11.add(cb2);
        pnl11.add(lbladd);
        pnl11.add(txt1);
        pnl1.add(pnl11, BorderLayout.CENTER);
        pnl12= new JPanel(new GridLayout(2,1));
        pnl12g = new JPanel(new GridLayout(1,2));
        r1= new JRadioButton("Doma");
        r2 = new JRadioButton("Gosti");
       
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        pnl12g.add(r1);
        pnl12g.add(r2);
        pnl12.add(pnl12g);
        btn1 = new JButton("Dodadi Tim");
        pnl12.add(btn1);
        pnl1.add(pnl12, BorderLayout.SOUTH);
        
        btn1.addActionListener(this);
        btn1.setActionCommand("btn1");
        
        pnl2= new JPanel(new GridLayout(7,1));
        pnl2.setBorder(new TitledBorder("Kreiranje na tiket"));
        ta= new JTextArea(10, 120);
        ta.setBorder(new TitledBorder("Tiket"));
        pnl2.add(ta);
        lbltip = new JLabel("izberi Tip!");
        pnl2.add(lbltip);
        pnl21= new JPanel(new GridLayout(1,3));
        r3 = new JRadioButton("1");
        r4 = new JRadioButton("X");
        r5 = new JRadioButton("2");
        
        ButtonGroup bg1= new ButtonGroup();
        bg1.add(r3);
        bg1.add(r4);
        bg1.add(r5);
        pnl21.add(r3);
        pnl21.add(r4);
        pnl21.add(r5);
        pnl2.add(pnl21);
        
        lblpreg= new JLabel("Pregled:");
        pnl2.add(lblpreg);
        txt2 = new JTextField();
        txt2.setEditable(false);
        pnl2.add(txt2);
        
        btn2 = new JButton("Dodadi!");
        btn2.addActionListener(this);
        btn2.setActionCommand("btn2");
        
        
        btn3 = new JButton("Izbrisi tiket!");
        btn3.addActionListener(this);
        btn3.setActionCommand("btn3");
        
        pnl2.add(btn2);
        pnl2.add(btn3);
        
        pnl3 = new JPanel( new BorderLayout());
        pnl3.setBorder(new TitledBorder("Uplata na tiket:"));
        sl = new JSlider();
        sl.setMajorTickSpacing(50); 
        sl.setMinorTickSpacing(16); 
        sl.setPaintTicks(true); 
        sl.setPaintLabels(true);

        
        
        lbluplata = new JLabel("Vnesi uplata!!");
        pnl31 = new JPanel(new GridLayout(2,1));
        pnl31.add(lbluplata);
        pnl31.add(sl);
        
  
        pnl3.add(pnl31, BorderLayout.NORTH);
        btn4 = new JButton("Uplati tiket");
        btn4.addActionListener(this);
        btn4.setActionCommand("btn4");
        pnl3.add(btn4, BorderLayout.SOUTH);
        
        
        
        
        pnlglavna.add(pnl1);
        pnlglavna.add(pnl2);
        pnlglavna.add(pnl3);
        this.getContentPane().add(pnlglavna);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "btn1":
                String tim="";
                if(r1.isSelected()){
                    tim=txt1.getText();
                    cb1.addItem(tim);
                }else if(r2.isSelected()){
                    tim=txt1.getText();
                    cb2.addItem(tim);
                }
                break;
            case "btn2":
                String par="";
                par+=cb1.getItemAt(cb1.getSelectedIndex());
                if(r3.isSelected()){
                    par+="1";
                }else if(r4.isSelected()){
                    par+="X";
                }else if(r5.isSelected()){
                    par+="2";
                }
                par+=cb2.getItemAt(cb2.getSelectedIndex());
                ta.append(par);
                ta.append("\n");
                break;
            case "btn3":
                ta.removeAll();
                break;
        }
    }

    
}
    

