import java.util.ArrayList;
import java.util.Scanner;

public class arraylist {
    public static void main(String[] args) throws Exception 
    {
        ArrayList<Nasabah> nasabah = new ArrayList <Nasabah>();
        ArrayList<String> logMutasi = new ArrayList <String>();
        System.out.println("Aplikasi Bank ");

        String yn = "y";
        Scanner input = new Scanner(System.in);
        init(nasabah);
        do {
            menu();
            int pilihan = 0;
            pilihan = input.nextInt();
            
            if(pilihan==1) //tambah data
            {
                String NomorRekening;

                String NamaNasabah;
                long Saldo=0;
                System.out.print("Nama Nasabah \t:\t");
                NamaNsb = input.next();
                System.out.print("Nomor Rekening \t:\t");
                NoRek = input.next();
                System.out.print("Saldo  \t:\t");
                Saldo = input.nextLong();
                nasabah.add(new Nasabah(NomorRekening, NamaNasabah, Saldo));
            }

            else if (pilihan==2)
            {
                String NomorRekening;
                long setoran=0;
                System.out.print ("Nomor Rekening \t:\t");
                NoRek = input.next();
                System.out.print ("Nominal Transfer (IDR)\t:\t");
                setoran = input.nextLong();
                int i=0;
                for (Nasabah nasabah2 : nasabah) {
                    if(nasabah2.getNomorRekening().equals(NomorRekening)){
                        System.out.println("Nomor rekening ditemukan");
                        System.out.println(nasabah2);
                        Nasabah tmpnsb = nasabah2;
                        tmpnsb.setSaldo(tmpnsb.getSaldo() + setoran);
                        nasabah.set(i, tmpnsb);

                        System.out.println("Setoran Berhasil");
                        logMutasi.add("Setor " + setoran + " ke rekening " + tmpnsb.getNomorRekening() + " AN 1" + tmpnsb.getNamaNasabah());
                    }
                i++;
                }

            }
            else if (pilihan==3)
            {
                for (String string : logMutasi){
                    System.out.println(string);
                }
            }
            else if (pilihan==4) 
            {
                String NomorRekening3;
                String NomorRekening4;
                long tf=0;
                System.out.print ("Masukkan Nomor Rekening Anda \t:\t");
                NoRek3 = input.next();
                int  i=0;
                for (Nasabah nasabah3 : nasabah) 
                {
                    i+=1;
                    if(nasabah3.getNomorRekening().equals(NomorRekening3))
                    {
                        System.out.println("Rekening berhasil ditemukan di data "+i);
                        System.out.println("Nama rekening yang mentransfer :  " + nasabah3.getNamaNasabah());
                        System.out.print ("Masukkan Nomor Rekening yang dituju \t:\t");
                        NomorRekening4 = input.next();
                        for (Nasabah nasabah4 : nasabah) 
                        {
                            if(nasabah4.getNomorRekening().equals(NomorRekening4))
                            { 
                                System.out.println("Rekening A/N "+ nasabah4.getNamaNasabah());
                                System.out.print ("Nominal Transfer (IDR)\t:\t");
                                tf = input.nextLong();

                                if(tf<nasabah3.getSaldo() && (nasabah3.getSaldo())!=0)
                                {
                                    Nasabah tmpnsb2 = nasabah3;
                                    tmpnsb2.setSaldo(tmpnsb2.getSaldo()- tf);
                                    Nasabah tmpnsb3 = nasabah4;
                                    tmpnsb3.setSaldo(tmpnsb3.getSaldo() + tf);
                                    nasabah.set(i, tmpnsb2);
                                    logMutasi.add("Transfer " + tf + " ke rekening " + tmpnsb3.getNomorRekening() + " AN " + tmpnsb3.getNamaNasabah());
                                    System.out.println("\n<TRANSAKSI BERHASIL>");
                                    System.out.println("Saldo Tersisa " + tmpnsb2.getSaldo());
                                }
                                else if(tf>nasabah3.getSaldo() || (nasabah3.getSaldo())==0)
                                {
                                    System.out.println("\n<TRANSAKSI GAGAL>");
                                    System.out.println("Maaf, saldo anda tidak mencukupi...");  
                                }
                            }
                            i++;
                        }
                       
                        break;
                    }
                 else if (!(NomorRekening3).equals(nasabah3.getNomorRekening()))
                    { 
                      System.out.println("Rekening belum ditemukan di data "+i);    
                    }
                    
                }
            }
            else if (pilihan==5){
                cetakNamaNasabah(nasabah);
            }
            else if (pilihan==6){
                break;
            }
            else {continue;}
            
            System.out.println("Apakah anda ingin kembali ke menu utama? (y/n)");
            yn = input.next();
        } while (yn.equalsIgnoreCase( "y"));
        input.close();
    }

    public static ArrayList <Nasabah> init(ArrayList <Nasabah> nasabah)
    {
        Nasabah nsb1 = new Nasabah("0308103", "Otto", 2000000);
        nasabah.add(nsb1);
        Nasabah nsb2 = new Nasabah("9084789", "Durandal", 1000000);
        nasabah.add(nsb2);
        Nasabah nsb3 = new Nasabah("7089023", "Bronya", 5000000);
        nasabah.add(nsb3);
        Nasabah nsb4 = new Nasabah("5907532", "Adam", 10000000);
        nasabah.add(nsb4);
        nasabah.add(new Nasabah("3081212", "Hawa", 3000000));
        cetakNamaNasabah(nasabah);
        return nasabah;
    }
    public static void menu()
    {
        System.out.println("Perbankan Sederhana");
        System.out.println("1. Tambah Nasabah ");
        System.out.println("2. Setor Uang");
        System.out.println("3. Cek Mutasi Rekening");
        System.out.println("4. Transfer Uang");
        System.out.println("5. Cetak Data Nasabah");
        System.out.println("6. Keluar");
        System.out.println("Masukkan Pilihan Anda\t:\t");
    }
    public static void hapusNasabah(ArrayList<Nasabah> nasabah, int idx){
        nasabah.remove(idx);        
    }
    public static void hapusNasabah(ArrayList<Nasabah> nasabah, Nasabah nsb){
        nasabah.remove(nsb);        
    }
    public static void cetakNamaNasabah(ArrayList<Nasabah> nasabah){
        System.out.println("No.Rekening\tNama\t\tSaldo\tNo.Rekening\tPIN\tTgl. Daftar");
        System.out.println("-----------------------------------------------------------------------------------");
        for (Nasabah nsbh : nasabah) {
            System.out.println(nsbh);
        }
        System.out.println("------------------------------------------------------------------------------------");
    }
}