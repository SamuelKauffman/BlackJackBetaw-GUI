import javax.swing.JOptionPane;

/**
 * @author Sam Kauffman
 *
 */
public class BlackJack extends Hand {
	private int bet;
	private int money;
	public boolean win;
	public int nextCard;

	/**
	 * Default constructor
	 */
	public BlackJack() {
		nextCard = 4;
		bet = 10;
		money = 100;
	}//end default constructor
	
	
	/**
	 * @return bet
	 */
	public int getBet() {
		return this.bet;
	}//end getBet

	/**
	 * @param bet
	 */
	public void setBet(int bet) {
		this.bet = bet;
	}//end setBet

	/**
	 * @return money
	 */
	public int getMoney() {
		return money;
	}//end getMoney

	/**
	 * @param money
	 */
	public void setMoney(boolean win) {
		if(win == true) {
			this.money = (money-bet) + bet*2;
		}
		else if(win == false) {
			this.money = money - bet;
		}
	}//end setBet

	/**
	 * @param playerHand
	 * @param dealerHand
	 * This method compares your cards to the dealers cards. 
	 * If you win it sets win to true, if you lose it sets win to false.
	 */
	public void winLose(int playerHand, int dealerHand) { // Make this take in 2 getValue methods, compare the 2 values
															// and whoever is greater but under 21, wins
		if (dealerHand < playerHand) {
			setBet(getBet()*2);
    		setMoney(true);
    		JOptionPane.showMessageDialog(null, "Congrats! \n You Won: " + getBet() + "\n Your money is: " + getMoney());

		} else if (dealerHand > playerHand) {
    		setMoney(false);
    		JOptionPane.showMessageDialog(null, "Dealer Wins! \n You lost: " + getBet() + "\n Your money is: " + getMoney());

		} else if (dealerHand == playerHand) {
    		JOptionPane.showMessageDialog(null, "Stand off!" + "\n Your money is: " + getMoney());

		}
	}//end WinLose
	
	/**
	 * @param nextCard
	 */
	public void hit(int nextCard) {
		nextCard++;
		this.nextCard = nextCard;
	}//end hit
	
	
}//end class
