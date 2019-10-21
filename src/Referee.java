import java.lang.reflect.Array;
import java.util.Arrays;
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
        deck.shuffle();

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
        cardOnTop = deck.getDealCard();
        //cardOnTop = new Card((int) (Math.random()) * 4, (int) (Math.random()) * 14);

        // ---------------------------------
    }


    public void playGame() {
        // ---------------------------------
        // TODO: you write this.

        while (gameIsStillPlaying)
        {
            Scanner keyboardReader = new Scanner(System.in);
            // suggestion: Show the top discarded card
            playerHand.printCards();
            System.out.println(" ");
            System.out.println("Top Card: " + cardOnTop);

            int[] moveCards = new int[100];
            moveCards = playerHand.checkMove(cardOnTop);
            while (moveCards[0] == -1)
            {
                System.out.println("You don't have a move :( you have to draw");
                Card d = deck.getDealCard();
                playerHand.add(d);
                System.out.println("You drew a " + d);
                boolean match = d.isAMatch(cardOnTop);
                if (match)
                {
                    Card n = null;
                    int p = playerHand.getNumCardsUsed();
                    moveCards[0] = p - 1;
                }
            }
            System.out.println("You have a move!");
            playerHand.printCards();
            System.out.println("Here are your moves: ");
            int z = 0;
            while (moveCards[z] != -1)
            {
                System.out.println(moveCards[z]);
                z++;
            }
            System.out.println("Which card would you like to play? Type the number of the card");
            int choice = keyboardReader.nextInt();
            cardOnTop = playerHand.getCopyOfCardAtIndex(choice);
            playerHand.removeCardAtIndex(choice);

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
