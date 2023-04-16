import java.util.Random;

public class Deck {
	private String[] mSuit;
	private String[] mRank;
	protected String[] mDeck;
	protected int[] mValue;
	private String mTopCard;

	public Deck() {
		mSuit = new String[4];
		mRank = new String[13];
		mDeck = new String[52];
		mValue = new int[52];
		mTopCard = "";
	}

	public Deck(String[] suit, String[] rank, String[] deck, int[] value, String topCard) {
		mSuit = suit;
		mRank = rank;
		mDeck = deck;
		mValue = value;
		mTopCard = topCard;
	}

	public void setRank() {
		String[] rankArray = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
				"Queen", "King" };
		mRank = rankArray;
	}

	public void setSuit() {
		String[] suitArray = { "Clubs", "Diamonds", "Hearts", "Spades" };
		mSuit = suitArray;
	}

	public void setOrder() {
		String[] deck = new String[52];
		for (int i = 0; i < mRank.length; i++) {
			for (int n = 0; n < mSuit.length; n++) {
				deck[mSuit.length * i + n] = mRank[i] + " of " + mSuit[n];
				mDeck = deck;
			}
		}
	}

	public void getOrder() {
		for (int i = 0; i < mDeck.length; i++) {
			System.out.println(mDeck[i]);
		}
	}

	public void shuffleCards() {
		Random shuffle = new Random();
		for (int i = 0; i < mDeck.length; i++) {
			int newIndex = shuffle.nextInt(mDeck.length);
			String randomCard = mDeck[newIndex];
			int randomValue = mValue[newIndex];
			mDeck[newIndex] = mDeck[i];
			mDeck[i] = randomCard;
			mValue[newIndex] = mValue[i];
			mValue[i] = randomValue;
		}
	}

	public void getShuffledCards() {
		for (int i = 0; i < mDeck.length; i++) {
			System.out.println(mDeck[i]);
			System.out.println(mValue[i]);
		}
	}

	public String getTopCard(int hit) {
		if (hit >= mDeck.length) {
			shuffleCards();
		}
		mTopCard = mDeck[hit];
		return mTopCard;
	}

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
	}

	public void valueOrder() {
		for (int i = 0; i < mValue.length; i++) {
			System.out.println(mValue[i]);
		}
	}
}
