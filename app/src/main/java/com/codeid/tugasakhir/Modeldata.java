package com.codeid.tugasakhir;

public class Modeldata {
    private String kategori;
    private String deskripsi;
    private String key;

    public Modeldata(){

    }

    public Modeldata(String kategori, String deskripsi) {
        this.kategori = kategori;
        this.deskripsi = deskripsi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String katergori) {
        this.kategori = katergori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
