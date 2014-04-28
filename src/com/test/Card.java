package com.test;

public class Card {
	/** 点数*/
	private int rank;
	/** 花色*/
	private int suit;
	public static final int THREE = 0;
	public static final int FOUR = 1;
	public static final int FIVE = 2;
	public static final int SIX = 3;
	public static final int SEVEN = 4;
	public static final int EIGHT = 5;
	public static final int NIGHT = 6;
	public static final int TEEN = 7;
	public static final int JACK = 8;
	public static final int QUEEN = 9;
	public static final int KING = 10;
	public static final int ACE = 11;
	public static final int DEUCE = 12;
	public static final int BLACK = 13;
	public static final int COLOR = 14;
	
	public static final int DIAMOND = 0;
	public static final int CLUB = 1;
	public static final int HEART = 2;
	public static final int SPADE = 3;
	public static final int JOKER = 4;
	String[] rankResult ="3,4,5,6,7,8,9,10,J,Q,K,A,2,王".split(",");
	String[] suitResult ="红桃,黑桃,方块,梅花,大,小".split(",");
	
	public Card(int rank,int suit){
		this.setRan(rank);
		this.setSuit(suit);
	}
	
	public void setRan(int ran){
		if(ran<THREE||ran>COLOR){
			throw new IllegalArgumentException("ran 超过了范围！");
		}
		this.rank = ran;
	}
	
	public int getRan(){
		return this.rank;
	}
	
	public String getRanName(){
		return this.rankResult[this.rank];
	}

	public void setSuit(int suit){
		if(suit<DIAMOND||suit>JOKER){
			throw new IllegalArgumentException("suit 超过了范围！");
		}
		this.suit = suit;
	}
	
	public int getSuit(){
		return this.suit;
	}
	
	public String getSuitString(){
		return this.suitResult[this.suit];
	}
}
