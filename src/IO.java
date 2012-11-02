import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class IO {
	public static int setOrder() {
		while (true) {
			System.out.println("-----Set Order-----");
			System.out.println("which do you like?");
			System.out.println("1: first");
			System.out.println("2: second");
			System.out.print("your choise: ");
			System.out.flush();
			BufferedReader r = new BufferedReader(new InputStreamReader(
					System.in), 1);
			try {
				String input = r.readLine();
				if (Integer.valueOf(input) == 1) {
					return 1;
				} else if (Integer.valueOf(input) == 2) {
					return 2;
				} else {
					System.out.println("please type \"1\" or \"2\"");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				System.out.println("please type \"1\" or \"2\"");
			}
		}
	}

	public static void showOnesTurn(String name) {
		System.out.println("#####" + name + "'s Turn#####");
	}

	public static void showField(List<Card> field) {
		System.out.println("-----field-----");
		for (Card fieldCard : field) {
			System.out.println("   " + fieldCard.getName());
		}
	}

	public static void showHand(List<Card> hand) {
		System.out.println("-----your card-----");
		for (int i = 0; i < hand.size(); i++) {
			System.out.println(i + ": " + hand.get(i).getName());
		}
	}

	public static int openYouCard(int num) {
		while (true) {
			System.out.print("your open card: ");
			System.out.flush();
			int idx = -1;
			BufferedReader r = new BufferedReader(new InputStreamReader(
					System.in), 1);
			try {
				String input = r.readLine();
				idx = Integer.valueOf(input);
				if (idx >= 0 && idx < num) {
					return idx;
				} else {
					System.out.println("please type number between 0 to "
							+ (num - 1));
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				System.out.println("please type number between 0 to "
						+ (num - 1));
			}
		}
	}

	public static void comOpen(String name) {
		System.out.println("Com opend " + name);
	}

	public static int choice(List<Card> choice) {
		while (true) {
			System.out.println("you can get:");
			for (int i = 0; i < choice.size(); i++) {
				System.out.println(i + ": " + choice.get(i).getName());
			}
			System.out.print("your choise: ");
			System.out.flush();
			BufferedReader r = new BufferedReader(new InputStreamReader(
					System.in), 1);
			try {
				String input = r.readLine();
				if (Integer.valueOf(input) >= 0
						&& Integer.valueOf(input) < choice.size()) {
					return Integer.valueOf(input);
				} else {
					System.out.println("please type number between 0 to "
							+ (choice.size() - 1));
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				System.out.println("please type number between 0 to "
						+ (choice.size() - 1));
			}
		}
	}

	public static void noGet(String pName) {
		System.out.println(pName + " couldn't get anything...");
	}

	public static void getPair(String pName, String cName1, String cName2) {
		System.out.println(pName + " got " + cName1 + " and " + cName2 + "!");
	}
	
	public static void completeYaku(String pName, String yName) {
		System.out.println(pName + " completed " + yName + "!!");
	}
	
	public static void showDraw(String name) {
		System.out.println("draw card: " + name);
	}

	public static int finishConfirm() {
		while (true) {
			System.out.println("will you finish this game?");
			System.out.println("1: yes");
			System.out.println("2: no");
			System.out.print("your choice: ");
			System.out.flush();
			BufferedReader r = new BufferedReader(new InputStreamReader(
					System.in), 1);
			try {
				String input = r.readLine();
				if (Integer.valueOf(input) == 1) {
					return 1;
				} else if (Integer.valueOf(input) == 2) {
					return 2;
				} else {
					System.out.println("please type \"1\" or \"2\"");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				System.out.println("please type \"1\" or \"2\"");
			}
		}
	}
	
	public static void showWinner(Player winner) {
		if(winner == null) {
			System.out.println("draw game");
		} else {
			System.out.println(winner.getName() + " won!!");
			System.out.print("yaku: [ ");
			for (int i=0; i<winner.getKoikoi().length; i++) {
				System.out.print(winner.getKoikoi()[i] + " ");
			}
			System.out.println("]");
		}
	}
}
