/*
* Names: Reggie, Ziru, Liam
* Description: 
*
*/

package resources;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
	public static int CARDLIMIT = 52;
	public static int NUMPLAYER = 4;
	public static ArrayList<Card> PRIMARYDECK  = new ArrayList<Card>();

	// ordered dimension map based on player index 3;

	public static int[][] PlayerData = new int[4][2];

	Stack<Card> pile;

	static {
	
	// PlayerData
	PlayerData[0][0] = 9;
	PlayerData[0][1] = 0;

	PlayerData[1][0] = 9;
	PlayerData[1][1] = 275;

	PlayerData[2][0] = 259;
	PlayerData[2][1] = 0;

	PlayerData[3][0] = 509;
	PlayerData[3][1] = 0; 




	//DimensionMap.add(new Dimension(9, 0));

	boolean color;
	
	for(int i = 1; i <= 13; i ++){
		for(Card.Suit suit: Card.Suit.values()){

			PRIMARYDECK.add(new Card(i, suit));
		}
	}
	}

	static {
		
	}

	public static double Lerp(double Start, double Goal, double Alpha) {
		return Start + (Goal - Start) * Alpha;
	}

	public static void main(String[] args) {
		Solitaire game = new Solitaire();
		GUI gui = new GUI(game);
		
	}
}