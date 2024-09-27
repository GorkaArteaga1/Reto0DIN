package dataAccessTier;

import classes.User;
import java.util.ResourceBundle;

/**
 * La clase FileUserDataAccessor implementa la interfaz DataAccessible y se
 * encarga de la recuperación de datos de usuario desde un archivo de recursos.
 *
 * Esta clase utiliza ResourceBundle para leer la información del usuario
 * almacenada en un archivo de propiedades.
 */
public class FileUserDataAccessor implements DataAccessible {

    /**
     * Recupera los datos de un usuario desde un archivo de propiedades.
     *
     * @return Un objeto (User) con los datos recuperados, incluyendo DNI,
     * nombre, contraseña y edad.
     */
    @Override
    public User recogerDatos() throws Exception {
        try {
            String datoDni = ResourceBundle.getBundle("dataAccessTier.leerDatos").getString("DNI");
            String datoNombre = ResourceBundle.getBundle("dataAccessTier.leerDatos").getString("NOMBRE");
            String datoPasswd = ResourceBundle.getBundle("dataAccessTier.leerDatos").getString("PASSWD");
            String datoEdad = ResourceBundle.getBundle("dataAccessTier.leerDatos").getString("EDAD");

            User user = new User();

            user.setDni(datoDni);
            user.setNombre(datoNombre);
            user.setPasswd(datoPasswd);
            user.setEdad(datoEdad);
        return user;
        } catch (Exception e) {
            throw e;
        }
        
    }
}
