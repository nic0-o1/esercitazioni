/*

Copyright 2021 Luca Prigioniero, Massimo Santini

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
  public static long reverse(long x) {
    long r = 0;
    do r = r * 10 + x % 10;
    while ((x /= 10) != 0);
    return r;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    long x = s.nextLong(), r;

    System.out.println(x);
    for (; ; ) {
      r = reverse(x);
      if (r == x) break;
      r += x;
      System.out.println(r);
      x = r;
    }
  }
}
