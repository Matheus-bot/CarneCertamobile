package com.example.carnecertamobile;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "carnes")
public class Carne {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome;
    private String categoria;
    private String preferencia;

    public Carne(String nome,
                 String categoria,
                 String preferencia) {

        this.nome = nome;
        this.categoria = categoria;
        this.preferencia = preferencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getPreferencia() {
        return preferencia;
    }
}
