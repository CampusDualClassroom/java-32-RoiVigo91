package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Exercise32 {

    public static void main(String[] args) {
        String texto = generateStringToSave(null);

        printToFile(texto);
    }

    public static String generateStringToSave(String string) {
        return (string != null) ? string : generateUserInputToSave();
    }

    private static String generateUserInputToSave(){
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while(!(string = Utils.string()).isEmpty()){
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        String rutaFichero = "src/main/resources/data.txt";

        try (FileWriter writer = new FileWriter(rutaFichero)) {
            writer.write(string);
            System.out.println("Texto guardado correctamente en " + rutaFichero);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }



}
