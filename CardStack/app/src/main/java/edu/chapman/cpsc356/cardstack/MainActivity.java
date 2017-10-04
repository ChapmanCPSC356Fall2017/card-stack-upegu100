package edu.chapman.cpsc356.cardstack;

import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    private TextView upperNumTextView;
    private TextView lowerNumTextView;
    private ImageView upperSuitImageView;
    private ImageView centerSuitImageView;
    private ImageView lowerSuitImageView;
    private Stack<Card> cardStack;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout);

        this.upperNumTextView = (TextView) findViewById(R.id.tv_upperNumber);
        this.lowerNumTextView = (TextView) findViewById(R.id.tv_lowerNumber);
        this.upperSuitImageView = (ImageView) findViewById(R.id.iv_upperSuit);
        this.centerSuitImageView = (ImageView) findViewById(R.id.iv_centerSuit);
        this.lowerSuitImageView = (ImageView) findViewById(R.id.iv_lowerSuit);

        //Creates all 52 cards, pushes them onto cardStack, and then shuffles the stack
        this.cardStack = new Stack<>();

        for (int i = 1; i < 14; ++i)
        {
            for (int j = 1; j < 5; ++j)
            {
                this.cardStack.push(new Card(i,toCardSuit(j)));
            }
        }

        Collections.shuffle(this.cardStack);
        displayCard(cardStack.pop());
    }

    /*
    * displayCard method
    * input: Card
    * output: void; displays card to screen by calling displayCardNum and displaySuit
    */
    public void displayCard(Card c)
    {
        displayCardNum(c.getCardNum());
        displaySuit(c.getCardSuit());
    }

    /*
    * displayCardNum method
    * input: card number, with Ace = 1, Jack = 11, Queen = 12, and King = 13
    * output: void; upperNumTextView and lowerNumTextView to correct number/letter
    */
    public void displayCardNum(int num)
    {
        if ((num > 1)&&(num < 11))
        {
            upperNumTextView.setText(String.valueOf(num));
            lowerNumTextView.setText(String.valueOf(num));
        }
        else if (num == 1)
        {
            upperNumTextView.setText(R.string.A);
            lowerNumTextView.setText(R.string.A);
        }

        else if (num == 11)
        {
            upperNumTextView.setText(R.string.J);
            lowerNumTextView.setText(R.string.J);
        }
        else if (num == 12)
        {
            upperNumTextView.setText(R.string.Q);
            lowerNumTextView.setText(R.string.Q);

        }
        else
        {
            upperNumTextView.setText(R.string.K);
            lowerNumTextView.setText(R.string.K);
        }
    }

    /*
    * displaySuit method
    * input: Cardsuit
    * output: void; changes upperSuitImage, centerSuitImage, and lowerSuitImage to correct suit
    * Also changes color of upperNumTextView and lowerNumTextView according to correct suit
    */
    public void displaySuit(CardSuit cardSuit)
    {
        if (cardSuit == CardSuit.HEARTS)
        {
            upperSuitImageView.setImageResource(R.drawable.heart_image);
            centerSuitImageView.setImageResource(R.drawable.heart_image);
            lowerSuitImageView.setImageResource(R.drawable.heart_image);
            upperNumTextView.setTextColor(Color.parseColor("#e60000"));
            lowerNumTextView.setTextColor(Color.parseColor("#e60000"));
        }
        else if (cardSuit == CardSuit.DIAMONDS)
        {
            upperSuitImageView.setImageResource(R.drawable.diamond_image);
            centerSuitImageView.setImageResource(R.drawable.diamond_image);
            lowerSuitImageView.setImageResource(R.drawable.diamond_image);
            upperNumTextView.setTextColor(Color.parseColor("#e60000"));
            lowerNumTextView.setTextColor(Color.parseColor("#e60000"));
        }
        else if (cardSuit == CardSuit.SPADES)
        {
            upperSuitImageView.setImageResource(R.drawable.spade_image);
            centerSuitImageView.setImageResource(R.drawable.spade_image);
            lowerSuitImageView.setImageResource(R.drawable.spade_image);
            upperNumTextView.setTextColor(Color.parseColor("#000000"));
            lowerNumTextView.setTextColor(Color.parseColor("#000000"));
        }
        else
        {
            upperSuitImageView.setImageResource(R.drawable.club_image);
            centerSuitImageView.setImageResource(R.drawable.club_image);
            lowerSuitImageView.setImageResource(R.drawable.club_image);
            upperNumTextView.setTextColor(Color.parseColor("#000000"));
            lowerNumTextView.setTextColor(Color.parseColor("#000000"));
        }
    }

    /*
    * onScreenClick method
    * Handles when user clicks the screen
    * if cardStack is empty, finishes MainActivity
    * if cardStack, is not empty, displays Card on top of cardStack and pops it off
    */
    public void onScreenClick(View view)
    {
        if (!cardStack.isEmpty())
        {
            displayCard(cardStack.pop());
        }

        else
        {
            finish();
        }
    }

    /*
    * toCardSuit method
    * input: integer
    * output: CardSuit enum, either HEARTS, DIAMONDS, SPADES, or CLUBS
    */
    public CardSuit toCardSuit(int n)
    {
        switch (n)
        {
            case 1:
                return CardSuit.HEARTS;
            case 2:
                return CardSuit.DIAMONDS;
            case 3:
                return CardSuit.SPADES;
            default:
                return CardSuit.CLUBS;
        }
    }
}
