package edu.chapman.cpsc356.cardstack;
/**
 * Created by Nadiya on 9/30/2017.
 */

public class Card
{
    private int cardNum;
    private int suit;
    private CardSuit cardSuit;

    //No default constructor given

    public Card(int cardNum, int suit)
    {
        this.cardNum = cardNum;
        this.suit = suit;
    }


    public int getCardNum()
    {
        return cardNum;
    }

    public int getSuit() { return suit; }

    //No setters included, since card cannot be change after created
}
