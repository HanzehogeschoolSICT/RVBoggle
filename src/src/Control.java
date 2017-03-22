import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;

/**
 * Created by RonOS on 3/20/2017.
 */
public class Control {

    private Model model;
    @FXML
    private GridPane grid;
    @FXML
    private MenuBar menu;



    public void initialize() {
        model = new Model(8);
        for(int k = 0; k < model.board.length; k++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100 / model.board.length);
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100 / model.board.length);
            grid.getColumnConstraints().add(column);
            grid.getRowConstraints().add(row);
        }
        populateGrid();
    }

    public void populateGrid() {
        for(int i = 0; i < model.board.length; i++) {
            for(int j = 0; j < model.board[i].length; j++) {
                String character = Character.toString(model.board[i][j]);
                Label label = new Label(character);
                label.setAlignment(Pos.CENTER);
                label.setPrefSize(10,10);
                GridPane.setHalignment(label, HPos.CENTER);
                grid.add(label, i, j);
            }
        }
        grid.setGridLinesVisible(true);
    }

    public void reset() {
        model.populateBoard();
        grid.getChildren().clear();
        populateGrid();
    }

    public void resetVisited() {
        for(int i = 0; i < model.board.length; i++) {
            for(int j = 0; j < model.board[i].length; j++) {
                model.visited[i][j] = false;
            }
        }
    }

    public void scan() {
        for(int i = 0; i < model.board.length; i++) {
            for(int j = 0; j < model.board[i].length; j++) {
                findWords(i, j, "");
                resetVisited();
            }
        }
        System.out.println("Done searching:");
        for (String word : model.words) {
            System.out.println(word);
        }
    }

    public void findWords(int x, int y, String word) {
        try {
            word = word + model.board[x][y];
            if(model.visited[x][y]) {
                return;
            }
            model.visited[x][y] = true;
        }

        catch (IndexOutOfBoundsException ex) {
            return;
        }

        boolean startsWith = false;
        for (int i = 0; i < model.checkList.size(); i++) {
            String checkString = model.checkList.get(i);
            if(word.equalsIgnoreCase(checkString)) {
                model.words.add(word);
            }

            if(checkString.startsWith(word)) {
                startsWith = true;
            }
        }

        if(startsWith) {
            findWords(x+1, y, word);
            findWords(x, y+1, word);
            findWords(x-1, y, word);
            findWords(x, y-1, word);
            findWords(x+1, y+1, word);
            findWords(x-1, y-1, word);
            findWords(x-1, y+1, word);
            findWords(x+1, y-1, word);
        }

        else {
            return;
        }

    }
}
