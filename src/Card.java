public class Card {
	private String name;
	// gokou, hanami, tsukimi, inoshikacho, akatan, aotan, tan, tane, kasu
	private int[] yaku;
	public Card(String name, int[] yaku) {
		this.name = name;
		this.yaku = yaku;
	}
	public String getName() {
		return name;
	}
	public int[] getYaku() {
		return yaku;
	}
}
