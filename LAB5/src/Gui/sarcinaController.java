package Gui;
import Controller.Controller;
import Exceptions.MyException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class sarcinaController {
    private SarcinaView sarcinaView;
    private Controller controller;

    public sarcinaController(SarcinaView sarcinaView, Controller controller){
        this.sarcinaView = sarcinaView;
        this.controller = controller;
    }

    public EventHandler<ActionEvent> addButtonHandler(){
        return new EventHandler<ActionEvent>() {
        	
            @Override
            public void handle(ActionEvent event) {
            	
            	 try {
            		 controller.addsarcina (Integer.parseInt(sarcinaView.idText.getText()),
                             sarcinaView.descriereText.getText(),
                             Integer.parseInt(sarcinaView.durataText.getText()));
                 } catch (MyException e) {
                     System.out.println(e.getMessage());
                 }
            	
            	
                

            }
        };
    }
    
    
    
    public EventHandler<ActionEvent> deleteButtonHandler(){
    	 return new EventHandler<ActionEvent>() {
         	
             @Override
             public void handle(ActionEvent event) {
             	
             	 try {
             		 controller.removesarcina (Integer.parseInt(sarcinaView.idText.getText()));
                  } catch (MyException e) {
                      System.out.println(e.getMessage());
                  }
             	
             	
                 

             }
         };
    }
    
    public EventHandler<ActionEvent> updateButtonHandler(){
    	 return new EventHandler<ActionEvent>() {
         	
             @Override
             public void handle(ActionEvent event) {
             	
             	 try {
             		 controller.updatesarcina (Integer.parseInt(sarcinaView.idText.getText()),
                              sarcinaView.descriereText.getText(),
                              Integer.parseInt(sarcinaView.durataText.getText()));
                  } catch (MyException e) {
                      System.out.println(e.getMessage());
                  }
             	
             	
                 

             }
         };
    }
    
    
    
    
    
}