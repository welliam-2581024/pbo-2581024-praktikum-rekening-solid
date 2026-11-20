public class Deposito extends Rekening implements BerBunga {
    private double bungaPersen;

    public Deposito(String nomor, String pemilik, int saldo, double bungaPersen) {
        super(nomor, pemilik, saldo);
        this.bungaPersen = bungaPersen;
    }

    @Override
    public int tambahBunga() {
        int bunga = (int) (saldo * bungaPersen / 100);
        setor(bunga);
        return bunga;
    }

    @Override
    public int biayaAdminBulanan() {
        return 0;
    }

    // Versi salah: throw new UnsupportedOperationException("Deposito tidak bisa ditarik");
    // Hasil: Exception in thread "main" java.lang.UnsupportedOperationException: Deposito tidak bisa ditarik
    @Override
    public boolean tarik(int jumlah) {
        return false;
    }

    @Override
    public String keterangan() {
        return "Deposito, bunga " + bungaPersen + "% per bulan";
    }
}