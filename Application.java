import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author sam Kauffman
 * @Version 1.0
 * 
 *          This is a BlackJack game that has simple game rules and allows you
 *          to play against the dealer
 *
 */
public class Application {

	public static void main(String[] args) {

		// Instantiates everything
		BlackJack blackjack = new BlackJack();

		int bet;
		String betInput = null;

		Deck deck = new Deck();
		deck.setRank();
		deck.setSuit();
		deck.setOrder();
		deck.setValue();
		deck.setGraphics();
		deck.shuffleCards();

		deck.getGraphic();
		deck.getShuffledCards();

		Hand playerHand = new Hand();
		Hand dealerHand = new Hand();

		// welcome frame

		Object[] options1 = { "Start", "Quit" };

		JPanel panel = new JPanel();
		panel.add(new JLabel("Welcome to BlackJack"));

		int menuButton = JOptionPane.showOptionDialog(null, panel, "BlackJack", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options1, null);

		// checks if bet is valid
		if (menuButton == 0) {

			int check = 0;
			do {
				if (check == -1) {
					betInput = JOptionPane.showInputDialog(null, "How much money do you want to bet?", "BlackJack",
							JOptionPane.ERROR_MESSAGE);
				} else if (check == 0) {
					betInput = JOptionPane.showInputDialog("How much money do you want to bet?");
					System.out.println(betInput);

				}
				if (betInput == null) {
					JOptionPane.showMessageDialog(null, "You walk away with " + blackjack.getMoney(), "Quit",
							JOptionPane.PLAIN_MESSAGE);
					System.exit(0);
				}
				try {
					bet = Integer.parseInt(betInput);
					bet = (int) Math.abs(bet);
					blackjack.setBet(bet);
					if (bet <= blackjack.getMoney()) {
						check = 1;
					}
					if (bet == 0 || bet > blackjack.getMoney()) {
						check = -1;
					}
				} catch (NumberFormatException e) {
					check = -1;
				}

			} while (check < 1);
			
			//Shuffle card screen
			JPanel shufflePanel = new JPanel();
			shufflePanel.add(new JLabel("Dealer currently shuffling cards"));
			JFrame shuffleframe = new JFrame("shuffle...");
			shuffleframe.setLayout(new GridLayout(3, 1));
			shuffleframe.add(shufflePanel);
			shuffleframe.pack();
			shuffleframe.setVisible(true);
			shuffleframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			shuffleframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
			ImageIcon icon = new ImageIcon("C:\\\\Users\\\\sam58\\\\Videos\\\\Captures\\\\shuffle-cards.gif");
			JLabel label = new JLabel(icon);
			JOptionPane.showMessageDialog(null, label, "Shuffling...", JOptionPane.PLAIN_MESSAGE);
			shuffleframe.dispose();
			
			//adds first 2 cards for each player
			dealerHand.addCard(deck.getTopCard(0), deck.mValue[0]);
			dealerHand.addCard(deck.getTopCard(1), deck.mValue[1]);

			playerHand.addCard(deck.getTopCard(2), deck.mValue[2]);
			playerHand.addCard(deck.getTopCard(3), deck.mValue[3]);

			JPanel dealerPanel = new JPanel();

			JPanel dealerPanelReveal = new JPanel();

			JPanel playerPanel = new JPanel();

			JPanel buttonPanel = new JPanel();

			JPanel buttonPanel2 = new JPanel();
			
			//makes new dealer panel for frame
			JLabel dealerLabel = new JLabel("Dealer Cards");
			dealerPanel.add(dealerLabel);
			dealerPanelReveal.add(dealerLabel);

			dealerPanel.add(new JLabel(new ImageIcon(deck.mGraphics[0])));
			dealerPanel.add(new JLabel(new ImageIcon(deck.mGraphics[1])));
			dealerPanelReveal.add(new JLabel(new ImageIcon(deck.mGraphics[0])));
			dealerPanelReveal.add(new JLabel(new ImageIcon(deck.mGraphics[1])));

			//makes new player panel for frame
			JLabel playerLabel = new JLabel("Player Cards");
			playerPanel.add(playerLabel);

			playerPanel.add(new JLabel(new ImageIcon(deck.mGraphics[2])));
			playerPanel.add(new JLabel(new ImageIcon(deck.mGraphics[3])));

			JFrame frame2 = new JFrame("BlackJack");
			JFrame frame = new JFrame("BlackJack");
			frame.setLayout(new GridLayout(3, 1));
			//adds panels to frame
			frame.add(dealerPanel); 
			frame.add(playerPanel); 
			frame.add(buttonPanel);
			frame.pack();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

			
			JButton button3 = new JButton("Ok");
			buttonPanel2.add(button3);
			button3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Close the frame when the button is clicked
					frame2.dispose();
				}
			});

			JButton button1 = new JButton("Hit");
			buttonPanel.add(button1);
			button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (dealerHand.getValue() <= 16) {
						dealerHand.addCard(deck.getTopCard(blackjack.nextCard), deck.mValue[blackjack.nextCard]);
						dealerPanelReveal.add(new JLabel(new ImageIcon(deck.mGraphics[blackjack.nextCard])));
						dealerPanel.add(new JLabel(new ImageIcon(
								"C:\\\\Users\\\\sam58\\\\OneDrive\\\\Pictures\\\\cards\\\\backside.png")));


						blackjack.hit(blackjack.nextCard);
					}

					playerHand.addCard(deck.getTopCard(blackjack.nextCard), deck.mValue[blackjack.nextCard]);
					playerPanel.add(new JLabel(new ImageIcon(deck.mGraphics[blackjack.nextCard])));


					blackjack.hit(blackjack.nextCard);
					frame2.setLayout(new GridLayout(3, 1));
					frame2.add(dealerPanelReveal);
					frame2.add(playerPanel);
					frame2.add(buttonPanel2);
					frame2.pack();
					frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame2.setExtendedState(JFrame.MAXIMIZED_BOTH);

					if (dealerHand.getValue() > 21) {
						frame.dispose();
						frame2.setVisible(true);
						blackjack.setBet(blackjack.getBet());
						blackjack.setMoney(true);
						JOptionPane.showMessageDialog(null, "Congrats, Dealer Bust! \n You Won: " + blackjack.getBet()
								+ "\n Your money is: " + blackjack.getMoney());
					} else if (playerHand.getValue() > 21) {
						frame.dispose();
						frame2.setVisible(true);
						blackjack.setMoney(false);
						JOptionPane.showMessageDialog(null, "You Bust! \n You lost: " + blackjack.getBet()
								+ "\n Your money is: " + blackjack.getMoney());
					} else if (playerHand.getValue() > 21 && dealerHand.getValue() > 21) {
						frame.dispose();
						frame2.setVisible(true);
						blackjack.setMoney(false);
						JOptionPane.showMessageDialog(null, "You Bust! \n You lost: " + blackjack.getBet()
								+ "\n Your money is: " + blackjack.getMoney());
					} else {

						frame.dispose();
						frame.setLayout(new GridLayout(3, 1));
						frame.add(dealerPanel);
						frame.add(playerPanel);
						frame.add(buttonPanel);
						frame.pack();
						frame.setVisible(true);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					}
				}
			});
			JButton button2 = new JButton("Stand");
			buttonPanel.add(button2);
			button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame2.setLayout(new GridLayout(3, 1));
					frame2.add(dealerPanel); 
					frame2.add(playerPanel); 
					frame2.add(buttonPanel2);
					frame2.pack();
					frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame2.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.dispose();
					while (dealerHand.getValue() <= 16) {
						dealerHand.addCard(deck.getTopCard(blackjack.nextCard), deck.mValue[blackjack.nextCard]);
						dealerPanel.add(new JLabel(new ImageIcon(deck.mGraphics[blackjack.nextCard])));
						blackjack.hit(blackjack.nextCard);
					}
					if (dealerHand.getValue() > 21) {
						frame2.setVisible(true);
						blackjack.setBet(blackjack.getBet());
						blackjack.setMoney(true);
						JOptionPane.showMessageDialog(null, "Congrats, Dealer Bust! \n You Won: " + blackjack.getBet()
								+ "\n Your money is: " + blackjack.getMoney());
					} else {
						frame2.setVisible(true);
						blackjack.winLose(playerHand.getValue(), dealerHand.getValue());

					}
				}
			});

		} else {
			System.exit(0);
		}
	}

}
