package com.example.tienda_perfumes.constantesSQL;

public class ConstantesSQL {

    public final static String SQL_OBTENER_PERFUMES_JSON =
            "SELECT tv.id AS id, " +
                    "tv.nombre AS nombre, " +
                    "tv.marca AS marca, " +
                    "tv.genero AS genero, " +
                    "tv.mililitros AS mililitros, " +
                    "tv.precio AS precio, " +
                    "c.nombre AS categoria " +
                    "FROM TABLA_PERFUMES AS tv, CATEGORIA AS c " +
                    "WHERE tv.categoria_id = c.id";


    public static final String SQL_OBTENER_PERFUME_JSON =
            "SELECT tv.id AS id, " +
                    "tv.nombre AS nombre, " +
                    "tv.marca AS marca, " +
                    "tv.genero AS genero, " +
                    "tv.mililitros AS mililitros, " +
                    "tv.precio AS precio, " +
                    "CAST(tv.descripcion AS VARCHAR) AS descripcion, " +
                    "c.nombre AS categoria " +
                    "FROM TABLA_PERFUMES AS tv, CATEGORIA AS c " +
                    "WHERE tv.categoria_id = c.id " +
                    "AND tv.id = :id";
}
