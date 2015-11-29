package com.example.christopher.proyecto;

/**
 * Created by Christopher on 27/11/2015.
 */
public class Carro {

    private long _id;
    private String _nombre;
    private String _apellido;
    private int _dni;
    private String _marca;

    public Carro(String _nombre, String _apellido, int _dni, String _marca) {
        this._nombre = _nombre;
        this._apellido = _apellido;
        this._dni = _dni;
        this._marca = _marca;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_apellido() {
        return _apellido;
    }

    public void set_apellido(String _apellido) {
        this._apellido = _apellido;
    }

    public int get_dni() {
        return _dni;
    }

    public void set_dni(int _dni) {
        this._dni = _dni;
    }

    public String get_marca() {
        return _marca;
    }

    public void set_marca(String _marca) {
        this._marca = _marca;
    }
}
