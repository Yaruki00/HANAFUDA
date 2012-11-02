import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {
	public void game() {
		// generate yamafuda
		List<Card> yama = generateYama();
		// set field cards
		Field field = new Field(yama.subList(0, 8));
		yama.removeAll(field.getCardList());
		// select first or second
		Player first = null;
		Player second = null;
		if(IO.setOrder() == 1) {
			first = new You(yama.subList(0, 8));
			yama.removeAll(first.getCardList());
			second = new Com(yama.subList(0, 8));
			yama.removeAll(second.getCardList());
		} else {
			first = new Com(yama.subList(0, 8));
			yama.removeAll(first.getCardList());
			second = new You(yama.subList(0, 8));
			yama.removeAll(second.getCardList());
		}
		// game start
		int turn = 0;
		Player winner = null;
		while (turn < 8) {
			turn += 1;
			// first's turn
			IO.showOnesTurn(first.getName());
			IO.showField(field.getCardList());
			if(first.getName() == "You") {
				IO.showHand(first.getCardList());
			}
			// open card
			Card open = first.openCard();
			findMach(first, open, field);
			// finish?
			if (first.canFinish()) {
				if (first.willFinish()) {
					winner = first;
					break;
				}
			}
			// draw card
			Card draw = yama.get(0);
			yama.remove(draw);
			IO.showDraw(draw.getName());
			IO.showField(field.getCardList());
			findMach(first, draw, field);
			// finish?
			if (first.canFinish()) {
				if (first.willFinish()) {
					winner = first;
					break;
				}
			}
			// second's turn
			IO.showOnesTurn(second.getName());
			IO.showField(field.getCardList());
			if(second.getName() == "You") {
				IO.showHand(second.getCardList());
			}
			// open card
			open = second.openCard();
			findMach(second, open, field);
			// finish?
			if (second.canFinish()) {
				if (second.willFinish()) {
					winner = second;
					break;
				}
			}
			// draw card
			draw = yama.get(0);
			yama.remove(draw);
			IO.showDraw(draw.getName());
			IO.showField(field.getCardList());
			findMach(second, draw, field);
			// finish?
			if (second.canFinish()) {
				if (second.willFinish()) {
					winner = second;
					break;
				}
			}
		}
		IO.showWinner(winner);
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

	private void findMach(Player p, Card c, Field field) {
		List<Card> available = new ArrayList<Card>();
		for (Card fieldCard : field.getCardList()) {
			if (c.getMonth() == fieldCard.getMonth()) {
				available.add(fieldCard);
			}
		}
		if (available.size() == 0) {
			IO.noGet(p.getName());
			p.removeCard(c);
			field.addCard(c);
		} else if (available.size() == 1) {
			IO.getPair(p.getName(), available.get(0).getName(), c.getName());
			p.addPair(available.get(0), c);
			p.removeCard(c);
			field.removeCard(available.get(0));
		} else {
			Card choice = p.choiceCard(available);
			IO.getPair(p.getName(), choice.getName(), c.getName());
			p.addPair(choice, c);
			p.removeCard(c);
			field.removeCard(choice);
		}
	}

}
