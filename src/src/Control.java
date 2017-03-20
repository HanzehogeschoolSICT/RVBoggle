import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

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
        populateGrid();
    }

    public void populateGrid() {

        for(int k = 0; k < model.board.length; k++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100 / model.board.length);
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100 / model.board.length);
            grid.getColumnConstraints().add(column);
            grid.getRowConstraints().add(row);
        }

        grid.setGridLinesVisible(true);
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

        grid.setMinSize(0, 0);
    }

}
