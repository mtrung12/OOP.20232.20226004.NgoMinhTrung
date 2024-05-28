package hust.soict.ict.aims.screen.customer.controller;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class ItemController {

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;


    private Media media;
    private Cart cart;
    public void setData(Media media){
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost()+"$");
        if(media instanceof Playable){
            btnPlay.setVisible(true);
        }
        else{
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }
    public ItemController(Cart cart){
        this.cart = cart;
    }
    @FXML
    public void btnAddToCartClicked(ActionEvent event) {
        try {
            cart.addMedia(media);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        Dialog<String> dialog = new Dialog<>();
        DialogPane dialogPane = new DialogPane();
        dialogPane.setContentText(((Playable) media).toStringPlay());
        dialogPane.setHeaderText("Playing Media");
        dialog.setDialogPane(dialogPane);
        // Create a ButtonType for closing the dialog
        ButtonType closeButton = new ButtonType("Confirm");
        dialog.getDialogPane().getButtonTypes().add(closeButton);

        // Set the close button to close the dialog
        Button closeButtonNode = (Button) dialog.getDialogPane().lookupButton(closeButton);
        closeButtonNode.setOnAction(e -> dialog.close());
        dialog.showAndWait();
    }

}
