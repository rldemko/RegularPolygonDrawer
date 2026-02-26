import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class RegularPolygonDrawer extends Application {

    private Pane drawPane;

    @Override
    public void start(Stage primaryStage) {
        // Window Title 
        primaryStage.setTitle("Regular Polygon Drawer");

        // Load icon from classpath
        Image icon = new Image(getClass().getResourceAsStream("/polygon.png"));
        primaryStage.getIcons().add(icon);

		//Text boxes
        TextField sidesField = new TextField();
        sidesField.setPromptText("Number of sides");
        sidesField.setAccessibleText("Enter number of sides");

        TextField radiusField = new TextField();
        radiusField.setPromptText("Radius length");
        radiusField.setAccessibleText("Enter radius length");
		
		//Color picker does what it says
        ColorPicker colorPicker = new ColorPicker(Color.BLUE);
        colorPicker.setAccessibleText("Choose polygon color");

        Button drawButton = new Button("Draw Polygon");
        drawButton.setAccessibleText("Draw the polygon based on inputs");

        Label errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);
        errorLabel.setAccessibleText("Error message area");

        VBox controls = new VBox(10,
                new Label("Sides:"), sidesField,
                new Label("Radius:"), radiusField,
                new Label("Color:"), colorPicker,
                drawButton, errorLabel);

        drawPane = new Pane();
        drawPane.setPrefSize(500, 500);

        HBox root = new HBox(10, controls, drawPane);

        Scene scene = new Scene(root, 800, 600);

        // Press Enter to draw
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case ENTER:
                    drawPolygon(sidesField, radiusField, colorPicker, errorLabel);
                    break;
                default:
                    break;
            }
        });


		//Press button to draw
        drawButton.setOnAction(e ->
            drawPolygon(sidesField, radiusField, colorPicker, errorLabel)
        );

        primaryStage.setScene(scene);
        primaryStage.show();

        // Start in the sides field
        sidesField.requestFocus();
    }

    private void drawPolygon(TextField sidesField, TextField radiusField,
                             ColorPicker colorPicker, Label errorLabel) {
        drawPane.getChildren().clear();
        errorLabel.setText("");

        int n;
        double r;

        // Validate sides
        try {
            n = Integer.parseInt(sidesField.getText());
            if (n < 3) {
                errorLabel.setText("Must have at least 3 sides.");
                return;
            }
        } catch (Exception e) {
            errorLabel.setText("Invalid number of sides.");
            return;
        }

        // Validate radius
        try {
            r = Double.parseDouble(radiusField.getText());
            if (r <= 0) {
                errorLabel.setText("Radius must be positive.");
                return;
            }
        } catch (Exception e) {
            errorLabel.setText("Invalid radius.");
            return;
        }

        double centerX = drawPane.getWidth() / 2;
        double centerY = drawPane.getHeight() / 2;
		
		//Fit check
        if (r * 2 > Math.min(drawPane.getWidth(), drawPane.getHeight())) {
            errorLabel.setText("Polygon too large for drawing area.");
            return;
        }

        Polygon polygon = new Polygon();
        double theta = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {
            double x = centerX + r * Math.cos(i * theta);
            double y = centerY + r * Math.sin(i * theta);
            polygon.getPoints().addAll(x, y);
        }

        polygon.setFill(colorPicker.getValue());
        polygon.setStroke(Color.BLACK);

        drawPane.getChildren().add(polygon);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
