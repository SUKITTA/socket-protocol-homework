import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

// Client class 
public class Client
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            Scanner scn = new Scanner(System.in);

            // getting localhost ip 
            InetAddress ip = InetAddress.getByName("localhost");

            // establish the connection with server port 5056 
            Socket s = new Socket(ip, 5056);

            // obtaining input and out streams 
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            // the following loop performs the exchange of 
            // information between client and client handler 
            System.out.println("-----------------Hello manager! WELCOME to Pet shop------------------\n\n");
            while (true)
            {
                System.out.println(dis.readUTF());
                String tosend = scn.nextLine();

                if(tosend.equals("C"))
                {
                    dos.writeUTF("C");
                    System.out.println(dis.readUTF());
                }

                if(tosend.equals("E"))
                {
                    System.out.println("Closing this connection : " + s);
                    s.close();
                    System.out.println("Connection closed");
                    break;
                }

                // printing date or time as requested by client 
                String received = dis.readUTF();
                //System.out.println(received.replaceAll("[\\[\\]]", ""));
            }

            // closing resources 
            scn.close();
            dis.close();
            dos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
} 