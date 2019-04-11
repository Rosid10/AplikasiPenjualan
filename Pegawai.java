package penjualan;

public class Pegawai{
    String idPegawai, namaPegawai;
//data construktor
    public Pegawai(String id, String nama){
        this.idPegawai = id;
        this.namaPegawai = nama;
    }

    public void setId(String idPegawai){
        this.idPegawai = idPegawai;
    }
    public void setNama(String namaPegawai){
        this.namaPegawai = namaPegawai;
    }
    public String getId(){
        return this.idPegawai;
    }
    public String getNama(){
        return this.namaPegawai;
    }
}