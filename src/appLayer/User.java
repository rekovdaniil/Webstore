package appLayer;
import dataLayer.DB_user;
/**
 * Created by Daniil on 12.02.2018.
 */
public class User {
    public boolean isValidUserCredentials(String sUserName, String sUserPassword)
    {
        DB_user DB_user_object = new DB_user();
        return DB_user_object.isValidUserLogin(sUserName,sUserPassword);
    }

    public boolean isValidRegistrationData(String sUserName, String sUserPassword, String sUserRePassword, String sName, String sUSerSurname)
    {
        DB_user DB_user_object = new DB_user();
        return DB_user_object.isValidUserRegistration(sUserName,sUserPassword, sUserRePassword, sName, sUSerSurname);
    }
    public boolean GetAllUsers()
    {
        DB_user DB_user_object = new DB_user();
        return DB_user_object.GetAllUsers();
    }

    public boolean deleteUser(int ID)
    {
        DB_user DB_user_object = new DB_user();
        return DB_user_object.DeleteUser(ID);
    }


}
