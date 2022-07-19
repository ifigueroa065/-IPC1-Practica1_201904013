/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_201904013;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Isai Figueroa
 */
public class P1_201904013 {
static Scanner entrada = new Scanner(System.in);
    DecimalFormat df= new DecimalFormat("0.00");
 static boolean condicion=true;
 static String Entrada,RUTA1,TXTCIFRAR;
 static char TXT;
 static int tamaño, numero,FILAS, COLUMNAS,FILAS2,COLUMNAS2,TAM,TAMINVERSA;
 static char [] SEPARAR = new char[1];
 static char  TRADUCTOR;
 static int [] ASCII = new int[1];
 static int [] INTCADENA = new int[1];
  static int [] INTCADENA2 = new int[1];
 static int [][] Matriz=new int [1][1];
 static int [][] Matriz2=new int [1][1];
 static int[][] CIFRADA=new int [1][1];
 static int[][] DESCIFRADA=new int [1][1];
 static double [] DET= new double[1];
 static double [][] MatrizDET=new double[1][1];
 static double[][] MATRIZINVERSA=new double[1][1];
 static double[][] MATRIXXX=new double [1][1];
 static double [] MATRIXD=new double[1];
 /*PARA LA MATRIZ DEL MENSAJE CIFRADO*/
 static double [] VALORESDOU=new double[1];
 static double [][] MATRIXVALORESDOU=new double[1][1];

 
 
 
 
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MENU();
    }
    
    static void MENU() {
        System.out.println("       BIENVENIDO            ");
        while (condicion == true) {
            System.out.println("**************************");
            System.out.println("**    Elija una opción  **");
            System.out.println("**************************");
            System.out.println("  -->1.CIFRAR             ");
            System.out.println("  -->2.DESCIFRAR          ");
            System.out.println("  -->3.GAUSS JORDAN       ");
            System.out.println("---INGRESE 0 PARA SALIR---");

            switch (entrada.nextLine()) {
                case "1":
                    CIFRAR();
                    break;
                case "2":
                    //DESCIFRAR
                    DESCIFRAR();

                    break;
                case "3":
                    //GAUSS JORDAN
                  
                    break;

                case "0":
                    condicion = false;
                    System.out.println("GRACIAS POR UTILIZAR MI PROGRAMA :)");
                    break;

                default:
                    System.out.println("--NO SELECCIONÓ UNA OPCIÓN VÁLIDA--");
            }
        }
    }

    static void CIFRAR() {
        System.out.println("***Ingrese el texto a cifrar***");
        TXTCIFRAR = entrada.nextLine();
        //Se define el tamaño del arreglo 
        System.out.println("*******************************");
        tamaño = TXTCIFRAR.length();
        GUARDAR_EN_VECTOR();
        VerificarLARGO();
        LLENARMATRIZ();
        IMPRIMIR_MATRIZ();
        LEERARCHIVO();
        MULTIPLICARMATRICES();

    }

    static void VerificarLARGO() {

        if (tamaño % 3 == 0) {
            FILAS = 3;
            COLUMNAS = tamaño / 3;
            //System.out.println("El numero " + tamaño + "es multiplo de 3");
            //System.out.println("Matriz de" + FILAS + "x" + COLUMNAS);

        } else if (tamaño % 4 == 0) {

            FILAS = 4;
            COLUMNAS = tamaño / 4;
            //System.out.println("El numero " + tamaño + "es multiplo de 4");
            //System.out.println("Matriz de" + FILAS + "x" + COLUMNAS);

        } else if (tamaño % 5 == 0) {

            FILAS = 5;
            COLUMNAS = tamaño / 5;
            //System.out.println("El numero " + tamaño + "es multiplo de 5");
            //System.out.println("Matriz de" + FILAS + "x" + COLUMNAS);

        } else if (tamaño % 7 == 0) {

            FILAS = 7;
            COLUMNAS = tamaño / 7;

            //System.out.println("El numero " + tamaño + "es multiplo de 7");
            //System.out.println("Matriz de" + FILAS + "x" + COLUMNAS);

        } else if (tamaño % 11 == 0) {

            FILAS = 11;
            COLUMNAS = tamaño / 11;

            //System.out.println("El numero " + tamaño + "es multiplo de 11");
            //System.out.println("Matriz de" + FILAS + "x" + COLUMNAS);

        } else if (tamaño % 13 == 0) {
            FILAS = 13;
            COLUMNAS = tamaño / 13;

            //System.out.println("El numero " + tamaño + "es multiplo de 13");
            //System.out.println("Matriz de" + FILAS + "x" + COLUMNAS);

        } else if (tamaño % 17 == 0) {
            FILAS = 17;
            COLUMNAS = tamaño / 17;
            //System.out.println("El numero " + tamaño + "es multiplo de 17");
            //System.out.println("Matriz de" + FILAS + "x" + COLUMNAS);

        } else {
            System.out.println("LARGO FUERA DE RANGO");
        }

    }

    static void GUARDAR_EN_VECTOR() {

        SEPARAR = new char[tamaño];
        ASCII = new int[tamaño];

        for (int posicion = 0; posicion < tamaño; posicion++) {
            //Ciclo para guardar caracteres
            char VALOR;

            //Se guarda el caracter 
            VALOR = TXTCIFRAR.charAt(posicion);
            int ca = (int) (VALOR);
            //Se guarda en el vector
            SEPARAR[posicion] = VALOR;
            ASCII[posicion] = ca;

            //System.out.print(SEPARAR[posicion]+ ","); 
            //System.out.print(ASCII[posicion] + ",");
        }
        //System.out.println("");
        //System.out.println("el tamaño del arreglo es:" + tamaño);
    }

    static void LLENARMATRIZ() {
        /*METODO PARA LLENAR LA MATRIZ*/
        Matriz = new int[FILAS][COLUMNAS];

        int c = 0;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                /*se da la posicion del valor*/
                Matriz[i][j] = ASCII[c];
                c++;
            }
        }

    }

    static void LLENARMATRIZ2() {
        /*METODO PARA LLENAR LA MATRIZ*/
        Matriz2 = new int[FILAS2][COLUMNAS2];

        int c = 0;
        for (int i = 0; i < FILAS2; i++) {
            for (int j = 0; j < COLUMNAS2; j++) {
                /*se da la posicion del valor*/
                Matriz2[i][j] = INTCADENA[c];
                c++;
            }

        }
    }

    static void IMPRIMIR_MATRIZ() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                /*Se imprime la posiciond de la matriz*/
                //System.out.print("|" + Matriz[i][j] + "|");

            }
            //System.out.println("");
        }
    }

    static void IMPRIMIR_MATRIZ2() {
        for (int i = 0; i < FILAS2; i++) {
            for (int j = 0; j < COLUMNAS2; j++) {
                /*Se imprime la posiciond de la matriz*/
                //System.out.print("|" + Matriz2[i][j] + "|");

            }
           // System.out.println("");
        }
    }

    static void LEERARCHIVO() {
        try {
            String ruta;
            System.out.println("Ingrese la ruta del archivo");
            ruta = entrada.nextLine();
            File archivo = new File(ruta);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            //LEER ARCHIVO
            int[][] matriz;
            FILAS2 = 0;
            COLUMNAS2 = 0;
            String linea;
            String temporal = "";

            while ((linea = br.readLine()) != null) {
                String[] fila = linea.split(",");

                temporal += linea + ",";

                for (int i = 0; i < fila.length; i++) {

                }
                COLUMNAS2 = fila.length;
                FILAS2 = FILAS2 + 1;
            }
            fr.close();

            matriz = new int[FILAS2][COLUMNAS2];
            //System.out.println("");
            //System.out.println("Numero de filas=" + FILAS2);
            //System.out.println("Numero de columnas=" + COLUMNAS2);

            String[] DATOS = temporal.split(",");
            TAM = DATOS.length;
            INTCADENA = new int[TAM];
            for (int c = 0; c < DATOS.length; c++) {
                int convertido = Integer.parseInt(DATOS[c]);
                INTCADENA[c] = convertido;
            }
            LLENARMATRIZ2();
            IMPRIMIR_MATRIZ2();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void MULTIPLICARMATRICES() {
        //System.out.println("MULTIPLICANDO MATRICES");
        //LLENARMATRIZ2();
        //IMPRIMIR_MATRIZ2();

        //System.out.println("x ");

        //LLENARMATRIZ();
        //IMPRIMIR_MATRIZ();
        System.out.println("********************");
        System.out.println("El mensaje cifrado es :");
        System.out.println("********************");
        CIFRADA = new int[FILAS2][COLUMNAS];

        for (int i = 0; i < FILAS2; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                for (int h = 0; h < COLUMNAS2; h++) {
                    CIFRADA[i][j] += Matriz2[i][h] * Matriz[h][j];
                }
                System.out.print(CIFRADA[i][j] + ",");
            }
        }
    }

    static void DESCIFRAR() {
        LEER_ARCHIVO_DOUBLE();
        LEER_ARCHIVO2();
        MULTIPLI_MATRIX();

    }

    static void LEER_ARCHIVO2() {
        try {
            String ruta2;
            System.out.println("---Ingrese la ruta del archivo Llave--");
            ruta2 = entrada.nextLine();
            
            File archivo = new File(ruta2);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            //LEER ARCHIVO
            int[][] matriz;
            FILAS = 0;
            COLUMNAS = 0;
            String linea2;
            String temporal2 = "";

            while ((linea2 = br.readLine()) != null) {
                String[] fila2 = linea2.split(",");

                temporal2 += linea2 + ",";

                for (int i = 0; i < fila2.length; i++) {

                }
                COLUMNAS = fila2.length;
                FILAS = FILAS + 1;
            }
            fr.close();

            matriz = new int[FILAS][COLUMNAS];
            /*System.out.println("");
            System.out.println("Numero de filas=" + FILAS);
            System.out.println("Numero de columnas=" + COLUMNAS);*/

            String[] DATOS2 = temporal2.split(",");
            TAM = DATOS2.length;
            DET = new double[TAM];
            for (int c = 0; c < DATOS2.length; c++) {
                double convertido2 = Double.parseDouble(DATOS2[c]);
                DET[c] = convertido2;
            }
            LLENARMATRIZ3();
            IMPRIMIRMATRIZ3();
            DETERMINANTE();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void LLENARMATRIZ3() {
        /*METODO PARA LLENAR LA MATRIZ*/
        MatrizDET = new double[FILAS][COLUMNAS];

        int c = 0;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                /*se da la posicion del valor*/
                MatrizDET[i][j] = DET[c];
                c++;
            }

        }
    }

    static void LEER_ARCHIVO_DOUBLE() {
        try {
            String ruta;
            System.out.println("***Ingrese la ruta del archivo***");
            ruta = entrada.nextLine();
            System.out.println("**********************************");
            File archivo = new File(ruta);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            //LEER ARCHIVO
            int[][] matriz;
            FILAS2 = 0;
            COLUMNAS2 = 0;
            String linea;
            String temporal = "";

            while ((linea = br.readLine()) != null) {
                String[] fila = linea.split(",");

                temporal += linea + ",";

                for (int i = 0; i < fila.length; i++) {

                }
                COLUMNAS2 = fila.length;
                FILAS2 = FILAS2 + 1;
            }
            fr.close();

            matriz = new int[FILAS2][COLUMNAS2];
            /*System.out.println("");
            System.out.println("Numero de filas=" + FILAS2);
            System.out.println("Numero de columnas=" + COLUMNAS2);*/

            String[] DATOS = temporal.split(",");
            TAM = DATOS.length;
            VALORESDOU = new double[TAM];
            for (int c = 0; c < DATOS.length; c++) {
                double convertido = Double.parseDouble(DATOS[c]);
                VALORESDOU[c] = convertido;
            }
            LLENAR_MATRIX_DOUBLE();
            IMPRIMIR_MATRIX_DOUBLE();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void LLENAR_MATRIX_DOUBLE() {
        /*METODO PARA LLENAR LA MATRIZ*/
        MATRIXVALORESDOU = new double[FILAS2][COLUMNAS2];

        int c = 0;
        for (int i = 0; i < FILAS2; i++) {
            for (int j = 0; j < COLUMNAS2; j++) {
                /*se da la posicion del valor*/
                MATRIXVALORESDOU[i][j] = VALORESDOU[c];
                c++;
            }

        }
    }

    static void IMPRIMIR_MATRIX_DOUBLE() {
        for (int i = 0; i < FILAS2; i++) {
            for (int j = 0; j < COLUMNAS2; j++) {
                /*Se imprime la posiciond de la matriz*/
                //System.out.print("|" + MATRIXVALORESDOU[i][j] + "|");

            }
            //System.out.println("");
        }
    }

    static void IMPRIMIRMATRIZ3() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                /*Se imprime la posiciond de la matriz*/
                //System.out.print("|" + MatrizDET[i][j] + "|");

            }
            //System.out.println("");
        }
    }

    static void DETERMINANTE() {
        MATRICES MATRIX = new MATRICES();
        try {
            //System.out.println("el determinante de la matriz  es" + MATRIX.DETERMINANTE(0, MatrizDET));
            double determinante = MATRIX.DETERMINANTE(0, MatrizDET);
            double[][] MatrizAdjunta = MATRIX.Adjunta(MatrizDET);
            double[][] MatrizTranspuesta = MATRIX.Transpuesta(MatrizAdjunta);

            for (int i = 0; i < MatrizDET.length; i++) {
                for (int j = 0; j < MatrizDET.length; j++) {
                    //System.out.print(MatrizDET[i][j] + "|");
                }
                //System.out.println("");
            }

            //System.out.println("la inversa es");
            if (determinante == 0) {
                //System.out.println("LA matriz no tiene inversa");
            } else {
                TAMINVERSA = MatrizTranspuesta.length;
                MATRIZINVERSA = new double[TAMINVERSA][TAMINVERSA];

                for (int i = 0; i < TAMINVERSA; i++) {
                    for (int j = 0; j < TAMINVERSA; j++) {
                        //System.out.print(MatrizTranspuesta[i][j]/determinante+"|");
                        MATRIZINVERSA[i][j] = MatrizTranspuesta[i][j] / determinante;
           /*Se imprime la matriz inversa */
                       // System.out.print((MATRIZINVERSA[i][j]) + "|");
                    }
                    //System.out.println("");
                }
            }

        } catch (Exception e) {

            System.out.println("error");
        }
    }

    static void IMPRIMIR_INVERSA() {
        for (int i = 0; i < TAMINVERSA; i++) {
            for (int j = 0; j < TAMINVERSA; j++) {
                /*Se imprime la posiciond de la matriz*/
               //System.out.print("|" + MATRIZINVERSA[i][j] + "|");

            }
            //System.out.println("");
        }
    }

    static void MULTIPLI_MATRIX() {
        //System.out.println("MULTIPLICANDO MATRICES");

        //IMPRIMIR_INVERSA();
        //System.out.println("x ");
        //LLENAR_MATRIX_DOUBLE();
        //IMPRIMIR_MATRIX_DOUBLE();

        System.out.println("**************************");
        System.out.println("       El mensaje  es :   ");
        System.out.println("**************************");
        
        DESCIFRADA = new int[TAMINVERSA][COLUMNAS2];

        for (int i = 0; i < TAMINVERSA; i++) {
            for (int j = 0; j < COLUMNAS2; j++) {
                for (int h = 0; h < TAMINVERSA; h++) {
                    DESCIFRADA[i][j] += Math.round(MATRIZINVERSA[i][h] * MATRIXVALORESDOU[h][j]);

                }
                //System.out.print(DESCIFRADA[i][j] + "|");
            }
            //System.out.println("");
        }
        int lectura;
        //System.out.println("El mensaje es : ");
        for (int i = 0; i < TAMINVERSA; i++) {
            for (int j = 0; j < COLUMNAS2; j++) {
                //System.out.println("posicion"+i+","+j+ DESCIFRADA[i][j] + "");

                lectura = DESCIFRADA[i][j];
                TRADUCTOR = (char) (lectura);
                System.out.print(TRADUCTOR);

            }

        }
        System.out.println("");

    }
    
}
