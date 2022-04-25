/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automacellulare;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Paolo
 */
public class AutomaCellulare extends Application {
   
/**
 * Dimensione scena 600x600
 * Dimensione rettancogolo 8x8
 * Dimensione init 75
 */
    @Override
    public void start(Stage stage) throws InterruptedException {
        int[] init = new int[100];
        for(int i=0; i < 100;i++){
            init[i] = 0;
        }
        init[38] = 1;
//        int[] path ={0,1,1,1,1,1,0,1,0};   //190  
//        int[] path ={0,1,1,1,1,0,1,1,0};   //222  
        int[] path ={0,1,1,1,1,0,0,0,0};   //30   
//        int[] path ={1,0,1,0,0,0,1,0,0}; //69
//        int[] path ={1,0,0,0,1,0,0,0,0}; 
        Automa automa = new Automa(path,init);
        GridPane griglia = new GridPane();
//        Scene scene = new Scene(griglia, 800, 800);
        stage.setTitle("AutomaCellulare!");
        //r aumento con la generazioni
        Scene scene = new Scene(griglia,800,800);
        for(int r=0; r < 90;r++){
            //calcoliamo l'evoluzione
            automa.calcolaGenerazione();
            init = automa.getGenerazione();
            //stampiamo a video il risultato
            for(int w=0; w < 100;w++){
//                Thread.sleep(50);
               //se ho un 1 allora mostro il rettangolo
                if(init[w]==1)
                    griglia.add(new Rectangle(8,8), w, r);
                else
                    griglia.add(new Rectangle(8,8,Color.TRANSPARENT), w, r);
            }
        }
        stage.setScene(scene);
        stage.show();

    }
//        Button btn = new Button();
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
