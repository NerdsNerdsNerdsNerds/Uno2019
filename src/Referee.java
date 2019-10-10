public class Referee
{
    private ComputerPlayer comp;
    // ---------------------------------
    // Add any other private variables for Referee here.
    private CardStack2 deck;
    private CardStack2 playerHand;

    private int whoseTurn;
    private boolean gameIsStillPlaying;

    private boolean playerHasUno;
    private boolean compHasUno;

    private Card cardInPlay;
    private Card cardOnTop;

    // ---------------------------------

    public Referee()
    {
        comp = new ComputerPlayer();
        // ---------------------------------
        // TODO: initialize any other variables for Referee here.
        playerHand = new CardStack2();
        deck = new CardStack2();

        whoseTurn = 0;
        gameIsStillPlaying = true;

        playerHasUno = false;
        compHasUno = false;

        cardInPlay = null;
        cardOnTop = null;

        //Make playerHand
        for (int i = 0; i < 7; i++)
        {
            Card c = new Card((int)(Math.random())*4, (int)(Math.random())*14);
            playerHand.add(c);
        }

        //Make comp hand
        for (int i = 0; i < 7; i++)
        {
            Card c = new Card((int) (Math.random()) * 4, (int) (Math.random()) * 14);
            comp.acceptCard(c);
        }

        //Deal top card
        cardOnTop = new Card((int) (Math.random()) * 4, (int) (Math.random()) * 14);

        // ---------------------------------
    }


    public void playGame()
    {
        // ---------------------------------
        // TODO: you write this.

        while (gameIsStillPlaying)
        {

            // suggestion: Show the top discarded card


            // suggestion: ask the user what they want to do. (and check that they are allowed to!)

            // suggestion: do what the user says.

            // check for UNO

            // check for winner.

            // ---------------------------------
            // identify the new top discarded card
            // ask the computer player for a card to match that.

            // if the computer player returns null, keep drawing cards (and adding them to the computer player's deck) until
            // a playable card is drawn.

            // check for UNO!

            // check for winner.


        }

    }

}
