/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package korrow;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kantarat
 */
public class Table extends javax.swing.JFrame {
    String ImgPath = null;
 
    /**
     * Creates new form Table
     */
    public Table() {
        initComponents();
        findItems();
        tableItem3.setAutoCreateRowSorter(true);
        
    }
    
    public Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://35.166.222.133:3306/Project?zeroDateTimeBehavior=convertToNull",
                "sitfreshy", "123456789");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }     
    
    public ArrayList<Item>ListItems(){
        ArrayList<Item> itemList = new ArrayList<Item>();
        Statement st;
        
        try{
            String searchQuery = "SELECT * FROM Item";
            //String searchQuery = "SELECT * FROM Item WHERE CONCAT('item_id','item_name','item_owner_id','item_unit','item_capacity_amount','item_current_amount','item_image_path','item_note','item_rent_detail','item_available','item_type','category_item_id_category_item')LIKE '%"+ValToSearch+"%'";
            Connection con = Db1.getConnectionBuilder();
            st = con.createStatement();
            ResultSet rs = st.executeQuery(searchQuery);
            Item item;
            while(rs.next()){
                item = new Item(
                    rs.getString("item_id"),
                    rs.getString("item_name"),
                    rs.getString("item_owner_id"),
                    rs.getString("item_unit"),
                    rs.getLong("item_capacity_amount"),
                    rs.getLong("item_current_amount"),
                    rs.getString("item_image_path"),
                    rs.getString("item_note"),
                    rs.getString("item_rent_detail"),
                    rs.getByte("item_available"),
                    rs.getString("item_type"),
                    rs.getInt("category_item_id_category_item"),
                    rs.getBytes("Image"));
                    
                itemList.add(item);
            }
            con.close();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return itemList;
    }
    
    public void findItems(){
        ArrayList<Item> items = ListItems();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"item_id","item_name","item_owner_id","item_unit","item_capacity_amount","item_current_amount","item_image_path","item_note","item_rent_detail","item_available","item_type","category_item_id_category_item"});
        Object[] row = new Object[13];
        
        for(int i =0; i< items.size();i++){
            row[0] = items.get(i).getId();
            row[1] = items.get(i).getName();
            row[2] = items.get(i).getOwnerId();
            row[3] = items.get(i).getUnit();
            row[4] = items.get(i).getCapaAmount();
            row[5] = items.get(i).getCurrentAmount();
            row[6] = items.get(i).getPic();
            row[7] = items.get(i).getNote();
            row[8] = items.get(i).getRentDe();
            row[9] = items.get(i).getAvali();
            row[10] = items.get(i).getType();
            row[11] = items.get(i).getCata();
            
            
            model.addRow(row);
            
        }
        tableItem3.setModel(model);
        
   
    }
    
   

    
    public ImageIcon ResizeImage(String imagePath, byte[] pic)
    {
        ImageIcon myImage = null;
        
        if(imagePath != null)
        {
            myImage = new ImageIcon(imagePath);
        }else{
            myImage = new ImageIcon(pic);
        }
        
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
        
    }
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextField1_search = new javax.swing.JTextField();
        jButton1_btnSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableItem3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_item = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_idOw = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        current = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_note = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1_insert = new javax.swing.JButton();
        btn_Update = new javax.swing.JButton();
        jButton3_Delete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        btn_choIm = new javax.swing.JButton();
        jComboBox1_current = new javax.swing.JComboBox<>();
        jTextField1_cur = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jTextField1_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 141, -1));

        jButton1_btnSearch.setText("Search");
        jButton1_btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1_btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 20, -1, -1));

        tableItem3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name Item", "Owner Id", "Item Unit", "Item Capacity", "Item Current", "Item image", "Item note", "Item rent", "Item available", "Item type", "Item Category"
            }
        ));
        tableItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableItem3MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableItem3);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 900, 400));

        jLabel1.setText("ไอดีของ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 60, 20));
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 100, -1));
        jPanel1.add(txt_item, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 100, -1));

        jLabel2.setText("ชื่อของ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 60, 20));

        txt_idOw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idOwActionPerformed(evt);
            }
        });
        jPanel1.add(txt_idOw, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 100, -1));

        jLabel3.setText("รหัสผู้ฝาก");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 60, 20));

        current.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentActionPerformed(evt);
            }
        });
        jPanel1.add(current, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 30, -1));

        jLabel4.setText("จำนวน");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 60, 20));

        txt_note.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_noteActionPerformed(evt);
            }
        });
        jPanel1.add(txt_note, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 170, 50));

        jLabel5.setText("Note Item");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 60, 20));

        jButton1_insert.setText("Insert");
        jButton1_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_insertActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1_insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        btn_Update.setText("Update");
        btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, -1, -1));

        jButton3_Delete.setText("Delete");
        jButton3_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 80, -1));

        jLabel6.setText("รูปภาพ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        image.setBackground(new java.awt.Color(240, 255, 250));
        image.setOpaque(true);
        jPanel1.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 160, 100));

        btn_choIm.setText("Choose image");
        btn_choIm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_choImActionPerformed(evt);
            }
        });
        jPanel1.add(btn_choIm, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, -1));

        jComboBox1_current.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "เครื่อง ", "ชิ้น", "เเท่ง ", "เเผ่น ", "อัน ", "ผืน ", "ขวด" }));
        jComboBox1_current.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1_currentActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1_current, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, -1, -1));
        jPanel1.add(jTextField1_cur, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 60, -1));

        jButton1.setText("เเสดงรูป");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jLabel12.setFont(new java.awt.Font("Gabriola", 3, 24)); // NOI18N
        jLabel12.setText("Korrow Project EIEI");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, 180, 70));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Rockwell Condensed", 0, 24)); // NOI18N
        jLabel13.setText("     Korrow Project NaJa EIEI");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableItem3MouseClicked
        // TODO add your handling code here:
         try{
             int totalRow = tableItem3.getSelectedRow();
             String tableClick = (tableItem3.getModel().getValueAt(totalRow,0).toString());
             String sql = "select * from Item where Item_Id = '"+tableClick+"'";
             Connection c = Db1.getConnectionBuilder();
             PreparedStatement pre = c.prepareStatement(sql);
             ResultSet rs = c.createStatement().executeQuery(sql);
            if(rs.next()){
                pre.execute();
                String add1 = rs.getString("Item_Id");
               txt_id.setText(add1);
               String add2 = rs.getString("Item_Name");
               txt_item.setText(add2);
               String add3 = rs.getString("Item_Owner_Id");
               txt_idOw.setText(add3);
               String add4 = rs.getString("item_current_amount");
               current.setText(add4);
               String add5 = rs.getString("item_unit");
               jTextField1_cur.setText(add5) ;
               String add6 = rs.getString("item_note");
               txt_note.setText(add6);
            
               
               image.setIcon(ResizeImage(null,ListItems().get(totalRow).getPicture()));
               c.close();
            }
        }catch(Exception e){
            
        }
         
       
        
    }//GEN-LAST:event_tableItem3MouseClicked

    private void jButton1_btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_btnSearchActionPerformed
        // TODO add your handling code here:
       
               
    
        
        
    }//GEN-LAST:event_jButton1_btnSearchActionPerformed

    private void currentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentActionPerformed

    private void txt_idOwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idOwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idOwActionPerformed

    private void txt_noteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_noteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_noteActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        // TODO add your handling code here:
        if(ImgPath == null){
            try{
                int index = tableItem3.getSelectedRow();
                String id = tableItem3.getValueAt(index, 0).toString();
                Connection con = Db1.getConnectionBuilder();
                PreparedStatement ps = con.prepareStatement("UPDATE Item SET item_name=?,item_owner_id=?,item_current_amount=?,item_unit=?,item_note=? WHERE item_id=?" );
              
                ps.setString(1,txt_item.getText());
                ps.setString(2,txt_idOw.getText());
                
                ps.setString(3,current.getText());
                ps.setString(4,jTextField1_cur.getText());
                ps.setString(5,txt_note.getText());
                ps.setString(6,id);
               
                ps.executeUpdate();
                findItems();
                con.close();
                JOptionPane.showMessageDialog(null," Update Success");
                
            }catch(Exception ex){
                Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            
        }
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void jButton3_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_DeleteActionPerformed
        // TODO add your handling code here:
        try{
            int index = tableItem3.getSelectedRow();
            String id = tableItem3.getValueAt(index, 0).toString();
            
            Connection con = Db1.getConnectionBuilder();
            String sql = "DELETE FROM Item WHERE item_id = '"+id+"'";
            Db1.getConnectionBuilder().createStatement().executeUpdate(sql);
            findItems();
            con.close();
           
            JOptionPane.showMessageDialog(null,"Deleted");
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
        }    
    }//GEN-LAST:event_jButton3_DeleteActionPerformed

    private void btn_choImActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_choImActionPerformed
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser(); 
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image","jpg","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            image.setIcon(ResizeImage(path, null));
            ImgPath = path;
        }else{
            System.out.println("No File");
        }
        
    }//GEN-LAST:event_btn_choImActionPerformed

    private void jButton1_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_insertActionPerformed
        // TODO add your handling code here:
        
            try {
                Connection con = Db1.getConnectionBuilder();
                PreparedStatement ps = con.prepareStatement("insert into Item(item_id,item_name,item_owner_id,item_unit,item_current_amount,item_note,Image,category_item_id_category_item)" 
                        + "values(?,?,?,?,?,?,?,1) ");
                ps.setString(1,txt_id.getText());
                ps.setString(2,txt_item.getText());
                ps.setString(3,txt_idOw.getText());
                ps.setString(4,jTextField1_cur.getText());
                ps.setString(5,current.getText());
                ps.setString(6,txt_note.getText());
                
               
                
               
                InputStream img = new FileInputStream(new File(ImgPath));
                ps.setBlob(7, img);
                if(ps.executeUpdate() == 1)
                {
                    JOptionPane.showMessageDialog(null, "Image Inserted");
                }
            
                ps.executeUpdate();
                findItems();
                 JOptionPane.showMessageDialog(null, "Data Inserted");
                 con.close();
            } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null, ex.getMessage());
            }
       
       
        //Test
        System.out.println("Name => "+txt_id.getText());
        System.out.println("ชื่อของ => "+txt_item.getText());
        System.out.println("Owner => "+txt_idOw.getText());
        System.out.println("Current => "+current.getText());
        System.out.println("Image => "+ImgPath);
    }//GEN-LAST:event_jButton1_insertActionPerformed

    private void jComboBox1_currentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1_currentActionPerformed
        // TODO add your handling code here:
        jTextField1_cur.setText(jComboBox1_current.getSelectedItem().toString());
        
    }//GEN-LAST:event_jComboBox1_currentActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            //String sql = "select Image from Item where item_id"
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Table().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Update;
    private javax.swing.JButton btn_choIm;
    private javax.swing.JTextField current;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton1_btnSearch;
    private javax.swing.JButton jButton1_insert;
    private javax.swing.JButton jButton3_Delete;
    private javax.swing.JComboBox<String> jComboBox1_current;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1_cur;
    private javax.swing.JTextField jTextField1_search;
    private javax.swing.JTable tableItem3;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_idOw;
    private javax.swing.JTextField txt_item;
    private javax.swing.JTextField txt_note;
    // End of variables declaration//GEN-END:variables
}
