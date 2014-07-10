/**
 * Created with IntelliJ IDEA.
 * User: samweli
 * Date: 7/9/14
 * Time: 9:49 PM
 * To change this template use File | Settings | File Templates.
 *
 */

import java.awt.*;
import java.awt.event.*;

public class CalculatorView extends Frame implements ActionListener,TextListener {

    TextArea textArea;
    Panel upperPanel;
    Panel lowerPanel;
    Button [][] listOfButtonsArray;
    Operation operation;

    public CalculatorView(String title){

        super(title);
        setLayout(new GridLayout(2,1));
        setSize(350,370);


        /*
          creating the upper frame which will contain the textarea for input
          calculations
        */
        upperPanel = new Panel(new FlowLayout(FlowLayout.CENTER,0,0));

        /*
          this panel will contain buttons for input operand and operations
        */

        lowerPanel = new Panel(new GridLayout(4,4,0,0));

        textArea = new TextArea("",5,42,TextArea.SCROLLBARS_NONE);
        textArea.addTextListener(this);
        upperPanel.add(textArea);
        listOfButtonsArray = new Button[4][7];

        createButtons(listOfButtonsArray);
        addButtonsToPanel(listOfButtonsArray,lowerPanel);



        operation = new Operation();

        add(upperPanel);
        add(lowerPanel);
        setVisible(true);


    }
    /*
        method for initializing button setting
    */


    private void createButtons(Button[][] listOfButtonsArray){

        Button numberButton;

        int buttonNumber = 9;
        /*
          adding buttons attached with action listener and
           with numbers from 9 to 0 into the button array
         */
        for(int i = 0; i < 4; i++){
            for(int j =0 ;j < 7;j++){
                if(j < 3){
                    numberButton = new  Button(String.valueOf(buttonNumber));
                    numberButton.addActionListener(this);
                    listOfButtonsArray[i][j] = numberButton;
                    buttonNumber--;
                }
            }
        }

        /*
           initialising required buttons
         */
        Button dotButton = new Button(".");
        Button moduloButton = new Button("%");

        Button sumButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplyButton = new Button("*");
        Button divideButton = new Button("/");

        Button absoluteButton = new Button("|x|");
        Button sineButton = new Button("Sin(\u03B8)");
        Button cosineButton = new Button("Cos(\u03B8)");
        Button tangentButton = new Button("Tan(\u03B8)");
        Button naturalLogButton =new Button("ln");
        Button logButton = new Button("log");
        Button squareButton = new Button("X\u00B2");
        Button squareRootButton = new Button("\u221AX");
        Button equalSignButton = new Button("=");

        Button backButton = new Button("<--");
        Button deleteButton = new Button("del");


        /*
           adding action listener to the above declared buttons
         */


        dotButton.addActionListener(this);
        moduloButton.addActionListener(this);

        sumButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        absoluteButton.addActionListener(this);
        sineButton.addActionListener(this);
        cosineButton.addActionListener(this);
        tangentButton.addActionListener(this);
        naturalLogButton.addActionListener(this);
        logButton.addActionListener(this);
        squareButton.addActionListener(this);
        squareRootButton.addActionListener(this);
        equalSignButton.addActionListener(this);

        backButton.addActionListener(this);
        deleteButton.addActionListener(this);

        /*
          assigning buttons to the button array
         */

        listOfButtonsArray[0][3] = sumButton;
        listOfButtonsArray[0][4] = sineButton;
        listOfButtonsArray[0][5] = absoluteButton;
        listOfButtonsArray[0][6] = backButton;
        listOfButtonsArray[1][3] = subtractButton;
        listOfButtonsArray[1][4] = cosineButton;
        listOfButtonsArray[1][5] = squareButton;
        listOfButtonsArray[1][6] = deleteButton;
        listOfButtonsArray[2][3] = multiplyButton;
        listOfButtonsArray[2][4] = tangentButton;
        listOfButtonsArray[2][5] = squareRootButton;
        listOfButtonsArray[2][6] = new Button(" ");
        listOfButtonsArray[3][1] = dotButton;
        listOfButtonsArray[3][2] = moduloButton;
        listOfButtonsArray[3][3] = divideButton;
        listOfButtonsArray[3][4] = naturalLogButton;
        listOfButtonsArray[3][5] = logButton;
        listOfButtonsArray[3][6] = equalSignButton;
    }
    private void addButtonsToPanel(Button [][] listOfButtonsArray,Panel panel) {
        for(int i = 0; i < 4; i++){
            for(int j =0 ;j < 7;j++){
                if(listOfButtonsArray[i][j] != null){
                    panel.add(listOfButtonsArray[i][j]);
                }
            }
        }
    }

    public void actionPerformed(ActionEvent ae){

        long firstNumber;
        long secondNumber;

        long result;

        String operation;
        String numbers = "0123456789";
        String operands = "+-*/%.";
        String trig = "SinCosTanlnlog";
        String textAreaString;

        /*the following if statement check if the button
          clicked is a number button
         */
        if(numbers.contains(ae.getActionCommand())){
            firstNumber = Integer.parseInt(ae.getActionCommand());
            textArea.append(ae.getActionCommand());
        }
        else if(operands.contains(ae.getActionCommand())){
            textArea.append(ae.getActionCommand());
        }
        else if(ae.getActionCommand().equals("<--")){
            textArea.setText(textArea.getText().substring(0,textArea.getText().length() - 1));
        }
        else if(ae.getActionCommand().equals("Sin(\u03B8)")){
            textArea.setText("Sin");
        }
        else if(ae.getActionCommand().equals("Cos(\u03B8)")){
            textArea.setText("Cos");
        }
        else if(ae.getActionCommand().equals("Tan(\u03B8)")){
            textArea.setText("Tan");
        }
        else if(ae.getActionCommand().equals("log")){
            textArea.setText("log");
        }
        else if(ae.getActionCommand().equals("ln")){
            textArea.setText("ln");
        }
        else if(ae.getActionCommand().equals("|x|")){
            textArea.setText(this.operation.abs(textArea.getText()));
        }
        else if(ae.getActionCommand().equals("X\u00B2")){
            textArea.setText(this.operation.sqr(textArea.getText()));
        }
        else if(ae.getActionCommand().equals("\u221AX")){
            textArea.setText(this.operation.sqrt(textArea.getText()));
        }
        else if(ae.getActionCommand().equals("del")){
            textArea.setText("");
        }


        else if(ae.getActionCommand().equals("=")){

            if(textArea.getText().contains("*")){
                textArea.setText(this.operation.multiply(textArea.getText()));
            }
            else if(textArea.getText().contains("/")){
                textArea.setText(this.operation.divide(textArea.getText()));
            }
            else if(textArea.getText().contains("%")){
                textArea.setText(this.operation.modulo(textArea.getText()));
            }
            else if(textArea.getText().contains("+")){
                textArea.setText(this.operation.add(textArea.getText()));
            }
            else if(textArea.getText().contains("-") && !(trig.contains(textArea.getText().substring(0,textArea.getText().indexOf("-"))))){
                textArea.setText(this.operation.subtract(textArea.getText()));
            }
            else if(textArea.getText().contains("ln")){
                textArea.setText(this.operation.logE(textArea.getText()));
            }
            else if(textArea.getText().contains("log")){
                textArea.setText(this.operation.log(textArea.getText()));
            }
            else if(textArea.getText().contains("Sin")){
                textArea.setText(this.operation.sin(textArea.getText()));
            }
            else if(textArea.getText().contains("Cos")){
                textArea.setText(this.operation.cos(textArea.getText()));
            }
            else if(textArea.getText().contains("Tan")){
                textArea.setText(this.operation.tan(textArea.getText()));
            }
        }
    }
    public void textValueChanged(TextEvent te){
        String textAreaString = textArea.getText();
        int count;
        int indexOfLastAction;

        /* following if statements check if there are more than
          one same operator in the input then add first expression
         */

        if(textAreaString.contains("+")){

            count = textAreaString.length() - textAreaString.replace("+", "").length();

            if(count == 2){
                indexOfLastAction = textAreaString.lastIndexOf('+');

                textArea.setText(this.operation.add(textAreaString.substring(0,indexOfLastAction))+"+");
            }
        }
        else if(textAreaString.contains("-")){
            count = textAreaString.length() - textAreaString.replace("-", "").length();


            if(count == 2){
                indexOfLastAction = textAreaString.lastIndexOf('-');

                textArea.setText(this.operation.subtract(textAreaString.substring(0,indexOfLastAction))+"-");
            }
        }
        else if(textAreaString.contains("*")){
            count = textAreaString.length() - textAreaString.replace("*", "").length();


            if(count == 2){
                indexOfLastAction = textAreaString.lastIndexOf('*');

                textArea.setText(this.operation.multiply(textAreaString.substring(0,indexOfLastAction))+"*");
            }
        }
        else if(textAreaString.contains("/")){
            count = textAreaString.length() - textAreaString.replace("/", "").length();


            if(count == 2){
                indexOfLastAction = textAreaString.lastIndexOf('/');

                textArea.setText(this.operation.divide(textAreaString.substring(0,indexOfLastAction))+"/");
            }
        }
    }

}
