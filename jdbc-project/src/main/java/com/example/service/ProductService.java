package com.example.service;

import com.example.dal.DBCon;
import com.example.dao.ProductDao;
import com.example.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductService implements ProductDao {

    @Override
    public Product seeProduct(int id) {
        String sql = "select * from products where ProductID=" + id;
        try{
            DBCon dbCon =new DBCon();
            Connection conn =dbCon.getConnection();
            PreparedStatement pst =conn.prepareStatement(sql);

            ResultSet rs= pst.executeQuery();
            if(rs.next()){
                return new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            } else{
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
