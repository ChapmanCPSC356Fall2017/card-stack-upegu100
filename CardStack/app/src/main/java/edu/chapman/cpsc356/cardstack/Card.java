package edu.chapman.cpsc356.cardstack;
/**
 * Created by Nadiya on 9/30/2017.
 */

public class Card
{
    private int cardNum;
    private CardSuit cardSuit;

    //No default constructor given

    public Card(int cardNum, CardSuit cardSuit)
    {
        this.cardNum = cardNum;
        this.cardSuit = cardSuit;
    }


    public int getCardNum() { return cardNum; }

    public CardSuit getCardSuit() { return cardSuit; }

    //No setters included, since card cannot be change after created
}
