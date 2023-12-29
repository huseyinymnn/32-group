package project;

public class Process {
	
	   private int varisZamani;
	    private int oncelik;
	    private int prosesZamani;
	    private int bellekBoyutu;
	    private int yaziciSayisi;
	    private int tarayiciSayisi;
	    private int modemSayisi;
	    private int cdSurucuSayisi;
	    private static int prosesSayac = 0;
	    private int prosesID;
	    
	    public Process(int varisZamani, int oncelik, int prosesZamani, int bellekBoyutu,  int yaziciSayisi, int tarayiciSayisi, int modemSayisi, int cdSurucuSayisi) {
	        this.varisZamani = varisZamani;
	        this.oncelik = oncelik;
	        this.prosesZamani = prosesZamani;
	        this.bellekBoyutu = bellekBoyutu;
	        this.yaziciSayisi = yaziciSayisi;
	        this.tarayiciSayisi = tarayiciSayisi;
	        this.modemSayisi = modemSayisi;
	        this.cdSurucuSayisi = cdSurucuSayisi;
	        this.prosesID = ++prosesSayac; // Her bir prosese benzersiz bir ID atıyoruz
	    }
  
	    @Override
	    public String toString() {
	        return "Proses{" +
	                "varisZamani=" + varisZamani +
	                ", oncelik=" + oncelik +
	                ", prosesZamani=" + prosesZamani +
	                ", bellekBoyutu=" + bellekBoyutu +
	                ", yaziciSayisi=" + yaziciSayisi +
	                ", tarayiciSayisi=" + tarayiciSayisi +
	                ", modemSayisi=" + modemSayisi +
	                ", cdSurucuSayisi=" + cdSurucuSayisi +
	                '}';
	    }
	    
	    public int getProsesID() {
	        return prosesID;
	    }

	    public int getVarisZamani() {
        return varisZamani;
	    }
	    public void setVarisZamani(int varisZamani) {
        this.varisZamani = varisZamani;
	    }
	   
	    public int getOncelik() {
	        return oncelik;
	    }
	    public void setOncelik(int oncelik) {
	        this.oncelik = oncelik;
	    }

	    public int getProsesZamani() {
	        return prosesZamani;
	    }
	    public void setProsesZamani(int prosesZamani) {
	        this.prosesZamani = prosesZamani;
	    }

	    public int getBellekBoyutu() {
	        return bellekBoyutu;
	    }
	    public void bellekBoyutu(int bellekBoyutu) {
	        this.bellekBoyutu = bellekBoyutu;
	    }

	    public int getYaziciSayisi() {
	        return yaziciSayisi;
	    }
	    public void setYaziciSayisi(int yaziciSayisi) {
	        this.yaziciSayisi = yaziciSayisi;
	    }

	    public int getTarayiciSayisi() {
	        return tarayiciSayisi;
	    }
	    public void setTarayiciSayisi(int tarayiciSayisi) {
	        this.tarayiciSayisi = tarayiciSayisi;
	    }

	    public int getModemSayisi() {
	        return modemSayisi;
	    }
	    public void setModemSayisi(int modemSayisi) {
	        this.modemSayisi = modemSayisi;
	    }

	    public int getCdSurucuSayisi() {
	        return cdSurucuSayisi;
	    }
	    public void setCdSurucuSayisi(int cdSurucuSayisi) {
	        this.cdSurucuSayisi = cdSurucuSayisi;
	    }

}


