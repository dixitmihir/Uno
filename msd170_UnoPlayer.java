
import java.util.List;

public class msd170_UnoPlayer implements UnoPlayer {

    public int play(List<Card> hand, Card upCard, Color calledColor,
        GameState state) {
					int[] x=state.getNumCardsInHandsOfUpcomingPlayers(); //number of cards in each player's hand
					Color[] y=state.getMostRecentColorCalledByUpcomingPlayers();//Most Recent Coller Called by Upcoming Players
					int[] z=state.getTotalScoreOfUpcomingPlayers();//total score of upcoming players
					List<Card> n=state.getPlayedCards();//Played Cards so far
			for(int i=0;i<hand.size();i++){//for loop which increments through my hand
					if(hand.get(i).getColor()==upCard.getColor()||
						hand.get(i).getColor()==calledColor||//if statement which determines a card is playable
						(hand.get(i).getNumber()==upCard.getNumber()&&
						hand.get(i).getRank()==upCard.getRank())){
							if(x[0]==1&&(hand.get(i).getRank()==Rank.SKIP)||
								hand.get(i).getRank()==Rank.REVERSE)//if the next player has UNO, and I have a playable skip, skip the next player in order to prevent them from winning the game
								return i;
							else if(hand.get(i).getRank()==Rank.DRAW_TWO&&hand.get(i).getColor()==upCard.getColor()){// if there is a draw two, I will play it first
								return i;}
							else if(z[0]>z[1]&&z[0]>z[2]&&hand.get(i).getRank()==Rank.SKIP)//if the next player has the highest score and I have a playable skip, skip them to prevent getting more points
									return i;
							else if(hand.get(i).getRank()==Rank.REVERSE)//if there is a playable reverse, play it to change flow of cards
								return i;
							else if(hand.get(i).getRank()==Rank.SKIP){// if there is a playable skip, play it to change flow of cards
								return i;}					
							else if(hand.get(i).getColor()==y[0]){//this will change card color
								return i;}	
							else if(hand.get(i).getRank()==Rank.WILD){//if there is nothing else to play, use a wild card to change color
								return i;}
							else if(hand.get(i).getRank()==Rank.WILD_D4){//use cautiously when in possesion of one (only if nothing else is satisfied)
								return i;}
							else{return i; //find first playable card
					}
				}
			}		return -1;//no other card is playable
		}	
			 
    public Color callColor(List<Card> hand) {

      int r=0;//initializaitons of counters
      int y=0;
      int b=0;
      int g=0;
      for(int i=0;i<hand.size();i++){
		if(hand.get(i).getColor()==Color.RED)//increment red if red
			r++;
		if(hand.get(i).getColor()==Color.YELLOW)// increment yellow if yellow
			y++;
		if(hand.get(i).getColor()==Color.BLUE)// increment blue if blue
			b++;
		if(hand.get(i).getColor()==Color.GREEN)// increment green if green
			g++;}
		int max=Math.max(r,y);//comparison to determine highest appearing card in hand
		int max2=Math.max(g,b);
		int max3=Math.max(max,max2);
			if(max3==g){
				return Color.GREEN;}
			if(max3==r){
				return Color.RED;}
			if(max3==y){
				return Color.YELLOW;}
			if(max3==b){
				return Color.BLUE;}//return highest card count

		return Color.YELLOW;//return yellow if no max
		
	}
  }



