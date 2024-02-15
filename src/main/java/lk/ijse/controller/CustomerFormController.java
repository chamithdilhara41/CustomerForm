package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.model.Tm.customerTm;
import lk.ijse.model.customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerFormController {

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnSave;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private TableView<customerTm> tblCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;

    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void txtAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtIdOnAction(ActionEvent event) {

    }

    @FXML
    void txtNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtTelOnAction(ActionEvent event) {

    }

    public void initialize() {
        loadAllCustomers();
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
    }

    private void loadAllCustomers() {
         /*let's imagine this getcustomers() method
        fetch the all customer objects from the MySQL database and return Customer object arraylist*/
        List<customer> customerList = getCustomers();

        ObservableList<customerTm> obList = FXCollections.observableArrayList();

        for(customer c : customerList) {
            customerTm tm = new customerTm(c.getName(), c.getAddress(), c.getTel());

            obList.add(tm);
        }

        tblCustomer.setItems(obList);
    }

    private List<customer> getCustomers() {
        List<customer> customerList = new ArrayList<>();

        customerList.add(new customer("S001", "Supun", "Galle", "0756555678"));
        customerList.add(new customer("S002", "Nilantha", "Panadura", "0786345643"));
        customerList.add(new customer("S003", "Kaushi", "Jaffna", "0716865667"));

        return customerList;
    }
}
