package resources;


public class Main {
	public static int CardLimit = 50;
	public static int PlayerLimit = 4;
	public static ArrayList<Card> RandomCardData = new ArrayList<Card>();
	
	public static double Lerp(double Start, double Goal, double Alpha) {
		return Start + (Goal - Start) * Alpha;
	}

	public static void main(String[] args) {
		Solitaire game = new Solitaire();
		GUI gui = new GUI(game);
		
	}
}