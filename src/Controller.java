import java.util.ArrayList;
import java.util.Random;


public class Controller {
	public void start() {
		// generate yamafuda
		ArrayList<Card> yama = generateYama();
		// set field cards
		Field field = new Field(yama.subList(0, 8));
		yama.removeAll(field.getCardList());
		// set player cards
		Player first = new Player(yama.subList(0, 8));
		yama.removeAll(first.getCardList());
		Player second = new Player(yama.subList(0, 8));
		yama.removeAll(second.getCardList());
	}
	
	private ArrayList<Card> generateYama() {
		ArrayList<Card> yama = new ArrayList<Card>(48);
		Random rnd = new Random();
		Card c[] = {
				new Card("01_tsuru", new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0}),
				new Card("01_akatan", new int[]{0, 0, 0, 0, 1, 0, 1, 0, 0}),
				new Card("01_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("01_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("02_uguisu", new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0}),
				new Card("02_akatan", new int[]{0, 0, 0, 0, 1, 0, 1, 0, 0}),
				new Card("02_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("02_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("03_maku", new int[]{1, 1, 0, 0, 0, 0, 0, 0, 0}),
				new Card("03_akatan", new int[]{0, 0, 0, 0, 1, 0, 1, 0, 0}),
				new Card("03_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("03_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("04_hototogisu", new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0}),
				new Card("04_tan", new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0}),
				new Card("04_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("04_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("05_yatsuhashi", new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0}),
				new Card("05_tan", new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0}),
				new Card("05_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("05_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("06_cho", new int[]{0, 0, 0, 1, 0, 0, 0, 1, 0}),
				new Card("06_aotan", new int[]{0, 0, 0, 0, 0, 1, 1, 0, 0}),
				new Card("06_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("06_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("07_inoshishi", new int[]{0, 0, 0, 1, 0, 0, 0, 1, 1}),
				new Card("07_tan", new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0}),
				new Card("07_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("07_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("08_tsuki", new int[]{1, 0, 1, 0, 0, 0, 0, 0, 0}),
				new Card("08_gan", new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0}),
				new Card("08_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("08_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("09_sakazuki", new int[]{0, 1, 1, 0, 0, 0, 0, 1, 0}),
				new Card("09_aotan", new int[]{0, 0, 0, 0, 0, 1, 1, 0, 0}),
				new Card("09_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("09_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("10_shika", new int[]{0, 0, 0, 1, 0, 0, 0, 1, 0}),
				new Card("10_aotan", new int[]{0, 0, 0, 0, 0, 1, 1, 0, 0}),
				new Card("10_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("10_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("11_ame", new int[]{-5, -1, -1, 0, 0, 0, 0, 0, 0}),
				new Card("11_tsubame", new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0}),
				new Card("11_tan", new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0}),
				new Card("11_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("12_houou", new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0}),
				new Card("12_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("12_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}),
				new Card("12_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1})
		};
		int cnt = 0;
		while (cnt < 48) {
			int idx = rnd.nextInt(48);
			if(!yama.contains(c[idx])) {
				yama.add(c[idx]);
				cnt += 1;
			}
		}
		return yama;
	}
	
}
