package chatting.application;
        
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import javax.swing.*;
import java.net.*;
public class Client extends JFrame implements ActionListener{
    JPanel p1;// create division in the frame
    JTextField t1;
   // static JFrame f1 = new JFrame();
    JButton b1;
   static JTextArea a1;
    
    static Socket s;
    static DataInputStream dis;//tracking the transferred data
    static DataOutputStream dos;
    Boolean typing;
    

    Client()
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
        
        ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/bunty.jpeg"));//for image
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
       /*  Timer t;
        t = new Timer(1,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(!typing)
                {
                    l4.setText("Active Now");   
                }
            }
         });*/
        
       t1 = new JTextField();
       t1.setBounds(5, 670, 310, 27);
       t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
       add(t1);
       /* t1.addKeyListener(new KeyAdapter(){
           public void keyPressed(KeyEvent ke){
               l4.setText("typing...");
               
               t.stop();
               
               typing = true;
           }
           
           public void keyReleased(KeyEvent ke){
               typing = false;
               
               if(!t.isRunning()){
                   t.start();
               }
           }
       });*/
       b1 =new JButton("Send");
       b1.setBounds(315,670,115,27);
       b1.setBackground(new Color(7,94,84));
       b1.setForeground(Color.WHITE);
       b1.setFont(new Font("SAN_SERIF",Font.BOLD,16));
       b1.addActionListener(this);
       add(b1);
       
       a1=new JTextArea();
       a1.setBounds(5, 75,440,540);
       a1.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
   //  a1.setBackground(Color.WHITE);
       a1.setEditable(false);
       a1.setLineWrap(true);
       a1.setWrapStyleWord(true);
       add(a1);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(450,700);
        setLocation(600,20);
        setUndecorated(true);//hide the action bar
        setVisible(true);

        setResizable(false);
    }
        
        public void actionPerformed(ActionEvent ae)
        {
            try{
                
                String out=t1.getText();
                a1.setText(a1.getText()+"\n\t\t\t"+out);
                dos.writeUTF(out);
                t1.setText(" ");
            }catch(Exception e){
            }
        }
    public static void main(String arg[])
    {
        new Client().setVisible(true);
        
        try{
            
            s=new Socket("127.0.0.1",6001);
            String msgin="";

            dis=new DataInputStream(s.getInputStream());
            dos=new DataOutputStream(s.getOutputStream());
            while(true){
            msgin=dis.readUTF();
            a1.setText(a1.getText()+"\n"+msgin);
            }
             
        }catch(Exception e){
            
        }
    }
}
 
