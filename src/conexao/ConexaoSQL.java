package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoSQL {

    private static final String UrlDatabase = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String user = "root";
    private static final String password = "";

    public static Connection createConnection() throws Exception {

        Connection connection = DriverManager.getConnection(UrlDatabase, user, password);

        return connection;

    }

    public static void main(String[] args) throws Exception {

        Connection con = createConnection();

        if (con != null){
            System.out.println("Conexao obtida com sucesso");
            con.close();
        }
    }


}
