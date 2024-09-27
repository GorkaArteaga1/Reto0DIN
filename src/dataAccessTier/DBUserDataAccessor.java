package dataAccessTier;

import classes.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * La clase DBUserDataAccessor implementa la interfaz DataAccessible y se
 * encarga de la gestión de datos de usuario en la base de datos.
 *
 * Esta clase utiliza JDBC para interactuar con la base de datos.
 */
public class DBUserDataAccessor implements DataAccessible {

    private static final Logger logger = Logger.getLogger("dataAccessTier.DBUserDataAccessor"); // Logger
    Alert alert;

    private Connection con;
    private PreparedStatement stmt;
    private ResourceBundle fichConf;
    private String url;
    private String usuario;
    private String pass;

    private final String RECOGIDA_DATOS = "SELECT * FROM USUARIO";

    /**
     * Constructor de la clase. Inicializa los parámetros de conexión a la base
     * de datos a partir del archivo de configuración.
     */
    public DBUserDataAccessor() {
        fichConf = ResourceBundle.getBundle("dataAccessTier.bd");
        url = fichConf.getString("url");
        usuario = fichConf.getString("usuario");
        pass = fichConf.getString("pass");
    }

    /**
     * Abre una conexión a la base de datos utilizando los parámetros
     * configurados.
     *
     * Se captura una excepción SQLException para manejar errores de conexión.
     */
    public void openConnection() throws SQLException{
        try {
            con = DriverManager.getConnection(url, usuario, pass);
        } catch (SQLException e) {
           throw e;
        }
    }

    /**
     * Cierra la conexión a la base de datos y libera los recursos utilizados.
     *
     * Se asegura de cerrar el PreparedStatement y la conexión si están activos.
     */
    public void closeConnection() throws SQLException{
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Recupera los datos de un usuario desde la base de datos.
     *
     * @return Un objeto (User) con los datos recuperados, o un objeto (User)
     * vacío si no se encuentran registros.
     * @throws java.sql.SQLException
     */
    @Override
    public User recogerDatos() throws Exception{
        ResultSet rs;
        User user = new User();

        this.openConnection();

        try {
            stmt = con.prepareStatement(RECOGIDA_DATOS);
            rs = stmt.executeQuery();

            if (rs.next()) {
                user.setDni(rs.getString("DNI"));
                user.setNombre(rs.getString("NOMBRE"));
                user.setPasswd(rs.getString("PASSWD"));
                user.setEdad(rs.getString("EDAD"));
            }

        } catch (Exception e) {
            throw e;           
        }

        this.closeConnection();

        return user;
    }
}
