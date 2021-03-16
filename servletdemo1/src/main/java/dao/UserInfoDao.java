package dao;

import model.User;
import model.UserInfo;

import java.sql.*;
/** USERINFODAO
 * @author zaur
 * This class helps to add values to DataBase     */
public class UserInfoDao {
    public int regUser1 (UserInfo userInfo) throws ClassNotFoundException, SQLException {
/**
 * @author zaur
 * @param takes the userInfo   */

        String sqll = "INSERT INTO usersInfo" + "(user_id, firstname, lastname, city, country, gender) VALUES" + "(?,?,?,?,?,?);";

        int result = 0;
        Class.forName("org.postgresql.Driver");
        try {

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","zaur12");
            PreparedStatement prepare = connection.prepareStatement("select max(user_id)+1 from usersInfo"); //it helps us to increase id when the user is added
                                                                                                                 //because serial does not increase automatically
            ResultSet rs = prepare.executeQuery();
            String user_id ="" ;
            while(rs.next())
            {
                user_id = rs.getString(1);
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sqll);
            preparedStatement.setInt(1, Integer.parseInt(user_id));
            preparedStatement.setString(2,userInfo.getFirstname());
            preparedStatement.setString(3, userInfo.getLastname());       // sends to the DataBase postgresql
            preparedStatement.setString(4,userInfo.getCity());
            preparedStatement.setString(5,userInfo.getCountry());
            preparedStatement.setString(6,userInfo.getGender());
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
                                                         //We should not show exception to the client
        }

        return result;                   //returning the result
    }


}
