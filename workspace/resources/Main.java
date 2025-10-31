package resources;


public class Main {
	public static int Lerp(int Start, int Goal, double Alpha) {
		return Start + (Goal - Start) * Alpha;
	}

	public static void main(String[] args) {
		Solitaire game = new Solitaire();
		GUI gui = new GUI(game);
	}
}