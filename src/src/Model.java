import java.util.Random;

/**
 * Created by RonOS on 3/20/2017.
 */
public class Model {

    public char[][] board;

    public Model(int size) {
        board = new char[size][size];
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
