/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examencliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author alumno
 */
public class Examencliente {

    public static void main(String[] args)  throws IOException{    
        String host = "localhost";
        int port = 1234;
        
        
        try (Socket socket = new Socket(host, port)) {
            System.out.println("Conectado al servidor " + host + " en el puerto " + port + ".");

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            String answer = input.readLine();
            String ip1 = answer.split("|")[0];
            String ip2 = answer.split("|")[1];
            Ipv4Adress dir = new Ipv4Adress(ip1.split("/")[0], ip1.split("/")[1]);
            Ipv4Adress dir2 = new Ipv4Adress(ip2.split("/")[0], ip2.split("/")[1]);

            while (true) {
                    String resultado1 = dir.getDecimalMask();
                    String resultado2 = dir2.getDecimalMask();

                    if (resultado1.equals(resultado2)) {
                        output.println("Tienen la mis dirección de red");
                    } else if (resultado1 != resultado2) {
                        output.println("No tienen la mis dirección de red");
                    } else {
                        output.println("Fin de la conexión");
                        break; 
                    }
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}