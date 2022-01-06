import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException
    {
            char operator;
            float  temp, num1, num2;
            Scanner inp = new Scanner(System.in);
            Socket s = new Socket("192.168.50.42",8080);
            
            PrintWriter pr = new PrintWriter(s.getOutputStream());
            pr.println("Hello, I can connected!!");
            pr.flush();
            
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            
            String str = bf.readLine();
            System.out.println("Server : "  + str);
    
            Scanner sc1 = new Scanner(s.getInputStream());
            PrintStream p = new PrintStream(s.getOutputStream());
            System.out.print("Choose an operator: +, -, *, or /: ");
            operator = inp.next().charAt(0);
            p.println(operator);
            System.out.print("Enter first number: ");
            num1 = inp.nextFloat();
            p.println(num1);
            System.out.print("Enter second number: ");
            num2 = inp.nextFloat();
            p.println(num2);
            System.out.print("Result: " + num1 + " " + operator + " " + num2 + "  =  ");
            temp = sc1.nextFloat();
            System.out.println(temp);
    
            inp.close();
            s.close(); 
    }
}
