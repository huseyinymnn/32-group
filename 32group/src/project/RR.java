package project;

import java.util.LinkedList;
import java.util.Queue;

public class RR {
    private Queue<Process> prosesKuyrugu;
    private int quantum;

    public RR(int quantum) {
        this.quantum = quantum;
        prosesKuyrugu = new LinkedList<>();
    }

    public void sirala(Queue<Process> kuyruk) {
        prosesKuyrugu.addAll(kuyruk);

        while (!prosesKuyrugu.isEmpty()) {
        	Process proses = prosesKuyrugu.poll();
            int kalanSure = proses.getProsesZamani();

            while (kalanSure > 0) {
                if (kalanSure > quantum) {
                    // Bir quantum süresince prosesi çalıştır
                    System.out.println("Proses çalışıyor: " + proses.toString() + " - Kalan Süre: " + kalanSure);
                    kalanSure -= quantum;
                } else {
                    // Kalan süre quantum'dan azsa işlemi tamamla
                    System.out.println("Proses çalışıyor: " + proses.toString() + " - Kalan Süre: " + kalanSure);
                    kalanSure = 0;
                }
            }

            if (proses.getProsesZamani() > 0) {
                // Proses hala bitmediyse, kuyruğa geri ekle
                prosesKuyrugu.add(proses);
            } else {
                System.out.println("Proses tamamlandı: " + proses.toString());
            }
        }
    }
}
