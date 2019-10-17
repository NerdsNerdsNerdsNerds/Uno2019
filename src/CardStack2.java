public class CardStack2
{
    public final int MAX_CARDS = 200; // the size of the array, most of which will be unused. (final means "constant")

    private Card[] myCards;
    private Card[] moveCards;
    private int numCardsUsed;

    public CardStack2()
    {
        myCards = new Card[MAX_CARDS];
        moveCards = new Card[myCards.length];
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
        swapCards(idx, numCardsUsed);
        // suggestion: copy the item you just moved to the end of the used series into "temp"
        temp = myCards[numCardsUsed];
        // suggestion: set the value of array at the last used index to null, and decrement numUsedCards.
        myCards[numCardsUsed] = null;
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

    public void printCards()
    {
        int number = 0;
        System.out.println("My Cards:");
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

    public void printMoveCards()
    {
        int number = 0;
        System.out.println("My Cards:");
        for (Card a: moveCards)
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
        for (int i = 0; i<14; i++)
        {
            for (int j=0; j<4; j++)
            {
                Card c = new Card(j,i);
                Card d = new Card(j,i);
                this.add(c);
                this.add(d);
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

    //public boolean checkMove(Card cardOnTop)
    //{
        //boolean move = false;
        //for (Card c : myCards)
           // {
                //if (c.isAMatch(cardOnTop))
                //{
                 //   move = true;
                //}
            //}
        //return move;
    //}

    public int[] checkMove(Card cardOnTop)
    {

    }

}
