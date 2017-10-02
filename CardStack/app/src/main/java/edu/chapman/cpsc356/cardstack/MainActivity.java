package edu.chapman.cpsc356.cardstack;

import android.graphics.Color;
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


        this.cardStack = new Stack<>();

        for (int i = 1; i < 14; ++i)
        {
            for (int j = 1; j < 5; ++j)
            {
                this.cardStack.push(new Card(i,j));
            }
        }

        Collections.shuffle(this.cardStack);
        displayCard(cardStack.pop());
    }

    public void displayCard(Card c)
    {
        displayCardNum(c.getCardNum());
        displaySuit(c.getSuit());
    }

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

    public void displaySuit(int suit)
    {
        if (suit == 1)
        {
            upperSuitImageView.setImageResource(R.drawable.heart_image);
            centerSuitImageView.setImageResource(R.drawable.heart_image);
            lowerSuitImageView.setImageResource(R.drawable.heart_image);
            upperNumTextView.setTextColor(Color.parseColor("#e60000"));
            lowerNumTextView.setTextColor(Color.parseColor("#e60000"));
        }
        else if (suit == 2)
        {
            upperSuitImageView.setImageResource(R.drawable.diamond_image);
            centerSuitImageView.setImageResource(R.drawable.diamond_image);
            lowerSuitImageView.setImageResource(R.drawable.diamond_image);
            upperNumTextView.setTextColor(Color.parseColor("#e60000"));
            lowerNumTextView.setTextColor(Color.parseColor("#e60000"));
        }
        else if (suit == 3)
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
}
