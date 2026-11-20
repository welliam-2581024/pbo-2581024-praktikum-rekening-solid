public class LaporanBank {
    private static final int LEBAR = 35;

    public void cetakJudul(String judul) {
        StringBuilder sb = new StringBuilder("========== " + judul + " ");
        while (sb.length() < LEBAR) {
            sb.append('=');
        }
        System.out.println(sb);
    }

    public void cetakDaftar(String judul, Rekening[] semua) {
        cetakJudul(judul);
        for (Rekening r : semua) {
            System.out.printf("%s | %-6s | %12s%n", r.getNomor(), r.getPemilik(),
                    Rekening.formatRupiah(r.getSaldo()));
            System.out.println("      " + r.keterangan());
        }
    }

    public void cetakTotal(Rekening[] semua) {
        int total = 0;
        for (Rekening r : semua) {
            total += r.getSaldo();
        }
        System.out.println("-".repeat(LEBAR));
        System.out.println("Total dana bank : " + Rekening.formatRupiah(total));
    }
}