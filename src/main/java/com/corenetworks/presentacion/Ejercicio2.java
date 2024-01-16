package com.corenetworks.presentacion;

import java.io.*;

public class Ejercicio2 {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("¿Archivo de origen:? ");
            String archivoOrigen = br.readLine();
            System.out.print("¿Archivo cifrado:? ");
            String archivoDestino = br.readLine();

            System.out.print("Número entre 1 y 255: ");
            int numeroCifrado = Integer.parseInt(br.readLine());

            if (numeroCifrado < 1 || numeroCifrado > 255) {
                System.out.println("El valor debe estar entre 1 y 255.");
                return;
            }

            encriptar(archivoOrigen, archivoDestino, numeroCifrado);

            System.out.println("Cifrado completado correctamente.");
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void encriptar(String archivoOrigen, String archivoDestino, int numeroCifrado) throws IOException {
        try (FileReader fr = new FileReader(archivoOrigen);
             FileWriter fw = new FileWriter(archivoDestino)) {

            int currentChar;
            while ((currentChar = fr.read()) != -1) {
                int caracterEncriptado = currentChar ^ numeroCifrado;
                fw.write(caracterEncriptado);
            }
        }
    }
}