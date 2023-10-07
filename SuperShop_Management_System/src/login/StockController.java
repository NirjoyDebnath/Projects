/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.net.URL;
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
import static login.SupplierController.getDataSupplylist;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class StockController implements Initializable {

    @FXML
    private Button b4;
    @FXML
    private Button b3;
    @FXML
    private Button b2;
    @FXML
    private TableView<Stocklist> stlist;
    @FXML
    private TableColumn<Stocklist, Integer> tcp_id;
    @FXML
    private TableColumn<Stocklist, Integer> tcs_id;
    @FXML
    private TableColumn<Stocklist, Integer> tcquantity;
    @FXML
    private TableColumn<Stocklist, Float> tcprice;
    @FXML
    private TableColumn<Stocklist, String> tcexpirydate;
    
    ObservableList<Stocklist> st_list;
     int index = -1;
    /**
     * Initializes the controller class.
     */
     public static ObservableList<Stocklist> getDataStocklist(){
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
        ObservableList<Stocklist> st_list= FXCollections.observableArrayList();
        try{
            
            ResultSet resultset=null;
            resultset=dbc.queryToDB("select * from stock");
            while(resultset.next()){
                //System.out.println(resultset.getString("deliverydate"));
                st_list.add(new Stocklist(resultset.getInt("product_id"),resultset.getInt("supply_id"),resultset.getInt("quantity"),resultset.getFloat("price"),resultset.getString("expirydate")));
            }
            System.out.println("fetched");
        }catch(Exception e){
            System.out.println("can't fetch");
            System.out.println(e);
        }
        
        //System.out.println(s_list.size());
        //float x=s_list.get(0).cost;
        //System.out.println(x);
        return st_list;
    }
    @FXML
    private TextField t1;
    @FXML
    private TextField t3;
    @FXML
    private TextField t5;
    @FXML
    private TextField t2;
    @FXML
    private TextField t4;
    @FXML
    private TextField search_tf;
    @FXML
    private Button searchbtn;
     
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
        //ObservableList<Supplylist> s_list;
        st_list=getDataStocklist();
        tcp_id.setCellValueFactory(new PropertyValueFactory<Stocklist,Integer>("p_id"));
        tcs_id.setCellValueFactory(new PropertyValueFactory<Stocklist,Integer>("s_id"));
        tcquantity.setCellValueFactory(new PropertyValueFactory<Stocklist,Integer>("quan"));
        tcprice.setCellValueFactory(new PropertyValueFactory<Stocklist,Float>("price"));
        tcexpirydate.setCellValueFactory(new PropertyValueFactory<Stocklist,String>("date"));
        stlist.setItems(st_list);
        //S.setItems(null);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initialization();
    }    

    @FXML
    private void getSelected(MouseEvent event) {
         index = stlist.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        //a = p_id.getCellData(index);
        t1.setText(tcp_id.getCellData(index).toString());
        t2.setText(tcs_id.getCellData(index).toString());
        t3.setText(tcquantity.getCellData(index).toString());
        t4.setText(tcprice.getCellData(index).toString());
        t5.setText(tcexpirydate.getCellData(index).toString());
    }

    @FXML
    private void delete(MouseEvent event) throws SQLException, ClassNotFoundException {
        System.out.println("oooo");
        if(stlist.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not selection");
            alert.setContentText("No item is selected!");
            alert.show();
            return;
        }
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();
        //isss ektu jaater naam de variable gular
        String id = stlist.getSelectionModel().getSelectedItem().getP_id() + "";
        System.out.println(id);
        String query = "DELETE FROM stock WHERE product_id =" + id;//
        dbc.insertDataToDB(query);
        initialization();
    }

    @FXML
    private void edit(MouseEvent event) throws SQLException, ClassNotFoundException {
        if(stlist.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not selection");
            alert.setContentText("No item is selected!");
            alert.show();
            return;
        }
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();
        //isss ektu jaater naam de variable gular
        String productid = t1.getText().toString();
        String supplyid = t2.getText().toString();
        String quantity = t3.getText().toString();
        String price   = t4.getText().toString();
        String expdate = t5.getText().toString();
        String id =stlist.getSelectionModel().getSelectedItem(). getP_id() + "";
        String query = "update stock set product_id= '" + productid + "', supply_id= '" + supplyid + "',quantity = '" + quantity + "',price = '" + price + "' , expirydate= '" + expdate + "'where product_id =" + id;//
        dbc.insertDataToDB(query);
        initialization();
    }

    @FXML
    private void onClicksSearchbtn(ActionEvent event) throws ClassNotFoundException, SQLException {
        String qry = "select * from stock where supply_id like '%" + search_tf.getText() + "%'";
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();
        ResultSet resultset = null;
        st_list.clear();
        resultset = dbc.queryToDB(qry);while(resultset.next()){
                //System.out.println(resultset.getString("deliverydate"));
                st_list.add(new Stocklist(resultset.getInt("product_id"),resultset.getInt("supply_id"),resultset.getInt("quantity"),resultset.getFloat("price"),resultset.getString("expirydate")));
            }
        tcp_id.setCellValueFactory(new PropertyValueFactory<Stocklist,Integer>("p_id"));
        tcs_id.setCellValueFactory(new PropertyValueFactory<Stocklist,Integer>("s_id"));
        tcquantity.setCellValueFactory(new PropertyValueFactory<Stocklist,Integer>("quan"));
        tcprice.setCellValueFactory(new PropertyValueFactory<Stocklist,Float>("price"));
        tcexpirydate.setCellValueFactory(new PropertyValueFactory<Stocklist,String>("date"));
        stlist.setItems(st_list);
    }
    
}
