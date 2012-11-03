import java.util.ArrayList;
import java.util.List;

public class Controller {
	public void game() {
		// generate yamafuda
		Yamafuda yama = new Yamafuda();
		// set field cards
		Field field = new Field(yama.drawCards(8));
		// select first or second
		Player first = null;
		Player second = null;
		int order = IO.setOrder();
		if (order == 1) {
			first = new You(yama.drawCards(8));
			second = new Com(yama.drawCards(8));
		} else if (order == 2) {
			first = new Com(yama.drawCards(8));
			second = new You(yama.drawCards(8));
		} else {
			first = new You(yama.drawCards(8));
			second = new You(yama.drawCards(8));
		}
		// game start
		int turn = 0;
		Player winner = null;
		while (turn < 8) {
			turn += 1;
			// first's turn
			IO.showOnesTurn(first.getName());
			IO.showField(field.getCardList());
			if (first.getName() == "You") {
				IO.showHand(first.getCardList());
			}
			// open card
			Card open = first.openCard();
			findMach(first, open, field);
			// finish?
			if (first.canFinish()) {
				if (first.willFinish()) {
					winner = first;
					break;
				}
			}
			// draw card
			Card draw = yama.drawCard();
			IO.showDraw(draw.getName());
			IO.showField(field.getCardList());
			findMach(first, draw, field);
			// finish?
			if (first.canFinish()) {
				if (first.willFinish()) {
					winner = first;
					break;
				}
			}
			// second's turn
			IO.showOnesTurn(second.getName());
			IO.showField(field.getCardList());
			if (second.getName() == "You") {
				IO.showHand(second.getCardList());
			}
			// open card
			open = second.openCard();
			findMach(second, open, field);
			// finish?
			if (second.canFinish()) {
				if (second.willFinish()) {
					winner = second;
					break;
				}
			}
			// draw card
			draw = yama.drawCard();
			IO.showDraw(draw.getName());
			IO.showField(field.getCardList());
			findMach(second, draw, field);
			// finish?
			if (second.canFinish()) {
				if (second.willFinish()) {
					winner = second;
					break;
				}
			}
		}
		IO.showWinner(winner);
	}

	private void findMach(Player p, Card c, Field field) {
		List<Card> available = new ArrayList<Card>();
		for (Card fieldCard : field.getCardList()) {
			if (c.getMonth() == fieldCard.getMonth()) {
				available.add(fieldCard);
			}
		}
		if (available.size() == 0) {
			IO.noGet(p.getName());
			p.removeCard(c);
			field.addCard(c);
		} else if (available.size() == 1) {
			IO.getPair(p.getName(), available.get(0).getName(), c.getName());
			p.addPair(available.get(0), c);
			p.removeCard(c);
			field.removeCard(available.get(0));
		} else {
			Card choice = p.choiceCard(available);
			IO.getPair(p.getName(), choice.getName(), c.getName());
			p.addPair(choice, c);
			p.removeCard(c);
			field.removeCard(choice);
		}
	}

}
