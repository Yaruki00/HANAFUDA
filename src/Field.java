import java.util.ArrayList;

public class Field {
	private ArrayList<Card> cards;
	public Field(ArrayList<Card> cards) {
		this.cards = cards;
	}
	public void addCard(Card c) {
		cards.add(c);
	}
	public void removeCard(Card c) {
		cards.remove(c);
	}
	public ArrayList<Card> getCardList() {
		return cards;
	}
}
