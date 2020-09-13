
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Himanshu
 */
public class server {
    public static void main(String[] args){
        try{
            ServerSocket so=new ServerSocket(2222);
            Socket s=so.accept();
            DataInputStream dsin=new DataInputStream(s.getInputStream());
            DataOutputStream dsout=new DataOutputStream(s.getOutputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String msgin="",msgout="";
            while(!msgin.equals("end")){
                msgin=dsin.readUTF();
                System.out.println(msgin);
                msgout=br.readLine();
                dsout.writeUTF(msgout);
                dsout.flush();
            }
            s.close();
            
        }catch(IOException e){
            
        }
    }
    
}
