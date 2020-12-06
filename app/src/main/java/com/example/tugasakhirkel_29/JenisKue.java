package com.example.tugasakhirkel_29;

public class JenisKue {
    private String _id, _nama, _jenis, _warna, _harga;
    public JenisKue (String id, String nama, String jenis, String warna, String harga) {
        this._id = id;
        this._nama = nama;
        this._jenis = jenis;
        this._warna = warna;
        this._harga = harga;
    }
    public JenisKue() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_jenis() {
        return _jenis;
    }
    public void set_jenis(String _jenis) {
        this._jenis = _jenis;
    }
    public String get_warna() {
        return _warna;
    }
    public void set_warna(String _warna) {
        this._warna = _warna;
    }
    public String get_harga() {
        return _harga;
    }
    public void set_harga(String _harga) {
        this._harga = _harga;
    }
}
