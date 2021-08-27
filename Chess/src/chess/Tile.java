package chess;

import java.awt.*;
import javax.swing.*;

import pieces.*;

/**
 * This is the Tile Class. It is the token class of GUI.
 * There are total of 64 tiles that together makes up the Chess Board
 *
 */
public class Tile extends JPanel implements Cloneable{

	private boolean availableDestination; //available tiles for a valid move
	private JLabel content;
	private static final long serialVersionUID = 1L;
	private Piece piece; //abstract class for all piece on the board
	int row, col;    //row and col of board and can be accessed by piece and move
	private boolean chosen =false; //currently selecgted piece
	private boolean ischeck=false; //is king checked
	
	//Constructors
	public Tile(int row, int col, Piece p)
	{		
		this.row = row;
		this.col = col;
		
		setLayout(new BorderLayout());
	
	 if((row + col)%2==0)
	  setBackground(Color.cyan);
	
	 else
	  setBackground(Color.white);
	 
	 if(p!=null)
		 setPiece(p);
	}
	
	//A constructor that takes a Tile as argument and returns a new Tile with the same data but different reference
	public Tile(Tile tile) throws CloneNotSupportedException
	{
		this.row = tile.row;
		this.col = tile.col;
		setLayout(new BorderLayout());
		if((row + col)%2==0)
			setBackground(Color.cyan);
		else
			setBackground(Color.white);
		if(tile.getpiece()!=null)
		{
			setPiece(tile.getpiece().getcopy());
		}
		else
			piece=null;
	}
	
	public void setPiece(Piece p)    //Function to set a tile with a piece
	{
		piece=p;
		ImageIcon img=new javax.swing.ImageIcon(this.getClass().getResource(p.getPath()));
		content=new JLabel(img);
		this.add(content);
	}
	
	public void removePiece()      //Function to remove a piece from the tile
	{
		if (piece instanceof King)
		{
			piece=null;
			this.remove(content);
		}
		else
		{
			piece=null;
			this.remove(content);
		}
	}
	
	
	public Piece getpiece()    //Function to access a piece of a particular tile
	{
		return this.piece;
	}
	
	public void select()       //Function to mark a tile indicating it's selection
	{
		this.setBorder(BorderFactory.createLineBorder(Color.red,6));
		this.chosen =true;
	}
	
	public boolean isselected()   //Function to return if the cell is under selection
	{
		return this.chosen;
	}
	
	public void deselect()      //Function to delselect the tile
	{
		this.setBorder(null);
		this.chosen =false;
	}
	
	public void setpossibledestination()     //Function to highlight a tile to indicate that it is a possible valid move
	{
		this.setBorder(BorderFactory.createLineBorder(Color.blue,4));
		this.availableDestination =true;
	}
	
	public void removepossibledestination()      //Remove the tile from the list of possible moves
	{
		this.setBorder(null);
		this.availableDestination =false;
	}
	
	public boolean ispossibledestination()    //Function to check if the tile is a possible destination
	{
		return this.availableDestination;
	}
	
	public void setcheck()     //Function to highlight the current tile as checked (For King)
	{
		this.setBackground(Color.RED);
		this.ischeck=true;
	}
	
	public void removecheck()   //Function to deselect check
	{
		this.setBorder(null);
		if((row + col)%2==0)
			setBackground(Color.cyan);
		else
			setBackground(Color.white);
		this.ischeck=false;
	}
	
	public boolean ischeck()    //Function to check if the current tile is in check
	{
		return ischeck;
	}
}