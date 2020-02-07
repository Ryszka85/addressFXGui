package gui.guiView;

import datamodel.Person;
import gui.controller.ModalDialogController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Optional;

public class ModalDialog<T> {
    private Dialog<ButtonType> dialog;
    private FXMLLoader fxmlLoader;
    private ModalDialogController<T> dialogController;

    public ModalDialog(Window window,
                       final String fxmlPath) {
        this.dialog = new Dialog<>();
        this.dialog.initOwner(window);
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/" + fxmlPath));
        try {
            this.dialog.getDialogPane()
                    .setContent(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        this.dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
    }

    public void setDialogController(ModalDialogController<T> dialogController) {
        this.dialogController = dialogController;
    }

    public T getDialogData() {
        final Optional<ButtonType> confirmedResults = getConfirmedResults();
        if (confirmedResults.isPresent() && confirmedResults.get() == ButtonType.OK) {
            try {
                return dialogController.getDataFromDialog();
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }


    public Dialog<ButtonType> getDialog() {
        return dialog;
    }

    public Optional<ButtonType> getConfirmedResults() {
        return dialog.showAndWait();
    }

    public FXMLLoader getFxmlLoader() {
        return fxmlLoader;
    }
}
