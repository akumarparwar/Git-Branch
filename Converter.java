package account;
//class-38
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Converter extends JFrame implements ActionListener,Runnable {
	
  JLabel L1;
  JTextField t1;
  JButton b1,b[];
  JTextArea ta1;
  JPanel p1,keyPad,inputPanel,controlPanel;//JPanel ka Layout Flow layout hota hai .Flow layout means Arrange components from left to right and top to bottom 
  
  Thread myThread;
  
  public void run()
  {   
	  for(;;)
	  {
          try
          {
		     this.setTitle(new java.util.Date().toString());
		     myThread.sleep(1000);
          }
          catch(Exception ex)
          {
        	  
          }
      }
  
          
   }          
  
  public Converter()
  {
	  myThread = new Thread(this);
	  myThread.start();
	  
	  this.setVisible(true);
	  this.setSize(400, 600);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	  L1 = new JLabel("Distance in miles:"); 
	  t1 = new JTextField(20); 
	  b1 = new JButton("Convert"); 
	  p1 = new JPanel();
	  keyPad = new JPanel();
	  inputPanel = new JPanel();
	  controlPanel = new JPanel();
	  ta1 = new JTextArea(5,20);//(row,coloum)//Constructs a new empty TextArea with the specified number ofrows and columns
	  
	  JScrollPane js = new JScrollPane(ta1);
	  p1.setLayout(new BorderLayout());
	  
	  b= new JButton[12];
	  
	  String label[] = {"1","2","3","4","5","6","7","8","9","C","0","."};
	  
	  for(int i =0;i<b.length;i++)
	  {
		  b[i] = new JButton(label[i]);
		  keyPad.add(b[i]);
		  b[i].addActionListener(this);
	  }
	  
	  inputPanel.add(L1);
	  inputPanel.add(t1);
	  p1.add(inputPanel,"North");
	  
	  p1.add(js,"Center");
	  
	  
	  
	  p1.add(controlPanel,"East");
	  
	  keyPad.setLayout(new GridLayout(4,3,5,10));//(row,col,hgap,vgap)
	  
	  controlPanel.setLayout(new  BorderLayout());
	  controlPanel.add(keyPad,"North");
	  controlPanel.add(b1,"South");
	  
	  this.add(p1);
	
	  
	  b1.addActionListener(this);
	  
	  ta1.setEditable(false);
	  p1.setBorder(BorderFactory.createTitledBorder("Converter"));

  }
  boolean val =true;
  public void actionPerformed(ActionEvent e)
  {    
	  JButton x = (JButton)e.getSource();
	  
	  if(x.getText().equals("Convert"))
	  {
		  double km = Double.parseDouble(t1.getText())*1.67;//Java parseDouble() method is the part of the Double class of the java.lang package. This method is used to parse the string value to its equivalent Double value
		  ta1.append(t1.getText()+" is equals to :"+km+"km \n");//append method Appends the given text to the end of the document 
	  }
	  else if(x.getText().equals("C"))
	  {
		  t1.setText("");
	  }
	  else 
	  {
		  
		  if(x.getText().equals(".") && val == true)
		  {
			  t1.setText(t1.getText()+x.getText()); 
			  val= false;
		  }
		  else if(!x.getText().equals("."))
		  {
			  t1.setText(t1.getText()+x.getText());
		  }
	  }
	  
	 
  }
  public static void main(String args[])
  {
	  new Converter();
  }
}
