package Praktikum01;
//import java.time.*;
public class Buku {
    private String kategori;
    private String judul;
    private double hargaSewa;
    private double hargaDenda;
//    private LocalDate deadlineSewa;
    public Buku() {
    }

    public Buku(String kategori, String judul,
            double sewa, double denda) {
        this.kategori = kategori;
        this.judul = judul;
        this.hargaSewa = sewa;
        this.hargaDenda = denda;
    }
    
    public double getHargaSewa() {
        return hargaSewa;
    }
    public double getHargaDenda() {
        return hargaDenda;
    }
    public String getKategori() {
        return kategori;
    }
    public String getJudul() {
        return judul;
    }
//    public void setDeadlineSewa(LocalDate hariSewa) {
//        this.deadlineSewa = hariSewa;
//    }
//    public LocalDate getDeadlineSewa() {
//        return deadlineSewa;
//    }
    @Override
    public String toString() {
        return " Buku " + judul + ", \n"
                + "      Kategori   : " + kategori + "\n"
                + "      Harga Sewa : Rp. " + (int)hargaSewa
                + ",00 / hari\n"
                + "      Harga Denda: Rp. " + (int)hargaDenda
                + ",00 / hari\n";
    }
}
