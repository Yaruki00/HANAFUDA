import java.util.ArrayList;
import java.util.Random;


public class Controller {
	public void start() {
		// generate yamafuda
		ArrayList<Card> yama = generateYama();
		
	}
	
	private ArrayList<Card> generateYama() {
		ArrayList<Card> yama = new ArrayList<Card>(48);
		Random rnd = new Random();
		Card c;
		int cnt = 0;
		while (cnt < 48) {
			switch (rnd.nextInt(48)) {
			// January
			// tsuru
			case 0:
				c = new Card("01_tsuru", new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// akatan
			case 1:
				c = new Card("01_akatan", new int[]{0, 0, 0, 0, 1, 0, 1, 0, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 2:
				c = new Card("01_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 3:
				c = new Card("01_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// February
			// uguisu
			case 4:
				c = new Card("02_uguisu", new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// akatan
			case 5:
				c = new Card("02_akatan", new int[]{0, 0, 0, 0, 1, 0, 1, 0, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 6:
				c = new Card("02_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 7:
				c = new Card("02_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// March
			// maku
			case 8:
				c = new Card("03_maku", new int[]{1, 1, 0, 0, 0, 0, 0, 0, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// akatan
			case 9:
				c = new Card("03_akatan", new int[]{0, 0, 0, 0, 1, 0, 1, 0, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 10:
				c = new Card("03_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 11:
				c = new Card("03_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// April
			// hototogisu
			case 12:
				c = new Card("04_hototogisu", new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// tan
			case 13:
				c = new Card("04_tan", new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 14:
				c = new Card("04_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 15:
				c = new Card("04_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// May
			// yatsuhashi
			case 16:
				c = new Card("05_yatsuhashi", new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// tan
			case 17:
				c = new Card("05_tan", new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 18:
				c = new Card("05_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 19:
				c = new Card("05_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// June
			// cho
			case 20:
				c = new Card("06_cho", new int[]{0, 0, 0, 1, 0, 0, 0, 1, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// aotan
			case 21:
				c = new Card("06_aotan", new int[]{0, 0, 0, 0, 0, 1, 1, 0, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 22:
				c = new Card("06_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 23:
				c = new Card("06_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// July
			// inoshishi
			case 24:
				c = new Card("07_inoshishi", new int[]{0, 0, 0, 1, 0, 0, 0, 1, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// tan
			case 25:
				c = new Card("07_tan", new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 26:
				c = new Card("07_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 27:
				c = new Card("07_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// August
			// tsuki
			case 28:
				c = new Card("08_tsuki", new int[]{1, 0, 1, 0, 0, 0, 0, 0, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// gan
			case 29:
				c = new Card("08_gan", new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 30:
				c = new Card("08_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 31:
				c = new Card("08_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// September
			// sakazuki
			case 32:
				c = new Card("09_sakazuki", new int[]{0, 1, 1, 0, 0, 0, 0, 1, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// aotan
			case 33:
				c = new Card("09_aotan", new int[]{0, 0, 0, 0, 0, 1, 1, 0, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 34:
				c = new Card("09_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 35:
				c = new Card("09_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// October
			// shika
			case 36:
				c = new Card("10_shika", new int[]{0, 0, 0, 1, 0, 0, 0, 1, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// aotan
			case 37:
				c = new Card("10_aotan", new int[]{0, 0, 0, 0, 0, 1, 1, 0, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 38:
				c = new Card("10_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 39:
				c = new Card("10_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// November
			// ame
			case 40:
				c = new Card("11_ame", new int[]{-5, -1, -1, 0, 0, 0, 0, 0, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// tsubame
			case 41:
				c = new Card("11_tsubame", new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// tan
			case 42:
				c = new Card("11_tan", new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 43:
				c = new Card("11_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// houou
			case 44:
				c = new Card("12_houou", new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 45:
				c = new Card("12_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 46:
				c = new Card("12_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			// kasu
			case 47:
				c = new Card("12_kasu", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1});
				if(!yama.contains(c)) {
					yama.add(c);
					cnt += 1;
				}
				break;
			}
		}
		return yama;
	}
	
}
