import java.util.Scanner;

public class RecursiveSudokuSolver {
    static Scanner sc = new Scanner(System.in);
    //create a grid with unfinished sudoku puzzle
    static int [][] grid = {
        {5, 0, 0, 0, 8, 0, 0, 4, 9},
        {0, 0, 0, 5, 0, 0, 0, 3, 0},
        {0, 6, 7, 3, 0, 0, 0, 0, 1},
        {1, 5, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 2, 0, 8, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 8},
        {7, 0, 0, 0, 0, 4, 1, 5, 0},
        {0, 3, 0, 0, 0, 2, 0, 0, 0},
        {4, 9, 0, 0, 5, 0, 0, 0, 3},
    };
    
    static void solve(){
      for(int y = 0; y < 9; y++){
         for(int x = 0; x < 9; x++){
            if(grid[y][x] == 0){ //check if there is a 0 at this position
               for(int n = 1; n < 10; n++){
                  if(possible(y,x,n)){ //calls the possible method
                     grid[y][x] = n;
                     solve(); //recursively call the method we are using
                     grid[y][x] = 0; //this is called "backtracking", we reset the solution to 0
                  }
               }
               return;
            }            
         }
      }
      printGrid();
      System.out.println("More?"); //here we ask the user to check for another possible solution
      String inp = sc.nextLine();
    }
    //y is the column
    //x is the row
    //n is the number that goes into the square
    static boolean possible(int y, int x, int n){
        //first we solve for rows and columns
      for(int i = 0; i < 9; i++){
         if(grid[y][i] == n || grid[i][x] == n){
            return false;
         }
      }
      //next we solve for the 3 X 3 squares
      int x0 = (x/3)*3;
      int y0 = (y/3)*3;
      
      for(int i = 0; i < 3; i++){
         for(int j = 0; j < 3; j++){
            if(grid[y0+i][x0+j] == n){ //compare n value to values within square
               return false;
            }
         }
      }
      return true;
    }
    
    static void printGrid(){
      for(int y = 0; y < 9; y++){
         for(int x = 0; x < 9; x++){
            System.out.print("[" + grid[y][x] + "]");
         }
         System.out.println();
      }
    }
    
    public static void main(String[] args){
      solve();
    }
}
