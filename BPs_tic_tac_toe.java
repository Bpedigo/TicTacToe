

//package bps_tic_tac_toe;

/**
 *
 * Brian Pedigo July 2014
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class BPs_tic_tac_toe implements ActionListener {
    
    static JLabel jlab, wins, losses;
    static JButton[] sqrs = new JButton[9];
    static int moves = 0;
    static int NumWins = 0;
    static int Numlosses = 0;
    
    BPs_tic_tac_toe()
    {        
    
     JFrame jfrm = new JFrame("BP's Tic Tac Toe Game!");
    
    jfrm.setLayout(new GridLayout(4,3));
    
    jfrm.setSize(800,600);
    
    jfrm.setLocation(250,100);
    
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    for(int i = 0; i<9; i++)
    {
    sqrs[i] = new JButton("");
    sqrs[i].addActionListener(this);
    jfrm.add(sqrs[i]);
    }
    
    
    jlab = new JLabel("Programed By Brian Pedigo July 2014");
    wins = new JLabel("Number of wins");
    losses = new JLabel("Number of losses");
    
    
    jfrm.add(jlab);
    jfrm.add(wins);
    jfrm.add(losses);
   
    jfrm.setVisible(true);
  
    }
    
    
    boolean ChkForWin(String XorO)
    {
        int[] a = {0,3,6,0,1,2,0,6,2};
        int[] b = {1,4,7,3,4,5,4,4,4};
        int[] c = {2,5,8,6,7,8,8,2,6};
        
        for(int i = 0; i<a.length; i ++)
        {
            if(sqrs[a[i]].getText().equals(XorO))
                    
            {
                if(sqrs[b[i]].getText().equals(XorO))
                {
                    if(sqrs[c[i]].getText().equals(XorO))
                    {
                        return true;
                    }
                }
            }   
        }
        
    return false;
           
    }
    
    void AImove()
    {
        //do somthing
        int[] a = {0,3,6,0,1,2,0,6,2,8,3,6,0,8,2,2,5,8,8,7,6,0,1,2};
        int[] b = {1,4,7,3,4,5,4,4,4,4,5,8,2,0,6,1,4,7,5,4,3,6,7,8};
        int[] c = {2,5,8,6,7,8,8,2,6,0,4,7,1,4,4,0,3,6,2,1,0,3,4,5};
        boolean found = false;
        // looks for win
        for(int i = 0; i<a.length; i ++)
        {
            if(sqrs[a[i]].getText().equals("O"))
                    
            {
                if(sqrs[b[i]].getText().equals("O"))
                {
                    if(sqrs[c[i]].getText().equals(""))
                    {
                        sqrs[c[i]].setText("O");
                        found = true;
                        break;
                    }
                }
            } 
            
        }
       //looks for block
        if(!found)
        {
        for(int j = 0; j<b.length; j++)
        {
         
            if(sqrs[a[j]].getText().equals("X"))
                    
            {
                if(sqrs[b[j]].getText().equals("X"))
                {
                    if(sqrs[c[j]].getText().equals(""))
                    {
                        sqrs[c[j]].setText("O");
                        found = true;
                        break;
                    }
                }
            } 
        }
        }
        //looks for path to win
        if(!found)
        {
            
            for(int k = 0; k<c.length; k++)
            {
            if(sqrs[a[k]].getText().equals(""))
                    
            {
                if(sqrs[b[k]].getText().equals(""))
                {
                    if(sqrs[c[k]].getText().equals(""))
                    {
                        sqrs[c[k]].setText("O");
                        found = true;
                        break;
                    }
                }
            }
        }
        }
        // looks for any open spots
        if(!found)
            for(int e = 0; e<a.length; e++)
            {
                if(sqrs[a[e]].getText().equals(""))
                {
                    sqrs[a[e]].setText("O");
                    break;
                }
            }
    
    
    }
    
    void reset()
    {
        for(int i = 0; i<9;i++)
        {
            sqrs[i].setText("");
        }
        moves = 0;
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
        
     for(int i = 0; i<sqrs.length;i++)
     {      
        if(ae.getSource() == sqrs[i] && sqrs[i].getText().equals(""))
        {
            moves++;
            sqrs[i].setText("X");
            
            if(ChkForWin("X"))
            {
              JOptionPane.showMessageDialog(null,"You won!","Tic_Tac_Toe",-1,new ImageIcon("Images/winner.jpg"));
              NumWins++;
              wins.setText("Human " +NumWins);
              reset();  
            }
            else
            {
                AImove();
            }
            
            
            if(ChkForWin("O")) 
            {
             JOptionPane.showMessageDialog(null,"You Loses!","Tic_Tac_Toe",-1,new ImageIcon("Images/winner.jpg"));
             Numlosses++;
             losses.setText("CPU " +Numlosses);
             reset();
            }
            
            if(moves>4)
            {
                JOptionPane.showMessageDialog(null,"Draw!","Tic Tac Toe",-1);
                
                reset();
            } 
        }
     }  
           
    }
     
    
    public static void main(String[] args) {
      
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BPs_tic_tac_toe();
            }
        });
    }
    
}
