 import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener{

    JFrame jframe;
    JTextField jTextField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton add,sub,div,mul;
    JButton dec,equ,del,clr,neg;
    JPanel jpanel;

    double num1=0,num2=0;
    char operator;

    Calculator(){
        jframe = new JFrame("Calculator");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(400,600);
        jframe.setLayout(null);

        jTextField = new JTextField();
        jTextField.setBounds(50,25,300,50);

        jTextField.setEditable(false);
        jframe.add(jTextField);

        add = new JButton("+");
        sub = new JButton("-");
        div = new JButton("/");
        mul = new JButton("*");
        dec = new JButton(".");
        equ = new JButton("=");
        del = new JButton("delete");
        clr = new JButton("clear");
        neg = new JButton("(-)" );

        functionButtons[0] = add;
        functionButtons[1] = sub;
        functionButtons[2] = div;
        functionButtons[3] = mul;
        functionButtons[4] = dec;
        functionButtons[5]  = equ;
        functionButtons[6] = del;
        functionButtons[7] = clr;
        functionButtons[8] = neg;
        
        for(int i=0;i<9;i++){
            functionButtons[i].addActionListener((this));
            functionButtons[i].setFocusable(false);
        }

        for(int i=0;i<10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }
   jpanel = new JPanel();
  jpanel.setBounds(50,100,300,300);
  jpanel.setLayout(new GridLayout(4,4,10,10));   
//  jpanel.setBackground(Color.yellow);

  jpanel.add(numberButtons[1]);
  jpanel.add(numberButtons[2]);
  jpanel.add(numberButtons[3]);
  jpanel.add(add);
  jpanel.add(numberButtons[4]);
  jpanel.add(numberButtons[5]);
  jpanel.add(numberButtons[6]);
  jpanel.add(sub);
  jpanel.add(numberButtons[7]);
  jpanel.add(numberButtons[8]);
  jpanel.add(numberButtons[9]);
  jpanel.add(mul);
  jpanel.add(dec);
  jpanel.add(numberButtons[0]);
  jpanel.add(equ);
  jpanel.add(div);


  neg.setBounds(50,430,100,50);
  del.setBounds(150,430,100,50);
  clr.setBounds(250,430,100,50);
        jframe.add(jpanel);
        jframe.add(neg);
        jframe.add(del);
        jframe.add(clr);
        jframe.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
       for(int i=0;i<10;i++){
           if(e.getSource() == numberButtons[i]){
               jTextField.setText(jTextField.getText().concat(String.valueOf(i)));
           }
       }

       if(e.getSource() == dec){
           jTextField.setText(jTextField.getText().concat("."));
       }
       if(e.getSource() == add){
        num1 = Double.parseDouble(jTextField.getText());
        operator = '+';
        jTextField.setText("");
       }

       if(e.getSource() == sub){
        num1 = Double.parseDouble(jTextField.getText());
        operator = '-';
        jTextField.setText("");
       }

       if(e.getSource() == mul){
        num1 = Double.parseDouble(jTextField.getText());
        operator = '*';
        jTextField.setText("");
       }

       if(e.getSource() == div){
        num1 = Double.parseDouble(jTextField.getText());
        operator = '/';
        jTextField.setText("");
       }
       if(e.getSource() == clr){
        jTextField.setText("");
       }

       if(e.getSource() == del){
           String str = jTextField.getText();
           jTextField.setText("");
           for(int i=0;i<str.length()-1;i++){
               jTextField.setText(jTextField.getText() + str.charAt(i));
           }
    
       }

       if(e.getSource() == neg){
           double temp = Double.parseDouble(jTextField.getText());
        temp*=-1;
        jTextField.setText(String.valueOf(temp));
 
    }

       if(e.getSource()==equ){
           num2 = Double.parseDouble(jTextField.getText());
double result = 0;
           switch(operator){
               case '+':
               result = num1 + num2;
               break;

               case '-':
               result = num1 - num2;
               break;

               case '*':
               result = num1 * num2;
               break;

               case '/':
               result = num1 / num2;
               break;
           }
           jTextField.setText(String.valueOf(result));
           num1 = result;
       }
        
    }

    public static void main(String[] args){
        Calculator calculator = new Calculator();
    }

    
}
