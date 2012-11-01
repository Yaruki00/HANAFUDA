import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Player {
	protected String name;
	protected List<Card> haveCards, gotCards;
	protected int[] flags;

	public String getName() {
		return name;
	}
	
	public Player(List<Card> cards) {
		haveCards = new ArrayList<Card>(8);
		haveCards.addAll(cards);
		gotCards = new ArrayList<Card>(40);
		flags = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	}

	public void removeCard(Card c) {
		haveCards.remove(c);
	}

	public List<Card> getCardList() {
		return haveCards;
	}

	public void addPair(Card fst, Card snd) {
		gotCards.add(fst);
		gotCards.add(snd);
		for (int i = 0; i < 9; i++) {
			flags[i] += fst.getYaku()[i];
			flags[i] += snd.getYaku()[i];
		}
	}

	public boolean canFinish() {
		boolean finish = false;
		if (flags[0] == 3) {
			System.out.println("sanko!!");
			finish = true;
		}
		if (flags[0] == 4) {
			System.out.println("yonko!!");
			finish = true;
		}
		if (flags[0] == -2) {
			System.out.println("ame yonko!!");
			finish = true;
		}
		if (flags[0] == -1) {
			System.out.println("goko!!");
			finish = true;
		}
		if (flags[1] == 2) {
			System.out.println("hanamizake!!");
			finish = true;
		}
		if (flags[2] == 2) {
			System.out.println("tsukimizake!!");
			finish = true;
		}
		if (flags[3] == 3) {
			System.out.println("inoshikacho!!");
			finish = true;
		}
		if (flags[4] == 3) {
			System.out.println("akatan!!");
			finish = true;
		}
		if (flags[5] == 3) {
			System.out.println("aotan!!");
			finish = true;
		}
		if (flags[6] >= 5) {
			System.out.println("tan!!");
			finish = true;
		}
		if (flags[7] >= 5) {
			System.out.println("tane!!");
			finish = true;
		}
		if (flags[8] >= 10) {
			System.out.println("kasu!!");
			finish = true;
		}
		return finish;
	}

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
	
	public Card openCard() {
		return null;
	}

	public Card choiseCard(List<Card> available) {
		return null;
	}
}
