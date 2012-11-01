import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Card> cards;
	public Player(List<Card> cards) {
		this.cards = new ArrayList<Card>(8);
		this.cards.addAll(cards);
	}
	public List<Card> getCardList() {
		return cards;
	}
}
