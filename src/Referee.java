import java.util.Scanner;

public class Referee
{
    private ComputerPlayer comp;
    // ---------------------------------
    // Add any other private variables for Referee here.
    private CardStack2 deck;
    private CardStack2 playerHand;
    private CardStack2 compHand;

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
        compHand = new CardStack2();

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
        }

        //Make comp hand
        for (int i = 0; i < 7; i++)
        {
            Card c = deck.getDealCard();
            compHand.add(c);
        }

        //Deal top card
        cardOnTop = deck.getDealCard();
        while (cardOnTop.getNumber() == 13 || cardOnTop.getNumber() == 12)
        {
            cardOnTop = deck.getDealCard();
        }
        // ---------------------------------
    }


    public void playGame() {
        // ---------------------------------
        System.out.println("WELCOME TO UNO! Game starting now...");
        while (gameIsStillPlaying)
        {
            Scanner keyboardReader = new Scanner(System.in);

            //refreshes deck
            if (deck.getNumCardsUsed() <= 20)
            {
                deck.makeDeck();
            }

            //------------------------------- PLAYER TURN
            while (whoseTurn == 0)
            {
                playerHand.updateNumber(); //this is used in case the player gets to play two turns in a row -- it updates the number of cards in their hand for when they move (otherwise you might get a nullpointer exception)

                //print top card
                System.out.println(" ");
                System.out.println(" ------------------");
                System.out.println("| Top Card: " + cardOnTop + " |");
                System.out.println(" ------------------");

                //check if player has a move
                int[] moveCards = new int[100];
                moveCards = playerHand.checkMove(cardOnTop);
                while (moveCards[0] == -1) {
                    System.out.println("You don't have a move :( you have to draw");
                    Card d = deck.getDealCard();
                    playerHand.add(d);
                    System.out.println("You drew a " + d);
                    boolean match = d.isAMatch(cardOnTop);
                    if (match) {
                        int p = playerHand.getNumCardsUsed();
                        moveCards[0] = p - 1;
                    }
                }
                // print hand and possible moves
                System.out.println(" ");
                System.out.println("---------PLAYER HAND---------");
                playerHand.printCards();
                System.out.println("-----------------------------");
                System.out.println("Here are your moves: ");
                int z = 0;
                System.out.print("| ");
                while (moveCards[z] != -1) {
                    System.out.print(moveCards[z]);
                    System.out.print(" | ");
                    z++;
                }
                System.out.println(" ");

                //ask player what card to play
                System.out.println("Which card would you like to play? Type the number of the card.");
                int choice = keyboardReader.nextInt();
                boolean goodchoice = false;
                while (! goodchoice)
                    {
                        for (int i: moveCards)
                        {
                            if (choice == i)
                            {
                                goodchoice = true;
                                break;
                            }
                        }
                        if (!goodchoice) {
                            System.out.println("That is not a possible move. Try again please.");
                            keyboardReader.nextLine();
                            choice = keyboardReader.nextInt();
                        }
                    }
                keyboardReader.nextLine();
                //plays card
                cardOnTop = playerHand.getCopyOfCardAtIndex(choice);
                playerHand.removeCardAtIndex(choice);

                // check for UNO
                if (playerHand.getNumCardsUsed() == 1) {
                    System.out.println("The player has UNO!");
                }
                if (compHand.getNumCardsUsed() == 1) {
                    System.out.println("The computer has UNO!");
                }

                // check for winner.
                if (playerHand.getNumCardsUsed() == 0) {
                    System.out.println("The player wins! Congratulations!");
                    gameIsStillPlaying = false;
                    break;
                }

                //check to see whose turn now
                if (cardOnTop.getNumber() == 10) {
                    whoseTurn = 0;
                } else if (cardOnTop.getNumber() == 12 || cardOnTop.getNumber() == 13) {
                    System.out.println("What color do you want the top card to be? Type 0 for blue, 1 for green, 2 for red, and 3 for yellow.");
                    int color = keyboardReader.nextInt();
                    keyboardReader.nextLine();
                    boolean goodcolor = false;
                    while (! goodcolor)
                    {
                        if (color <= 4)
                        {
                            goodcolor = true;
                            break;
                        }
                        if (! goodcolor)
                        {
                            System.out.println("This is not a possible color. Please try again.");
                            color = keyboardReader.nextInt();
                            keyboardReader.nextLine();
                        }

                    }
                    cardOnTop.setColor(color);
                    if (cardOnTop.getNumber() == 12) {
                        whoseTurn = 0;
                        for (int i = 0; i < 4; i++) {
                            Card c = deck.getDealCard();
                            compHand.add(c);
                        }
                    }
                    if (cardOnTop.getNumber() == 13)
                    {
                        whoseTurn = 1;
                    }

                } else if (cardOnTop.getNumber() == 11) {
                    whoseTurn = 0;
                    for (int i = 0; i < 2; i++) {
                        Card c = deck.getDealCard();
                        compHand.add(c);
                    }
                } else {
                    whoseTurn = 1;
                }
            }

            //------------------------------- COMPUTER TURN
            while (whoseTurn == 1)
            {
                compHand.updateNumber(); //this is used in case the computer gets to play two turns in a row -- it updates the number of cards in their hand for when they move (otherwise you might get a nullpointer exception)

                //check to see if the computer has a move
                int[] moveCards = new int[100];
                moveCards = compHand.checkMove(cardOnTop);
                while (moveCards[0] == -1)
                {
                    Card d = deck.getDealCard();
                    compHand.add(d);
                    System.out.println("The computer drew a card.");
                    boolean match = d.isAMatch(cardOnTop);
                    if (match) {
                        Card n = null;
                        int h = compHand.getNumCardsUsed();
                        moveCards[0] = h - 1;
                    }
                }

                //plays a random card out of the possible moves
                int z = (int)(Math.random()*moveCards.length);
                while (moveCards[z] == -1)
                {
                    z = (int)(Math.random()*moveCards.length);
                }
                cardOnTop = compHand.getCopyOfCardAtIndex(moveCards[z]);
                compHand.removeCardAtIndex(moveCards[z]);
                System.out.println(" ");
                System.out.println("Computer played a "+cardOnTop);

                // check for UNO
                if (compHand.getNumCardsUsed() == 1) {
                    System.out.println("The computer has UNO!");
                }

                // check for winner.
                if (playerHand.getNumCardsUsed() == 0) {
                    System.out.println("The player wins! Congratulations!");
                    gameIsStillPlaying = false;
                    break;
                }
                if (compHand.getNumCardsUsed() == 0)
                {
                    System.out.println("The computer wins. Better luck next time!");
                    gameIsStillPlaying = false;
                    break;
                }

                //check to see whose turn it is now
                if (cardOnTop.getNumber() == 10)
                {
                    whoseTurn = 1;
                }
                else if (cardOnTop.getNumber() == 12 || cardOnTop.getNumber() == 13)
                {
                    int color = (int)(Math.random()*4);
                    cardOnTop.setColor(color);
                    if (color == 0)
                    {
                        System.out.println("The computer changed the color to blue.");
                    }
                    if (color == 1)
                    {
                        System.out.println("The computer changed the color to green.");
                    }
                    if (color == 2)
                    {
                        System.out.println("The computer changed the color to red.");
                    }
                    if (color == 3)
                    {
                        System.out.println("The computer changed the color to yellow.");
                    }
                    if (cardOnTop.getNumber() == 12) {
                        whoseTurn = 1;
                        for (int i = 0; i < 4; i++) {
                            Card c = deck.getDealCard();
                            playerHand.add(c);
                        }
                    }
                    if (cardOnTop.getNumber() == 13)
                    {
                        whoseTurn = 0;
                    }
                } else if (cardOnTop.getNumber() == 11)
                {
                    whoseTurn = 1;
                    for (int i = 0; i < 2; i++) {
                        Card c = deck.getDealCard();
                        playerHand.add(c);
                    }
                } else {
                    whoseTurn = 0;
                }

            }

        }

    }
}
