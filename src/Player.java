import java.util.ArrayList;
import java.util.List;

public class Player {
	protected List<Card> haveCards, gotCards;
	protected int[] flags;
	public Player(List<Card> cards) {
		haveCards = new ArrayList<Card>(8);
		haveCards.addAll(cards);
		gotCards = new ArrayList<Card>(40);
		flags = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
	}
	public void removeCard(Card c) {
		haveCards.remove(c);
	}
	public List<Card> getCardList() {
		return haveCards;
	}
	public void addPair(Card fst, Card snd) {
		gotCards.add(fst);
		gotCards.add(snd);
		for (int i = 0; i < 9; i++) {
			flags[i] += fst.getYaku()[i];
			flags[i] += snd.getYaku()[i];
		}
	}
	public Card openCard() {
		return null;
	}
	public Card choiseCard(List<Card> available) {
		return null;
	}
}
