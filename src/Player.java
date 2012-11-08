import java.util.ArrayList;
import java.util.List;

abstract class Player {
	protected String name;
	protected List<Card> haveCards, gotCards;
	protected int[] flags, koikoi;

	public Player(List<Card> cards) {
		haveCards = new ArrayList<Card>(8);
		haveCards.addAll(cards);
		gotCards = new ArrayList<Card>(40);
		flags = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		koikoi = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	}
	
	public String getName() {
		return name;
	}
	
	public int[] getKoikoi() {
		return koikoi;
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

	public boolean canFinish() {
		boolean finish = false;
		if (flags[0] == 3 && koikoi[0] == 0) {
			IO.completeYaku(getName(), "sanko");
			koikoi[0] += 1;
			finish = true;
		}
		if (flags[0] == 4 && koikoi[0] == 1) {
			IO.completeYaku(getName(), "yonko");
			koikoi[0] += 1;
			finish = true;
		}
		if (flags[0] == -2 && koikoi[0] == 0 || flags[0] == -2 && koikoi[0] == 1) {
			IO.completeYaku(getName(), "ame yonko");
			koikoi[0] += 1;
			finish = true;
		}
		if (flags[0] == -1 && koikoi[0] == 2) {
			IO.completeYaku(getName(), "goko");
			koikoi[0] += 1;
			finish = true;
		}
		if (flags[1] == 2) {
			IO.completeYaku(getName(), "hanamizake");
			koikoi[1] += 1;
			flags[1] = 0;
			finish = true;
		}
		if (flags[2] == 2) {
			IO.completeYaku(getName(), "tsukimizake");
			koikoi[2] += 1;
			flags[2] = 0;
			finish = true;
		}
		if (flags[3] == 3) {
			IO.completeYaku(getName(), "inoshikacho");
			koikoi[3] += 1;
			flags[3] = 0;
			finish = true;
		}
		if (flags[4] == 3) {
			IO.completeYaku(getName(), "akatan");
			koikoi[4] += 1;
			flags[4] = 0;
			finish = true;
		}
		if (flags[5] == 3) {
			IO.completeYaku(getName(), "aotan");
			koikoi[5] += 1;
			flags[5] = 0;
			finish = true;
		}
		if (flags[6] >= 5) {
			IO.completeYaku(getName(), "tan");
			koikoi[6] += flags[6] - 4;
			flags[6] = 4;
			finish = true;
		}
		if (flags[7] >= 5) {
			IO.completeYaku(getName(), "tane");
			koikoi[7] += flags[7] - 4;
			flags[7] = 4;
			finish = true;
		}
		if (flags[8] >= 10) {
			IO.completeYaku(getName(), "kasu");
			koikoi[8] += flags[8] - 9;
			flags[8] = 9;
			finish = true;
		}
		return finish;
	}

	abstract public boolean willFinish();
	abstract public Card openCard(List<Card> field);
	abstract public Card choiceCard(List<Card> available);
}
