package com.seed.world.test2020_1;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public int game(int[] guess, int[] answer) {
      try {
    	  if(guess.length != 3 || answer.length != 3) {
    		  throw new Exception("guess or answer illegal");
    	  }
      }catch(Exception e) {
    	  e.printStackTrace();
    	  return -1;
      }
      int result = 0;
      for(int i = 0 ; i < 3 ; i++ ) {
    	  if( guess[i] == answer[i]) {
    		  result++;
    	  }
      }
		return result;
		
    }
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
