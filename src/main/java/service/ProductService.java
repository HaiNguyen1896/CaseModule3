package service;

import fillter.ConnectToMySQL;
import model.Product;
import service.IService.IProductService;

import java.sql.Connection;
import java.util.List;

public class ProductService implements IProductService<Product> {
    Connection connection = ConnectToMySQL.getConnection();

    @Override
    public void add(Product product) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Product> findAll() {

    }

    @Override
    public void edit(int id) {

    }
}
