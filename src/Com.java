import java.util.List;
import java.util.Random;

public class Com extends Player {
	public Com(List<Card> cards) {
		super(cards);
		name = "Com";
	}

	@Override
	public Card openCard(List<Card> field) {
		Random rnd = new Random();
		int idx = rnd.nextInt(haveCards.size());
		IO.comOpen(haveCards.get(idx).getName());
		return haveCards.get(idx);
	}

	@Override
	public Card choiceCard(List<Card> available) {
		Random rnd = new Random();
		return available.get(rnd.nextInt(available.size()));
	}

	@Override
	public boolean willFinish() {
		return true;
	}
}
