
/*This program will create a voting system, where the user will input the name of the candidate they would like to vote
 * and the name of the winner will be displayed with the total votes received.
 * In case of a tie, the program will display the names of the candidates and number of votes as well.
 * The program will use Scanner objects to collect the user inputs,
 * ArrayLists, while and for loops, together with if and switch statements.
 */

 /*Importing ArrayList, Collections and Scanner class 
  * from Java utilities */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task4 {
    //method that will prompt the user to enter the name of the person they would like to vote.
    public static void initial_message(){
        String hash = "# "; //string to use for a more appealing visual effect
        System.out.println(hash.repeat(32)); //repeat method will repeat the string the number of desired times, avoiding repeating n-number of print statements 
        System.out.println("# Please enter the name of the person you would like to vote: #");
        System.out.println("# To exit poll, enter -1 or an empty line.                    #");
        System.out.println(hash.repeat(32));

    }

    public static void main(String[] args){
        /* ArrayLists created for candidates names, candidates votes and a
         * third ArrayList to collect the names of candidates that will get the highest numeber of votes, in case there is a tie.
         */
        ArrayList <String> candidates = new ArrayList<String>(); 
        ArrayList <Integer> votes = new ArrayList<Integer>();
        ArrayList <String> winning_candidates = new ArrayList<String>();

        //Scanner object initiated to collect user input 
        Scanner input = new Scanner(System.in);
        
        //While Loop that will allow the user to input as many names as they like until the condition becames false
        while(true){
            initial_message();
            //String variable name will collect user input containing the candidate they would like to vote
            String name = input.nextLine();
            System.out.println(); 

            //If statement will check if name input by user is already been input before.
            if(candidates.contains(name)){
                for(int x = 0; x<candidates.size() && x<votes.size(); x++){
                    if(name.equals(candidates.get(x))){ //if candidate name already in the ArrayList == true  
                        votes.set(x, (votes.get(x)+1));//vote value at the same idex of matching name in candidates list is increased by one
                    }
                }
            }
            //If user input equals -1 or empty space, program will calculate the winner and stop.
            else if(name.equals("-1") || name.equals(" ") || name.equals("")){ 
                if(candidates.size()==0){
                    System.out.println("No candidates");
                    break;
                }
                
                int highest_vote = Collections.max(votes); //int variable declared and assigned to maximum value present in the votes ArrayList
                for( int x = 0; x<votes.size(); x++){ //for loop to iterate through votes ArrayList and check how many objects are equal to the maximum value
                    
                    /*everytime an object of the votes array matches the highest value,
                    * the correspondent candidate name at the same index number is added
                    * to the winning_candidates ArrayList*/
                    if(votes.get(x).equals(highest_vote)){  
                        winning_candidates.add(candidates.get(x)); 
                    }
                    switch (votes.get(x)){
                        case 1:
                        System.out.println(candidates.get(x) + " received a total of "+ votes.get(x) + " vote!");
                        break;
                        default:
                        System.out.println(candidates.get(x) + " received a total of "+ votes.get(x) + " votes!");
                            
                    }
                }
                /*Switch statement will test the size of the winning_candidates ArrayList size against two cases.
                    * If the ArrayList length equals 1, there is only one winner and the program will proceed to enter a second, nested switch case 
                    * that will ensure the word "vote" is printed correctly according to the number of votes the candidate received. 
                    * If the length of the winner ArrayList is greater than 1, then there is a tie between 2 or more candidates, therefore the "default" case will be executed.
                    */
                System.out.println("* *".repeat(20));
                    
                        switch (winning_candidates.size()){
                        case 1:
                            switch(highest_vote){
                                case 1: //In the unlikely scenario of only one candidate and only one vote
                                System.out.println("The winner is "+ winning_candidates + " with a total of "+ highest_vote + " vote!");
                                break;
                                default:
                                System.out.println("The winner is "+ winning_candidates + " with a total of "+ highest_vote + " votes!");
                                

                            }
                            break;

                        default:
                            switch(highest_vote){
                                case 1:
                                System.out.println("We have a tie! The following candidates "+ winning_candidates + " have each a total of "+ highest_vote + " vote.");
                                break;
                                default:
                                System.out.println("We have a tie! The following candidates "+ winning_candidates + " have each a total of "+ highest_vote + " votes.");
                                

                            }
                             
                        }
                    
                    input.close();
                    break; //break statement will end while loop and exit the program
                }

            /*If user input is not already into the candidates ArrayList, then the name will be added and 1 vote will be added to the votes ArrayList, 
            then loop restarts from beginning*/
            else{
                candidates.add(name);
                votes.add(1); 
            }
        }
    }
}
