import java.util.ArrayList;

public class Hand {
	private ArrayList<String> mCards;
	private int mTotalValue;
	private int handSize;

	public Hand() {
		mCards = new ArrayList<String>();
		mTotalValue = 0;
		handSize = 0;
	}

	public void addCard(String card, int value) {
		mCards.add(card);
		mTotalValue += value;
		handSize++;
	}

	public int getValue() {
		return mTotalValue;
	}

	public void displayHand() {
		System.out.println("Your Hand: ");
		for (String card : mCards) {
			System.out.println(card);
		}
		System.out.println("Total value: " + mTotalValue);
		System.out.println("\n");
	}

	public void displayDealersHand(int dealerTwoCard) {
		System.out.println("Dealers Hand: ");
		for (int i = 0; i < 2 && i < mCards.size(); i++) {
			System.out.println(mCards.get(i));
		}
		
		System.out.println("The value of dealers first 2 cards: " + dealerTwoCard);
	}

	public int getHandSize() {
		return handSize;
	}
}