/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire;

import java.util.*;

/**
 *
 * @author phantomtaco123
 */
public class Solitaire {
    public static String[] suits = {"Club", "Spade", "Heart", "Diamond"};
    public static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
        "Jack", "Queen", "King", "Ace"};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffleDeck();
        deck.displayDeck();
    }
    
}

class Deck {
    public ArrayList<Card> deck;
    
    public Deck() {
        deck = buildDeck();
    }
    
    public void displayDeck() {
        for (int i = 0; i < 52; i++) {
            deck.get(i).displayCard();
        }
    }
    
    public void shuffleDeck() {
        Random rgen = new Random();
            
        for (int i = 0; i < 52; i++) {
            int randomPosition = rgen.nextInt(deck.size());
            Card temp = deck.get(i);
            
            deck.set(i, deck.get(randomPosition));
            deck.set(randomPosition, temp);
        }
    }
    
    private ArrayList<Card> buildDeck() {
        ArrayList<Card> newDeck = new ArrayList(52);
        
        for (int i = 0; i < 52; i++) {
            newDeck.add(new Card());
        }
        
        int count = 0;
        
        for (String suit : Solitaire.suits) {
            for (String rank : Solitaire.ranks) {
                newDeck.get(count).suit = suit;
                newDeck.get(count).rank = rank;
                count++;
            }
        }
        
        return newDeck;
    }
}

class Card {
    public String suit;
    public String rank;
    
    public Card() {
        suit = "";
        rank = "";
    }
    
    public void displayCard() {
        System.out.println("The current card is the " + rank + " of " + suit + "s.");
    }
}

