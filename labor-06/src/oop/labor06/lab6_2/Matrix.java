package oop.labor06.lab6_2;

import java.util.Random;

public class Matrix {
    private double[][] data;
    private final int rows;
    private final int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        data = new double[rows][columns];
    }

    public Matrix(double[][] data) {
        rows=data.length;
        columns=data[0].length;
        this.data = new double[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                this.data[i][j]=data[i][j];
            }
        }
    }

    public Matrix(Matrix matrix) {
        rows=matrix.rows;
        columns=matrix.columns;
        data=new double[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                data[i][j]=matrix.data[i][j];
            }
        }
    }

    public void fillRandom(double min,double max){
        Random rand=new Random();
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                data[i][j]=rand.nextDouble()*(max-min)+min;
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void printMatrix(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print(String.format("%7.2f",data[i][j]));
            }
            System.out.println("\n");
        }
    }

    public static Matrix add(Matrix matrix1, Matrix matrix2){
        if(matrix1.rows!=matrix2.rows||matrix1.columns!=matrix2.columns){
            System.out.println("The two matrices don't have the same dimensions");
            return null;
        }
        Matrix result=new Matrix(matrix1.rows,matrix1.columns);
        for(int i=0;i<matrix1.rows;i++){
            for(int j=0;j<matrix1.columns;j++){
                result.data[i][j]=matrix1.data[i][j]+matrix2.data[i][j];
            }
        }
        return result;
    }

    public static Matrix multiply(Matrix matrix1, Matrix matrix2){
        if(matrix1.columns!=matrix2.rows){
            System.out.println("The two matrices are not compatible with the multiplication operation.");
            return null;
        }
        Matrix result=new Matrix(matrix1.rows,matrix2.columns);
        for(int i=0;i<matrix1.rows;i++){
            for(int j=0;j<matrix2.columns;j++){
                for(int k=0;k<matrix1.columns;k++){
                    result.data[i][j]+=matrix1.data[i][k]*matrix2.data[k][j];
                }
            }
        }
        return result;
    }

    public static Matrix transpose(Matrix matrix){
        Matrix result=new Matrix(matrix.columns,matrix.rows);
        for(int i=0;i<matrix.rows;i++){
            for(int j=0;j<matrix.columns;j++){
                result.data[j][i]=matrix.data[i][j];
            }
        }
        return result;
    }
}
