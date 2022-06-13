public class Nasabah{
    private String NomorRekening;
    private String NamaNasabah;
    private long Saldo=0;
    private int NomorKartu;
    private int Pin;
    private String TanggalDaftar;

    public Nasabah(){
        ublic class Nasabah {
            private String NomorRekening;
            private String NamaNasabah;
            private long Saldo=0;
            private int NomorKartu;
            private int Pin;
            private String TanggalDaftar;
        
            public Nasabah() {
            }
            public Nasabah (String NomorRekening){
                this.NomorRekening=NomorRekening;
            }
            public Nasabah(String NomorRekening, String NamaNasabah, long Saldo) {
                this.NomorRekening = NomorRekening;
                this.NamaNasabah = NamaNasabah;
                this.Saldo = Saldo;
                this.TanggalDaftar = java.time.LocalDate.now().toString();
            }
        
            public Nasabah(String NomorRekening, String NamaNasabah, long Saldo, int NomorKartu, int Pin, String TanggalDaftar) {
                this.NomorRekening = NomorRekening;
                this.NamaNasabah = NamaNasabah;
                this.Saldo = Saldo;
                this.NomorKartu = NomorKartu;
                this.Pin = Pin;
                this.TanggalDaftar = TanggalDaftar;
            }
        
            public String getNomorRekening() {
                return this.NomorRekening;
            }
        
            public void setNomorRekening(String NomorRekening) {
                this.NomorRekening = NomorRekening;
            }
        
            public String getNamaNasabah() {
                return this.NamaNasabah;
            }
        
            public void setNamaNasabah(String NamaNasabah) {
                this.NamaNasabah = NamaNasabah;
            }
        
            public long getSaldo() {
                return this.Saldo;
            }
        
            public void setSaldo(long Saldo) {
                this.Saldo = Saldo;
            }
        
            public int getNomorKartu() {
                return this.NomorKartu;
            }
        
            public void setNomorKartu(int NomorKartu) {
                this.NomorKartu = NomorKartu;
            }
        
            public int getPin() {
                return this.Pin;
            }
        
            public void setPin(int Pin) {
                this.Pin = Pin;
            }
        
            public String getTanggalDaftar() {
                return this.TanggalDaftar;
            }
        
            public void setTanggalDaftar(String TanggalDaftar) {
                this.TanggalDaftar = TanggalDaftar;
            }
        
            @Override
            public String toString() {
                return "" + "" + getNomorRekening() + "'" + 
                "\t" + getNamaNasabah() + "'" + "\t\t" + getSaldo() + "'" + "\t" + getNomorKartu() + "'" +
                "\t" + getPin() + "'" +
                "\t" + getTanggalDaftar() + "'" +"";
            }
            
        }
    }
}