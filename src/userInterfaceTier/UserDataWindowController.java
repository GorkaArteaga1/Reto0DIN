package userInterfaceTier;

import classes.User;
import dataAccessTier.UserManagerFactory;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * Controlador de la ventana de datos del usuario.
 *
 * Esta clase maneja la interacción de la interfaz de usuario para la
 * visualización y edición de los datos del usuario. Utiliza el patrón de diseño
 * MVC para separar la lógica de presentación de la lógica de negocio.
 */
public class UserDataWindowController {

    private static final Logger logger = Logger.getLogger("userInterfaceTier.UserDataWindowController"); // Logger

    @FXML
    private Button button;

    @FXML
    private TextField tFDni;

    @FXML
    private TextField tFNombre;

    @FXML
    private TextField tFPasswd;

    @FXML
    private TextField tFEdad;

    /**
     * Maneja la acción del botón cuando se hace clic en él.
     *
     * Este método recupera los datos del usuario mediante el
     * UserManagerFactory, y los muestra en los campos de texto
     * correspondientes. En caso de error, se registra un mensaje de error y se
     * puede mostrar una alerta al usuario.
     *
     * @param event El evento de acción generado por el clic del botón.
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            User user = UserManagerFactory.getBusquedaDatos().recogerDatos();
            tFDni.setText(user.getDni());
            tFNombre.setText(user.getNombre());
            tFPasswd.setText(user.getPasswd());
            tFEdad.setText(user.getEdad());

        } catch (Exception e) {
            // LOG diciendo error al cargar los datos
            logger.severe(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
            
        }
    }
}
