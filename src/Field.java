import java.util.ArrayList;
import java.util.List;

public class Field {
	private List<Card> cards;
	public Field(List<Card> cards) {
		this.cards = new ArrayList<Card>(24);
		this.cards.addAll(cards);
	}
	public void addCard(Card c) {
		cards.add(c);
	}
	public void removeCard(Card c) {
		cards.remove(c);
	}
	public List<Card> getCardList() {
		return cards;
	}
}
