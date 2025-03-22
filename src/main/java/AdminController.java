import com.example.demo1.dao.AdminDAO;
import com.example.demo1.models.Admin;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class AdminController {
    @FXML
    private TableView<Admin> adminTable;
    @FXML
    private TableColumn<Admin, Integer> adminIdColumn;
    @FXML
    private TableColumn<Admin, String> fullNameColumn;
    @FXML
    private TableColumn<Admin, String> emailColumn;
    @FXML
    private TableColumn<Admin, String> phoneNumberColumn;

    private AdminDAO adminDAO;

    public AdminController() {
        adminDAO = new AdminDAO();
    }

    public void initialize() {
        adminIdColumn.setCellValueFactory(new PropertyValueFactory<>("adminId"));
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        // Load data from database
        List<Admin> admins = adminDAO.getAllAdmins();
        adminTable.getItems().addAll(admins);
    }
}



