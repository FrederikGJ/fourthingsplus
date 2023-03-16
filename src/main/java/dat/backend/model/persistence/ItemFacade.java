package dat.backend.model.persistence;

import dat.backend.model.entities.Item;

import java.sql.Connection;
import java.util.List;

public class ItemFacade {

    public static List<Item> getItem (ConnectionPool connectionPool){
        return ItemMapper.getItems(connectionPool);
    }

}
