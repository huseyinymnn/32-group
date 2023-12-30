package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<Process> prosesKuyrugu = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("giriş.txt"))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                // Satırları işleyerek Proses nesneleri oluşturun ve kuyruğa ekleyin
                String[] parcalar = satir.split(", ");
                int varisZamani = Integer.parseInt(parcalar[0]);
                int oncelik = Integer.parseInt(parcalar[1]);
                int prosesZamani = Integer.parseInt(parcalar[2]);
                int bellek = Integer.parseInt(parcalar[3]);
                int yazici = Integer.parseInt(parcalar[4]);
                int tarayici = Integer.parseInt(parcalar[5]);
                int modem = Integer.parseInt(parcalar[6]);
                int cdSurucu = Integer.parseInt(parcalar[7]);

                Process proses = new Process(varisZamani, oncelik, prosesZamani, bellek, yazici, tarayici, modem, cdSurucu);
                prosesKuyrugu.add(proses);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Örnek: bir sıralayıcı nesnesi oluşturulur ve proses kuyruğu bu sıralayıcıya gönderilir
        ISiralayici sıralayıcı = new GBG(); // Burada uygun sıralayıcıyı oluşturduk
        sıralayıcı.sirala(prosesKuyrugu);
    }
}
