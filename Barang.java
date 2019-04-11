package penjualan;

public class Barang{
    //atribut/ state barang 
    protected String kodeBarang, namaBarang, deskripsiBarang, jenisBarang;
    protected int jumlahBarang, hargaBarang;


    //data construktor
    public Barang(String kd, String nama, String desk, int hrg, int stok){
        this.kodeBarang = kd;
        this.namaBarang = nama;
        this.deskripsiBarang = desk;
        this.hargaBarang = hrg;
        this.jumlahBarang = stok;
    }


    //method/ behavior barang
    //getter
    public String getKode(){
        return this.kodeBarang;
    }
    public String getNama(){
        return this.namaBarang;
    }
    public String getDes(){
        return this.deskripsiBarang;
    }
    public String getJenis(){
        return this.jenisBarang;
    }
    public int getJumlah(){
        return this.jumlahBarang;
    }
    public int getHarga(){
        return this.hargaBarang;
    }


    //setter
    public void setKode(String x){
        this.kodeBarang =x;
    }
    public void setNama(String x){
        this.namaBarang =x;
    }
    public void setDes(String x){
        this.deskripsiBarang =x;
    }
    public void setJenis(String x){
        this.jenisBarang =x;
    }
    public void setStok(int x){
        this.jumlahBarang =x;
    }
    public void setHarga(int x){
        this.hargaBarang =x;
    }
    //fungsi mengurangi Stock barang
    public void barangDibeli(int jumlahBeli){
        this.jumlahBarang -= jumlahBeli;
    }
}