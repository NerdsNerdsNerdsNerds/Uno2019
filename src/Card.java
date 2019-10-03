public class Card
{
    // ---------------------------------
    // TODO: decide which private card variables you want to have. e.g. color, face value

    // ---------------------------------


    public Card () // you probably will put some parameters in here....
    {
        // ---------------------------------
        // TODO receive the information in the parameters for this function and copy them into your permanent variables.

        // ---------------------------------
    }

    // ---------------------------------
    // TODO: add accessors for your variables. You won't need modifiers, since you aren't planning on changing cards once you have them.

    // ---------------------------------


    /**
     * compares this card with the card that is given as a parameter - can one of these cards be placed on the other legally?
     * @param otherCard - the card we wish to place on this one (or vice versa)
     * @return - whether placing these two cards together would be a legal move.
     */
    public boolean isAMatch(Card otherCard)
    {
        // ---------------------------------
        // TODO: you write this!
        // hint: if you have a variable called color, you might compare this.color to otherCard.color....

        // ---------------------------------

        return false;
    }

    /**
     * compares this card with the card that is given as a parameter and indicates whether they are the same card.
     * @param otherCard - the card we wish to campare
     * @return whether these cards have the same color and face value.
     */
    public boolean isTheSame(Card otherCard)
    {
        // ---------------------------------
        // TODO: you write this!
        // hint: if you have a variable called color, you might compare this.color to otherCard.color....

        // ---------------------------------
        return false;
    }

    public String toString()
    {
        String result = "";
        // ---------------------------------
        // TODO: you write this!

        // ---------------------------------
        return result;
    }


}
