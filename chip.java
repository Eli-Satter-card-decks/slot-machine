/**
 *
 * @author Eli Satter
 */




      
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class chips{
public static int bet=0;
public static int chips=50;
static JFrame frame=new JFrame("Chip Gambles");
    static JPanel mainPanel = new JPanel();
	static JPanel gamblingwindow=new JPanel();
    static JPanel finalscore=new JPanel();
	 static JLabel gambleingcall=new JLabel("");
    static JLabel odd=new JLabel("");
    static JLabel even=new JLabel("");
    static JLabel score=new JLabel("");
    static JLabel endchipcount=new JLabel("");
    static JLabel special=new JLabel("WATCH HERE");
	static JLabel algorithmex=new JLabel("Get a 3, 5, or a 7 to win at low stakes, and either 5 and 3, 5, or 7, OR 6 and 6 to lose at high stakes.");
	static JTextArea setchips=new JTextArea("Call how many chips you'ii bet");
	static JButton lowstakes=new JButton("Low Stakes");
	static JButton highstakes=new JButton("High Stakes");
	static JButton endgame=new JButton("End the game");
    static JLabel keepgoing=new JLabel("");
	static JLabel chipcount=new JLabel("100");
public static String confusin="";
	 public static void main(String[] args) {
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mainPanel.setLayout(new FlowLayout());  
    gamblingwindow.setLayout(null);
    finalscore.setLayout(null);
	mainPanel.setPreferredSize(new Dimension (1000, 800));
	gamblingwindow.setPreferredSize(new Dimension (1000,800));
	finalscore.setPreferredSize(new Dimension (100,800));
	frame.add(mainPanel);
	mainPanel.add(gamblingwindow);
	mainPanel.add(finalscore);
gamblingwindow.add(special);
	gamblingwindow.add(odd);
	gamblingwindow.add(even);
	gamblingwindow.add(score);
	gamblingwindow.add(algorithmex);
	gamblingwindow.add(setchips);
	gamblingwindow.add(lowstakes);
	gamblingwindow.add(highstakes);
	gamblingwindow.add(keepgoing);
	gamblingwindow.add(gambleingcall);
	gamblingwindow.add(endgame);
	gamblingwindow.add(chipcount);
	chipcount.setBounds(50, 200, 50, 50);
	lowstakes.setBounds(50, 300, 150, 100);
	highstakes.setBounds(50, 425, 150, 100);
	setchips.setBounds(50, 50, 250, 50);
special.setBounds(50, 150, 150, 50);
	algorithmex.setBounds(50, 500, 800, 100);
	keepgoing.setBounds(50, 700, 800, 75);
	endgame.setBounds(50, 600, 250, 75);
	
	  frame.pack();
    frame.setVisible(true);
	
	lowstakes.addActionListener((ActionListener) new bettinodd());
	 highstakes.addActionListener((ActionListener) new bettinneven());
	endgame.addActionListener((ActionListener) new restartee());
}

      public static class bettinodd implements ActionListener{
        @Override
   
 

        public void actionPerformed(ActionEvent e) {
			 highstakes.setEnabled(false);
			 bet=Integer.parseInt(setchips.getText());
			 
			 chips=Integer.parseInt(chipcount.getText());
			 int vbl=5;
			 int minimumcall=3;
int setrange=2;
int rando=1;
if((chips>=bet) && (bet>0)){
rando=(int)Math.floor(Math.random()*(11-minimumcall+1)+minimumcall);
if (rando==vbl){
	System.out.println();
	chips=chips+6*bet;
}
if( (rando-vbl)== setrange || (vbl - rando) ==setrange ){
	chips=chips+3*bet;
	
	}
	else {chips = chips - 2*bet;}
		String hooray=Integer.toString(chips);
		 chipcount.setText(hooray);
		   if ((rando == 3) || (rando==7)){
                 //           confusin =  ("You drew a " +rando+", you got "+(bet * 3) +" chips!");
special.setText("√");
                    }else if (rando==5){
                //            confusin =  ("You drew a " +rando+", you got "+(bet * 6) +" chips!");
special.setText("√ √");
                        }
                            else
              //             confusin =  ("You drew a " +rando+", you lost "+(bet * 2) +" chips!");
special.setText("██");
                        
						algorithmex.setText(confusin);
		}}
}
	 public static class bettinneven implements ActionListener {

 @Override

        public void actionPerformed(ActionEvent e) {
			 lowstakes.setEnabled(false);
			 bet=Integer.parseInt(setchips.getText());
			 chips=Integer.parseInt(chipcount.getText());
			 int vbl=5;
			 int minimumcall=3;
			 int oddpoint=0;
			 int n=2;
int setrange=2;
int rando=1;
if((chips>=bet) && (bet>0)){
rando=(int)Math.floor(Math.random()*(11-minimumcall+1)+minimumcall);
if (rando%n==0){
		oddpoint=oddpoint+1;
		
	}
 if (rando == vbl) {
                            System.out.println();
                            chips = chips + 6 * bet;
                        }
                        if (oddpoint == 0 && (rando - (vbl + oddpoint) == setrange || (vbl + oddpoint) - rando == setrange)) {
                            chips = chips + 4 * bet;

                        } else {
                            chips = chips - 1 * bet;
                        }
                        if (rando == (oddpoint + vbl)) {
                            System.out.println();
                            chips = chips + 5 * bet;
                        } else if (oddpoint == 1 && (rando - (vbl + oddpoint) == setrange || (vbl + oddpoint) - rando == setrange)) {
                            chips = chips - bet * 7;
                        } else {
                            chips = chips - 4 * bet;
                        }
		String hooray=Integer.toString(chips);
		 chipcount.setText(hooray);
		 
		   if ((((rando== 3) || (rando == 7))&&(oddpoint==0))) {
            //            confusin = ("You drew a " +(vbl + oddpoint) +" and a " + rando+", you got "+(bet * 3)+" points! ");
special.setText("██ ██ ██");
                    }
                    else
                    if ((rando == 5) && ((oddpoint)==0)){
          //              confusin = ("You drew a " +(vbl + oddpoint) + " and a " + rando+", you got "+(10 * bet)+" points! ");
special.setText("██ ██ ██ ██");
                    }
                    else
        //                confusin = ("You drew a " +(vbl + oddpoint) + " and a " + rando+", you lost "+(2 * bet)+" points! ");
special.setText("√ √");
                    if ((rando==6) && ((oddpoint) == 1)){
      //                  confusin = ("You drew a " +(vbl + oddpoint) + " and a " + rando+", you got "+(11*bet)+" points! ");
special.setText("██ ██");
                    } else if (((oddpoint) == 1) && ((rando==4) || (rando == 8))){
    //                    confusin = ("You drew a " +(vbl + oddpoint) + " and a " + rando+", you lost "+(4 * bet)+" points! ");
special.setText("√ √ √ √");
                    }else if ((oddpoint==1)){
  //                      confusin = ("You drew a "+(vbl + oddpoint) + " and a " + rando+", you lost "+(2 * bet)+" points! ");
special.setText("√ √");
                    }



                    algorithmex.setText(confusin);
		}}
}
	 
public static class restartee implements ActionListener{
	@Override
       public void actionPerformed(ActionEvent e){
lowstakes.setEnabled(true);
highstakes.setEnabled(true);
		   keepgoing.setText("you ended with "+chips+" chips your last time at the table");
		chipcount.setText("100");
		}
}
}

