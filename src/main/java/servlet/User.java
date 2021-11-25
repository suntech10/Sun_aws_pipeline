package servlet;


import com.revature.ConnectionService;
import com.revature.annotations.JsonElement;
import com.revature.annotations.JsonSerializable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*class Cat{
    public Cat(){}
    private String name;
    private int age;

    public int getAge() {
        return age;
    }
    public String getName(){
        return name;
    }

    public void setAge(int age ) {
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public String toString(){
        return "Cat [name: "+name+", age:"+age+ "]";
    }
}*/

//import com.sun.org.glassfish.gmbal.ParameterNames;
//import org.codehaus.jackson.schema.JsonSerializableSchema;

        import com.revature.annotations.JsonElement;
        import com.revature.annotations.JsonSerializable;

        import java.lang.reflect.Field;
        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;

@JsonSerializable
public class User {
    public User() {
    }

    // @ParametersAreNonnullByDefault
    @JsonElement
    private int ps_id;

    // @ParametersAreNullableByDefault
    @JsonElement
    private String username;

    // @ParametersAreNullableByDefault
    @JsonElement
    private String password;

    // @ConstructorProperties({"ps_id", "username", "password"})
    public User(int ps_id, String username, String password) {
        this.ps_id = ps_id;
        this.username = username;
        this.password = password;
    }

    public int getPsId() {
        return this.ps_id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    /***************************************************************************/
    public void setPsId(int personId) {
        this.ps_id = personId;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public void setPassWord(String passWord) {
        this.password = passWord;
    }

    public Object getById(int id) {
        String sql = "select * from \"Persons\" where ps_id=?";
        com.revature.User person = null;
        try (Connection connection = ConnectionService.getInstance()) {
            assert connection != null;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                person = new com.revature.User();
                person.setPsId(rs.getInt(1));
                person.setUserName(rs.getString(2));
                person.setPassWord(rs.getString(3));
                // person.setUserType(UserType.values()[rs.getInt(4) - 1]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return person;
    }



    public boolean update(Connection conn, com.revature.User user, String username, String password, int psId) {
        String sql = "update \"Persons\" set username=?, password=? where id=?";

        if (conn != null) conn= ConnectionService.getInstance();
        try {
            assert conn != null;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setInt(3, psId);

            if (stmt.executeUpdate() != 0) {
                return true;
            }

            // shorthand combination returning a conditional operation
            return stmt.executeUpdate() != 0;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean deleteById(int id) {
        return false;
    }


}



