package project;

import java.util.Queue;
import java.util.LinkedList;

public class Gorevlendirici {
    private Queue<Process> gercekZamanliKuyruk;
    private Queue<Process> kullaniciKuyruk;
    private BellekYonetimi bellekYonetimi;
    private KaynakTahsisi kaynakYonetimi;
    private GBG geriBeslemeSiralayici;

    public Gorevlendirici() {
        gercekZamanliKuyruk = new LinkedList<>();
        kullaniciKuyruk = new LinkedList<>();
        bellekYonetimi = new BellekYonetimi();
        kaynakYonetimi = new KaynakTahsisi();
        geriBeslemeSiralayici = new GBG();
    }

    // İşlemleri kuyruğa ekleme
    public void prosesEkle(Process proses) {
        if (proses.getOncelik() == 0) {
            gercekZamanliKuyruk.add(proses);
        } else {
            kullaniciKuyruk.add(proses);
        }
    }

    // Görevlendirici çalıştırma metodu
    public void calistir() {
        while (!gercekZamanliKuyruk.isEmpty() || !kullaniciKuyruk.isEmpty()) {
            if (!gercekZamanliKuyruk.isEmpty()) {
                // Gerçek zamanlı prosesleri işle
            	Process gercekZamanliProses = gercekZamanliKuyruk.poll();
                calistirProses(gercekZamanliProses);
            } else {
                // Kullanıcı kuyruğundaki prosesleri işle
            	Process kullaniciProsesi = kullaniciKuyruk.poll();
                geriBeslemeSiralayici.oncelikDegistir(kullaniciProsesi); // Öncelik değişikliği yap
                calistirProses(kullaniciProsesi);
            }
        }
    }

    // Prosesi çalıştırma işlevi
    private void calistirProses(Process proses) {
        if (bellekYonetimi.bellekTahsisEt(proses)) {
            if (kaynakYonetimi.kaynakTahsisEt(proses)) {
                // Prosesi çalıştır
                System.out.println("Proses çalışıyor: " + proses.toString());
                try {
                    Thread.sleep(proses.getProsesZamani() * 1000); // Süre simülasyonu için
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Proses tamamlandığında bellek ve kaynakları serbest bırak
                bellekYonetimi.bellekSerbestBirak(proses);
                kaynakYonetimi.kaynaklariSerbestBirak(proses);
                System.out.println("Proses tamamlandı: " + proses.toString());
            } else {
                // Kaynak tahsisi yapılamadı, proses beklemeye alınabilir veya iptal edilebilir.
                System.out.println("Proses için yeterli kaynak yok: " + proses.toString());
            }
        } else {
            // Bellek tahsisi yapılamadı, proses beklemeye alınabilir veya iptal edilebilir.
            System.out.println("Bellek tahsisi yapılamadı: " + proses.toString());
        }
    }
}

