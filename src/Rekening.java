import java.util.Locale;

public abstract class Rekening {
    private String nomor;
    private String pemilik;
    protected  int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public abstract int biayaAdminBulanan();

    public abstract String keterangan();

    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    public String getNomor() {
        return nomor;
    }

    public String getPemilik() {
        return pemilik;
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean setor(int jumlah) {
        if (jumlah <= 0) {
            return false;
        }
        saldo+= jumlah;
        return true;
    }

    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo) {
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    protected static String formatRupiah(int angka) {
        return "Rp" + String.format(Locale.US, "%,d", angka).replace(',', ',');
    }
}