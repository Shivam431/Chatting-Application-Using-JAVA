package chatting.application;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
public class Server extends JFrame{
    JPanel p1;// create division in the frame
    JTextField t1;
    static JFrame f1 = new JFrame();

    Server()
    {
        
        p1=new JPanel();
        p1.setLayout(null);
        
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0,0,450,70);
        add(p1);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3.png"));//for image
        Image i2=i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);  //scalling of image
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);// we cannot directly add image onto the frame so we use Jlabel
        l1.setBounds(5,17,30,30);
        p1.add(l1);
        setLayout(null);
         l1.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent ae){
               System.exit(0);
           }
       });// click arrow to close the window
        
        ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/1.png"));//for image
        Image i5=i4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);  //scalling of image
        ImageIcon i6=new ImageIcon(i5);
        JLabel l2=new JLabel(i6);// we cannot directly add image onto the frame so we use Jlabel
        l2.setBounds(40,5,60,60);
        p1.add(l2);
        setLayout(null);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/video.png"));
       Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
       ImageIcon i9 = new ImageIcon(i8);
       JLabel l5 = new JLabel(i9);
       l5.setBounds(290, 20, 30, 30);
       p1.add(l5);
       
       ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/phone.png"));
       Image i12 = i11.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
       ImageIcon i13 = new ImageIcon(i12);
       JLabel l6 = new JLabel(i13);
       l6.setBounds(350, 20, 35, 30);
       p1.add(l6);
       
       ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3icon.png"));
       Image i15 = i14.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
       ImageIcon i16 = new ImageIcon(i15);
       JLabel l7 = new JLabel(i16);
       l7.setBounds(410, 20, 13, 25);
       p1.add(l7);
       setLayout(null);
        
        
        JLabel l3=new JLabel("Gaitonde");
        l3.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        // setLayout(null);
        l3.setForeground(Color.WHITE);
        l3. setBounds(110,10,100,20);
        p1.add(l3);
        
        JLabel l4=new JLabel("Active Now");
        l4.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        // setLayout(null);
        l4.setForeground(Color.WHITE);
        l4. setBounds(110,35,100,20);
        p1.add(l4);
        
       t1 = new JTextField();
       t1.setBounds(5, 620, 310, 30);
       t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
       add(t1);
        
        
        
        
        //getContentPane().setBackground(Color.YELLOW);
        setSize(450,700);
        setLocation(400,200);
       // setUndecorated(true);//hide the action bar
        setVisible(true);

        setResizable(false);
    }
    public static void main(String arg[])
    {
        new Server().setVisible(true);
    }
}
 
