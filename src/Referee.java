import java.util.Scanner;

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
        //initialize any other variables for Referee here.
        playerHand = new CardStack2();
        deck = new CardStack2();

        whoseTurn = 0;
        gameIsStillPlaying = true;

        playerHasUno = false;
        compHasUno = false;

        cardInPlay = null;
        cardOnTop = null;

        //Make the deck
        deck.makeDeck();

        //Make playerHand
        for (int i = 0; i < 7; i++)
        {
            Card c = deck.getDealCard();
            playerHand.add(c);
            //Card c = new Card((int)(Math.random())*4, (int)(Math.random())*14);
            //playerHand.add(c);
        }

        //Make comp hand
        for (int i = 0; i < 7; i++)
        {
            Card c = deck.getDealCard();
            comp.acceptCard(c);
            //Card c = new Card((int) (Math.random()) * 4, (int) (Math.random()) * 14);
            //comp.acceptCard(c);
        }

        //Deal top card
        deck.getDealCard();
        //cardOnTop = new Card((int) (Math.random()) * 4, (int) (Math.random()) * 14);

        // ---------------------------------
    }


    public void playGame()
    {
        // ---------------------------------
        // TODO: you write this.

        while (gameIsStillPlaying)
        {
            Scanner keyboardReader = new Scanner(System.in);
            // suggestion: Show the top discarded card
            playerHand.printCards();

            // suggestion: ask the user what they want to do. (and check that they are allowed to!)
            System.out.println("What would you like to do? Play a card or draw?");
            String play = keyboardReader.next();


            // suggestion: do what the user says.

            // check for UNO
            if(playerHand.size() == 1)
            {
                System.out.println("The player had UNO!");
            }
            if(comp.size() == 1)
            {
                System.out.println("The computer had UNO!");
            }

            // check for winner.
            if(playerHand.size() == 0)
            {
                System.out.println("The player wins! Congratulations!");
                gameIsStillPlaying = false;
            }



            // ---------------------------------
            // identify the new top discarded card
            // ask the computer player for a card to match that.

            // if the computer player returns null, keep drawing cards (and adding them to the computer player's deck) until
            // a playable card is drawn.

            // check for UNO!

            // check for winner.
            if(comp.size() == 0)
            {
                System.out.println("The computer wins. Better luck next time!");
                gameIsStillPlaying = false;
            }

        }

    }

}
