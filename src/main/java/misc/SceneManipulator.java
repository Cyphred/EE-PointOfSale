package main.java.misc;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneManipulator {
    private Scene scene;
    private Stage stage;
    private Parent root;

    /**
     * A Scene Manupulator method that changes the Scene inside the Stage
     * @param rootPane - it is the root node of a the FXML.
     * @param fxmlName - the FXML file name.
     * @param title - to change the Title of the stage
     * */
    public void changeScene(Pane rootPane,String fxmlName,String title){
        root =  getFXML(fxmlName);
        stage = getStage(rootPane);
        stage.setTitle(title);
        scene = new Scene(rootPane,stage.getWidth(),stage.getHeight());
        stage.setScene(scene);
    }

    /**
     * A SceneManipulator method that changes the Window or the Stage
     * @param rootPane - it is the root node of a the FXML.
     * @param fxmlName - the FXML file name.
     * @param title - to change the Title of the stage
     */
    public void changeStage(Pane rootPane,String fxmlName,String title){
        root =  getFXML(fxmlName);
        stage = getStage(rootPane);
        stage.close();
        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    /**
     * A SceneManipulator method that open new Stage without closing the last Stage
     * @param fxmlName - the FXML file name.
     * @param title - to change the Title of the stage
     */
    public void openStage(String fxmlName,String title){
        root = getFXML(fxmlName);
        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    /**
     * A SceneManipulator method for opening FXML inside the Pane
     * @param parent - the anchor where the FXML file to be placed
     * @param fxmlName - the FXML file name.
     */
    public void attachNode(AnchorPane parent,String fxmlName){
        root = getFXML(fxmlName);
        AnchorPane.setBottomAnchor(root,0.0);
        AnchorPane.setLeftAnchor(root,0.0);
        AnchorPane.setRightAnchor(root,0.0);
        AnchorPane.setTopAnchor(root,0.0);
        parent.getChildren().add(root);
    }

    /**
     * To cloase a specific Stage bt passing the rootPane
     * @param rootPane
     */
    public void closeStage(Pane rootPane){
        stage = getStage(rootPane);
        stage.close();
    }

    /**
     * Getting the FXML file and saving it inside a Node
     * @param fxmlName
     * @return it returns the Parent where the fxml files is placed
     */
    private Parent getFXML(String fxmlName){
        try {
            return FXMLLoader.load(getClass().getResource("/"+DirectoryHandler.FXML+fxmlName+".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * To get the Stage where the rootPane is placed
     * @param rootPane
     * @return
     */
    private Stage getStage(Pane rootPane){
        return (Stage) rootPane
                .getScene()
                .getWindow();
    }

}
