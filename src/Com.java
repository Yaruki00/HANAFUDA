import java.util.List;
import java.util.Random;

public class Com extends Player {
	public Com(List<Card> cards) {
		super(cards);
		name = "Com";
	}

	@Override
	public Card openCard() {
		Random rnd = new Random();
		int idx = rnd.nextInt(haveCards.size());
		System.out.println("Com opend " + haveCards.get(idx).getName());
		return haveCards.get(idx);
	}

	@Override
	public Card choiseCard(List<Card> available) {
		Random rnd = new Random();
		return available.get(rnd.nextInt(available.size()));
	}

	@Override
	public boolean willFinish() {
		return true;
	}
}
