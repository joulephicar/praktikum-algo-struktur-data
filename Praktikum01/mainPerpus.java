package Praktikum01;

import java.util.*;
import java.time.*;

public class mainPerpus {
    public static void tampil(ArrayList<Buku> data){
        int counter = 0;
        for (Buku b: data){
            counter++;
            System.out.printf("  %d. %s",counter,b.toString());
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        LocalDate tudey = LocalDate.now();
//        char c;
//        ArrayList<Buku> dataBuku = new ArrayList<>();
//        dataBuku.add(new Buku("Dongeng Anak, Si Mpus dan Si Heli", "Kids", 2000, 200));     
//        dataBuku.add(new Buku("Arti-arti dari Gerakan Ekor Kucing", "Life", 1500, 250));
//        dataBuku.add(new Buku("Dongeng Anak, Si Mpus dan Si Heli", "Kids", 2000, 200)); 
//        dataBuku.add(new Buku("Gundala sang Patriot", "Komik", 5000, 1000));
//        dataBuku.add(new Buku("101 Perintah Penting dalam Linux", "Pengetahuan", 2000, 500));
//        int kasus;
//        do {  
//            System.out.printf("\n========Menu Perpustakaan========\n");
//            System.out.println("1. Menampilkan Daftar Buku");
//            System.out.println("2. Menyewa Buku");
//            System.out.println("3. Mengembalikkan Buku");
//            System.out.println("0. Keluar");
//            System.out.print("Pilih Menu: ");
//            kasus = in.nextInt();
//            switch (kasus) {
//                case 1:
//                    tampil(dataBuku);
//                    break;
//                case 2:
//                    System.out.printf("Buku mana yang ingin dipinjam? ");
//                    int pil = in.nextInt(); pil--;
//                    System.out.printf("Berapa lama meminjam buku (hari)? ");
//                    int day = in.nextInt();
////                    int harga = dataBuku.get(pil).getSewa()*day;
//                    System.out.printf("Total harga peminjaman buku selama %d"
//                            + " hari: Rp. %d,00\n", day, harga);
//                    System.out.printf("Anda Yakin? (Y/n) ");
//                    c = in.next().charAt(0);
//                    if (c == 'y' || c == 'Y') {
//                        System.out.printf("Berhasil Memesan...\n");
//                        LocalDate hari = tudey.plusDays(day);
//                        dataBuku.get(pil).setDeadlineSewa(hari);
//                        System.out.println("Deadline pengembalian buku: "
//                                + dataBuku.get(pil).getDeadlineSewa());
//                    } else {
//                        System.out.printf("Pemesanan dibatalkan\n");
//                    }
//                    break;
//                case 3:
//                    System.out.printf("Tanggal berapa sekarang? (format 20xx-08-20) : ");
//                    String now = in.next();
//                    LocalDate skr = LocalDate.parse(now);
//                    System.out.printf("Buku mana yang ingin dikembalikkan? ");
//                    int pili = in.nextInt(); pili--;
//                    try { // menjalankan sintaksis jika deadline buku ke-pili != null
//                        LocalDate deadL = dataBuku.get(pili).getDeadlineSewa();
//                        if (skr.isAfter(deadL)) { // apakah sekarang lewat deadl
//                            long jarak = Duration.between(deadL.atStartOfDay(),
//                                    skr.atStartOfDay()).toDays();
//                            System.out.printf("Anda mengembalikan buku "
//                                    + "terlambat %d hari\nDenda yang "
//                                    + "harus dibayarkan: Rp. %d,00\n", jarak,
//                                    jarak * dataBuku.get(pili).getDenda());
//                        }
//                        System.out.printf("Anda yakin? (Y/n) ");
//                        c = in.next().charAt(0);
//                        if (c == 'y' || c == 'Y') {
//                            System.out.printf("Berhasil mengembalikan...\n");
//                            dataBuku.get(pili).setDeadlineSewa(null); //set null
//                        } else {
//                            System.out.printf("Pengembalian dibatalkan\n");
//                        }
//                    } catch (NullPointerException e) { // jika deadline = null
//                        System.out.println("Anda tidak meminjam buku tersebut!");
//                    }
//                    break;
//                case 0:
//                    System.out.println("Terima Kasih...");
//                    break;
//                default:
//                    System.out.println("Menu tak ditemukan!");
//            }
//        } while (kasus != 0);
    }
}