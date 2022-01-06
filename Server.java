import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Server {
    public static void main(String[] args) throws IOException
    {
        char operator;
        float num1, num2, result;
        ServerSocket s1 = new ServerSocket(8080);
        Socket ss = s1.accept();
        
        System.out.println("Client connected");
        
        InputStreamReader in = new InputStreamReader(ss.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        
        String str = bf.readLine();
        System.out.println("Client : " + str);
        
        PrintWriter pr = new PrintWriter(ss.getOutputStream());
        pr.println("Hello, You can connected :) ");
        pr.flush();
        
        Scanner inp = new Scanner(ss.getInputStream());
        operator = inp.next().charAt(0);
        num1 = inp.nextFloat();
        num2 = inp.nextFloat();
        
        PrintStream p = new PrintStream(ss.getOutputStream());
        
        switch (operator) {
        
        
        // performs addition between numbers
        case '+':
            result = num1 + num2;
            System.out.print( "Calculated for clients: " + num1 + " + " + num2 + " = " + result + "\n" );
            p.println(result);
            break;

        // performs subtraction between numbers
        case '-':
            result = num1 - num2;
            System.out.print( "Calculated for clients: " + num1 + " - " + num2 + " = " + result + "\n" );
            p.println(result);
            break;

        // performs multiplication between numbers
        case '*':
            result = num1 * num2;
            System.out.print( "Calculated for clients: " + num1 + " * " + num2 + " = " + result + "\n" );
            p.println(result);
            break;

        // performs division between numbers
        case '/':
            result = num1 / num2;
            System.out.print( "Calculated for clients: " + num1 + " / " + num2 + " = " + result + "\n" );
            p.println(result);
            break;

        default:
            System.out.println("Invalid operator!");
            break;
        }
        
        s1.close();

    } 
}