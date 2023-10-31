package com.project.repository;

import com.mongodb.client.*;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.project.beans.Imovel;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ImobiliariaRepositoryImp implements ImobiliariaRepository{

    private static final String url = "jdbc:mysql://localhost:3306/imobiliaria";
    private static final String user = "root";
    private static final String password = "root123";

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    List<Imovel> imoveis = new ArrayList<Imovel>();

    public List<Imovel> getImoveis() throws SQLException {
        findAllMongoDB();
        return findAllMySQL();
    }

    public List<Imovel> findAllMySQL() throws SQLException{
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            ResultSet rs = connection.createStatement().executeQuery("select * from imoveis");

            List<Imovel> imoveis = new ArrayList<Imovel>();

            while(rs.next()){
                long id = rs.getLong("id");
                String code = rs.getString("code");
                String name = rs.getString("name");
                String descricao = rs.getString("descricao");

                Imovel imovel= new Imovel();
                imovel.setId(id);
                imovel.setCode(code);
                imovel.setName(name);
                imovel.setDescricao(descricao);

                imoveis.add(imovel);
            }

            System.out.println("IMOVEIS MYSQL: " + imoveis);
            return imoveis;
        }

        /*catch(ClassNotFoundException e) {
            System.out.println("Driver do banco não localizado");
        } */
        catch (SQLException e) {
            System.out.println("Erro ao acessar o banco"+e.getMessage());
            //throw new RuntimeException(e);
        }finally {
            if(connection != null){
                connection.close();
            }
        }

        return imoveis;
    }

    public List<Object> findAllMongoDB() {

        MongoDatabase database = client.getDatabase("imobiliaria");
        MongoCollection<Document> collection = database.getCollection("imoveis");

        FindIterable<Document> findInterable = collection.find();
        List<Object> response = new ArrayList<Object>();

        for(Document doc : findInterable){
            response.add(doc);
        }

        System.out.println("IMOVEIS MONGO DB " + response);

        return response;
    }
}
