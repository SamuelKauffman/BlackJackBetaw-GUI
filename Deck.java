import java.util.Random;

/**
 * @author Sam Kauffman
 *
 */
public class Deck {
	private String[] mSuit;
	private String[] mRank;
	protected String[] mDeck;
	protected String[] mGraphics;
	protected int[] mValue;
	private String mTopCard;

	/**
	 * Default constructor
	 */
	public Deck() {
		mSuit = new String[4];
		mRank = new String[13];
		mDeck = new String[52];
		mGraphics = new String[52];
		mValue = new int[52];
		mTopCard = "";
	}//end default constructor

	/**
	 * @param suit
	 * @param rank
	 * @param deck
	 * @param value
	 * @param topCard
	 */
	public Deck(String[] suit, String[] rank, String[] deck, int[] value, String topCard) {
		mSuit = suit;
		mRank = rank;
		mDeck = deck;
		mValue = value;
		mTopCard = topCard;
	}//end preferred constructor

	/**
	 * sets an array with all 13 ranks
	 */
	public void setRank() {
		String[] rankArray = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
				"Queen", "King" };
		mRank = rankArray;
	}//end setRank

	/**
	 * sets an array with all 4 suits
	 */
	public void setSuit() {
		String[] suitArray = { "Clubs", "Diamonds", "Hearts", "Spades" };
		mSuit = suitArray;
	}//end setSuit

	/**
	 * sets an array with all 4 suits
	 */
	public void setGraphics() {
		String[] graphic = new String[52];
		for (int i = 1; i <= graphic.length; i++) {
			graphic[i - 1] = "C:\\\\Users\\\\sam58\\\\OneDrive\\\\Pictures\\\\cards\\\\" + i + ".png";
			mGraphics = graphic;
		}
	}
		
	public void getGraphic() {
		for(int i = 0; i <= mGraphics.length - 1; i++) {
			System.out.println(mGraphics[i]);
		}
	}
	/**
	 * sets card array in order
	 */
	public void setOrder() {
		String[] deck = new String[52];
		for (int i = 0; i < mRank.length; i++) {
			for (int n = 0; n < mSuit.length; n++) {
				deck[mSuit.length * i + n] = mRank[i] + " of " + mSuit[n];
				mDeck = deck;
			}
		}
	}//end setOrder

	/**
	 * gets order of cards, mainly for testing purposes 
	 */
	public void getOrder() {
		for (int i = 0; i < mDeck.length; i++) {
			System.out.println(mDeck[i]);
		}
	}//end getOrder

	/**
	 * shuffles cards randomly
	 */
	public void shuffleCards() {
		Random shuffle = new Random();
		for (int i = 0; i < mDeck.length; i++) {
			int newIndex = shuffle.nextInt(mDeck.length);
			String randomCard = mDeck[newIndex];
			int randomValue = mValue[newIndex];
			String randomGraphic = mGraphics[newIndex];
			mDeck[newIndex] = mDeck[i];
			mGraphics[newIndex] = mGraphics[i]; 
			mGraphics[i] = randomGraphic;
			mDeck[i] = randomCard;
			mValue[newIndex] = mValue[i];
			mValue[i] = randomValue;
			
		}
	}//end shuffleCards

	/**
	 * gets shuffled cards, mainly for testing
	 */
	public void getShuffledCards() {
		for (int i = 0; i < mDeck.length; i++) {
			System.out.println(mDeck[i]);
			System.out.println(mValue[i]);
		}
	}//end getShuffledCards

	/**
	 * @param hit
	 * @return top card
	 */
	public String getTopCard(int hit) {
		if (hit >= mDeck.length) {
			shuffleCards();
		}
		mTopCard = mDeck[hit];
		return mTopCard;
	}//end getTopCard

	/**
	 * sets card value, if the card is above 10, such as the face cards, it sets them to 10
	 */
	public void setValue() {
		int[] value = new int[52];
		for (int i = 0; i < mRank.length; i++) {
			for (int n = 0; n < mSuit.length; n++) {
				int cardValue = i + 1;
				if (cardValue > 10) {
					cardValue = 10;
				}
				value[mSuit.length * i + n] = cardValue;
				mValue = value;
			}
		}
	}//end setValue

	/**
	 * prints value order, for testing purposes
	 */
	public void valueOrder() {
		for (int i = 0; i < mValue.length; i++) {
			System.out.println(mValue[i]);
		}
	}//end valueOrder
}
