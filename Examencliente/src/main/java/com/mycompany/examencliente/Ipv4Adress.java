package com.mycompany.examencliente;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alumno
 */
public class Ipv4Adress {
     //Atributos
    private String IPAddress;
    private String mask;
   
    private String binaryAddress;
   
    private int intMask;
    private String binaryMask;
    private String decimalMask;
    private String CIDRMask;
    
    private String binaryNetwork;
    private String decimalNetwork;
    
    private String binaryBroadCast;
    private String decimalBroadCast;
    
    private String binaryFirdtHost;
    private String decimalFirdtHost;
    
    private String binaryFinalHost;
    private String decimalFinalHost;
    
    private double maxHost;
    
    private String typeRed;
    
// Constructor

    public Ipv4Adress(String IPAddress, String mask) {
        this.IPAddress = IPAddress;
        this.mask = mask;
       
        this.binaryAddress = IPAddressToBinary();
       
        this.intMask = Integer.valueOf(mask);
        this.binaryMask = "1".repeat(intMask) + "0".repeat(32 - intMask);
        this.decimalMask = binaryToDecimal(binaryMask);
        this.CIDRMask = "/" + intMask;
        
        this.binaryNetwork = binaryAddress.substring(0, intMask) + "0".repeat(32 - intMask);
        this.decimalNetwork = binaryToDecimal(binaryNetwork);
        
        this.binaryBroadCast = binaryAddress.substring(0, intMask) + "1".repeat(32 - intMask);
        this.decimalBroadCast = binaryToDecimal(binaryBroadCast);
        
        this.binaryFirdtHost = binaryAddress.substring(0, 31) + "1";
        this.decimalFirdtHost = binaryToDecimal(binaryFirdtHost);
        
        this.binaryFinalHost = binaryAddress.substring(0, 31) + "1".repeat(32 - 1);
        this.decimalFinalHost = binaryToDecimal(binaryFinalHost);
        
        this.maxHost = Math.pow(2, 32 - intMask) - 2;
        
        
        
    }

    public String getIPAddress() {
        return IPAddress;
    }
    public String getBinaryAddress() {
        return binaryNotation(binaryAddress);
    }
    public String getBinaryMask() {
        return binaryNotation(binaryMask);
    }
    public String getDecimalMask() {
        return decimalMask;
    }
    public String getCIDRMask() {
        return CIDRMask;
    }
    public String getbinaryNetwork() {
        return binaryNetwork;
    }
    public String getdecimalNetwork() {
        return decimalNetwork;
    }
    public String getbinaryBroadCast() {
        return binaryBroadCast;
    }
    public String getdecimalBroadCast() {
        return decimalBroadCast;
    }
    public String getbinaryFirdtHost() {
        return binaryFirdtHost;
    }
    public String getdecimalFirdtHost() {
        return decimalFirdtHost;
    }
    
    public String getbinaryFinalHost() {
        return binaryFinalHost;
    }
    public String getdecimalFinalHost() {
        return decimalFinalHost;
    }
    public double getMaxhost() {
        return maxHost;
    }
   
    // Pasar una direccion a binario
    private String IPAddressToBinary() {
        String result = "";
        String[] octets = IPAddress.split("\\.");
        for (String octet : octets) {
            result += String.format("%8s", Integer.toBinaryString(Integer.valueOf(octet))).replace(" ", "0");
        }
        return binaryNotation(result);
    }
    // Mostrar una direccion de 32 bits en grupos de 8
    private String binaryNotation(String binary) {
        return binary.substring(0, 8) + "." +
                binary.substring(8, 16) + "." +
                binary.substring(16, 24) + "." +
                binary.substring(24, 32);
    }
    // Pasar una direccion de binario a decimal
    private String binaryToDecimal(String binary) {
        return Integer.parseInt(binary.substring(0, 8), 2) + "." +
            Integer.parseInt(binary.substring(8, 16), 2) + "." +
            Integer.parseInt(binary.substring(16, 24), 2) + "." +
            Integer.parseInt(binary.substring(24, 32), 2);
    }
    
    // Averiguar el tipo de ip
    private String addressType(){
        String formatted = "";
        String[] octets = IPAddress.split("\\.");
        for (String octet : octets) {
            formatted += String.format("3s", octet).replace(" ", "0") + ".";
        }
        formatted = formatted.substring(0,15);
        
        if ((formatted.compareTo("010.000.000.000") >= 0) &&
            (formatted.compareTo("010.255.255.255") >= 0) &&
            (formatted.compareTo("172.016.000.000") >= 0) &&
            (formatted.compareTo("172.031.255.255") >= 0) &&
            (formatted.compareTo("172.031.255.255") >= 0) &&
            (formatted.compareTo("172.031.255.255") >= 0)){
                return "Privada";
            } else {
                return "Publica";
        }
    }     
}
