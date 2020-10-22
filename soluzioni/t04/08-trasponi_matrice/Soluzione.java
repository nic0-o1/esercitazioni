/*

Copyright 2020 Massimo Santini

This file is part of "Programmazione 2 @ UniMI" teaching material.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This material is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this file.  If not, see <https://www.gnu.org/licenses/>.

*/

import java.util.Scanner;

public class Soluzione {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int N = Integer.parseInt(args[0]);
    int M = Integer.parseInt(args[1]);
    int[][] A = new int[N][M];

    // leggo la matrice

    for (int r = 0; r < N; r++) for (int c = 0; c < M; c++) A[r][c] = s.nextInt();

    // predispongo la matrice trasposta

    int[][] T = new int[M][N];

    for (int r = 0; r < M; r++) for (int c = 0; c < N; c++) T[r][c] = A[c][r];

    // stampo la matrice trasposta

    for (int r = 0; r < M; r++) {
      for (int c = 0; c < N; c++) System.out.print(T[r][c] + " ");
      System.out.println();
    }

    s.close();
  }
}
