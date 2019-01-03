package appLayer;

import dataLayer.DB_item;
import dataLayer.DB_user;

import javax.servlet.http.Part;
import java.io.File;
import java.sql.Blob;

/**
 * Created by Daniil on 14.02.2018.
 */
public class Item {
    public boolean RegisterNewItem(String title, String category, String description, String illustration, String price, Part filepart)
    {
        DB_item DB_item_object = new DB_item();
        return DB_item_object.RegisterNewItem(title,category,description,illustration,price,  filepart);
    }


    public boolean GetAllItems()
    {
        DB_item DB_item_object = new DB_item();
        return DB_item_object.GetAllItems();
    }

    public boolean Buy(int ID)
    {
        DB_item DB_item_object = new DB_item();
        return DB_item_object.BuyItem(ID);
    }

    public boolean GetChartList(String username)
    {
        DB_item DB_item_object = new DB_item();
        return DB_item_object.GetChartList(username);
    }

    public boolean DeleteChartItem(int ID)
    {
        DB_item DB_item_object = new DB_item();
        return DB_item_object.DeleteChartItem(ID);
    }
    public boolean updateQuantity(int ID, int Quantity)
    {
        DB_item DB_item_object = new DB_item();
        return DB_item_object.updateQuantity(ID, Quantity );

    }
    public boolean PlaceOrder()
    {
        DB_item DB_item_object = new DB_item();
        return DB_item_object.PlaceOrder();

    }

}
