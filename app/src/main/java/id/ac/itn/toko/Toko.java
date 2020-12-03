package id.ac.itn.toko;

public class Toko
{
    private String _id, _nama, _buka, _tutup;
    public Toko (String id, String nama, String buka, String tutup)
    {
        this._id = id;
        this._nama = nama;
        this._buka = buka;
        this._tutup = tutup;
    }
    public Toko(){
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

    public String get_buka() {
        return _buka;
    }

    public void set_buka(String _buka) {
        this._buka = _buka;
    }

    public String get_tutup() {
        return _tutup;
    }

    public void set_tutup(String _tutup) {
        this._tutup = _tutup;
    }
}

