package com.emergentes.Dao;

import com.emergentes.modelo.Productos;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductosDaoImplements extends ConexionBD implements ProductosDAO {

    @Override
    public void insert(Productos pro) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO productos (descripcion,cantidad,precio,categoria) VALUES(?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, pro.getDescripcion());
            ps.setInt(2, pro.getCantidad());
            ps.setFloat(3, pro.getPrecio());
            ps.setString(4, pro.getCategoria());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Productos pro) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE productos SET descripcion=?,cantidad=?,precio=?,categoria=? WHERE id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, pro.getDescripcion());
            ps.setInt(2, pro.getCantidad());
            ps.setFloat(3, pro.getPrecio());
            ps.setString(4, pro.getCategoria());
            ps.setInt(5, pro.getId());
            ps.executeUpdate();
        } catch (SQLException  e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM productos WHERE id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
        } catch (SQLException  e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Productos getById(int id) throws Exception {
        Productos p = new Productos();
        try {
            this.conectar();
            String sql = "SELECT * FROM productos WHERE id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if (rs.next()) {                
                p.setId(id);
                p.setDescripcion(rs.getString("descripcion"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setPrecio(rs.getFloat("precio"));
                p.setCategoria(rs.getString("categoria"));
            }            
        } catch (SQLException  e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return p;
    }

    @Override
    public List<Productos> getAll() throws Exception {
        try {
            ArrayList<Productos> lis = new ArrayList();
            this.conectar();
            String sql = "SELECT * FROM productos";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Productos p = new Productos();
                p.setId(rs.getInt("id"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setPrecio(rs.getFloat("precio"));
                p.setCategoria(rs.getString("categoria"));
                lis.add(p);
            }
            rs.close();
            ps.close();
            return lis;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

}
