/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum02.ADT_Larik;

public class AppPr1 {

    public static void main(String[] args) {
// implementasi untuk ADT_Larik
        double[] A = {3, 4, 1, 10, 5, 2, 10, 20, 16};
        double[] B = {4, 3, 1, 11, 7};
        Larik L1 = new Larik(A);
        Larik L2 = new Larik(B);
        L1.cetak("Isi Larik L1");
        L2.cetak("Isi Larik L2");
        Larik L3 = Larik.sambung(L1, L2);
        L3.cetak("L3 = gabungan dari L1 dan L2");
        Larik L4 = Larik.copyLarik(0, L1.getSize(), L1);
        L1.cetak("Isi Larik L1");
        L4.cetak("L4 Copy dari L1");
        Larik L5 = Larik.SelectionSort(L1, 0);
        L5.cetak("L5 Hasil pengurutan dari L1 kecil -> besar");
        Larik L6 = Larik.SelectionSort(L1, 1);
        L6.cetak("L6 Hasil pengurutan dari L1 besar -> kecil");
        L1.cetak("Isi Larik L1");
        double hasil = Larik.LarikKaliLarik(L1, L4);
        System.out.printf("HASIL KALI Larik L1*L4 = %.3f\n", hasil);
    }
}
