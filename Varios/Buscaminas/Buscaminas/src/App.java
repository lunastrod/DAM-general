import java.util.Scanner;
import com.dam.pojo.Board;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        Board b=new Board(Board.BEGINNER);

        boolean gameOver=false;
        while(!gameOver){
            System.out.println(b.toString());
            System.out.println("Enter row and column to reveal (e.g., '3 4'):");
            int row=sc.nextInt();
            int col=sc.nextInt();
            sc.nextLine(); // consume newline
    
            gameOver=b.reveal(row, col);
            if(gameOver){
                System.out.println("Game Over!");
                System.out.println(b.toStringNoFog()); // show all cells
            }
        }

    }
}
