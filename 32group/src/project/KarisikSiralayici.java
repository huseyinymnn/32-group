package project;

import java.util.Queue;

public class KarisikSiralayici {
    private ISiralayici siralayici;

    public KarisikSiralayici(ISiralayici s) {
        this.siralayici = s;
    }

    public void setSiralayici(ISiralayici s) {
        this.siralayici = s;
    }

    public void sirala(Queue<Process> kuyruk) {
        if (siralayici != null) {
            siralayici.sirala(kuyruk);
        } else {
            System.out.println("Sıralayıcı tanımlı değil.");
        }
    }
}
