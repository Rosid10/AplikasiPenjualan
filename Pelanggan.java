package penjualan;

public class Pelanggan{
    protected String idPelanggan,namaPelanggan,deskripsibarang,jenisbarang,alamat,email,NoHp;
    protected char jk;

    protected int jumlahbarang,hargabarang;
    public Pelanggan(){

    }

//data construktor
    public Pelanggan(String id, String nama, String email, String NoHp, String alamat){
        this.idPelanggan = id;
        this.namaPelanggan = nama;
        this.email = email;
        this.NoHp = NoHp;
        this.alamat = alamat;
        
    }


    public void setId(String id){
        this.idPelanggan = id;
    }
    public void setNama(String nama){
        this.namaPelanggan = nama;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setNoHp(String NoHp){
        this.NoHp = NoHp;
    }
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    public void setJk(char jk){
        this.jk = jk;
    }
    public String getId(){
        return this.idPelanggan;
    }
    public String getNama(){
        return this.namaPelanggan;
    }
    public String getEmail(){
        return this.email;
    }
    public String getNoHp(){
        return this.NoHp;
    }
    public String getAlamat(){
        return this.alamat;
    }

    public String getJk(){
        if(this.jk == 'L'){
            return "Laki-Laki";
        }
            return "Perempuan";
        
    }
}