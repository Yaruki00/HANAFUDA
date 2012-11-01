public class Card {
	private int month;
	private String name;
	// gokou, hanami, tsukimi, inoshikacho, akatan, aotan, tan, tane, kasu
	private int[] yaku;
	public Card(int month, String name, int[] yaku) {
		this.month = month;
		this.name = name;
		this.yaku = yaku;
	}
	public int getMonth() {
		return month;
	}
	public String getName() {
		return name;
	}
	public int[] getYaku() {
		return yaku;
	}
}
