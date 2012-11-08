import java.util.List;

public class You extends Player {
	public You(List<Card> cards) {
		super(cards);
		name = "You";
	}

	@Override
	public Card openCard(List<Card> field) {
		return haveCards.get(IO.openYouCard(haveCards.size()));
	}

	@Override
	public Card choiceCard(List<Card> available) {
		return available.get(IO.choice(available));
	}

	@Override
	public boolean willFinish() {
		if (IO.finishConfirm() == 1) {
			return true;
		} else {
			return false;
		}
	}
}
