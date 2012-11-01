import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class You extends Player {
	public You(List<Card> cards) {
		super(cards);
		name = "You";
	}
	
	@Override
	public Card openCard() {
		System.out.print("your open card: ");
		System.out.flush();
		int idx = -1;
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in), 1);
		try {
			String input = r.readLine();
			idx = Integer.valueOf(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return haveCards.get(idx);
	}
	
	@Override
	public Card choiseCard(List<Card> available) {
		System.out.println("you can get:");
		for (int i = 0; i < available.size(); i++) {
			System.out.println(i + ": " + available.get(i).getName());
		}
		System.out.print("your choise: ");
		System.out.flush();
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in), 1);
		try {
			String input = r.readLine();
			return available.get(Integer.valueOf(input));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean willFinish() {
		System.out.println("will you finish this game?");
		System.out.println("0: yes");
		System.out.println("1: no");
		System.out.print("your choise: ");
		System.out.flush();
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in), 1);
		try {
			String input = r.readLine();
			if (Integer.valueOf(input) == 0) {
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
