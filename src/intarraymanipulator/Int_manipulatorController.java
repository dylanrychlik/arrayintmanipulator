/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intarraymanipulator;

import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class Int_manipulatorController implements Initializable {
//Dylan Rychlik
//This program take an array of ints and manipulates them via an fxml controller. 
    @FXML
    private TextArea header;
    @FXML
    private TextArea field;
    @FXML
    private TextField input;
    int num;

    @FXML
    private TextField input2;
    @FXML
    private Button button;
    @FXML
    private Button button2;
    @FXML
    private Button sizearray;
    @FXML
    private Button first_element;
    @FXML
    private Button last_element;

    @FXML
    private Button sum;
    @FXML
    private Button mulplication;
    @FXML
    private Button mean;
    @FXML
    private Button Median;

    @FXML
    private Button sort;
    @FXML
    private Button largest;
    @FXML
    private Button smallest;
    @FXML
    private Button reverse;

    @FXML
    private Button duplicate;
    @FXML
    private Button EEFL;
    @FXML
    private Button odd;
    @FXML
    private Button even;

    @FXML
    private TextArea output;
    @FXML
    private TextArea options;
    int arr[];
    int num2;
    int x = 0;

    public Int_manipulatorController() {
        this.button2 = new Button();
        this.sizearray = new Button();
        this.first_element = new Button();
        this.last_element = new Button();

        this.sum = new Button();
        this.mulplication = new Button();
        this.mean = new Button();
        this.Median = new Button();

        this.sort = new Button();
        this.largest = new Button();
        this.smallest = new Button();
        this.reverse = new Button();

        this.duplicate = new Button();
        this.EEFL = new Button();
        this.odd = new Button();
        this.even = new Button();

    }
//initialize fxml window
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        options.setText("Enter the numbers. \n After you enter the numbers, \n please pick an array \n manipulation to perform:");
        sizearray.setText("Print size of array");
        EEFL.setText("Print everything execpt \n first and last elements.");
        options.getText();
        header.getText();
        field.getText();
        input.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {

                    input.setText(newValue.replaceAll("[^\\d]", ""));
                } else {

                    validate_numbers();
                }
            }
        });
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                arr = intialize_array();

            }
        });

        input2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {

                    input2.setText(newValue.replaceAll("[^\\d]", ""));

                } else {

                    input_number();
                }

            }
        });

    }
//validate the size of the array
    public void validate_numbers() {
        String outputstring = " ";
        try {
            num = Integer.parseInt(input.getText());
            if (num > 20 || num < 1) {
                outputstring = "Number is too big or too small";

                output.setText(outputstring);
            }

        } catch (NumberFormatException e) {
            outputstring = "That is not an integer, please try again.";

            output.setText(outputstring);
        }
    }
//this function inputs the array
    public void input_number() {
        try {
            input2.setOnKeyReleased(event -> {
                if (event.getCode() == KeyCode.ENTER) {

                    num2 = Integer.parseInt(input2.getText());
                    arr[x] = num2;

                    x++;
                    input2.clear();
                }

            });
        } catch (InputMismatchException e) {
            String outputstring = " ";
            outputstring = "That is not an integer, please try again.";

            output.setText(outputstring);
        }
    }
//this function returns the size of the array
    public void sizeofarray() {
        if (arr == null){
             String outputstring = "Array is empty!";

            output.setText(outputstring);
        } else {
            int x = array_size();
            String outputstring = "The size of array is: \n " + x;

            output.setText(outputstring);
        }
    }
//this function gets the size of the array
    public int array_size() {

        int x = arr.length;

        return x;
    }
//this functions calls the first element
    public void first_element_caller() {
        try {
            int x = first_element(arr);
            String outputstring = "The first element of array is: \n " + x;

            output.setText(outputstring);
        } catch (NullPointerException x) {
            String outputstring = "Error: You didn't input the numbers in the array ";

            output.setText(outputstring);
        }
    }
    //this function calls the largest element 
     public void  largest_element_caller() {
        try {
            int x =  largest_element(arr);
            String outputstring = "The largest element of array is: \n " + x;

            output.setText(outputstring);
        } catch (NullPointerException x) {
            String outputstring = "Error: You didn't input the numbers in the array ";

            output.setText(outputstring);
        }
    }
     //this functions gets the largest element
public int largest_element(int arr[]){
    int result = 0,temp = 0;
    for (int i = 0; i < arr.length; i++){
        if (i == 0){
            temp = arr[i];
        }
        else if (arr[i] > arr[i-1]){
            temp = arr[i];
        }
       
    }
     result = temp;
    return result;
}
     //this functions calls the smallest element
     public void  smallest_element_caller() {
        try {
            int x =  smallest_element(arr);
            String outputstring = "The smallest element of array is: \n " + x;

            output.setText(outputstring);
        } catch (NullPointerException x) {
            String outputstring = "Error: You didn't input the numbers in the array ";

            output.setText(outputstring);
        }
    }
       //this functions gets the smallest element
public int smallest_element(int arr[]){

    int temp = arr[0];
      for (int i = 1; i < arr.length; i++){
        
        if (arr[i] < temp) {
               temp = arr[i];
            }
       
    }
   
    return temp;
}
    //this functions gets the first element
    public int first_element(int arr[]) {

        int x;
        int temp = 0;
        int result = 0;

        for (x = arr.length - 1; x >= 0; x--) {
            temp = arr[x];
        }
        result = temp;

        return result;
    }
    //this functions calls the last element
    public void last_element_caller() {
        try {
            int x = last_element(arr);
            String outputstring = "The first element of array is: \n " + x;

            output.setText(outputstring);
        } catch (NullPointerException x) {
            String outputstring = "Error: You didn't input the numbers in the array ";

            output.setText(outputstring);
        }
    }
    //this functions gets the last element
    public int last_element(int arr[]) {

        int x;
        int temp = 0;
        int result = 0;

        for (x = 0; x < arr.length; x++) {
            temp = arr[x];
        }
        result = temp;

        return result;
    }
    //this functions calls the sum of array
    public void sum_caller() {
        try {
            int x = sum(arr);
            String outputstring = "The sum  of the array is: \n " + x;

            output.setText(outputstring);
        } catch (NullPointerException x) {
            String outputstring = "Error: You didn't input the numbers in the array ";

            output.setText(outputstring);
        }
    }
    //this functions gets the sum of array
    public int sum(int arr[]) {

        int x;
        int temp = 0;
        int result;

        for (x = 0; x < arr.length; x++) {
            temp = temp + arr[x];
        }
        result = temp;
        return result;
    }
//this functions calls the medium of array
    public void medium_caller() {
        try {
            double x = medium(arr);
            String outputstring = "The medium of the array is: \n " + x;

            output.setText(outputstring);
        } catch (NullPointerException x) {
            String outputstring = "Error: You didn't input the numbers in the array ";

            output.setText(outputstring);
        }
    }
//this function gets the medium of array
    public double medium(int arr[]) {
        sort(arr);
        int x;
        double temp = 0;
        double result = 0;

        if (arr.length % 2 != 0) {
            for (x = 0; x < arr.length - 1; x++) {
                for (int i = arr.length - 1; i > x; i--) {
                    temp = arr[x];
                }
                result = temp;

            }
        } else {

            temp = ((double) arr[arr.length / 2] + (double) arr[arr.length / 2 - 1]) / 2;

            result = temp;

        }

        return result;
    }
//this function calls the sort for array
    public void sort_caller() {
        try {

            sort(arr);
            printArray(arr);

        } catch (NullPointerException x) {
            String outputstring = "Error: You didn't input the numbers in the array ";

            output.setText(outputstring);
        }
    }
//this functions sorts the array in assending order
    void sort(int arr[]) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Prints the array
    void printArray(int arr[]) {
        int n = arr.length;
        String outputstring = "The sorted array is: \n";
        for (int i = 0; i < n; ++i) {
            outputstring += arr[i] + "\n";

            output.setText(outputstring);
        }
    }
//this function calls the mean of array
    public void mean_caller() {
        try {
            double x = mean(arr);
            String outputstring = "The mean of the array is: \n " + x;

            output.setText(outputstring);
        } catch (NullPointerException x) {
            String outputstring = "Error: You didn't input the numbers in the array ";

            output.setText(outputstring);
        }
    }
//this function calculates the mean of array
    public double mean(int arr[]) {

        int x;
        double temp = 0;
        double result;

        for (x = 0; x < arr.length; x++) {
            temp = temp + arr[x];
        }
        result = temp / arr.length;
        return result;
    }
//this funcion calls the product of array
    public void product_caller() {
        try {
            int x = product(arr);
            String outputstring = "The product of the array is: \n " + x;

            output.setText(outputstring);
        } catch (NullPointerException x) {
            String outputstring = "Error: You didn't input the numbers in the array ";

            output.setText(outputstring);
        }
    }
//this function calculates the product
    public int product(int arr[]) {

        int x;
        int temp = 0;
        int result;

        for (x = 0; x < arr.length; x++) {
            if (temp == 0) {
                temp = arr[x];
            } else {
                temp = temp * arr[x];
            }
        }
        result = temp;
        return result;

    }
//this function prints the array
    public void PrintList() {
        try {
            String outputstring = " ";
            outputstring += "Size of array:" + arr.length + " \n";
            outputstring += "The numbers in the array are: \n";

            for (int x = 0; x < arr.length; x++) {

                outputstring += arr[x] + " \n";

            }

            output.setText(outputstring);
        } catch (NullPointerException x) {
            String outputstring = "Error: You didn't input the numbers in the array ";

            output.setText(outputstring);
        }

    }
    //this function reverses the array
      public void reversearray() {
        try {
            String outputstring = " ";
          
            outputstring += "The numbers in the array reversed are: \n";

            for (int x = arr.length; x > 0; x--) {

                outputstring += arr[x -1] + " \n";

            }

            output.setText(outputstring);
        } catch (NullPointerException x) {
            String outputstring = "Error: You didn't input the numbers in the array ";

            output.setText(outputstring);
        }

    }
      //this functions clears the array
       public void cleararray() {
           try {
        if (arr.length == 0){
            String outputstring = "Error: Array already empty ";

            output.setText(outputstring); 
        }
        else {  
         // setting the array to null
arr = null;

// removing all array entries, making an array of size 0
arr = new int[0];
// keeping the array the same size, but making all values = null
arr= new int[arr.length];
              String outputstring = "Success! Array is now empty! ";

            output.setText(outputstring);
          
        } }
        catch (NullPointerException x) {
            String outputstring = "Error: Array already empty ";

            output.setText(outputstring);
        }

    }
       //this functions finds the duplicates of the array
 public void duplicatearray() {
        try {
            String outputstring = " ";
          
            outputstring += "The Duplicate Elements are: \n";

            for (int x = 0; x < arr.length; x++) {
for(int j = x+1;j < arr.length; j++) {
    if ((arr[x] == arr[j]) && (x != j)) {
                outputstring += "Duplicate Element : "+ arr[j] + "\n";

}
}
            }

            output.setText(outputstring);
        } catch (NullPointerException x) {
            String outputstring = "Error: You didn't input the numbers in the array ";

            output.setText(outputstring);
        }

    }
 //this function prints everything expect first and last element. 
  public void EEFLE() {
      try {
            String outputstring = " ";
          
            outputstring += "The numbers in the array execpt the first and last are: \n";

            for (int x = 1; x < arr.length -1; x++) {
                outputstring +=  arr[x] + "\n";
            }


            output.setText(outputstring);
        } catch (NullPointerException x) {
            String outputstring = "Error: You didn't input the numbers in the array ";

            output.setText(outputstring);
        } 
    }
 //this functions prints the even of array
    public void even() {
      try {
            String outputstring = " ";
          
            outputstring += "The even numbers in the array are: \n";

            for (int x = 0; x < arr.length; x++) {
                if (arr[x] %2 == 0){
                outputstring +=  arr[x] + "\n";
            }
            }

            output.setText(outputstring);
        } catch (NullPointerException x) {
            String outputstring = "Error: You didn't input the numbers in the array ";

            output.setText(outputstring);
        } 
    }
     //this functions prints the odd of array
      public void odd() {
     try {
            String outputstring = " ";
          
            outputstring += "The odd numbers in the array are: \n";

            for (int x = 0; x < arr.length; x++) {
                if (arr[x] %2 != 0){
                outputstring +=  arr[x] + "\n";
            }
            }

            output.setText(outputstring);
        } catch (NullPointerException x) {
            String outputstring = "Error: You didn't input the numbers in the array ";

            output.setText(outputstring);
        } 
    }
      //this functiion intializes array
    public int[] intialize_array() {

        arr = new int[num];

        output.clear();
        return arr;
    }

}
