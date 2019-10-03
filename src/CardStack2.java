public class CardStack2
{
    public final int MAX_CARDS = 100; // the size of the array, most of which will be unused. (final means "constant")

    private Card[] myCards;
    private int numCardsUsed;

    public CardStack2()
    {
        myCards = new Card[MAX_CARDS];
        numCardsUsed = 0;

    }

    /**
     * gets the number of cards in use by this cardstack.
     * @return the number of "used" cards.
     */
    public int size()
    {
        // ---------------------------------
        // TODO: you write this.

        // ---------------------------------
        return -1;
    }

    /**
     * put this card at the "end" of the list (actually at the first 'unused' null? spot), and increment the numCardsUsed.
     * @param c the card to add.
     */
    public void add(Card c)
    {
        // ---------------------------------
        // TODO: you write this!

        // ---------------------------------
    }

    /**
     * exchange the two cards at index i and index j with each other. (i and j could be the same...)
     * @param i - first index
     * @param j - second index
     */
    public void swapCards(int i, int j)
    {
        // ---------------------------------
        // TODO: you write this!

        // ---------------------------------

    }

    /**
     * removes the card at the given index from this stack of cards and returns it.
     * @param idx - the index in question
     * @return - the card that was previously at that location.
     * This may change the order of the cards in our list.
     */
    public Card removeCardAtIndex(int idx)
    {
        Card temp = null;
        // ---------------------------------
        // TODO: you write this!
        // suggestion: use the swapCards() method to trade the given index and the last used index.

        // suggestion: copy the item you just moved to the end of the used series into "temp"

        // suggestion: set the value of array at the last used index to null, and decrement numUsedCards.

        // ---------------------------------
        return temp;
    }


    /**
     * get a copy of the card that is at the given index WITHOUT removing it from the list of cards.
     * @param idx - the index in question.
     * @return - the card at the given location, or null if the index is out of range.
     */
    public Card getCopyOfCardAtIndex(int idx)
    {
        Card temp = null;
        // ---------------------------------
        // TODO: you write this!

        // ---------------------------------
        return temp;
    }

    /**
     * find the index of the first matching card in this stack, or -1 if it is not here.
     * @param c - the card to match
     * @return the location in the card stack where this card resides, or -1, if it can't be found.
     */
    public int indexOfFirstMatch(Card c)
    {
        int location  = -1;
        // ---------------------------------
        // TODO: you write this.

        // ---------------------------------
        return location;
    }

    public String toString()
    {
        String result = "";
        // ---------------------------------
        // TODO: you write this!

        // ---------------------------------
        /
    }


}
