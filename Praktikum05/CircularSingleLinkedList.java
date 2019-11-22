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
class NodeCSLL {

   Object data;
   NodeCSLL setelah;
}

public class CircularSingleLinkedList {

   private NodeCSLL pAwal, pAkhir;
   private int jumlah;

   public CircularSingleLinkedList() {
      pAwal = null;
      pAkhir = null;
      jumlah = -1;
   }

   public void SisipDataDiAwal(Object data) {
      NodeCSLL pBaru = new NodeCSLL();
      pBaru.data = data;
      pBaru.setelah = pBaru;
      if (pAwal == null) { // kosong / empty
         pAwal = pBaru;
         pAkhir = pBaru;
         jumlah = 0;
      } else {
         pBaru.setelah = pAwal;
         pAkhir.setelah = pBaru;
         pAwal = pBaru;
         jumlah++;
      }
   }

   public void SisipDataDiAkhir(Object data) {
      // lengkapi bagian ini
      NodeCSLL pBaru = new NodeCSLL();
      pBaru.data = data;
      pBaru.setelah = pBaru;
      if (pAwal == null) { // kosong / empty
         pAwal = pBaru;
         pAkhir = pBaru;
         jumlah = 0;
      } else {
         pAkhir.setelah = pBaru;
         pBaru.setelah = pAwal;
         pAkhir = pBaru;
         jumlah++;
      }
   }

   /*
    public void SisipDataDiAwal(Integer data) {
        NodeCSLL ins = new NodeCSLL(data);
        if (jumlah == -1) {
            pAwal = ins;
            pAkhir = ins;
            pAkhir.setelah = ins;
            jumlah = 0;
        } else {
            ins.setelah = pAwal;
            pAkhir.setelah = ins;
            pAwal = ins;
            jumlah++;
        }
    } */
 /*
    public void SisipDataDiAkhir(Integer data) {
        // lengkapi bagian ini
        NodeCSLL ins = new NodeCSLL(data);
        if (jumlah == -1) {
            pAwal = ins;
            pAkhir = ins;
            pAkhir.setelah = ins;
            jumlah = 0;
        } else {
            ins.setelah = pAwal;
            pAkhir.setelah = ins;
            pAkhir = ins;
            jumlah++;
        }
    } */
 /*
    public void hapusData(Integer dtHapus) {
        if (pAwal == null) {
            System.out.println("Kosong");
        } else if (pAwal.data.equals(dtHapus)){
            hapusSatuDataDiAwal();
        } else {
            NodeCSLL Curr = pAwal;
            while (!Curr.setelah.data.equals(dtHapus)) {
                Curr = Curr.setelah;
                if (Curr.equals(pAkhir)) {
                    break;
                }
            }
            if (Curr.setelah.equals(pAkhir)&&Curr.setelah.data.equals(dtHapus)) {
                hapusSatuDataDiAkhir();
                System.out.println("has");
            } else if (Curr.setelah.data.equals(dtHapus)) {
                Curr.setelah = Curr.setelah.setelah;
                jumlah--;
            } else {
                System.out.println("Data tidak ditemukan");
            }
        }
    }*/

   public void hapusData(Object dtHapus) {
      if (pAwal != null) {
         NodeCSLL pSbl, pKini, pHapus;
         pSbl = null;
         pKini = pAwal;
         boolean ketemu = false;
         int i = 0;
         while (!ketemu && (i <= jumlah)) {
            if (pKini.data.equals(dtHapus)) {
               ketemu = true;

            } else {
               pSbl = pKini;
               pKini = pKini.setelah;

            }
            i++;
         }
         System.out.println("Ketemu = " + ketemu);
         System.out.println("i = " + i);
         if (ketemu) {
            if (pSbl == null) {
               pHapus = pAwal;
               pAwal = pKini.setelah;
               pAkhir.setelah = pAwal;
               pHapus = null;

            } else {
               if (pAkhir == pKini) {
                  pAkhir = pSbl;
               }
               pSbl.setelah = pKini.setelah;
               pHapus = pKini;
               pHapus = null;

            }
            jumlah--;
         }
      }
   }

   /*
    public void sisipDataUrut(Integer dt){
        NodeCSLL ins = new NodeCSLL(dt);
        ins.setelah = ins;
        NodeCSLL curr = pAwal;
        if (jumlah == -1) {
            pAwal = ins;
            pAkhir = ins;
            pAkhir.setelah = ins;
            jumlah++;
        } else if (ins.data >= curr.data) {
            if (ins.data >= pAkhir.data) {
                SisipDataDiAkhir(ins.data);
            } else {
                while ((ins.data >= curr.setelah.data) && (curr.setelah != pAwal)) {
                    curr = curr.setelah;
                }
                ins.setelah = curr.setelah;
                curr.setelah = ins;
                jumlah++;
            }
        } else {
            SisipDataDiAwal(ins.data);
        }
//        System.out.println("tl : " + pAkhir.data);
    } */
   public void hapusSatuDataDiAwal() {
      // lengkapi bagian ini
      if (jumlah == -1) { // kosong / empty
         System.out.println("Belum ada isi");
      } else {
         pAwal = pAwal.setelah;
         pAkhir.setelah = pAwal;
         jumlah--;
      }
   }

   public void hapusSatuDataDiAkhir() {
// lengkapi bagian ini
      NodeCSLL pBaru = pAwal;
      if (jumlah == -1) { // kosong / empty
         System.out.println("Belum ada isi");
      } else {
         while (!pBaru.setelah.equals(pAkhir)) {
            pBaru = pBaru.setelah;
         }
         pBaru.setelah = pAwal;
         pAkhir = pBaru;
         jumlah--;
      }
   }

   public void cetak(String Komentar) {
      System.out.println(Komentar);
      NodeCSLL pCetak;
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
      CircularSingleLinkedList csll
              = new CircularSingleLinkedList();
//        csll.sisipDataUrut(60);
//        csll.cetak("sisip dt urut 60");
//        csll.sisipDataUrut(70);
//        csll.cetak("sisip dt urut 70");
//        csll.sisipDataUrut(6);
//        csll.cetak("sisip dt urut 6");
//        csll.sisipDataUrut(10);
//        csll.cetak("sisip dt urut 10");
//        csll.sisipDataUrut(91);
//        csll.cetak("sisip dt urut 91");
//        csll.sisipDataUrut(77);
//        csll.cetak("sisip dt urut 77");
//        csll.sisipDataUrut(27);
//        csll.cetak("sisip dt urut FINAL");
      csll.hapusData(80);
      csll.SisipDataDiAwal(new Integer(50));
      csll.SisipDataDiAwal(new Integer(60));
      csll.SisipDataDiAwal(new Integer(70));
      csll.SisipDataDiAwal(new Integer(8));
      csll.SisipDataDiAwal(new Integer(9));
      csll.SisipDataDiAwal(new Integer(90));
      csll.SisipDataDiAwal(new Integer(19));
      csll.cetak("csll Asal");
      csll.SisipDataDiAkhir(new Integer(100));
      csll.cetak("menambah 100 akhir");
      csll.hapusSatuDataDiAkhir();
      csll.cetak("setelah hapus data akhir");
      csll.hapusSatuDataDiAwal();
      csll.cetak("setelah hapus data awal");
      csll.hapusData(8);
      csll.cetak("csll stl 8 dihapus");
      csll.hapusData(999);
      csll.cetak("csll stl 999 dihapus (tetap)");
   }
}
