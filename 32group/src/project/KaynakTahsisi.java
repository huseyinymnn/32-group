package project;

import java.util.HashMap;
import java.util.Map;

public class KaynakTahsisi {
    private Map<String, Integer> kaynaklar;

    public KaynakTahsisi() {
        kaynaklar = new HashMap<>();
        kaynaklar.put("Yazici", 2); // 2 yazıcı
        kaynaklar.put("Tarayici", 1); // 1 tarayıcı
        kaynaklar.put("Modem", 1); // 1 modem
        kaynaklar.put("CDSurucu", 2); // 2 CD sürücüsü
    }

    public synchronized boolean kaynakTahsisEt(Process proses) {
        if (proses.getYaziciSayisi() <= kaynaklar.get("Yazici") &&
            proses.getTarayiciSayisi() <= kaynaklar.get("Tarayici") &&
            proses.getModemSayisi() <= kaynaklar.get("Modem") &&
            proses.getCdSurucuSayisi() <= kaynaklar.get("CDSurucu")) {

            // Kaynakları tahsis et
            kaynaklar.put("Yazici", kaynaklar.get("Yazici") - proses.getYaziciSayisi());
            kaynaklar.put("Tarayici", kaynaklar.get("Tarayici") - proses.getTarayiciSayisi());
            kaynaklar.put("Modem", kaynaklar.get("Modem") - proses.getModemSayisi());
            kaynaklar.put("CDSurucu", kaynaklar.get("CDSurucu") - proses.getCdSurucuSayisi());
            return true;
        }
        return false; // Kaynaklar yetersiz
    }

    public synchronized void kaynaklariSerbestBirak(Process proses) {
        // Serbest bırakılan kaynakları geri ver
        kaynaklar.put("Yazici", kaynaklar.get("Yazici") + proses.getYaziciSayisi());
        kaynaklar.put("Tarayici", kaynaklar.get("Tarayici") + proses.getTarayiciSayisi());
        kaynaklar.put("Modem", kaynaklar.get("Modem") + proses.getModemSayisi());
        kaynaklar.put("CDSurucu", kaynaklar.get("CDSurucu") + proses.getCdSurucuSayisi());
    }
}


