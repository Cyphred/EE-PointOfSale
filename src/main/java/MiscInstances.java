package main.java;

import main.java.data.DatabaseHandler;
import main.java.misc.SceneManipulator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MiscInstances {
    public DatabaseHandler dbHandler;
    public SceneManipulator sceneManipulator;

    public MiscInstances() {
        sceneManipulator = new SceneManipulator();
        instantiateDBHandler();
    }

    private void instantiateDBHandler(){
        String url,uname,password;
        try {
            Scanner textScan = new Scanner(
                    new FileInputStream("etc\\Connection.properties"));
            url = textScan.nextLine();
            uname = textScan.nextLine();
            password = textScan.nextLine();
            dbHandler= new DatabaseHandler(url,uname,password);// initializing the DatabaseHandler
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}