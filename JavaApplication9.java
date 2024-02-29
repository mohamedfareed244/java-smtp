package javaapplication9;

import java.util.Scanner;

public class JavaApplication9
{
public static void main(String args[]) throws  Exception
{
   
          Scanner in =new Scanner(System.in);
            System.out.println("enter the sender email : ");
            String sen=in.nextLine();
             System.out.println("enter the sender password : ");
              // enter your authentication code from google not normal passcode 
            String pass=in.nextLine();
            System.out.println("enter the reciever email : ");
            String rec=in.nextLine();
            System.out.println("enter the message subject ");
            String head=in.nextLine();
            System.out.println("enter the message body ");
            String body =in.nextLine();
           
JavaMail.sendMail(sen,pass,rec, head, body);
           
}
}
