package org.suprun.task1.entity;

import java.util.Arrays;

/**
 * {@code Matrix} class represents a Matrix entity.
 *
 * @author Philip Suprun
 */
public class Matrix {

    private int[][] matrix;

    public Matrix(int sizeX, int sizeY) {
        matrix = new int[sizeX][sizeY];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        return Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(matrix);
    }

    @Override
    public String toString() {

        for (int indexFirstFor = 0; indexFirstFor < matrix.length; indexFirstFor++) {
            for (int indexSecondFor = 0; indexSecondFor < matrix.length; indexSecondFor++)
                System.out.print(matrix[indexFirstFor][indexSecondFor] + "\t");
            System.out.println();
        }
        return "End";
    }
}
