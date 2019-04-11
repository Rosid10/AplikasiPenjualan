package penjualan;

import penjualan.Pegawai;
import penjualan.Pelanggan;
import java.util.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Penjualan{
    String noTransaksi, tgl;
    String kodeBarang, idPegawai, idPelanggan;
    int jumlahBeli;
    int harga;

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int menu;
    static HashMap<String,Barang> item = new HashMap<String,Barang>();   //Barang dihashmap mengambil dari class Barang
    static HashMap<String,Pelanggan> listPelanggan = new HashMap<String,Pelanggan>();
    static HashMap<String,Pegawai> listPegawai = new HashMap<String,Pegawai>();

    public void kurangStok(String kode){
        int a =this.item.get(kode).getJumlah()-this.jumlahBeli;
        this.item.get(kode).setStok(a);
    }


    public int totalBayar(){
        return this.harga * this.jumlahBeli;
    }

    public static Boolean hasBarang(String kode){
        if(item.containsKey(kode)){
            return true;
        }
        return false;
    }

    public static void cekBarang(String kode){
        if(item.containsKey(kode)){
            System.out.println("Barang dengan kode "+kode+" ada, dengan nama "+item.get(kode).getNama());

        }else{
            System.out.println("Barang tidak ditemukan di gudang");
        }
    }
        public static Boolean hasPelanggan(String a){
            if(listPelanggan.containsKey(a)){
               return true;
            }
            return false;
    
        }
        public static void cekMember(String id){
            if(listPelanggan.containsKey(id)){
                System.out.println("Member dengan ID "+id+" ada, dengan nama "+listPelanggan.get(id).getNama());
            }else{
                System.out.println("Member tidak ditemukan di gudang");
            }
        }


    public static void jual() throws IOException{
        //input barang hansmap
        item.put("B001", new Barang("B001","Asus Pro","Laptop gaming",600000,20));
        item.put("B002", new Barang("B002","Lenovo","Laptop Pro",700000,20));
        item.put("B003", new Barang("B003","Accer","Laptop Lemot",400000,20));
        item.put("B004", new Barang("B004","Notebook","Laptop Kecil",200000,20));
        
        //Tampilin list barang dilayar
        for(String i: item.keySet()){
            System.out.println("Nama Barang   : "+item.get(i).getNama());
            System.out.println("Kode Barang   : "+item.get(i).getKode());
            System.out.println("Harga         : "+item.get(i).getHarga());
            System.out.println("Stok          : "+item.get(i).getJumlah()+ "\n");
        }

        //Input data ke member
        listPelanggan.put("M001", new Pelanggan("M001", "Rosyid"));
        listPelanggan.put("M002", new Pelanggan("M002", "Andini"));

        listPegawai.put("P001", new Pegawai("P001","Robert"));
        //cek barang berdasarkan kode yang diinput
        System.out.print("Silahkan Masukkan Kode Barang Yang DiBeli : ");
        String kode = input.readLine().toUpperCase();

        if(hasBarang(kode) == false){
            System.out.println("Maaf barang dengan kode "+kode+" tersebut tidak ada.");
        }

        System.out.print("Silahkan masukkan kode Pelanggan : ");
        String idPelanggan = input.readLine().toUpperCase();
        
        if(hasPelanggan(idPelanggan) == false){
            System.exit(1);
        }
        System.out.print("Jumlah Beli : ");
        int jumlahBeli = Integer.parseInt(input.readLine());

        Penjualan trx = new Penjualan();
        trx.noTransaksi = item.get(kode).getKode()+listPelanggan.get(idPelanggan).getId();
        trx.kodeBarang = item.get(kode).getKode();
        trx.idPelanggan = listPelanggan.get(idPelanggan).getId();
        trx.tgl = "21/02/2019";
        trx.harga = item.get(kode).getHarga();
        trx.jumlahBeli = jumlahBeli;

        //fungsimengurangi stock //item.get(kode).barangDibeli(jumlahBeli);
        trx.kurangStok(kode);
        System.out.print("Jumlah Sisa Barang Anda : ");
        System.out.println(item.get(kode).getJumlah());
        
        /* Print Struk */ 
        System.out.println("\n\n================================================");
        System.out.println("+               NOTA PENJUALAN                  ");
        System.out.println("================================================");
        System.out.println("+ Tanggal             : "+trx.tgl);
        System.out.println("+ No.Transaksi        : "+trx.noTransaksi);
        System.out.println("+ Member              : "+listPelanggan.get(idPelanggan).getId()+" - "+listPelanggan.get(idPelanggan).getNama());
        System.out.println("+ Barang              : "+item.get(kode).getKode()+" - "+item.get(kode).getNama());
        System.out.println("+ Harga Satuan        : Rp."+trx.harga+",-");
        System.out.println("+ Jumlah Beli         : "+trx.jumlahBeli+" buah");
        System.out.println("================================================");
        System.out.println("+ TOTAL               : Rp."+trx.totalBayar()+",-");
        System.out.println("================================================");
        System.out.println("+                               Kasir           ");
        System.out.println("+");
        System.out.println("+                               "+listPegawai.get("P001").getNama());
        System.out.println("\n");
    }
    
    public static void menu() throws IOException{
        /* Pengulangan menu ketika engga pilih tombol keluar */
        boolean run =true;
        while(run == true){
            System.out.println("================================================");
            System.out.println("               Aplikasi Penjualan               ");
            System.out.println("================================================");
            System.out.println("                      MENU                      ");
            System.out.println("------------------------------------------------");
            System.out.println("    Kode        Aksi                            ");
            System.out.println("    1.      Jual Barang                         ");
            System.out.println("    2.      Input Barang                        ");
            System.out.println("    3.      Input Pelanggan                     ");
            System.out.println("    4.      Inputan Pegawai                     ");
            System.out.println("    X.      Keluar                              ");
            System.out.println("------------------------------------------------");
            System.out.print("    Silakan pilih menu :");
            String pilihan = input.readLine();
            
            /* Membandingkan string */
            if(pilihan.equalsIgnoreCase("x")){
                run = false;
                System.out.println("================================================");
            }
            else{
                run = true;
                menu =Integer.parseInt(pilihan);
                System.out.println("================================================");
                if(menu == 1){
                    jual();
                }
                else if(menu == 2){
                    inputBarang();
                }
                else if(menu == 3){
                    inputPelanggan();
                }
                else if(menu == 4){
                    inputPegawai();
                }
                else{
                    System.exit(1);
                }
            }
        
        }
    }
        
    public static void inputBarang() throws IOException{
        System.out.println("================================================");
        System.out.println("                Input barang                  ");
        System.out.println("================================================");
        System.out.print("Masukkan jumlah data barang yang akan diinput [B untuk kembali]   :");
        String in = input.readLine();
           /* Membandingkan string, back ke menu */
        if(in.equalsIgnoreCase("B")){
            menu();
            
        }else{
            try{    /* Try and Catch Exception jika jumlah bukan int */
            int jumlah = Integer.parseInt(in);
            for(int i=1; i <= jumlah;i++){
                System.out.print("Kode Barang         :");
                String kode = input.readLine().toUpperCase();
                System.out.print("Nama Barang         :");
                String nama = input.readLine();
                System.out.print("Deskripsi Barang    :");
                String desk = input.readLine();
                System.out.print("Harga Barang        :");
                int hrg = Integer.parseInt(input.readLine());
                System.out.print("Stok Masuk          :");
                int stok = Integer.parseInt(input.readLine());
            
                item.put(kode,new Barang(kode,nama,desk,hrg,stok));
                System.out.println("Barang berhasil diinput !");
            }
         /* Tampilin list barang di layar */
            for(String i: item.keySet()){
                System.out.println("Nama Barang : " + item.get(i).getNama());
                System.out.println("Kode Barang : " + item.get(i).getKode());
                System.out.println("Harga       : " + item.get(i).getHarga());
                System.out.println("Stok        : " + item.get(i).getJumlah() + "\n");
                }
            menu();
        }
        catch(Exception e){
            System.out.println("Bang, data yang diinput salah !");
            menu();
        }
    }
    }

    public static void inputPelanggan() throws IOException{
        System.out.println("================================================");
        System.out.println("                Input Pelanggan                  ");
        System.out.println("================================================");
        System.out.print("Nama Pelanggan        : ");
        String nama = input.readLine();
        System.out.print("ID Pelanggan          : ");
        String id = input.readLine().toUpperCase();
        System.out.print("Email pelanggan       : ");
        String email = input.readLine();
        System.out.print("Alamat Pelanggan      : ");
        String alamat = input.readLine();
        System.out.print("Jenis Kelamin         : ");
        char jk = input.readLine().charAt(0);
        System.out.print("Nomor HandPhone       : ");
        String NoHp = input.readLine();
            listPelanggan.put(nama,new Pelanggan(nama,id,email,NoHp,alamat));
            /* Tampilin list barang di layar */
            for(String i: item.keySet()){
                System.out.println("Nama Barang         : " + listPelanggan.get(i).getNama());
                System.out.println("Kode Barang         : " + listPelanggan.get(i).getId());
                System.out.println("Jenis Kelamin       : " + listPelanggan.get(i).getJk());
                System.out.println("Email               : " + listPelanggan.get(i).getEmail());
                System.out.println("Nomer Handphone     : " + listPelanggan.get(i).getNoHp());
                System.out.println("Alamat              : " + listPelanggan.get(i).getAlamat());

            
            }
        menu();
        }

        public static void inputPegawai() throws IOException{
            System.out.println("================================================");
            System.out.println("                Input Pegawai                   ");
            System.out.println("================================================");
            System.out.print("Nama Pelanggan        : ");
            String nama = input.readLine();
            System.out.print("ID Pelanggan          : ");
            String id = input.readLine().toUpperCase();
                listPegawai.put(id, new Pegawai(nama,id));
                System.out.println("Pegawai Cabul !!!");
                for(String i : listPelanggan.keySet()){
                    System.out.println("Nama Pegawai     : " + listPegawai.get(i).getNama());
                    System.out.println("ID Pegawai       : " + listPegawai.get(i).getId());

         
                }
                menu();
        }

        

    public static void main(String[] args) throws IOException{
        
        menu();
        

    }


}

    //  Barang brg1 = new Barang();
    //  brg1.setKode("B001");
    //  brg1.setNama("Asus Pro");
    //  brg1.setJenis("Laptop");
    //  brg1.setStok(10);
    //  brg1.setHarga(500000);

        //item.get("brg2").getNama();     //uSntuk memanggil barang ke-2

      //Pelanggan member1 = new Pelanggan();
      //member1.setId("M001");
      //member1.setNama("rosyid");
      //member1.setJk('L');

      //Pegawai empl1 = new Pegawai();
      //empl1.setId("P001");
      //empl1.setNama("Wawan");

      //Penjualan trx1 = new Penjualan();
      //trx1.noTransaksi = brg1.getKode() + member1.getId() + empl1.getId();
      //trx1.tgl = "20/02/2019";
      //trx1.kodeBarang = brg1.getKode();
      //trx1.idPegawai = empl1.getId();
      //trx1.idPelanggan = member1.getId();
      //trx1.jumlahBeli = 2;
      //trx1.harga = brg1.getHarga();

    //  System.out.println("     NOTA PENJUALAN    ");
    //  System.out.println("===========================");
    //  System.out.print("No. Transaksi : ");
    //  System.out.println(trx1.noTransaksi);
    //  System.out.print("Member : ");
    //  System.out.println(member1.getId()+" - "+member1.getNama());
    //  System.out.print("Kode Barang : ");
    //  System.out.println(brg1.getKode());
    //  System.out.print("Nama Barang : ");
    //  System.out.println(brg1.getNama());
    //  System.out.print("Jumlah Beli : ");
    //  System.out.println(trx1.jumlahBeli);
    //  System.out.print("Harga : ");
    //  System.out.println(brg1.getHarga());
    //  System.out.print("Total Bayar : ");
    //  System.out.println(trx1.totalBayar());
    //  System.out.print("\nTerima Kasih\n");
    //  System.out.println(empl1.getNama());