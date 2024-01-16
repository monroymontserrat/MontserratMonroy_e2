package com.corenetworks.presentacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        // Crear un programa que introduciendo el nombre de un fichero (con su ruta completa nos de toda la información posible de el)
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre del fichero con su extension");

        try (FileReader fr = new FileReader(sc.nextLine())) {
            BufferedReader bf = new BufferedReader(fr);
            String sCadena;
            String rutaAbsoluta = new File("MontserratMonroy.txt").getAbsolutePath();
            System.out.println("Ruta absoluta--->" + rutaAbsoluta);
            while ((sCadena = bf.readLine()) != null) {
                System.out.println(sCadena);
                System.out.println("El fichero tiene una longitud de -> " + sCadena.length() + " caracteres");
            }
            bf.close();
            sc.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}












