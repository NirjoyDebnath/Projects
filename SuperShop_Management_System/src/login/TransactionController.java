/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MN
 */
public class TransactionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField tp_id;

    @FXML
    private TextField ts_id;

    @FXML
    private TextField tquantity;


    @FXML
    private TableView<Transactionlist> list;

    @FXML
    private TableColumn<Transactionlist, String> tcproductname;

    @FXML
    private TableColumn<Transactionlist, Integer> tcquantity;

    @FXML
    private TableColumn<Transactionlist, Float> tcppu;

    @FXML
    private TableColumn<Transactionlist, Float> tctotal;
    
    @FXML
    private TableView<Transactionlist> list1;

    @FXML
    private TableColumn<Transactionlist, String> tcproductname1;

    @FXML
    private TableColumn<Transactionlist, Integer> tcquantity1;

    @FXML
    private TableColumn<Transactionlist, Float> tcppu1;

    @FXML
    private TableColumn<Transactionlist, Float> tctotal1;

    @FXML
    private Button badd;
    
    @FXML
    private Label bill;

    @FXML
    private Button btransact;
    public float xx=0;
    public String pp="";
    ArrayList<Integer> ss = new ArrayList<Integer>();

    
    public ObservableList<Transactionlist> t_list = FXCollections.observableArrayList();
    @FXML
    private TextField tc_id;
    @FXML
    private TextField tpaid;
    @FXML
    private TextField trb;
    @FXML
    private Label lpoint;
    @FXML
    private Label lpaid;
    @FXML
    private Label lchange;
    public void clear() {
        tp_id.setText(null);
        ts_id.setText(null);
        tquantity.setText(null);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LocalDate todaysDate = LocalDate.now();
        System.out.println(todaysDate);
        LocalDate localDate = LocalDate.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
        String formattedString = localDate.format(formatter);
        System.out.println(formattedString);
    }
    
    @FXML
    void addtocart(MouseEvent event) throws ClassNotFoundException, SQLException {
        
        String productname="tt";
        
        int quantity,p_id,s_id;
        float ppu=0,total;
        quantity=parseInt(tquantity.getText());
        p_id=parseInt(tp_id.getText());
        s_id=parseInt(ts_id.getText());
        ss.add(s_id);
        ResultSet resultset=null;
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();
        resultset=dbc.queryToDB("select * from stock where supply_id= '" + s_id + "'");
        while(resultset.next())
        {
            ppu=resultset.getFloat("price");
        }
        //ppu=parseFloat(tppu.getText());
        total=quantity*ppu;
        xx=xx+total;
        quantity=parseInt(tquantity.getText());
        
        //ResultSet resultset=null;
        
        resultset=dbc.queryToDB("select * from product where product_id='" + p_id + "';");
        //resultset=dbc.queryToDB("select * from product");
        try {
            //System.out.println(resultset.getString("productname"));
        //productname=resultset.getString("productname");
        while(resultset.next()){
                productname=resultset.getString("productname");
                if(pp!="")pp=pp+"\n";
                pp=pp+""+productname+"("+String.valueOf(quantity)+")";
            }
        //int t=0;
        } catch (SQLException ex) {
        Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(productname);
        //System.out.println(quantity);
        //System.out.println(ppu);
        //System.out.println(total);
        
        t_list.add(new Transactionlist(productname,quantity,ppu,total));
        System.out.println(t_list.size());
        tcproductname.setCellValueFactory(new PropertyValueFactory<Transactionlist,String>("productname"));
        tcquantity.setCellValueFactory(new PropertyValueFactory<Transactionlist,Integer>("quantity"));
        tcppu.setCellValueFactory(new PropertyValueFactory<Transactionlist,Float>("ppu"));
        tctotal.setCellValueFactory(new PropertyValueFactory<Transactionlist,Float>("total"));
        
        list.setItems(t_list);
        clear();
    }
    /*
    public TransactionController(ObservableList<Transactionlist> t_list) {
        System.out.println(t_list.size());
        this.t_list = t_list;
    }
    */
    

    public ObservableList<Transactionlist> getT_list() {
        System.out.println(this.t_list.size());
        return t_list;
    }

    public void setT_list() {
        this.t_list = t_list;
    } 
    @FXML
    void transact(MouseEvent event) throws SQLException, ClassNotFoundException {
        tcproductname1.setCellValueFactory(new PropertyValueFactory<Transactionlist,String>("productname"));
        tcquantity1.setCellValueFactory(new PropertyValueFactory<Transactionlist,Integer>("quantity"));
        tcppu1.setCellValueFactory(new PropertyValueFactory<Transactionlist,Float>("ppu"));
        tctotal1.setCellValueFactory(new PropertyValueFactory<Transactionlist,Float>("total"));
        list.setItems(null);
        //t_list.add(new Transactionlist(null,null,null,0));
        list1.setItems(t_list);
        bill.setText(Float.toString(xx));
        //xx=0;
        String dd,dm,dy;
        
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();
        
        
        LocalDate localDate = LocalDate.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
        String formattedString = localDate.format(formatter);
        System.out.println(formattedString);
        dbc.insertDataToDB("insert into customer(cdate) values('"+formattedString+"')");
        
        
        //dbc.insertDataToDB("insert into supply(phone,suppliername) values('"+phn+"','"+sname+"')");
        int c_id=0;
        ResultSet resultset=null;
        resultset=dbc.queryToDB("select * from customer");
        
        while(resultset.next())
        {
            c_id=resultset.getInt("customer_id");
        }
        for(int i=0;i<t_list.size();i++)
        {
            int p=0;
            
            resultset=dbc.queryToDB("select * from stock where supply_id= '" +ss.get(i)+ "'");
            while(resultset.next())
            {
                p=resultset.getInt("quantity");
            }
            System.out.println(p);
            p=p-t_list.get(i).quantity;
            System.out.println(ss.get(i));
            dbc.insertDataToDB("update stock set quantity= '" +p+ "' where supply_id ='"+ss.get(i)+"'");
            resultset=dbc.queryToDB("select * from product where productname= '" +t_list.get(i).productname + "'");
            
            while(resultset.next())
            {
                p=resultset.getInt("product_id");
            }
            dbc.insertDataToDB("insert into orders(product_id,customer_id,price,quantity) values('"+p+"','"+c_id+"','"+t_list.get(i).ppu+"','"+t_list.get(i).quantity+"')");
        }
        System.out.println(pp);
        dbc.insertDataToDB("insert into transactions(customer_id,bill,productnamewq) values('"+c_id+"','"+xx+"','"+pp+"')");
        //xx=0;
        //t_list.clear();
    }

    @FXML
    private void check(MouseEvent event) throws ClassNotFoundException, SQLException {
        int c_id=parseInt(tc_id.getText());
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();
        ResultSet resultset=null;
        resultset=dbc.queryToDB("select * from membership where card_id='"+c_id+"'");
        
        while(resultset.next())
        {
            lpoint.setText(Integer.toString(resultset.getInt("totalpoint")));
            //c_id=resultset.getInt("customer_id");
        }
    }

    @FXML
    private void paid(MouseEvent event) throws ClassNotFoundException, SQLException {
        int c_id=0,rb=0,paid,XX=(int) xx;
        if(!tc_id.getText().equals(""))c_id=parseInt(tc_id.getText());
        if(!trb.getText().equals(""))rb=parseInt(trb.getText());
        paid=parseInt(tpaid.getText());
        lpaid.setText(Integer.toString(rb+paid));
        lchange.setText(Integer.toString(-(XX-rb-paid)));
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();
        ResultSet resultset=null;
        resultset=dbc.queryToDB("select * from membership where card_id='"+c_id+"'");
        
        while(resultset.next())
        {
            int X=(int) (resultset.getInt("totalpoint")-rb+(xx/100));
            System.out.println(X);
            dbc.insertDataToDB("update membership set totalpoint= '" +X+ "' where card_id ='"+c_id+"'");
        }
        //dbc.insertDataToDB("update membership set totalpoint= '" +xx/100+ "' where card_id ='"+c_id+"'");
        list1.setItems(null);
        t_list.clear();
        xx=0;
    }

    
    
    
}
