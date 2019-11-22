/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum04;

import Praktikum01.Buku;
import java.util.*;

class NodeDLL {

    Object data;
    NodeDLL prev, next;
}

public class DoubleLinkedList {

    private NodeDLL pKepala, pEkor;

    public DoubleLinkedList() {
        pKepala = null;
        pEkor = null;
    }

    public void sisipDipKepala(Buku dt) {
        NodeDLL baru = new NodeDLL();
        baru.data = dt;
        if (pKepala == null) {
            baru.prev = pKepala;
            baru.next = pEkor;
            pKepala = baru;
            pEkor = baru;
        } else {
            baru.next = pKepala;
            pKepala.prev = baru;
            pKepala = baru;
        }
    }

    public void sisipDipEkor(Buku data) {
        NodeDLL baru = new NodeDLL();
        baru.data = data;
        if (pEkor == null) {
            baru.prev = pKepala;
            baru.next = pEkor;
            pKepala = baru;
            pEkor = baru;
        } else {
            baru.prev = pEkor;
            pEkor.next = baru;
            pEkor = baru;
        }
    }

    public void cetak(String kom) {
        System.out.println(kom);
        NodeDLL p = pKepala;
        if (pKepala == null) {
            System.out.println(">> Kosong");
        }
        while (p != pEkor.next) {
            System.out.print(p.data + "->");
            p = p.next;
        }
        System.out.println();
    }

    public void hapusDataTertentu(String judulBuku) {
        NodeDLL curr = pKepala;
        boolean flag = false;
        if (pKepala == null) { // klo masih kosong
            System.out.println(">> Linked List Kosong!!!"); return;
        } else if (((Buku) curr.data).getJudul().equals(judulBuku)) {
            pKepala = curr.next;  // klo di head
            flag = true;
        } else {
            while (curr.next != null) { // while nyari yang sama
                if (!((Buku) curr.next.data).getJudul().equals(judulBuku)) {
                    curr = curr.next; // next trus klo blom ketemu
                } else { // klo sama kaya judul
                    if (curr.next.next != null) {
                        curr.next.next.prev = curr;
                        flag = true;
                        curr.next = curr.next.next;
                        break;
                    } else {
                        curr.next = null;
                        flag = true;
                    }
                }
            }
        }
        if (!flag) {
            System.out.println(">> Data tidak ditemukan!!!");
        } else {
            System.out.println(">> Data berhasil dihapus!!!");
        }
    }

    public void sisipDataTerurut(Buku data) {
        NodeDLL temp = new NodeDLL();
        temp.data = data;
        if (pKepala == null) {
            pKepala = temp;
        } else {
            NodeDLL curr = pKepala;
            temp = null;
            while (curr != null && ((Buku) curr.data).getHargaSewa() < data.getHargaSewa()) {
                temp = curr;
                curr = curr.next;
            }
            while (curr != null && ((Buku) curr.data).getHargaDenda() < data.getHargaDenda() && ((Buku) curr.data).getHargaSewa() == data.getHargaSewa()) {
                temp = curr;
                curr = curr.next;
            }
            if (temp != null) {
                NodeDLL baru = new NodeDLL();
                baru.data = data;
                baru.next = curr;
                temp.next = baru;
                baru.prev = temp;
            } else {
                sisipDipKepala(data);
            }
        }
    }

    public static void main(String s[]) {
        DoubleLinkedList dll = new DoubleLinkedList();
        Scanner in = new Scanner(System.in);
        short pil = 0;
        String kategori, judul;
        double hargaSewa, hargaDenda;

        do {
            System.out.println("===== Program Perpus versi DLL: =====");
            System.out.println(">>");
            System.out.println(">> Menu: ");
            System.out.println(">> 1. Tambah Buku di Awal DLL");
            System.out.println(">> 2. Tambah Buku di Akhir DLL");
            System.out.println(">> 3. Hapus Suatu Buku berdasarkan judul");
            System.out.println(">> 4. Sisip Buku secara terurut");
            System.out.println(">> 5. Lihat Data Buku");
            System.out.println(">> 0. Keluar");
            System.out.print(">> Masukkan pilihan: ");
            pil = in.nextShort();
            in.nextLine();
            switch (pil) {
                case 1:
                    System.out.println(">> Isi data berikut: ");
                    System.out.print(">> Kategori Buku   : ");
                    kategori = in.nextLine();
                    System.out.print(">> Judul Buku      : ");
                    judul = in.nextLine();
                    System.out.print(">> Harga Sewa Buku : ");
                    hargaSewa = in.nextDouble();
                    System.out.print(">> Harga Denda Buku: ");
                    hargaDenda = in.nextDouble();
                    Buku tambahAwal = new Buku(kategori, judul, hargaSewa, hargaDenda);
                    System.out.println(">> Buku yang akan ditambah:");
                    System.out.printf(">> %s",tambahAwal.toString());
                    dll.sisipDipKepala(tambahAwal);
                    System.out.println(">> Buku berhasil ditambah!!!");
                    break;
                case 2:
                    System.out.println(">> Isi data berikut: ");
                    System.out.print(">> Kategori Buku   : ");
                    kategori = in.nextLine();
                    System.out.print(">> Judul Buku      : ");
                    judul = in.nextLine();
                    System.out.print(">> Harga Sewa Buku : ");
                    hargaSewa = in.nextDouble();
                    System.out.print(">> Harga Denda Buku: ");
                    hargaDenda = in.nextDouble();
                    Buku tambahAkhir = new Buku(kategori, judul, hargaSewa, hargaDenda);
                    System.out.println(">> Buku yang akan ditambah:");
                    System.out.printf(">> %s",tambahAkhir.toString());
                    dll.sisipDipKepala(tambahAkhir);
                    System.out.println(">> Buku berhasil ditambah!!!");
                    break;
                case 3:
                    dll.cetak(">> daftar Buku: ");
                    System.out.println(">> Masukkan judul yang ingin dihapus: ");
                    System.out.print(">> ");
                    String jdl = in.nextLine();
                    dll.hapusDataTertentu(jdl);
                    break;
                case 4:
                    System.out.println(">> Isi data berikut: ");
                    System.out.print(">> Kategori Buku   : ");
                    kategori = in.nextLine();
                    System.out.print(">> Judul Buku      : ");
                    judul = in.nextLine();
                    System.out.print(">> Harga Sewa Buku : ");
                    hargaSewa = in.nextDouble();
                    System.out.print(">> Harga Denda Buku: ");
                    hargaDenda = in.nextDouble();
                    Buku tambahUrut = new Buku(kategori, judul, hargaSewa, hargaDenda);
                    System.out.println(">> Buku yang akan ditambah:");
                    System.out.printf(">> %s",tambahUrut.toString());
                    dll.sisipDataTerurut(tambahUrut);
                    System.out.println(">> Buku berhasil ditambah!!!");
                    break;
                case 5:
                    dll.cetak(">> Isi DLL: ");
                    break;
                case 0:
                    System.out.println(">> Keluar dari Program...");
                    break;
                default:
                    System.out.println(">> Masukan salah!!!");
            }
        } while (pil != 0);

    }
}
