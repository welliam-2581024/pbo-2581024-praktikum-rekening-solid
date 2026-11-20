public class Giro extends Rekening {
    private int batasOverdraft;

    public Giro(String nomor, String pemilik, int saldo, int batasOverdraft) {
        super(nomor, pemilik, saldo);
        this.batasOverdraft = batasOverdraft;
    }

    @Override
    public int biayaAdminBulanan() {
        return 15000;
    }

    @Override
    public boolean tarik (int jumlah) {
        if (jumlah <= 0 || saldo - jumlah < -batasOverdraft) {
            return false;
        }

        saldo -= jumlah;
        return true;
    }

    @Override
    public void keterangan() {
        return ("Giro, batas overdraft " + formatRupiah(batasOverdraft));
    }
}