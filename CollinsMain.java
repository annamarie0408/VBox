//Anna Collins
//8/22/19
//Java Advanced Assignment 1

//I have abide by GTCC Academic Integrity Policy and/or
//that the program is my original work

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;




public class CollinsMain extends Application{

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        // Create a border pane
        BorderPane pane = new BorderPane();
        VBox vbox = new VBox(15); // Create an HBox with 15px spacing
        vbox.setStyle("-fx-background-color: #11f0d8");
        vbox.setPadding(new Insets(20,60,20,60));
        vbox.getChildren().add(new Label("BOOKS"));



        ArrayList<CollinsBook> arrBookList = new ArrayList<>(4);// the array is set to 4 because the text file
        //has f4 lines. This defines the ArrayList using the object CollinsBook

        try { //starting a try, this way the program still executes if the file is missing

            File fileinput = new File("src/CollinsBookData"); //defining the filepath

            Scanner sc = new Scanner(fileinput); //starting scanner


            while (sc.hasNextLine()) { //This will continue till there is no next line

                //defining variables/attributes and reading through the text file and assigning to the right thing
                //this is defined by the space between the items.
                String publisher = sc.next();
                String title = sc.next();
                String ISBN = sc.next();
                String imageName = sc.next();
                Double price = sc.nextDouble();

                //Instantiating the object
                CollinsBook test = new CollinsBook(publisher, title, ISBN, imageName, price);
                arrBookList.add(test); //assigning the newly created object to the ArrayList
            }

            //Reads through the Arraylist arrBookList and prints out each line
            //using the toString override method in the CollinsBook Class
            for (CollinsBook book : arrBookList) {
               vbox.getChildren().add(new Label(book.getTitle()));

             }

            Scene scene = new Scene(vbox);
            primaryStage.setTitle("***Book Titles***"); // Set the stage title
            primaryStage.setScene(scene); // Place the scene in the stage
            primaryStage.show(); // Display the stage

        } catch (FileNotFoundException e) { //if the file is not found it will through this exception adn print it to the console
            System.out.println(e.toString());
        }

    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }


}

