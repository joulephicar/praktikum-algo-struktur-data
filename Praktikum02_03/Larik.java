/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum02;

public class Larik {

    public static double LarikKaliLarik(Larik L, Larik lKolom) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private int size;
    private int[] itemDt;
    public void buatLarik(int n) {
        this.size = n;
        this.itemDt = new int[this.size];
    }

    public Larik(int n) {
        buatLarik(n);
    }

    public int getSize() {
        return this.size;
    }

    public Larik(int[] dt) {
        buatLarik(dt.length);
        for (int i = 0; i < dt.length; i++) {
            isiItem(i, dt[i]);
        }
    }

    public void isiItem(int id, int dt) {
        this.itemDt[id] = dt;
    }

    public void cetak(String komentar) {
        System.out.println(komentar);
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.itemDt[i] + " ");
        }
        System.out.println();
    }

    public int findBesar() {
        int besar = this.itemDt[0];
        for (int i = 1; i < this.size; i++) {
            if (besar < this.itemDt[i]) {
                besar = this.itemDt[i];
            }
        }
        return besar;
    }

    /**
     * program ini mencari posisi suatu data tertentu di larik
     */
    public int getPosisi(int dtCari) {
        int pos = -99;
        boolean ketemu = false;
        int i = 0;
        while (!ketemu && i < this.size) {
            if (dtCari == this.itemDt[i]) {
                ketemu = true;
                pos = i;
            }
            i++;
        }
        return pos;
    }

    private int getPosMax(int id) {
        int max = this.itemDt[id];
        int posMax = id;
        for (int i = id + 1; i < size; i++) {
            if (max <= this.itemDt[i]) {
                max = this.itemDt[i];
                posMax = i;
            }
        }
        return posMax;
    }

    private int getPosMin(int id) {
        int min = this.itemDt[id];
        int posMin = id;
        for (int i = id + 1; i < size; i++) {
            if (min >= this.itemDt[i]) {
                min = this.itemDt[i];
                posMin = i;
            }
        }
        return posMin;
    }

    public int PencarianBiner(int dtCari, int awal, int akhir) {

        int pos = -99;
        int tengah = (awal + akhir) / 2;
        if (dtCari < this.itemDt[tengah]) {
            return PencarianBiner(dtCari, awal, tengah);
        } else if (dtCari > this.itemDt[tengah]) {
            return PencarianBiner(dtCari, tengah + 1, akhir);
        } else if (dtCari == this.itemDt[tengah]) {
            return tengah;
        } else {
            return pos;
        }
    }

    /**
     * program untuk mencopy isi suatu Larik mulai dari posisi k sebanyak n item
     * hasilnya dikeluarkan sebagai array baru
     */
    public Larik copyLarik(int k, int n) {
        Larik lHasil = null;
        if (n <= this.size - k) {
            lHasil = new Larik(n);
            int j = 0;
            for (int i = k; i < k + n; i++) {
                lHasil.isiItem(j++, this.itemDt[i]);
            }
        }
        return lHasil;
    }

    /**
     * pilihan 0 : urutkan dari kecil ke besar lainya : urutkan dari besar ke
     * kecil Algoritma pengurutan ini menggunakan selection sort
     */
    public Larik SelectionSort(int pilihan) {
        Larik lsort = copyLarik(0, size);
        for (int i = 0; i < lsort.getSize(); i++) {
            int posData;
            if (pilihan == 0) {
                posData = lsort.getPosMin(i);
            } else {
                posData = lsort.getPosMax(i);
            }
            int dt1 = lsort.itemDt[i];
            int dt2 = lsort.itemDt[posData];
            lsort.itemDt[i] = dt2;
            lsort.itemDt[posData] = dt1;
        }
        return lsort;
    }
    public Larik InsertionSort(int pilihan){
        Larik lsort = copyLarik(0, size);
        int key, j;
        for (int i = 1; i < lsort.getSize(); i++) {
            key = lsort.itemDt[i];
            j = i - 1;
            if (pilihan == 0) {
                while ((j >= 0) && (lsort.itemDt[j] > key)) {
                    lsort.itemDt[j+1] = lsort.itemDt[j];
                    j--;
                }
            } else {
                while ((j >= 0) && (lsort.itemDt[j] < key)) {
                    lsort.itemDt[j+1] = lsort.itemDt[j];
                    j--;
                }
            }
            lsort.itemDt[j+1] = key;
        }
        return lsort;
    }
    public int[] findPosKelipatan(int x0, int x1, int x2) {
        int cnt = 0;
        for (int i = x1; i < x2; i++) {
            if (itemDt[i] % x0 == 0) {
                cnt++;
            }
        }
        int[] hasil = new int[cnt];
        cnt = 0;
        for (int i = x1; i < x2; i++) {
            if (itemDt[i] % x0 == 0) {
                hasil[cnt] = i;
                cnt++;
            }
        }
        return hasil;
    }
    public int[] getItemDt() {
        return itemDt;
    }
    public static void main(String[] args) {
        
        int[] A = {2, 34, 5, 7, 10};
        Larik lA = new Larik(A);
//        lA.cetak("aaa");
//        System.out.println("lA.getPosMin(0) = " + lA.itemDt[lA.getPosMin(1)]);
        lA.cetak("Sebelum");
        Larik lAsort = lA.SelectionSort(0);
        lAsort.cetak("Sesudah di sort");
        int k = lAsort.PencarianBiner(34,0,5);
        System.out.println(k);
        Larik lB = lA.SelectionSort(0);
        int p = lB.PencarianBiner(10, 0, 5);
        System.out.println(p);
        int[] set = {0,2,3,5,7,9,13,14,37,42,63};
        Larik lset = new Larik(set);
        lset.cetak("Larik Set");
        int[] find = lset.findPosKelipatan(7,2,10);
        System.out.println("Ditemukan Kelipatannya di indeks:");
        for (int i = 0; i < find.length; i++) {
            System.out.printf("lset[%d] = %d\n", find[i], lset.itemDt[find[i]]);
        }
        lA.InsertionSort(0).cetak("insertion sort:");
    }
}
