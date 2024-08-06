import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GradeTracker implements ActionListener {
    JButton b1,b2,b3;
    TextField textfields[];

    public void creatingGui(){
        JFrame myframe=new JFrame();
       
        Container c=myframe.getContentPane();
        c.setLayout(new BorderLayout());

        JPanel mypanel=new JPanel();
        mypanel.setLayout(new GridLayout(9,2));
        b1=new JButton();
        b1.setText("Calculate");
        b1.setFont(new Font("arial",Font.BOLD,25));
        b1.setForeground(new Color(0, 85, 255));
        b1.addActionListener(this);

       
        JPanel mypanel2=new JPanel();
        mypanel2.setLayout(new GridLayout(1,3));
        mypanel2.add(b1);
        b2=new JButton();
        b3=new JButton();
        b2.setText("");
        b3.setText("");
        b2.setFont(new Font("arial",Font.BOLD,15));
        b3.setFont(new Font("arial",Font.BOLD,15));
        b2.setForeground(new Color(0, 85, 255));
        b3.setForeground(new Color(0, 85, 255));
        mypanel2.add(b2);
        mypanel2.add(b3);
        
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        JLabel l5=new JLabel();
        JLabel l6=new JLabel();
        l5.setText("Student Name");
        l6.setText("Marks");
        l5.setFont(new Font("arial",Font.BOLD,25));
        l6.setFont(new Font("arial",Font.BOLD,25));
        l5.setForeground(new Color(0, 85, 255));
        l6.setForeground(new Color(0, 85, 255));
        mypanel.add(l5); mypanel.add(l6);

        textfields=new TextField[16];
        for(int i=0;i<16;i++){
            textfields[i]=new TextField();
            textfields[i].setFont(font1);
            if(i%2!=0){
            textfields[i].setBackground(Color.CYAN);}
            if(i%2==0){
                textfields[i].setBackground(new Color(0, 255, 170));}
            mypanel.add(textfields[i]);
            }
        
      
            
        c.add(mypanel2,BorderLayout.SOUTH);
        c.add(mypanel,BorderLayout.CENTER);
        myframe.setVisible(true);
        myframe.setSize(800,800);
        myframe.setLocationRelativeTo(null);
        myframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
      GradeTracker obj1=new GradeTracker();
      obj1.creatingGui();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            int high=1,low=1;
            int highest=Integer.valueOf(textfields[1].getText());
            int lowest=Integer.valueOf(textfields[1].getText());
            for(int i=1; i<16;i+=2){
                if(Integer.valueOf(textfields[i].getText())>highest){
                    highest=Integer.valueOf(textfields[i].getText());
                    high=i;
                }
                if(Integer.valueOf(textfields[i].getText())<lowest){
                    lowest=Integer.valueOf(textfields[i].getText());
                    low=i;
                }
            }
            String highest1=textfields[high-1].getText();
            String lowest1=textfields[low-1].getText();

            b2.setText(highest1+" has got "+String.valueOf(highest)+" \"highest marks\"");
            b3.setText(lowest1+" has got "+String.valueOf(lowest)+" \"the lowest marks\"");
        }
        
    }
}
