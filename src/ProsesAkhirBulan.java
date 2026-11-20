public class ProsesAkhirBulan {
    public void potongBiayaAdmin(Rekening[] semua) {
        for (Rekening r : semua) {
            System.out.printf("%-17s: %s%n", r.getNomor() + " biaya admin",
                    Rekening.formatRupiah(r.potongBiayaAdmin()));
        }
    }

    public void tambahBunga(BerBunga[] berbunga) {
        for (BerBunga b : berbunga) {
            System.out.printf("%-17s: %s%n", b.getNomor() + " bunga",
                    Rekening.formatRupiah(b.tambahBunga()));
        }
    }

    public void autodebet(Rekening[] semua, int jumlah) {
        for (Rekening r : semua) {
            String hasil = r.tarik(jumlah) ? Rekening.formatRupiah(jumlah) : "gagal";
            System.out.printf("%-17s: %s%n", r.getNomor() + " autodebet", hasil);
        }
    }
}