package project;

import java.util.Queue;

public class FCFS {
    public void sirala(Queue<Process> kuyruk) {
        while (!kuyruk.isEmpty()) {
            Process proses = kuyruk.poll();
            // Burada prosesi işle, çalıştır veya gerekli adımları gerçekleştir.
            // Örneğin:
            System.out.println("Proses çalışıyor: " + proses.toString());
            try {
                Thread.sleep(proses.getProsesZamani() * 1000); // Süre simülasyonu için
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Proses tamamlandı: " + proses.toString());
        }
    }
}
