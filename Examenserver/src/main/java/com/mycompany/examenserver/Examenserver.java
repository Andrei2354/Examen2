/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examenserver;

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
public class Examenserver {

public static void main(String[] args){
        // Puerto del servidor
        Random rand = new Random();
        int port = 1234;

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Servidor iniciado en el puerto " + port + ".");

            while (true) {
                // Aceptar una conexión de un cliente
                Socket client = server.accept();
                System.out.println("Cliente conectado: " + client.getInetAddress());

                // Leer y responder al cliente
                BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter output = new PrintWriter(client.getOutputStream(), true);

            String [] ip = {"192.168.1.8/24|192.168.1.8/24", "192.168.1.8/16|192.168.1.8/16","0.0.0.0/0|0.0.0.0/0"};

            List<String> listaip = Arrays.asList(ip);
            
            int numberOfElements = 2;

            for (int i = 0; i < numberOfElements; i++) {
                int randomIndex = rand.nextInt(listaip.size());
                String randomElement = listaip.get(randomIndex);
                String answer = randomElement;
                output.println(answer);  
            }
                String response = input.readLine();  
                System.out.println("Servidor: " + response);
                
                if ("Fin de la conexión".equals(response)) {
                    System.out.println("Fin de la conexión.");
                    break;
                } 
                else if ("No tienen la mis dirección de red".equals(response)) {
                    System.out.println("No tienen la mis dirección de red");
                } 
                else if ("Tienen la mis dirección de red".equals(response)) {
                    System.out.println("Tienen la mis dirección de red");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
