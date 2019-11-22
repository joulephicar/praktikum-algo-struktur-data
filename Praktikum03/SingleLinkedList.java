/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum03;

import Praktikum01.Buku;

/**
 *
 * @author Zulfikar
 */
class Node {
    Object data;
    Node next;

    public Node(Object data) {
        this.data = data;
    }

    public Node() {
    }
    
}

/**
 *
 * @author joulephicar
 */
public class SingleLinkedList {

    private Node head = null;
    private Node tail = null;
    int size = -1;
    public void sisipDidepan(Buku dt) {
        Node nodeBaru = new Node(dt);
        nodeBaru.next = head;
        head = nodeBaru;
        size++;
    }
    public void sisipDataDiAkhir(Buku data) {
        /* lengkapi method ini */
        Node baru = new Node(data);
        tail.next = baru;
        tail = baru;
        size++;
    }

    /**
     *
     * @param data
     */
    public void sisipDataUrut(Buku data) {
        Node sisip = new Node(data);
        if (head == null) { // ll kosong
            head = sisip;
            tail = sisip;
            size++;
        } else {
            Node curr = head;
            sisip = null;
            // temukan posisi penyisipan dimana nilai hargaSewa bukuBaru < hargaSewa bukuCurrent
            while (curr != null && (data.getHargaSewa() > ((Buku)curr.data).getHargaSewa())) {
                sisip = curr;
                curr = curr.next;
            }
            // temukan posisi penyisipan dimana nilai hargaDenda bukuBaru < hargaDenda bukuCurrent
            // (harga sewa harus ==)
            while (curr != null && (data.getHargaDenda() > ((Buku)curr.data).getHargaDenda())
                    && ((Buku)curr.data).getHargaSewa() == data.getHargaSewa()) {
                sisip = curr;
                curr = curr.next;
            }
            if (sisip != null) { // tunjuk node sisip ke baru
                Node nBaru = new Node(data);
                nBaru.next = curr;
                sisip.next = nBaru;
            } else { // sisip depan kalo emg dari awal dia lebih kecil
                sisipDidepan(data); 
           }
        }
    }
//    public void sisipDataUrut(Object data) {
//// lengkapi bagian ini
//        Node ins = new Node(data);
//        Buku insB = (Buku) ins.data;
//        Node curr = head;
//        if (head == null) {
//            head = ins;
//            tail = ins;
//            tail.next = null;
//            size++;
//            System.out.println("first");
//        } else if (insB.getSewa() > ((Buku)curr.data).getSewa()){
//             
//            if (insB.getSewa() > ((Buku)tail.data).getSewa()) {
//                this.sisipDataDiAkhir(data);
//                System.out.println("true");
//            } else if (insB.getSewa() < ((Buku)curr.data).getSewa()) {
//               
//                while ((insB.getSewa() > ((Buku)curr.next.data).getSewa()) && (curr.next != tail)) {
//                    curr = curr.next;
//                    System.out.println("adadasd");
//                }
//                if (insB.getSewa() == ((Buku)curr.next.data).getSewa()) {
//                    if (insB.getDenda() >= ((Buku)curr.next.data).getDenda()) {
//                        ins.next = curr.next.next;
//                        curr.next.next = ins;
//                        System.out.println("masssss");
//                    } else {
//                        System.out.println("masuk");
//                        ins.next = curr.next;
//                        curr.next = ins;
//                    }
//                } else {
//                    //
//                }
//                ins.next = curr.next;
//                curr.next = ins;
//                System.out.println("oioioio");
//                size++;
//            } else {
//                if (insB.getDenda() >= ((Buku)curr.data).getDenda()) {
//                    this.sisipDataDiAkhir(data);
//                } else {
//                    
//                }
//                
//            }
//        } else {
//            this.sisipDidepan(data);
//            
//                System.out.println("Fistsadadasdad");
//        }
//    }

//    public void sisipDataUrut(Integer dt){
//        NodeCSLL ins = new NodeCSLL(dt);
//        ins.setelah = ins;
//        NodeCSLL curr = pAwal;
//        if (jumlah == -1) {
//            pAwal = ins;
//            pAkhir = ins;
//            pAkhir.setelah = ins;
//            jumlah++;
//        } else if (ins.data >= curr.data) {
//            if (ins.data >= pAkhir.data) {
//                SisipDataDiAkhir(ins.data);
//            } else {
//                while ((ins.data >= curr.setelah.data) && (curr.setelah != pAwal)) {
//                    curr = curr.setelah;
//                }
//                ins.setelah = curr.setelah;
//                curr.setelah = ins;
//                jumlah++;
//            }
//        } else {
//            SisipDataDiAwal(ins.data);
//        }
////        System.out.println("tl : " + pAkhir.data);
//    }
    
    public Node getPointer() {
        return head;
    }

    public void cetak(String kom) {
        System.out.println(kom);
        Node n = head;
        while (n != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Buku buku1 = new Buku("Komputer", "Pemrograman Java", 2000, 3000);
        Buku buku2 = new Buku("Pendidikan", "Matematika SMA", 2500, 2500);
        Buku buku3 = new Buku("Komputer", "Belajar Microsoft Office", 2000, 7000);
        Buku buku4 = new Buku("Novel", "Laskar Pelangi", 1000, 4000);
        Buku buku5 = new Buku("Komik", "Doraemon", 2000, 5000);
        SingleLinkedList ll = new SingleLinkedList();
        ll.sisipDataUrut(buku1);
        ll.sisipDataUrut(buku2);
        ll.sisipDataUrut(buku3);
        ll.sisipDataUrut(buku4);
        ll.sisipDataUrut(buku5);
        ll.cetak("Linked List Buku");
    }
//    public static void main(String[] args) {
//        SingleLinkedList l = new SingleLinkedList();
////        l.sisipDidepan(11);
////        l.sisipDidepan(2);
////        l.sisipDidepan(30);
////        l.sisipDidepan(14);
////        l.sisipDidepan(5);
////        l.sisipDidepan(16);
////        l.cetak("l : LL Asal");
////        l.sisipDataDiAkhir(56);
////        l.cetak("l : LL setelah sisip di akhir");
////        System.out.println(l.hapusDiDepan());
////        l.cetak("l : LL setelah dihapus di depan");
////        System.out.println(l.hapusDiAkhir());
////        l.cetak("l : LL setelah dihapus di akhir");
////        l.hapusData(30);
////        l.cetak("LL setelah 30 dihapus");
////        SingleLinkedList l2 = new SingleLinkedList();
////        l2.sisipDataUrut(5);
////        l2.sisipDataUrut(1);
////        l2.sisipDataUrut(21);
////        l2.sisipDataUrut(3);
////        l2.sisipDataUrut(9);
////        l2.sisipDataUrut(16);
////        l2.sisipDataUrut(12);
////        l2.cetak("L2 : LL terurut");
////        SingleLinkedList L3 = SingleLinkedList.gabung(l, l2);
////        L3.cetak("L3 : L gabungan L1 dan L2");
//    }
}
