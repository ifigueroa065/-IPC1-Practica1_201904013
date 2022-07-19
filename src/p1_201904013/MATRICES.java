/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_201904013;

/**
 *
 * @author Isai Figueroa
 */
public class MATRICES {

    public double DETERMINANTE(int i, double[][] matriz) {
        if (matriz.length == 2) {
            /*si la matriz es 2x2*/
            double Deter = matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];

            return Deter;
            /*devuelve el determinante*/
        } else {
            double Deter = 0;

            for (int j = 0; j < matriz.length; j++) {
                /*se elimina la primera fila y columna de la matriz*/
                double[][] temp = this.SubMatriz(i, j, matriz);
                Deter = Deter + Math.pow(-1, i + j) * matriz[i][j] * this.DETERMINANTE(i, temp);
            }
            return Deter;
        }

    }

    private double[][] SubMatriz(int i, int j, double[][] matriz) {
        /*se crea la submatriz*/
        double[][] temp = new double[matriz.length - 1][matriz.length - 1];
        int count1 = 0;
        int count2 = 0;
        for (int k = 0; k < matriz.length; k++) {
            if (k != i) {
                count2 = 0;
                for (int l = 0; l < matriz.length; l++) {
                    if (l != j) {
                        temp[count1][count2] = matriz[k][l];
                        count2++;
                    }

                }
                count1++;

            }

        }
        return temp;/*Retorna la matriz temporal creada*/
    }
    
    public double[][] Adjunta(double[][] matriz) {

        double[][] tempAdj = new double[matriz.length][matriz.length];

        for (int i = 0; i < tempAdj.length; i++) {
            for (int j = 0; j < tempAdj.length; j++) {
                
                /*se crea una submatriz*/
                
                double[][] TEMPORAL = this.SubMatriz(i, j, matriz);
                
                /*basado en la formula de adjunta*/
                
                double EAdj = Math.pow(-1, i + j) * this.DETERMINANTE(0, TEMPORAL);
                tempAdj[i][j] = EAdj;

            }
        }
        return tempAdj;
    }
    
    public double[][] Transpuesta(double[][] matriz) {

        double[][] tempTrans = new double[matriz.length][matriz.length];

        for (int i = 0; i < tempTrans.length; i++) {
            for (int j = 0; j < tempTrans.length; j++) {
                
                /*aqui se tranpone la matriz*/
                
            tempTrans[i][j]=matriz[j][i];
            }
        }
        return tempTrans;
    }

}

