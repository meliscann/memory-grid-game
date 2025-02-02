package memoryGridGame;

import java.util.Scanner;

interface Identify {  //I use interface to assign references of different objects to an array.
    char whoAmI();
}

class XClosed implements Identify {
    public char whoAmI() {
        return 'X';
    }
} 

class Cup implements Identify {
    public char whoAmI() {
        return 'C';
    }
}

class Ball implements Identify {
    public char whoAmI() {
        return 'B';
    }
}

class Hat implements Identify {
    public char whoAmI() {
        return 'H';
    }
}

class Pen implements Identify {
    public char whoAmI() {
        return 'P';
    }
}

class Unidentified implements Identify {
    public char whoAmI() {
        return 'U';
    }
}


public class MemoryGridGame {
    static Identify grid [][] = new Identify[3][3];  //I defined grid.
    static String order = "CPCHPBUBH";  //I defined the "order" string to be written in the grid.   
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  
        closedGrid(); //The method that opens the cells.
        printXGrid();  //The method that prints the closed grid.
        openingBoxes();  //The method that opens the boxes.
        
        System.out.println("Press enter to close all boxes.");
        input.nextLine();
        
        closedGrid();
        printXGrid();
        
        System.out.println("\n\n\n\n\n\n\n\n");
        
        guess();
    }
    
    public static void closedGrid() { //Method that closes the grid and displays it as X's.
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new XClosed();
            }
        }
    }  
    
    public static void printXGrid() {  //Method that assigns references of classes to the grid.
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j].whoAmI() + " ");
            }
            System.out.println();
        }
    }  
    
    public static void fillGrid() {  //The method that assigns references of objects to elements of the grid.
        int k = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++ ) {
                char letter = order.charAt(k);
                switch (letter) {
                    case 'C':
                        grid[i][j] = new Cup();
                        break;
                    case 'B':
                        grid[i][j] = new Ball();
                        break;
                    case 'H':
                        grid[i][j] = new Hat();
                        break;
                    case 'P':
                        grid[i][j] = new Pen();
                        break;
                    case 'U':
                        grid[i][j] = new Unidentified();
                        break;
                }
                k++;
            }
        }
    }
    
    public static void openingBoxes() {  //The method that allows the user to open the cells one by one and have them play the game.
        Scanner input = new Scanner(System.in);
        fillGrid();
        int opened[][] = new int[3][3];
        for(int i = 0; i < 9; i++) {
            System.out.println("Please enter your row-col location to show. (separated by space or enter)");
            int row = input.nextInt()-1;
            int col = input.nextInt()-1;
            if(row > 3 || col > 3) {  
            	System.out.println("You entered incorrectly.\n");  //If the user logs in incorrectly, they lose 1 right and continue.
            	continue;
            	}

            else { opened[row][col] = 1;
            printOpened(opened);
            }
        }
       
    }
    
    public static void printOpened(int[][] opened) {  //The method that prints the opened grid.
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(opened[i][j] == 1) {
                    System.out.print(grid[i][j].whoAmI() + " ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
    
    public static void guess() {  //The method that makes the user guess
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your guess (like XXXXXXXXX)");
        String guess = input.nextLine();
        
        if(guess.length() != 9) {
            System.out.println("You made a missing keystroke.");

        }
        int correct = 0;
        for(int i = 0; i < 9; i++) {
            if(guess.charAt(i) == order.charAt(i)) {
                correct++;
            }
        }
        
        if(correct >= 4) {
            System.out.println("You remember " + correct + " locations. YOU WIN!");
        }
        else {
        	System.out.println("YOU LOSE. You remembered " + correct + " letters. You had to remember 4 or more to win.");
        }
    }

}


