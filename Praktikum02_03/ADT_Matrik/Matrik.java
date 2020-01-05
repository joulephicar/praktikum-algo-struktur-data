package Praktikum02.ADT_Matrik;
import Praktikum02.ADT_Larik.Larik;
public class Matrik {
    private int nBaris, nKolom;
    private double[][] itemDt;
    public double[][] getItemDt() {
        return itemDt;
    }
    public Matrik(int nBrs, int nKlm) {
        nBaris = nBrs;
        nKolom = nKlm;
        itemDt = new double[nBaris][nKolom];
    }
    public Matrik(double[][] A) {
        this(A.length, A[0].length); 
        this.nBaris = A.length;
        this.nKolom = A[0].length;
        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                this.itemDt[i][j] = A[i][j];
            }
        }
    }
    public int getNBaris() {
        return nBaris;
    }
    public int getNKolom() {
        return nKolom;
    }
    public double getItem(int idB, int idK) {
        return this.itemDt[idB][idK];
    }
    public void setItem(int idB, int idK, double dt) {
        this.itemDt[idB][idK] = dt;
    }
    public static Matrik tambah(Matrik A, Matrik B) {
        Matrik C = new Matrik(new double[A.nBaris][A.nKolom]);
        double temp = 0;
        for (int i = 0; i < C.nBaris; i++) {
            for (int j = 0; j < C.nKolom; j++) {
                temp = A.getItem(i, j) + B.getItem(i, j);
                C.setItem(i, j, temp);
            }
        }
        return C;
    }
    public static Larik VektorKaliMatrik(Larik L, Matrik M) {
        Larik lHasil = null;
        Larik lKolom = null;
        if (L.getSize() == M.getNBaris()) {
            lHasil = new Larik(new double[M.getNKolom()]);
            for (int i = 0; i < M.getNKolom(); i++) {
                lKolom = M.getKolom(i);
                double hasil = Larik.LarikKaliLarik(L, lKolom);
                System.out.println(hasil);
                lHasil.isiItem(i, hasil);
            }
        }
        return lHasil;
    }
    public static double determinan(Matrik tmp) {
        double det = 0;
        if (tmp.getNBaris() != tmp.getNKolom()) {
            return -1;
        } else {
            if (tmp.getNBaris() == 2) {
                double[][] mtk = tmp.getItemDt();
                det = mtk[0][0]*mtk[1][1] - mtk[1][0]*mtk[0][1];
            } else {
                System.out.printf("Operasi determinan matrik %dx%d belum disupport\n", tmp.getNBaris()*tmp.getNBaris());
            }
        }
        return det;
    }
    public static Matrik tranpos(Matrik A) {
        Matrik tmp = new Matrik(new double[A.nKolom][A.nBaris]);
        for (int i = 0; i < A.nKolom; i++) {
            for (int j = 0; j < A.nBaris; j++) {
                tmp.setItem(i, j, A.getItem(j, i));
            }
        }
        return tmp;
    }
    public Larik getBaris(int idBaris) {
        Larik row = new Larik(new double[this.nKolom]);
        for (int i = 0; i < this.nKolom; i++) {
            row.isiItem(i, this.getItem(idBaris, i));
        }
        return row;
    }
    public Larik getKolom(int idKolom) {
        Larik l = new Larik(new double[this.nBaris]);
        for (int i = 0; i < this.nBaris; i++) {
            double itemKolom = this.getItem(i, idKolom);
            l.isiItem(i, itemKolom);
        }
        return l;
    }
    public void cetak(String kom) {
        System.out.println(kom);
        for (int i = 0; i < this.nBaris; i++) {
            for (int j = 0; j < this.nKolom; j++) {
                System.out.printf("%.2f ", this.itemDt[i][j]);
            }
            System.out.println();
        }
    }
    public Matrik kali(Matrik m) {
        Matrik crossProduct = null;
        if (m.getNKolom() == m.getNBaris()) {
            crossProduct = new Matrik(m.getNBaris(), m.getNKolom());
            for (int i = 0; i < m.getNBaris(); i++) {
                for (int j = 0; j < m.getNKolom(); j++) {
                    int x = 0;
                    for (int k = 0; k < m.getNKolom(); k++) {
                        x += this.itemDt[i][k] * m.getItem(k, j);
                    }
                    crossProduct.setItem(i, j, x);
                }
            }
        }
        return crossProduct;
    }
    public Matrik tambah(Matrik x) {
        Matrik y = null;
        if ((this.nBaris == x.getNBaris()) && (this.nKolom == x.getNKolom())) {
            y = new Matrik(x.getNBaris(), x.getNKolom());
            for (int i = 0; i < this.nBaris; i++) {
                for (int j = 0; j < this.nKolom; j++) {
                    y.setItem(i, j, this.itemDt[i][j] + x.getItem(i, j));
                }
            }
        }
        return y;
    }
    public static void main (String[] args) {
        Matrik A,B,C;
        double [][] X = {{1, 2, 3},{2, 14, 5},{16, 8, 13}};
        double [][] Y = {{10, 12, 0},{5, 1, 5},{3, 1, 10}};
        A = new Matrik(X);
        B = new Matrik(Y);
        A.cetak("Matrik A");
        B.cetak("Matrik B");
        C = A.tambah(B);
        C.cetak("Matrik C = A+B");
        Larik lb,lk;
        lb = C.getBaris(1);
        lb.cetak("Larik baris ke-1");
        lk = C.getKolom(1);
        lk.cetak("Larik kolom ke-1");
        Matrik D = A.kali(B);
        D.cetak("Matrik D hasil kali A dan B:");
    }
}
