public class CardStack2
{
    public final int MAX_CARDS = 200; // the size of the array, most of which will be unused. (final means "constant")

    private Card[] myCards;
    private int numCardsUsed;
    private int number;

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
        int size = myCards.length;
        // ---------------------------------
        return size;
    }

    /**
     * put this card at the "end" of the list (actually at the first 'unused' null? spot), and increment the numCardsUsed.
     * @param c the card to add.
     */
    public void add(Card c)
    {
        // ---------------------------------
        myCards[numCardsUsed] = c;
        numCardsUsed = numCardsUsed + 1;
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
       Card s = myCards[i];
       Card d = myCards[j];
       myCards[i] = d;
       myCards[j] = s;
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
        // suggestion: use the swapCards() method to trade the given index and the last used index.
        swapCards(idx, numCardsUsed - 1);
        // suggestion: copy the item you just moved to the end of the used series into "temp"
        temp = myCards[numCardsUsed - 1];
        // suggestion: set the value of array at the last used index to null, and decrement numUsedCards.
        myCards[numCardsUsed -1] = null;
        numCardsUsed = numCardsUsed - 1;
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
        temp = myCards[idx];
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
        int loc = 0;
        boolean match = false;
        while (! match & loc<= myCards.length)
        {
            Card f = myCards[loc];
            match = c.isAMatch(f);
            loc = loc + 1;
        }
        if (match)
        {
            location = loc;
        }
        // ---------------------------------
        return location;
    }

    public int indexOfFirstNull(Card c)
    {
        int location  = -1;
        // ---------------------------------
        int loc = 0;
        boolean match = true;
        while (match & loc<= myCards.length)
        {
            Card f = new Card(0,13);
            match = c.isAMatch(f);
            loc = loc + 1;
        }
        if (match)
        {
            location = loc;
        }
        // ---------------------------------
        return location;
    }

    public void printCards()
    {
        number = 0;
        //System.out.println("My Cards:");
        for (Card a: myCards)
        {
            if (a != null)
            {
                System.out.print(number);
                System.out.print(". ");
                System.out.println(a);
                number ++;
            }
        }
    }


    public void makeDeck()
    {
        for (int i = 0; i<12; i++)
        {
            for (int j=0; j<4; j++)
            {
                Card c = new Card(j,i);
                Card d = new Card(j,i);
                this.add(c);
                this.add(d);
            }
        }
        for (int k = 12; k < 14; k ++)
        {
            for (int h = 0; h < 2; h ++)
            {
                Card c = new Card(4,k);
                this.add(c);
            }
        }
    }

    public Card getDealCard()
    {
        Card x = null;
        while (x == null) {
            int a = (int) (Math.random() * 104);
            Card b = this.getCopyOfCardAtIndex(a);
            this.removeCardAtIndex(a);
            x = b;
        }
        return x;
    }

    public void shuffle()
    {
        for (int i = 0; i<500; i++)
        {
            int a = (int)(Math.random()*104);
            int b = (int)(Math.random()*104);
            this.swapCards(a,b);
        }
    }


    public int[] checkMove(Card cardOnTop)
    {
        int[] moveCards = new int[myCards.length];
        int myCardPosition = 0;
        int moveCardPosition = 0;
        for (int i = 0; i < number; i++)
        {
            if (myCards[i].isAMatch(cardOnTop))
            {
                moveCards[moveCardPosition] = myCardPosition;
                moveCardPosition ++;
            }
            myCardPosition ++;
        }
        for (int i = moveCardPosition; i<moveCards.length; i++)
        {
            moveCards[i] = -1;
        }
        return moveCards;
    }

    public int getNumCardsUsed()
    {
        return numCardsUsed;
    }

    public void updateNumber()
    {
        number = 0;
        for (Card a: myCards)
        {
            if (a != null)
            {
                number ++;
            }
        }
    }
}
