package com.example.carnecertamobile;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CarneDao {

    @Insert
    void inserir(Carne carne);

    @Query(
            "SELECT * FROM carnes " +
                    "WHERE categoria = :categoria " +
                    "AND preferencia = :preferencia"
    )
    List<Carne> buscarCarnes(
            String categoria,
            String preferencia
    );

}