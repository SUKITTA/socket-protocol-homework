import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

// ClientHandler class 
class ClientHandler extends Thread
{
    DataManager stock = new DataManager();
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;
    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)
    {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run()
    {
        String received;
        String toreturn;

        while (true)
        {
            try {
                dos.writeUTF("--------------------PLEASE ENTER COMMAND--------------------\n"+
                        "CheckStock [C] | AddStuff [A] | RemoveStuff [R] | Exit [E]..\n");

                received = dis.readUTF();

                if(received.equals("E"))
                {
                    System.out.println("Manager " + this.s + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }


                // write on output stream based on the 
                // answer from the client 
                switch (received) {
                    case "C" :
                        toreturn = stock.fileReader();
                        dos.writeUTF(String.valueOf(toreturn));
                        break;

                    case "A" :
                        if ( received.equals(stock.fileReader())){
                            dos.writeUTF("Book failed");
                        } else {
                            dos.writeUTF("Invalid input");
                        }


//                        toreturn = "Fail || Success";
//                        dos.writeUTF(toreturn);
                        break;

                    case "R" :
//                        toreturn = "Fail || Success";
//                        dos.writeUTF(toreturn);
                        break;

                    default:
                        dos.writeUTF("Invalid input");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try
        {
            // closing resources 
            this.dis.close();
            this.dos.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
} 