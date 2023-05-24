package com.emergentes.Dao;

import com.emergentes.modelo.Productos;
import java.util.List;

public interface ProductosDAO {

    public void insert(Productos pro) throws Exception;

    public void update(Productos pro) throws Exception;

    public void delete(int id) throws Exception;

    public Productos getById(int id) throws Exception;

    public List<Productos> getAll() throws Exception;
}
