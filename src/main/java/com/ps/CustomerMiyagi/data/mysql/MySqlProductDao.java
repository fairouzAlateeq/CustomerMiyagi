package com.ps.CustomerMiyagi.data.mysql;

import com.ps.CustomerMiyagi.data.ProductDao;
import com.ps.CustomerMiyagi.models.Customer;
import com.ps.CustomerMiyagi.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlProductDao implements ProductDao {
    private DataSource dataSource;

    @Autowired
    public MySqlProductDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> findAllProducts(String sort){

        if(sort == null){
            sort = "product_id";
        }
        String[] acceptableSorts = {"product_id", "name", "phone", "category_id" };
        boolean isAcceptable = false;

        for (String sortName : acceptableSorts) {
            if (sortName.equals(sort)) {
                isAcceptable = true;
            }
        }

        if (!isAcceptable) {
            System.out.println("Sort value not acceptable");
            return null;
        }

        String query = "SELECT * FROM product order by " + sort + ";";

        List<Product> products = new ArrayList<>();
        try (
                Connection connection = this.dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                Product product = mapProduct(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findOneProduct(int id) {
        String query = "Select * from product where product_id = ?";
        Product product = null;
        try (
                Connection connection = this.dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            // instead of Resultset we need to set the id; so now nested try
            preparedStatement.setInt(1, id);
            try (
                    ResultSet resultSet = preparedStatement.executeQuery();

            ) {
                //cause we only have one
                if (resultSet.next()) {
                    product = mapProduct(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product createProduct(Product product) {
        String query = "Insert into product('name, 'price', category_id) values(?,?)";
        try (
                Connection connection = this.dataSource.getConnection();
                // we request the generated keys
                PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setString(3, product.getCategoryId());
            // to make sure it excuted
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                try (
                        ResultSet resultSet = preparedStatement.getGeneratedKeys();
                ) {

                    if(resultSet.next()){
                        product.setProductId(resultSet.getInt(1));
                        return product;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateProduct(int id, Product product) {
        String query = "update product set name = ?, phone = ?, category_id = ? where product_id = ?";
        try(
                Connection connection = this.dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setString(3, product.getCategoryId());
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteAProduct(int id) {
        String query = "delete from product where product_id = ?";
        try(
                Connection connection = this.dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Product mapProduct(ResultSet resultSet) throws SQLException {
        int productId = resultSet.getInt("product_id");
        String name = resultSet.getString("name");
        float price = resultSet.getFloat("price");
        String categoryId = resultSet.getString("category_id");

        return new Product(productId, name, price,categoryId);

    }
}
