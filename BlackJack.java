
public class BlackJack extends Hand {
	private int bet;
	private int money;
	public boolean win;

	public BlackJack() {
		bet = 10;
		money = 100;
	}
	
	public int getBet() {
		return this.bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
		this.money = money-this.bet;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney() {
		if (win == true) {
			money = money + bet;
		}
		if (win == false) {
			money = money - bet;
		}
	}

	public void WinLose(int playerHand, int dealerHand) { // Make this take in 2 getValue methods, compare the 2 values
															// and whoever is greater but under 21, wins
		if (dealerHand < playerHand) {
			System.out.printf("Dealers hand was %s, you win.", dealerHand);
			win = true;
			this.setMoney();
		} else if (dealerHand > playerHand) {
			System.out.printf("Dealers hand was %s, you lose.", dealerHand);
			win = false;
			this.setMoney();
		} else if (dealerHand == playerHand) {
			System.out.println("Standoff! you get your money back.");
			
		}
	}

	public void Bust(int cardTotal) {
		if (cardTotal > 21) {
			money = money - bet;
		} else if (cardTotal <= 21) {
			money = money + bet;
		}

	}
}
