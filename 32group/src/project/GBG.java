package project;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GBG implements ISiralayici {
	
    private Queue<Process>[] geriBeslemeKuyruklari;
    private int maxOncelikSeviyesi;
    private GBG geriBeslemeliSiralayici;
    
    public GBG() {
        this.geriBeslemeliSiralayici = null;
       
    }
    public GBG(int maxOncelikSeviyesi) {
        this.maxOncelikSeviyesi = maxOncelikSeviyesi;
        geriBeslemeKuyruklari = new Queue[maxOncelikSeviyesi + 1];

        for (int i = 0; i <= maxOncelikSeviyesi; i++) {
            geriBeslemeKuyruklari[i] = new LinkedList<>();
        }
    }

    public void oncelikDegistir(Process proses) {
        int oncelik = proses.getOncelik();

        if (oncelik < maxOncelikSeviyesi) {
            geriBeslemeKuyruklari[oncelik + 1].add(proses);
        }
    }

    public Process siradakiProses() {
        for (int i = 0; i <= maxOncelikSeviyesi; i++) {
            if (!geriBeslemeKuyruklari[i].isEmpty()) {
                return geriBeslemeKuyruklari[i].poll();
            }
        }
        return null;
    }
	@Override
	public void sirala(Queue<Process> kuyruk) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sirala(List<Process> prosesler) {
		// TODO Auto-generated method stub
		
	}
}
