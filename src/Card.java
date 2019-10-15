public class Card
{
    // ---------------------------------
    //decide which private card variables you want to have. e.g. color, face value
    private int color;
    private int number;
    // ---------------------------------


    public Card (int colorValue, int numberValue) // you probably will put some parameters in here....
    {
        // ---------------------------------
        //receive the information in the parameters for this function and copy them into your permanent variables.
        color = colorValue;
        number = numberValue;

        // ---------------------------------
    }

    // ---------------------------------
    //add accessors for your variables. You won't need modifiers, since you aren't planning on changing cards once you have them.
    public int getColor()
    {
        return color;
    }

    public int getNumber()
    {
        return number;
    }
    // ---------------------------------


    /**
     * compares this card with the card that is given as a parameter - can one of these cards be placed on the other legally?
     * @param otherCard - the card we wish to place on this one (or vice versa)
     * @return - whether placing these two cards together would be a legal move.
     */
    public boolean isAMatch(Card otherCard)
    {
        // ---------------------------------
        // hint: if you have a variable called color, you might compare this.color to otherCard.color....
        if (this.color == otherCard.color || this.number == otherCard.number)
        {
            return true;
        }
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
        // hint: if you have a variable called color, you might compare this.color to otherCard.color....
        if (this.number == otherCard.number & this.color == otherCard.color)
        {
            return true;
        }
        // ---------------------------------
        return false;
    }

    public String toString()
    {
        String colorOfCard = "Default";
        if (color == 0)
        {
            colorOfCard = "Blue";
        }
        if (color == 1)
        {
            colorOfCard = "Green";
        }
        if (color == 2)
        {
            colorOfCard = "Red";
        }
        if (color == 3)
        {
            colorOfCard = "Yellow";
        }

        String cardType = "Default";
        if (number == 10)
        {
            cardType = "Skip";
        }
        if (number == 11)
        {
            cardType = "Draw 2";
        }
        if (number == 12)
        {
            cardType = "Draw 4 Wild";
        }
        if (number == 13)
        {
            cardType = "Wild"
        }
        if (number < 10)
        {
            return colorOfCard + number;
        }
        else
        {
            return cardType + number;
        }
    }

    //Comment

}
