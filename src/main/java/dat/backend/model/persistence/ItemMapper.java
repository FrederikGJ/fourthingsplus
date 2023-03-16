package dat.backend.model.persistence;


import dat.backend.model.entities.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class ItemMapper {

    static List<Item> getItems(ConnectionPool connectionPool){

    List<Item> itemList = new ArrayList<>();

    String sql = "select * from item";

    try(Connection connection = connectionPool.getConnection()){

    try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()){
        int id = resultSet.getInt("item_id");
        String name = resultSet.getString("name");
        Boolean done = resultSet.getBoolean("done");
        Timestamp timestamp = resultSet.getTimestamp("created");
        String username = resultSet.getString("username");

        Item newItem = new Item(id, name, done, timestamp, username);
        itemList.add(newItem);
    }

    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }

    } catch (SQLException throwables) {
    throwables.printStackTrace();
    }
    return itemList;
    }


}
