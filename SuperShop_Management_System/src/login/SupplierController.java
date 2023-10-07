/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
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
import static login.ProductController.getDataProductlist;

/**
 * FXML Controller class
 *
 * @author MN
 */
public class SupplierController implements Initializable {
    
    @FXML
    private TableView<Supplylist> S;

    @FXML
    private TextField tp_id;

    @FXML
    private TextField tquantity;

    @FXML
    private TextField tsupplycost;

    @FXML
    private TextField td;
    
    @FXML
    private TextField tm;

    @FXML
    private TextField ty;
    
    @FXML
    private TextField td1;
    
    @FXML
    private TextField tm1;

    @FXML
    private TextField ty1;
    
    @FXML
    private TextField tprice;

    @FXML
    private TextField tsuppliername;

    @FXML
    private TextField tphone;

    @FXML
    private Button badd;

    @FXML
    private Button bclear;

    @FXML
    private Button bdelete;

    @FXML
    private Button bedit;

    @FXML
    private TableColumn<Supplylist, Integer> tcp_id;

    @FXML
    private TableColumn<Supplylist, Integer> tcquantity;

    @FXML
    private TableColumn<Supplylist, Integer> tcs_id;

    @FXML
    private TableColumn<Supplylist, Float> tcsupplycost;

    @FXML
    private TableColumn<Supplylist, String> tcdeliverydate;

    @FXML
    private TableColumn<Supplylist, String> tcsuppliername;

    @FXML
    private TableColumn<Supplylist, String> tcphone;
    
    ObservableList<Supplylist> s_list;
     int index = -1;

     public void clear() {
        tp_id.setText(null);
        tquantity.setText(null);
        tsupplycost.setText(null);
        td.setText(null);
        tm.setText(null);
        ty.setText(null);
        td1.setText(null);
        tm1.setText(null);
        ty1.setText(null);
        tprice.setText(null);
        tsuppliername.setText(null);
        tphone.setText(null);
        
    }
    /**
     * Initializes the controller class.
     */
    public static ObservableList<Supplylist> getDataSupplylist(){
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
        ObservableList<Supplylist> s_list= FXCollections.observableArrayList();
        try{
            
            ResultSet resultset=null;
            resultset=dbc.queryToDB("select * from supplies");
            while(resultset.next()){
                //System.out.println(resultset.getString("deliverydate"));
                s_list.add(new Supplylist(resultset.getInt("product_id"),resultset.getInt("quantity"),resultset.getInt("supply_id"),resultset.getFloat("supplycost"),resultset.getString("deliverydate"),resultset.getString("suppliername"),resultset.getString("phone")));
            }
            System.out.println("fetched");
        }catch(Exception e){
            System.out.println("can't fetch");
            System.out.println(e);
        }
        
        System.out.println(s_list.size());
        //float x=s_list.get(0).cost;
        //System.out.println(x);
        return s_list;
    }
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
        s_list=getDataSupplylist();
        tcp_id.setCellValueFactory(new PropertyValueFactory<Supplylist,Integer>("pid"));
        tcquantity.setCellValueFactory(new PropertyValueFactory<Supplylist,Integer>("quan"));
        tcs_id.setCellValueFactory(new PropertyValueFactory<Supplylist,Integer>("sid"));
        tcsupplycost.setCellValueFactory(new PropertyValueFactory<Supplylist,Float>("cost"));
        tcdeliverydate.setCellValueFactory(new PropertyValueFactory<Supplylist,String>("dd"));
        tcsuppliername.setCellValueFactory(new PropertyValueFactory<Supplylist,String>("sname"));
        tcphone.setCellValueFactory(new PropertyValueFactory<Supplylist,String>("phn"));
        S.setItems(s_list);
        //S.setItems(null);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initialization();
    }    

    @FXML
    private void addsupplyproduct(MouseEvent event) throws SQLException, ClassNotFoundException {
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();
        String sname,phn,dd,dm,dy,dd1,dm1,dy1;
        int quan,pid,sid;
        float cost,price;
        sid=0;
        sname= tsuppliername.getText();
        phn=tphone.getText();
        dd=td.getText();
        dm=tm.getText();
        dy=ty.getText();
        dd=dy+"-"+dm+"-"+dd;
        dd1=td1.getText();
        dm1=tm1.getText();
        dy1=ty1.getText();
        dd1=dy1+"-"+dm1+"-"+dd1;
        pid=parseInt(tp_id.getText());
        quan=parseInt(tquantity.getText());
        cost=parseFloat(tsupplycost.getText());
        price=parseFloat(tprice.getText());
        dbc.insertDataToDB("insert into supply(phone,suppliername) values('"+phn+"','"+sname+"')");
        ResultSet resultset=null;
        resultset=dbc.queryToDB("select * from supply");
        while(resultset.next())
        {
            sid=resultset.getInt("supply_id");
        }
        dbc.insertDataToDB("insert into stock(product_id,supply_id,quantity,price,expirydate) values('"+pid+"','"+sid+"','"+quan+"','"+price+"','"+dd1+"')");
        dbc.insertDataToDB("insert into supplies(product_id,supply_id,quantity,supplycost,deliverydate,phone,suppliername) values('"+pid+"','"+sid+"','"+quan+"','"+cost+"','"+dd+"','"+phn+"','"+sname+"')");
        initialization();
        clear();
        
    }

    @FXML
    private void delete(MouseEvent event) throws ClassNotFoundException, SQLException {
        if(S.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not selection");
            alert.setContentText("No item is selected!");
            alert.show();
            return;
        }
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();
        //isss ektu jaater naam de variable gular
        String id = S.getSelectionModel().getSelectedItem().getSid() + "";
        String query = "DELETE FROM supplies WHERE supply_id =" + id;//
        dbc.insertDataToDB(query);
        initialization();
        clear();
    }

    @FXML
    private void edit(MouseEvent event) throws ClassNotFoundException, SQLException {
        if(S.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not selection");
            alert.setContentText("No item is selected!");
            alert.show();
            return;
        }
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();
        
        String productid = tp_id.getText().toString();
        String quantity = tquantity.getText().toString();
        String supplycost =tsupplycost.getText().toString();
        String suppliername =tsuppliername.getText().toString();
        String phone =tphone.getText().toString();
        String id = S.getSelectionModel().getSelectedItem().getSid() + "";
        String query = "update supplies set product_id= '" +  productid + "',quantity= '" +quantity+ "',supplycost = '" + supplycost + "',phone  = '" + phone  + "',suppliername = '" + suppliername + "' where supply_id =" + id;//
        dbc.insertDataToDB(query);
        initialization();
        clear();
    }

    @FXML
    private void getSelected(MouseEvent event) {
        index =S.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        
        tp_id.setText(tcp_id.getCellData(index).toString());
        tquantity.setText(tcquantity.getCellData(index).toString());
        tsupplycost.setText(tcsupplycost.getCellData(index).toString());
        tphone.setText(tcphone.getCellData(index).toString());
        tsuppliername.setText(tcsuppliername.getCellData(index).toString());
    }

    @FXML
    private void onClicksSearchbtn(ActionEvent event) throws ClassNotFoundException, SQLException {
        String qry = "select * from supplies where supply_id like '%" + search_tf.getText() + "%'";
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();
        ResultSet resultset = null;
        resultset = dbc.queryToDB(qry);
        s_list.clear();
        while(resultset.next()){
                //System.out.println(resultset.getString("deliverydate"));
                s_list.add(new Supplylist(resultset.getInt("product_id"),resultset.getInt("quantity"),resultset.getInt("supply_id"),resultset.getFloat("supplycost"),resultset.getString("deliverydate"),resultset.getString("suppliername"),resultset.getString("phone")));
            }
        tcp_id.setCellValueFactory(new PropertyValueFactory<Supplylist,Integer>("pid"));
        tcquantity.setCellValueFactory(new PropertyValueFactory<Supplylist,Integer>("quan"));
        tcs_id.setCellValueFactory(new PropertyValueFactory<Supplylist,Integer>("sid"));
        tcsupplycost.setCellValueFactory(new PropertyValueFactory<Supplylist,Float>("cost"));
        tcdeliverydate.setCellValueFactory(new PropertyValueFactory<Supplylist,String>("dd"));
        tcsuppliername.setCellValueFactory(new PropertyValueFactory<Supplylist,String>("sname"));
        tcphone.setCellValueFactory(new PropertyValueFactory<Supplylist,String>("phn"));
        S.setItems(s_list);
    }
    
    
}
