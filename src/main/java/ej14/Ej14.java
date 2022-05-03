/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej14;

import eej11.App;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author hinda
 */
public class Ej14 {

    /*- En un programa Java y usando como base el ejercicio 11: 
Pregunta al usuario que app en modo texto desea leer de las posibles que haya en “./aplicaciones”. 
Para ello muestra un listado con las que haya en la carpeta.
Una vez leída la app desde el fichero y creado el objeto app con los datos correspondientes, muestra la app por pantalla.
Borra el archivo de la app leída.
Muestra el contenido del directorio “/.aplicaciones”.*/
    //metodos
    //method check if directory exist and give you the files
    public static String listarDirectorio(String ruta) {
        File f = new File(ruta);
        String fileName = "";
        if (f.exists()) {
            // Obtiene los ficheros y directorios dentro de f y los 
            // devuelve en un array
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {
                fileName = file2.getName();
                System.out.println(file2.getName());
            }
        } else {
            System.out.println("El directorio a listar no existe");

        }
        return fileName;
    }

    //borrar archivo desde directorio
    public static void borrarElemento(String ruta) throws IOException {
        Path file = Paths.get(ruta);
        try {
            Files.delete(file);
            System.out.println("file deleted");
        } catch (NoSuchFileException nsfe) {
            System.out.println("No se puede borrar " + ruta + " porque no existe");
        } catch (DirectoryNotEmptyException dnee) {
            System.out.println("No se puede borrar el directorio porque no está vacío");
        } catch (IOException e) {
            System.out.println("Problema borrando el elemento " + ruta);
        }
    }

    //leer un objeto desde Fichero de txt
    public static App leerObjFicheroTxt(String idFichero) {
        App app = new App();

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);
        try (Scanner datosFichero = new Scanner(new File(idFichero))) {
            // Guarda la línea completa en un String
            linea = datosFichero.nextLine();

            // Se guarda en el array de String cada elemento de la
            tokens = linea.split(";");

            app.setCodigoUni(Integer.parseInt(tokens[0]));
            app.setNombre(tokens[1]);
            app.setDescripcion(tokens[2]);
            app.setTamanioKb(Double.parseDouble(tokens[3]));
            app.setNumeroDescargas(Integer.parseInt(tokens[4]));

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return app;

    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String ruta = "./aplicaciones";
        String choice;
        listarDirectorio(ruta);

        System.out.println("Que Application desea leer?");

        choice = sc.next();
        if (listarDirectorio(ruta).equals("")) {
            System.out.println("fichero not exist");
        } else {
            System.out.println("la App es : " + leerObjFicheroTxt("./aplicaciones/" + choice));
            borrarElemento("./aplicaciones/" + choice);
            System.out.println("\n despues de borrar");
            listarDirectorio("./aplicaciones");
        }

    }

}
