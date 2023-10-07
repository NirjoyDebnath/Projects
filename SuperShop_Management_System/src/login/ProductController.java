/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class ProductController implements Initializable {

    private static Connection ConnectDB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button addproduct;
    @FXML
    private TextField T2;
    @FXML
    private TextField T3;
    @FXML
    private TextField T4;
    @FXML
    private TableView<Productlist> produc;

    @FXML
    private TableColumn<Productlist, Integer> p_id;

    @FXML
    private TableColumn<Productlist, String> p_name;

    @FXML
    private TableColumn<Productlist, String> p_brand;

    @FXML
    private TableColumn<Productlist, String> p_description;
    ObservableList<Productlist> p_list;
    int index = -1;
    
    
    //ResultSet resultset;
    
    
    public static ObservableList<Productlist> getDataProductlist(){
        DBConnect dbc = new DBConnect();
        
        try {
            dbc.connectToDB();
            System.out.println("connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("can't connect");
            System.out.println(ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("can't connect");
            System.out.println(ex);
        }
        ObservableList<Productlist> p_list= FXCollections.observableArrayList();
        try{
            
            ResultSet resultset=null;
            resultset=dbc.queryToDB("select * from product");
            while(resultset.next()){
                p_list.add(new Productlist(resultset.getInt("product_id"),resultset.getString("productname"),resultset.getString("brand"),resultset.getString("descrip")));
            }
            System.out.println("fetched");
        }catch(Exception e){
            System.out.println("can't fetch");
            System.out.println(e);
        }
        
        
        return p_list;
    }
    @FXML
    private TextField search_tf;
    @FXML
    private Button searchbtn;
    public void clear() {
        T2.setText(null);
        T3.setText(null);
        T4.setText(null);
    }
    public void initialization() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DBConnect dbc = new DBConnect();
        try {
            dbc.connectToDB();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ObservableList<Productlist> p_list;
        p_list=getDataProductlist();
        p_id.setCellValueFactory(new PropertyValueFactory<Productlist,Integer>("p_id"));
        p_name.setCellValueFactory(new PropertyValueFactory<Productlist,String>("p_name"));
        p_brand.setCellValueFactory(new PropertyValueFactory<Productlist,String>("p_brand"));
        p_description.setCellValueFactory(new PropertyValueFactory<Productlist,String>("p_description"));
        produc.setItems(p_list);
        
    }
    @FXML
    void getSelected(MouseEvent event) {
        index = produc.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        //a = p_id.getCellData(index);
        T2.setText(p_name.getCellData(index).toString());
        T3.setText(p_brand.getCellData(index).toString());
        T4.setText(p_description.getCellData(index).toString());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
        /*DBConnect dbc = new DBConnect();
        try {
            dbc.connectToDB();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Productlist> p_list;
        p_list=getDataProductlist();
        p_id.setCellValueFactory(new PropertyValueFactory<Productlist,Integer>("p_id"));
        p_name.setCellValueFactory(new PropertyValueFactory<Productlist,String>("p_name"));
        p_brand.setCellValueFactory(new PropertyValueFactory<Productlist,String>("p_brand"));
        p_description.setCellValueFactory(new PropertyValueFactory<Productlist,String>("p_description"));
        produc.setItems(p_list);
        */
        //T2.setText("777");
        initialization();

    }
    
    
    @FXML
    private void addnewproduct(MouseEvent event) throws SQLException, ClassNotFoundException {
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();
        String pname,brand,description;
        pname= T2.getText();
        brand= T3.getText();
        description= T4.getText();
        dbc.insertDataToDB("insert into product(productname,brand,descrip) values('"+pname+"','"+brand+"','"+description+"')");
        initialization();
        clear();
        
    }   
    @FXML
    private void edit(MouseEvent event) throws ClassNotFoundException, SQLException {
        if(produc.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not selection");
            alert.setContentText("No item is selected!");
            alert.show();
            return;
        }
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();
        //isss ektu jaater naam de variable gular
        String productName = T2.getText().toString();
        String brand = T3.getText().toString();
        String description = T4.getText().toString();
        String id = produc.getSelectionModel().getSelectedItem().getP_id() + "";
        String query = "update product set productname= '" + productName + "', brand= '" + brand + "',descrip = '" + description + "' where product_id =" + id;//
        dbc.insertDataToDB(query);
        initialization();
        clear();
    }

    @FXML
    private void deleterow(ActionEvent event) throws ClassNotFoundException, SQLException {
        System.out.println("oooo");
        if(produc.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not selection");
            alert.setContentText("No item is selected!");
            alert.show();
            return;
        }
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();
        //isss ektu jaater naam de variable gular
        String id = produc.getSelectionModel().getSelectedItem().getP_id() + "";
        System.out.println(id);
        String query = "DELETE FROM PRODUCT WHERE product_id =" + id;//
        dbc.insertDataToDB(query);
        initialization();
    }

    @FXML
    private void deleterow(MouseEvent event) {
    }

    @FXML
    private void onClicksSearchbtn(ActionEvent event) throws ClassNotFoundException, SQLException {
        String qry = "select * from product where product_id like '%" + search_tf.getText() + "%'";
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();
        ResultSet resultset = null;
        resultset = dbc.queryToDB(qry);
        p_list.clear();
        //ResultSet resultset=null;
            //resultset=dbc.queryToDB("select * from product");
            while(resultset.next()){
                p_list.add(new Productlist(resultset.getInt("product_id"),resultset.getString("productname"),resultset.getString("brand"),resultset.getString("descrip")));
            }
        //memberlist.setItems(null);
        
        p_id.setCellValueFactory(new PropertyValueFactory<Productlist,Integer>("p_id"));
        p_name.setCellValueFactory(new PropertyValueFactory<Productlist,String>("p_name"));
        p_brand.setCellValueFactory(new PropertyValueFactory<Productlist,String>("p_brand"));
        p_description.setCellValueFactory(new PropertyValueFactory<Productlist,String>("p_description"));
        produc.setItems(p_list);
    }

    

    
    
}
