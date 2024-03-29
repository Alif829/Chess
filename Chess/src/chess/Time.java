package chess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;




/**Timer class
    //contains required var and functions related to timer on the GUI
 */


public class Time
{
    private JLabel label;
    Timer countdownTimer;
    int Timerem;                       //remaining time
    public Time(JLabel passedLabel)
    {
       countdownTimer = new Timer(1000, new CountdownTimerListener());
       this.label = passedLabel;
       Timerem=Main.timeRemaining;
    }
    
    //A function that starts the timer
    public void start()
    {
    	countdownTimer.start();
    }
    
    //A function that resets the timer
    public void reset()
    {
    	Timerem=Main.timeRemaining;
    }
    
    //A function that is called after every second. It updates the timer and takes other necessary actions
    class CountdownTimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
       	 int min,sec;
       	 if (Timerem > 0)
       	 {
           	min=Timerem/60; //remainig time in minutes
           	sec=Timerem%60; //remaining time in seconds
            label.setText(String.valueOf(min)+":"+(sec>=10?String.valueOf(sec):"0"+String.valueOf(sec)));
            Timerem--;
         }
       	 else
       	 {
               label.setText("Time's up!");
               reset();
               start();
               Main.Mainboard.changechance();
		 }
    }
 }
}