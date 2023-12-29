package project;

import java.util.ArrayList;
import java.util.List;

public class BellekYonetimi {
    private static final int BELLEK_BOYUTU = 1024; // MB cinsinden bellek boyutu
    private static final int GERCEK_ZAMANLI_BELLEK = 64; // MB cinsinden gerçek zamanlı prosesler için ayrılan bellek
    private static final int KULLANICI_BELLEK = 960; // MB cinsinden kullanıcı prosesleri için ayrılan bellek

    private List<Integer> bellekBloklari;

    public BellekYonetimi() {
        bellekBloklari = new ArrayList<>(BELLEK_BOYUTU);
        for (int i = 0; i < BELLEK_BOYUTU; i++) {
            bellekBloklari.add(0); // Başlangıçta tüm bellek blokları boş
        }
    }

    // Bellek tahsis etme metodu
    public boolean bellekTahsisEt(Process proses) {
        int istenenBellek = proses.getBellekBoyutu();
        int baslangicIndeksi = (proses.getOncelik() == 0) ? 0 : GERCEK_ZAMANLI_BELLEK;

        for (int i = baslangicIndeksi; i < BELLEK_BOYUTU - istenenBellek; i++) {
            boolean uygun = true;
            for (int j = i; j < i + istenenBellek; j++) {
                if (bellekBloklari.get(j) != 0) { // Bellek kullanılıyor
                    uygun = false;
                    break;
                }
            }
            if (uygun) {
                // Bellek tahsisi yap
                for (int k = i; k < i + istenenBellek; k++) {
                    bellekBloklari.set(k, proses.getProsesID()); // Prosese tahsis et
                }
                return true;
            }
        }
        return false; // Uygun bellek bloğu bulunamadı
    }

    // Bellek serbest bırakma metodu
    public void bellekSerbestBirak(Process proses) {
        int baslangicIndeksi = (proses.getOncelik() == 0) ? 0 : GERCEK_ZAMANLI_BELLEK;
        int prosesID = proses.getProsesID();

        for (int i = baslangicIndeksi; i < BELLEK_BOYUTU; i++) {
            if (bellekBloklari.get(i) == prosesID) {
                bellekBloklari.set(i, 0); // Belleği serbest bırak
            }
        }
    }
}
