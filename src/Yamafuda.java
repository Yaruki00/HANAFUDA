import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Yamafuda {
	private List<Card> cards;
	public Yamafuda() {
		cards = new ArrayList<Card>(48);
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
			if (!cards.contains(c[idx])) {
				cards.add(c[idx]);
				cnt += 1;
			}
		}
	}

	public Card drawCard() {
		Card c = cards.get(0);
		cards.remove(c);
		return c;
	}
	
	public List<Card> drawCards(int num) {
		List<Card> cards = new ArrayList<Card>(num);
		cards.addAll(this.cards.subList(0, num));
		this.cards.removeAll(cards);
		return cards;
	}
	
}