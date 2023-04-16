import javax.swing.*;

public class Application {

	public static void main(String[] args) {

		BlackJack blackjack = new BlackJack();
		
		int bet;
		String betInput = null;
		int money = blackjack.getMoney();
		

		Deck deck = new Deck();
		deck.setRank();
		deck.setSuit();
		deck.setOrder();
		deck.setValue();
		deck.shuffleCards();

		Hand playerHand = new Hand();
		Hand dealerHand = new Hand();
		

		Object[] options1 = { "Start", "Quit" };

		JPanel panel = new JPanel();
		panel.add(new JLabel("Welcome to BlackJack"));

		int menuButton = JOptionPane.showOptionDialog(null, panel, "BlackJack", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options1, null);

		if (menuButton == 0) {

			int check = 0;
			do {
				if (check == -1 ) {
					betInput = JOptionPane.showInputDialog(null, "How much money do you want to bet?",
							"BlackJack", JOptionPane.ERROR_MESSAGE);
				} else if (check == 0) {
					betInput = JOptionPane.showInputDialog("How much money do you want to bet?");
					System.out.println(betInput);

				}
				if(betInput == null) {
					System.exit(0);
				}
				try {
					bet = Integer.parseInt(betInput);
					bet = bet*bet;
					bet = (int) Math.sqrt(bet);
					System.out.println(bet);
					check = 1;
					if(bet == 0) {
						check = -1;
					}
				} catch (NumberFormatException e) {
					check = -1;
				}
				
			} while (check < 1);

		} else {
			System.exit(0);
		}
	}

}
