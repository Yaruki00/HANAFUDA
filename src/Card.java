public class Card {
	private String name;
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
