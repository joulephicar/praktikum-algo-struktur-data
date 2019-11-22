/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum05;

/**
 *
 * @author joulephicar
 */
class NodeCDLL {

    Object data;
    NodeCDLL sebelum;
    NodeCDLL setelah;
}

public class CircularDoubleLinkedList {

    private NodeCDLL pAwal, pAkhir;
    private int jumlah;

    public CircularDoubleLinkedList() {
        pAwal = null;
        pAkhir = null;
        jumlah = -1;

    }

    public void SisipDataDiAwal(Object data) {
        NodeCDLL pBaru = new NodeCDLL();
        pBaru.data = data;
        pBaru.sebelum = pBaru;
        pBaru.setelah = pBaru;
        if (pAwal == null) {
            pAwal = pBaru;
            pAkhir = pBaru;
            jumlah = 0;
        } else {
            pBaru.sebelum = pAkhir;
            pBaru.setelah = pAwal;
            pAwal.sebelum = pBaru;
            pAkhir.setelah = pBaru;
            pAwal = pBaru;
            jumlah++;
        }
    }

    public void SisipDataDiAkhir(Object data) {
        NodeCDLL pBaru = new NodeCDLL();
        pBaru.data = data;
        pBaru.sebelum = pBaru;
        pBaru.setelah = pBaru;
        if (pAwal == null) {
            pAwal = pBaru;
            pAkhir = pBaru;
            jumlah = 0;
        } else {
            pBaru.sebelum = pAkhir;
            pBaru.setelah = pAwal;
            pAwal.sebelum = pBaru;
            pAkhir.setelah = pBaru;
            pAkhir = pBaru;
            jumlah++;
        }
// lengkapi bagian ini
    }

    public void hapusData(Object dtHapus) {
// lengkapi bagian ini
        NodeCDLL hpsB = pAwal;
        if (pAwal == null) {
            System.out.println("Kosong");
        } else if (pAwal.data.equals(dtHapus)){
            pAkhir.setelah = pAwal.setelah;
            pAwal.setelah.sebelum = pAkhir;
            pAwal.setelah = pAwal;
            jumlah--;
        } else {
            while (!hpsB.setelah.data.equals(dtHapus)) {
                hpsB = hpsB.setelah;
                if (hpsB.equals(pAkhir)) {
                    break;
                }
            }
            if (hpsB.setelah.data.equals(dtHapus)) {
                System.out.println("ketemu");
                NodeCDLL del = hpsB.setelah;
                NodeCDLL aft2 = hpsB.setelah.setelah;
                hpsB.setelah = aft2;
                aft2.sebelum = hpsB;
                del.sebelum = null;
                del.setelah = null;
                jumlah--;
            } else {
                System.out.println("Data not Found!");
            }
            
        }
    }

    public void cetak(String Komentar) {
        System.out.println(Komentar);
        NodeCDLL pCetak;
        pCetak = pAwal;
        int i = -1;
        while ((i < jumlah)) {
            System.out.print(pCetak.data + "->");
            pCetak = pCetak.setelah;
            i++;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
        cdll.SisipDataDiAwal(new Integer(50));
        cdll.SisipDataDiAwal(new Integer(70));
        cdll.SisipDataDiAwal(new Integer(8));
        cdll.SisipDataDiAwal(new Integer(9));
        cdll.SisipDataDiAwal(new Integer(90));
        cdll.SisipDataDiAwal(new Integer(19));
        cdll.cetak("cdll Asal");
        cdll.SisipDataDiAkhir(new Integer(100));
        cdll.cetak("sisip akhir");
        cdll.hapusData(9);
        cdll.cetak("setelah 9 dihapus");
    }
}
