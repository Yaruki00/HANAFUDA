import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {
	public void start() {
		// generate yamafuda
		List<Card> yama = generateYama();
		// set field cards
		Field field = new Field(yama.subList(0, 8));
		yama.removeAll(field.getCardList());
		// set player cards
		Player first = new You(yama.subList(0, 8));
		yama.removeAll(first.getCardList());
		Player second = new Player(yama.subList(0, 8));
		yama.removeAll(second.getCardList());
		// game start
		int turn = 0;
		while (turn < 8) {
			// first's turn
			System.out.println("field:");
			for (Card fieldCard : field.getCardList()) {
				System.out.println("  " + fieldCard.getName());
			}
			System.out.println("your card:");
			for (int i = 0; i < first.getCardList().size(); i++) {
				System.out.println(i + ": " + first.getCardList().get(i).getName());
			}
			// open card
			Card open = first.openCard();
			List<Card> available = new ArrayList<Card>();
			for (Card fieldCard : field.getCardList()) {
				if (open.getMonth() == fieldCard.getMonth()) {
					available.add(fieldCard);
				}
			}
			if (available.size() == 0) {
				System.out.println("you couldn't get anything...");
				first.removeCard(open);
				field.addCard(open);
			} else if (available.size() == 1) {
				System.out.println("you got " + available.get(0).getName() + " and " + open.getName() + "!");
				first.addPair(available.get(0), open);
				first.removeCard(open);
				field.removeCard(available.get(0));
			} else {
				Card choise = first.choiseCard(available);
				System.out.println("you got " + choise.getName() + " and " + open.getName() + "!");
				first.addPair(choise, open);
				first.removeCard(open);
				field.removeCard(choise);
			}
			// draw card
			Card draw = yama.get(0);
			yama.remove(draw);
			System.out.println("draw card: " + draw.getName());
			System.out.println("field:");
			available = new ArrayList<Card>();
			for (Card fieldCard : field.getCardList()) {
				System.out.println("  " + fieldCard.getName());
			}
			for (Card fieldCard : field.getCardList()) {
				if (draw.getMonth() == fieldCard.getMonth()) {
					available.add(fieldCard);
				}
			}
			if (available.size() == 0) {
				System.out.println("you couldn't get anything...");
				field.addCard(draw);
			} else if (available.size() == 1) {
				System.out.println("you got " + available.get(0).getName() + " and " + draw.getName() + "!");
				first.addPair(available.get(0), draw);
				field.removeCard(available.get(0));
			} else {
				Card choise = first.choiseCard(available);
				System.out.println("you got " + choise.getName() + " and " + draw.getName() + "!");
				first.addPair(choise, draw);
				field.removeCard(choise);
			}
		}
	}

	private ArrayList<Card> generateYama() {
		ArrayList<Card> yama = new ArrayList<Card>(48);
		Random rnd = new Random();
		Card c[] = {
				new Card(1, "01_tsuru", new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0 }),
				new Card(1, "01_akatan",
						new int[] { 0, 0, 0, 0, 1, 0, 1, 0, 0 }),
				new Card(1, "01_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(1, "01_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(2, "02_uguisu",
						new int[] { 0, 0, 0, 0, 0, 0, 0, 1, 0 }),
				new Card(2, "02_akatan",
						new int[] { 0, 0, 0, 0, 1, 0, 1, 0, 0 }),
				new Card(2, "02_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(2, "02_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(3, "03_maku", new int[] { 1, 1, 0, 0, 0, 0, 0, 0, 0 }),
				new Card(3, "03_akatan",
						new int[] { 0, 0, 0, 0, 1, 0, 1, 0, 0 }),
				new Card(3, "03_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(3, "03_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(4, "04_hototogisu", new int[] { 0, 0, 0, 0, 0, 0, 0,
						1, 0 }),
				new Card(4, "04_tan", new int[] { 0, 0, 0, 0, 0, 0, 1, 0, 0 }),
				new Card(4, "04_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(4, "04_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(5, "05_yatsuhashi", new int[] { 0, 0, 0, 0, 0, 0, 0,
						1, 0 }),
				new Card(5, "05_tan", new int[] { 0, 0, 0, 0, 0, 0, 1, 0, 0 }),
				new Card(5, "05_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(5, "05_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(6, "06_cho", new int[] { 0, 0, 0, 1, 0, 0, 0, 1, 0 }),
				new Card(6, "06_aotan", new int[] { 0, 0, 0, 0, 0, 1, 1, 0, 0 }),
				new Card(6, "06_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(6, "06_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(7, "07_inoshishi", new int[] { 0, 0, 0, 1, 0, 0, 0, 1,
						1 }),
				new Card(7, "07_tan", new int[] { 0, 0, 0, 0, 0, 0, 1, 0, 0 }),
				new Card(7, "07_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(7, "07_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(8, "08_tsuki", new int[] { 1, 0, 1, 0, 0, 0, 0, 0, 0 }),
				new Card(8, "08_gan", new int[] { 0, 0, 0, 0, 0, 0, 0, 1, 0 }),
				new Card(8, "08_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(8, "08_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(9, "09_sakazuki", new int[] { 0, 1, 1, 0, 0, 0, 0, 1,
						0 }),
				new Card(9, "09_aotan", new int[] { 0, 0, 0, 0, 0, 1, 1, 0, 0 }),
				new Card(9, "09_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(9, "09_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(10, "10_shika",
						new int[] { 0, 0, 0, 1, 0, 0, 0, 1, 0 }),
				new Card(10, "10_aotan",
						new int[] { 0, 0, 0, 0, 0, 1, 1, 0, 0 }),
				new Card(10, "10_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(10, "10_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(11, "11_ame",
						new int[] { -5, -1, -1, 0, 0, 0, 0, 0, 0 }),
				new Card(11, "11_tsubame", new int[] { 0, 0, 0, 0, 0, 0, 0, 1,
						0 }),
				new Card(11, "11_tan", new int[] { 0, 0, 0, 0, 0, 0, 1, 0, 0 }),
				new Card(11, "11_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(12, "12_houou",
						new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0 }),
				new Card(12, "12_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(12, "12_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }),
				new Card(12, "12_kasu", new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }) };
		int cnt = 0;
		while (cnt < 48) {
			int idx = rnd.nextInt(48);
			if (!yama.contains(c[idx])) {
				yama.add(c[idx]);
				cnt += 1;
			}
		}
		return yama;
	}

}
