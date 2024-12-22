package com.inforcap.main;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

public class LecturaEscritura {

    public static void main(String[] args) {

        crearArchivo("directorio","fichero");
        buscarTexto("fichero","Juan");
        buscarTexto("fichero","Gato");
        buscarTexto("fichero","Pedro");
        buscarTexto("fichero","Orozimbo");

    }

    static void crearArchivo(String nombreDirectorio, String nombreFichero){
        ArrayList<String> textos = new ArrayList<>();
        textos.add("Pedro");
        textos.add("Gato");
        textos.add("Juan");
        textos.add("Daniel");
        textos.add("Gato");
        textos.add("Juan");
        textos.add("Perro");
        textos.add("Camila");
        textos.add("Daniel");
        textos.add("Camila");

        File directorio = new File("src/" + nombreDirectorio);
        File fichero = new File(directorio.getPath() + "/" + nombreFichero + ".txt");

        if (!directorio.exists()){
            if(directorio.mkdir()){
                System.out.println("Directorio creado correctamente...");
                try {
                    fichero.createNewFile();
                    FileWriter fileWriter = new FileWriter(fichero,false);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    for(String s: textos){
                        bufferedWriter.write(s);
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.close();
                    fileWriter.close();

                } catch (IOException e) {
                    System.out.println("Error al crear el archivo...");
                }

            } else {
                System.out.println("Error al crear directorio...");
            }
        } else {
            System.out.println("El directorio ya está creado...");
            try {
                fichero.createNewFile();
                FileWriter fileWriter = new FileWriter(fichero,false);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for(String s: textos){
                    bufferedWriter.write(s);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                fileWriter.close();

            } catch (IOException e) {
                System.out.println("Error al crear el archivo...");
            }
        }
    }


    static void buscarTexto(String nombreFichero, String texto){
        int contador = 0;
        String data = "";
        File fichero = new File("src/directorio/" + nombreFichero + ".txt");
        try {
            FileReader fileReader = new FileReader(fichero);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            while (data != null){
                if(data.equals(texto)){
                    contador++;
                }
                data = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
            System.out.println("La palabra " + texto + " se encuentra : " + contador + " veces.");

        } catch (FileNotFoundException e) {
            System.out.println("El fichero buscado no existe");
        } catch (IOException e) {
            System.out.println("Se produjo un problema de lectura sobre el fichero mencionado");
        }

    }

    static void cargarDatos(String fichero){
        ArrayList<String> textos = new ArrayList<>();
        textos.add("Pedro");
        textos.add("Gato");
        textos.add("Juan");
        textos.add("Daniel");
        textos.add("Gato");
        textos.add("Juan");
        textos.add("Perro");
        textos.add("Camila");
        textos.add("Daniel");
        textos.add("Camila");

    }

}
