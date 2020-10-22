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

package no;

import java.util.Scanner;

public class Soluzione {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int eta = s.nextInt();
    s.close();

    int fascia;

    if (eta < 7) fascia = 3;
    else if (eta < 12) fascia = 7;
    else if (eta < 16) fascia = 12;
    else if (eta < 18) fascia = 16;
    else fascia = 18;

    System.out.println("fascia " + fascia);
  }
}
