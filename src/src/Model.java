import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by RonOS on 3/20/2017.
 */
public class Model {

    public ArrayList<String> words = new ArrayList<String>();

    public ArrayList<String> checkList = new ArrayList<String>();

    public boolean[][] visited;

    public char[][] board;

    public Model(int size) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("C:/Users/RonOS/Documents/MEGA/Projects/RVBoggle/src/src/words.txt"));
            String str;

            while((str = in.readLine()) != null){
                checkList.add(str);
            }
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }

        board = new char[size][size];
        visited = new boolean[size][size];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                visited[i][j] = false;
            }
        }
        populateBoard();
    }

    public void populateBoard() {
        Random r = new Random();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = (char) (r.nextInt(26) + 'a');
            }
        }
    }

}
