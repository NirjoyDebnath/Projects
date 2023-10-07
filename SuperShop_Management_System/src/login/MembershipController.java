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

/**
 * FXML Controller class
 *
 * @author MN
 */
public class MembershipController implements Initializable {

    @FXML
    private TextField tname;
    @FXML
    private TextField tphone;
    @FXML
    private TextField taddress;
    @FXML
    private TableView<Memberlist> memberlist;
    @FXML
    private TableColumn<Memberlist, Integer> tcc_id;
    @FXML
    private TableColumn<Memberlist, String> tcname;
    @FXML
    private TableColumn<Memberlist, String> tcphone;
    @FXML
    private TableColumn<Memberlist, String> tcaddress;
    @FXML
    private TableColumn<Memberlist, Integer> tcpoints;
    @FXML
    private Button badd;
    @FXML
    private Button bedit;
    @FXML
    private Button bdelete;

    ObservableList<Memberlist> m_list;
    int index = -1;
    
    public static ObservableList<Memberlist> getDataMemberlist() {
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
        ObservableList<Memberlist> m_list = FXCollections.observableArrayList();
        try {

            ResultSet resultset = null;
            resultset = dbc.queryToDB("select * from membership");
            while (resultset.next()) {
                //System.out.println(resultset.getString("deliverydate"));
                m_list.add(new Memberlist(resultset.getInt("card_id"), resultset.getString("name"), resultset.getString("phone"), resultset.getString("addres"), resultset.getInt("totalpoint")));
            }
            System.out.println("fetched");
        } catch (Exception e) {
            System.out.println("can't fetch");
            System.out.println(e);
        }

        //System.out.println(s_list.size());
        //float x=s_list.get(0).cost;
        //System.out.println(x);
        return m_list;
    }
    @FXML
    private Button searchbtn;
    @FXML
    private TextField search_tf;
    public void clear() {
        tname.setText(null);
        tphone.setText(null);
        taddress.setText(null);
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
        //ObservableList<Supplylist> s_list;
        m_list = getDataMemberlist();
        tcc_id.setCellValueFactory(new PropertyValueFactory<Memberlist, Integer>("cid"));
        tcname.setCellValueFactory(new PropertyValueFactory<Memberlist, String>("name"));
        tcphone.setCellValueFactory(new PropertyValueFactory<Memberlist, String>("phone"));
        tcaddress.setCellValueFactory(new PropertyValueFactory<Memberlist, String>("address"));
        tcpoints.setCellValueFactory(new PropertyValueFactory<Memberlist, Integer>("point"));
        memberlist.setItems(m_list);
        //S.setItems(null);

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initialization();

    }

    @FXML
    private void addmember(MouseEvent event) throws ClassNotFoundException, SQLException {
        
        String name, phn, address;
        name = tname.getText();
        phn = tphone.getText();
        address = taddress.getText();
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();
        dbc.insertDataToDB("insert into membership(name,phone,addres,totalpoint) values('" + name + "','" + phn + "','" + address + "','" + 0 + "')");
        initialization();
        clear();
    }

    @FXML
    private void onClicksSearchbtn(ActionEvent event) throws ClassNotFoundException, SQLException {
        String qry = "select * from membership where card_id like '%" + search_tf.getText() + "%'";
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();
        ResultSet resultset = null;
        resultset = dbc.queryToDB(qry);
        m_list.clear();
        while (resultset.next()) {
            //System.out.println(resultset.getString("deliverydate"));
            m_list.add(new Memberlist(resultset.getInt("card_id"), resultset.getString("name"), resultset.getString("phone"), resultset.getString("addres"), resultset.getInt("totalpoint")));
        }
        //memberlist.setItems(null);
        
        tcc_id.setCellValueFactory(new PropertyValueFactory<Memberlist, Integer>("cid"));
        tcname.setCellValueFactory(new PropertyValueFactory<Memberlist, String>("name"));
        tcphone.setCellValueFactory(new PropertyValueFactory<Memberlist, String>("phone"));
        tcaddress.setCellValueFactory(new PropertyValueFactory<Memberlist, String>("address"));
        tcpoints.setCellValueFactory(new PropertyValueFactory<Memberlist, Integer>("point"));
        memberlist.setItems( m_list);
    }

    @FXML
    private void getselected(MouseEvent event) {
        index = memberlist.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        //a = p_id.getCellData(index);
        tname.setText( tcname.getCellData(index).toString());
        tphone.setText( tcphone.getCellData(index).toString());
        taddress.setText(tcaddress.getCellData(index).toString());
    }

    @FXML
    private void edit(MouseEvent event) {
    }

    @FXML
    private void delete(MouseEvent event) throws ClassNotFoundException, SQLException {
        System.out.println("oooo");
        if(memberlist.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not selection");
            alert.setContentText("No item is selected!");
            alert.show();
            return;
        }
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();
        //isss ektu jaater naam de variable gular
        String id = memberlist.getSelectionModel().getSelectedItem().getCid() + "";
        System.out.println(id);
        String query = "DELETE FROM membership WHERE card_id  =" + id;//
        dbc.insertDataToDB(query);
        initialization();
    }

}
