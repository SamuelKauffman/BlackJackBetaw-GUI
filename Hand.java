import java.util.ArrayList;

/**
 * @author Sam Kauffman
 *
 */
public class Hand {
	private ArrayList<String> mCards;
	private int mTotalValue;
	private int handSize;

	/**
	 * Default Constructor
	 */
	public Hand() {
		mCards = new ArrayList<String>();
		mTotalValue = 0;
		handSize = 0;
	}//end default constructor

	/**
	 * @param card
	 * @param value
	 */
	public void addCard(String card, int value) {
		mCards.add(card);
		mTotalValue = mTotalValue + value;
		handSize++;
	}//end addCard

	/**
	 * @return card value
	 */
	public int getValue() {
		return mTotalValue;
	}//end getValue

	/**
	 *displays your hand
	 */
	public void displayHand() {
		System.out.println("Your Hand: ");
		for (String card : mCards) {
			System.out.println(card);
		}
		System.out.println("Total value: " + mTotalValue);
		System.out.println("\n");
	}//end displayHand

	/**
	 * @param dealerTwoCard
	 */
	public void displayDealersHand(int dealerTwoCard) {
		System.out.println("Dealers Hand: ");
		for (int i = 0; i < 2 && i < mCards.size(); i++) {
			System.out.println(mCards.get(i));
		}
		
		System.out.println("The value of dealers first 2 cards: " + dealerTwoCard);
	}//end displayDealersHand

	/**
	 * @return Handsize
	 */
	public int getHandSize() {
		return handSize;
	}//end Handsize
}