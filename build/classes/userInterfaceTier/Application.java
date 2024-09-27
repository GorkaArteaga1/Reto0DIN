package userInterfaceTier;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * La clase Application es la clase principal de la aplicación JavaFX.
 *
 * Esta clase extiende javafx.application.Application y se encarga de
 * inicializar y mostrar la interfaz de usuario cargando la vista FXML
 * correspondiente.
 */
public class Application extends javafx.application.Application {

    /**
     * Inicializa y muestra la ventana principal de la aplicación.
     *
     * @param stage El escenario principal donde se mostrará la interfaz de
     * usuario.
     * @throws Exception Si ocurre un error durante la carga del archivo FXML.
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Cargar DOM de la vista FXML
        Parent root = FXMLLoader.load(getClass().getResource("/view/UserView.fxml"));
        // Creamos una escena con nuestra vista
        Scene scene = new Scene(root);
        // Poner la escena en el escenario
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método principal de la aplicación.
     *
     * Este método se utiliza como punto de entrada de la aplicación, invocando
     * el método launch para iniciar la ejecución de JavaFX.
     *
     * @param args Argumentos de línea de comandos que pueden ser pasados al
     * iniciar la aplicación.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
