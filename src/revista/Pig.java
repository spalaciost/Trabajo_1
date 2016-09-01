package revista;
import javax.swing.JOptionPane;
import java.util.Random;

public class Pig
{
	String Play;
	boolean playerTurn = true;
	final int WIN = 100;
	final int COMPMAX = 20;
	int play, playerScore = 0, compScore = 0, compEnd, points, roundScore;
	int dice1Roll, dice2Roll;
        int decision;
        Random rand = new Random();
	Dice dice1 = new Dice();
	Dice dice2 = new Dice();
	
	public static void main (String[] args)
	{
	    JOptionPane.showMessageDialog(null, "====GAME PIG====");
		Pig pig = new Pig();
		pig.play();
	}
	public void play()
	{
		while(playerTurn)
		{
			Play = JOptionPane.showInputDialog("====INTRODUZCA==== \n 1. Si quiere tirar los dados \n" +
                                "2. para dejar que la IA tire \n");
			play = Integer.parseInt (Play);
			if (play == 1)
			{
				playerTurn = true;
			}
			else
			{
				playerTurn = false;
			}
			if (playerTurn == false)
			{
				computerRoll();   
			}
			else
			{
				playerRoll();
			}
		}		
	}   
public void computerRoll()
{
    
  decision = rand.nextInt(1) + 1;
	
				while (playerTurn == false && decision==1 )
				{
					dice1Roll = dice1.roll(); 
					dice2Roll = dice2.roll();
					JOptionPane.showMessageDialog(null, "La IA saca " + dice1Roll + "  +  " + dice2Roll);
					compScore = points(dice1Roll, dice2Roll, compScore);
					
					if (dice1Roll == 1 || dice2Roll == 1)
					{
						playerTurn = true;
					}
					
					JOptionPane.showMessageDialog(null, "Puntaje del jugador " + playerScore + "	" + " Puntaje de la IA " + compScore);
					
					if (compEnd >= COMPMAX)
					{
						playerTurn = true;
						compEnd = 0;
					}
				}
				if (compScore >= WIN)
				{
					win();
				}
}

public void playerRoll()
{
				dice1Roll = dice1.roll(); 
				dice2Roll = dice2.roll();
				JOptionPane.showMessageDialog(null, "Sacaste: " + dice1Roll + "  +  " + dice2Roll);
				playerScore = points(dice1Roll, dice2Roll, playerScore);
				JOptionPane.showMessageDialog(null, "Puntaje del Jugador " + playerScore + "	" + " Puntaje de la IA " + compScore);
				if (dice1Roll == 1 || dice2Roll == 1)
				{
					playerTurn = false;
					computerRoll();
				}
				if (playerScore >= WIN)
				{
					win();
				}
			
}
	public int points(int dice1Roll, int dice2Roll, int points)
	{
		if(roundCont(dice1Roll, dice2Roll));
		{
			roundScore += dice1Roll + dice2Roll;
		}
		if (dice1Roll == 1 && dice2Roll == 1)
		{
			JOptionPane.showMessageDialog(null, "El jugador pierde todo!");
			points = 0;
			compEnd = 0;
			roundScore = 0;
			return points;
		}
		else if (dice1Roll == 1 || dice2Roll == 1)
		{
			JOptionPane.showMessageDialog(null, "No recibe puntos!");
				roundScore = 0;
			return points;
		}
                else
		{
                    compEnd += dice1Roll + dice2Roll;
			points = roundScore;
			return points;
                }
	}
	public boolean roundCont(int dice1Roll, int dice2Roll)
	{
		if (dice1Roll == 1 && dice2Roll == 1)
		{
			return false;
		}
		else if (dice1Roll == 1 || dice2Roll == 1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}	
	public void win()
	{
		if (playerScore >= 100)
		{
			JOptionPane.showMessageDialog(null, "Bien, Ganaste");
			System.exit(0);
		}	
		if (compScore >= 100)
		{
			JOptionPane.showMessageDialog(null, "Lastima, perdiste");
			System.exit(0);
		} 
	}
}
class Dice
{
	private final int MIN_FACES = 4;
	private static Random generator = new Random();
	private int numFaces;
	private int faceValue;
	public Dice ()
	{
		numFaces = 6;
		faceValue = 1;
	}
	public int roll ()
	{
		faceValue = generator.nextInt(numFaces) + 1;
		return faceValue;
	}
	public int getFaceValue ()
	{
		return faceValue;
	}

}