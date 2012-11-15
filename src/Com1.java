import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Com1 extends Player {
	int aim;

	public Com1(List<Card> cards) {
		super(cards);
		name = "Com1";
	}

	@Override
	public Card openCard(List<Card> field) {
		// calc weight
		int[] weight = calcWeight();
		// collect available pair and calc value
		ArrayList<AvailablePair> availablePairs = new ArrayList<AvailablePair>();
		ArrayList<Card> available = new ArrayList<Card>();
		for (Card fieldCard : field) {
			for (Card handCard : haveCards) {
				if (fieldCard.getMonth() == handCard.getMonth()) {
					availablePairs.add(new AvailablePair(fieldCard, handCard, weight));
					if (!available.contains(fieldCard)) {
						available.add(fieldCard);
					}
				}
			}
		}
		// finish one more card
		for (AvailablePair pair : availablePairs) {
			int[] pairValue = pair.getPairValue();
			for (int i = 0; i < 9; i++) {
				if (pairValue[i] >= 60) {
					System.out.println("finish!! aim: " + i + ", value: " + pairValue[i]);
					IO.comOpen(pair.getHandCard().getName());
					return pair.getHandCard();
				}
			}
		}
		System.out.println("can't finish one more card");
		// calc aim
		int[] aimYaku = {0, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] base = {15, 30, 30, 20, 15, 15, 10, 10, 1};
		for (Card card : available) {
			for (int i = 0; i < 9; i++) {
				aimYaku[i] += card.getYaku()[i] * weight[i] * base[i];
			}
		}
		int[] handCardsValue = new int[haveCards.size()];
		for (int i = 0; i < haveCards.size(); i++) {
			handCardsValue[i] = 0;
			for (int j = 0; j < 9; j++) {
				aimYaku[j] += haveCards.get(i).getYaku()[j] * weight[j] * base[j];
				handCardsValue[i] += aimYaku[j];
			}
		}
		aim = 0;
		for (int i = 1; i < 9; i++) {
			if (aimYaku[aim] < aimYaku[i]) {
				aim = i;
			}
		}
		for (int i = 0; i < 9; i++) {
			System.out.println("aim " + i + ": " + aimYaku[i]);
		}
		// aiming card in field
		for (AvailablePair pair : availablePairs) {
			if (pair.getFieldValue()[aim] > 0) {
				System.out.println("field choise!! aim: " + aim + ", value: " + pair.getFieldValue()[aim]);
				IO.comOpen(pair.getHandCard().getName());
				return pair.getHandCard();
			}
		}
		System.out.println("there isn't aiming card in field");
		// aiming card in hand
		for (AvailablePair pair : availablePairs) {
			if (pair.getHandValue()[aim] > 0) {
				System.out.println("hand choise!! aim: " + aim + ", value: " + pair.getHandValue()[aim]);
				IO.comOpen(pair.getHandCard().getName());
				return pair.getHandCard();
			}
		}
		System.out.println("there isn't aiming card in hand");
		// good pair but not aiming
		int maxPairValue = 0, index = -1;
		for (int i = 0; i < availablePairs.size(); i++) {
			if (availablePairs.get(i).getPairValueSum() > maxPairValue) {
				maxPairValue = availablePairs.get(i).getPairValueSum();
				index = i;
			}
		}
		if (index != -1) {
			System.out.println("soso choise!! value: " + availablePairs.get(index).getPairValueSum());
			IO.comOpen(availablePairs.get(index).getHandCard().getName());
			return availablePairs.get(index).getHandCard();
		}
		System.out.println("there isn't good card in hand");
		// can't get any card
		int minCardValue = 200;
		for (int i = 0; i < haveCards.size(); i++) {
			if (handCardsValue[i] < minCardValue) {
				minCardValue = handCardsValue[i];
				index = i;
			}
		}
		System.out.println("kasu choise!! value: " + handCardsValue[index]);
		IO.comOpen(haveCards.get(index).getName());
		return haveCards.get(index);
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

	private int[] calcWeight() {
		int[] weight = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (Card gotCard : gotCards) {
			for (int i = 0; i < 9; i++) {
				weight[i] += gotCard.getYaku()[i];
			}
		}
		// weight
		// gokou
		switch (weight[0]) {
		case 1:
			weight[0] = 3;
			break;
		case 2:
			weight[0] = 6;
			break;
		case -3:
			weight[0] = 8;
			break;
		default:
			weight[0] = 1;
			break;
		}
		// hanami
		switch (weight[1]) {
		case 1:
			weight[1] = 4;
			break;
		default:
			weight[1] = 1;
			break;
		}
		// tsukimi
		switch (weight[2]) {
		case 1:
			weight[2] = 4;
			break;
		default:
			weight[2] = 1;
			break;
		}
		// inoshikacho
		switch (weight[3]) {
		case 1:
			weight[3] = 3;
			break;
		case 2:
			weight[3] = 4;
			break;
		default:
			weight[3] = 1;
			break;
		}
		// akatan
		switch (weight[4]) {
		case 1:
			weight[4] = 4;
			break;
		case 2:
			weight[4] = 6;
			break;
		default:
			weight[4] = 1;
			break;
		}
		// aotan
		switch (weight[5]) {
		case 1:
			weight[5] = 4;
			break;
		case 2:
			weight[5] = 6;
			break;
		default:
			weight[5] = 1;
			break;
		}
		// tan
		switch (weight[6]) {
		case 2:
			weight[6] = 3;
			break;
		case 3:
			weight[6] = 4;
			break;
		case 4:
			weight[6] = 8;
			break;
		default:
			weight[6] = 1;
			break;
		}
		// tane
		switch (weight[7]) {
		case 2:
			weight[7] = 3;
			break;
		case 3:
			weight[7] = 4;
			break;
		case 4:
			weight[7] = 8;
			break;
		default:
			weight[7] = 1;
			break;
		}
		// kasu
		switch (weight[8]) {
		case 7:
			weight[8] = 30;
			break;
		case 8:
			weight[8] = 40;
			break;
		case 9:
			weight[8] = 60;
			break;
		default:
			weight[8] = 1;
			break;
		}
		return weight;
	}
}
