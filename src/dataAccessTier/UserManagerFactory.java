package dataAccessTier;

import java.util.ResourceBundle;

/**
 * La clase UserManagerFactory es responsable de la creación de instancias de
 * acceso a datos de usuario.
 *
 * Proporciona un método estático que retorna un objeto que implementa la
 * interfaz DataAccessible, permitiendo la selección dinámica de la fuente de
 * datos (ya sea una base de datos MySQL o un archivo de propiedades).
 */
public class UserManagerFactory {

    /**
     * Devuelve una instancia de DataAccessible según la configuración
     * especificada en el archivo de propiedades.
     *
     * @return Una instancia de DBUserDataAccessor si la configuración indica
     * "MySql" en nuestro caso, o una instancia de FileUserDataAccessor en caso
     * contrario.
     */
    public static DataAccessible getBusquedaDatos() throws Exception{
        try {
            String datosBd = ResourceBundle.getBundle("dataAccessTier.config").getString("Acceso");

        if (datosBd.equalsIgnoreCase("MySql")) {
            return new DBUserDataAccessor();
        } else {
            return new FileUserDataAccessor();
        }
        } catch (Exception e) {
            throw e;
        }
        
    }
}
