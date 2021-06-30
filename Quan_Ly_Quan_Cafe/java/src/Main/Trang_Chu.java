/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Main.taikhoan;
import  Main.DANGNHAP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Administrator
 */
public class Trang_Chu extends javax.swing.JFrame {

        Ket_Noi_Oracle kn = new Ket_Noi_Oracle();
    String[] tenban = new String[20];
    String[] tendouong = new String[20];
    String[] bancantinh = new String[20];
    static String soban = "";
    static String mahd = "";
    static float tongtien = 0;
    public String[] soluongton = new String[20];
  
  DANGNHAP hienthiusser = new DANGNHAP();
    int[] tinhtrangban = new int[20];
    Vector vheader = new Vector();
    Vector vdata = new Vector();
    static Vector danhsach = new Vector();
    int themhd = 0;
    String tenhd = "";
Vector vheader1 = new Vector();
    Vector vdata1 = new Vector();
    /**
     * Creates new form interface1
     */
    public Trang_Chu() throws ClassNotFoundException, SQLException {
        initComponents();
        setLocationRelativeTo(null);
        tenban = kn.in_ban();
        ban.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        bancantinh = kn.in_ban();
        ban_can_tinh.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        tendouong = kn.in_douong();
        douong.setModel(new javax.swing.DefaultComboBoxModel<>(tendouong));
        nhapdouong.setModel(new javax.swing.DefaultComboBoxModel<>(tendouong));
        nhapdouong2.setModel(new javax.swing.DefaultComboBoxModel<>(tendouong));
        soluongton = kn.in_soluongton();
        int a = nhapdouong.getSelectedIndex();
        ton.setText(soluongton[a]);
        loadban();
        vheader.add("Bàn");
        vheader.add("Đồ Uống");
        vheader.add("Số Lượng");
        vheader.add("Đơn Giá");
        jTable1.setModel(new DefaultTableModel(vdata, vheader));
        load_bang_tinh_tien();
       txt_HIENTHI.setText(hienthiusser.ten);
       load_data_dump_file();
        vheader1.add("OWNER");
        vheader1.add("DIRECTORY_NAME");
        vheader1.add("DIRECTORY_PATH");
        
        jTable2.setModel(new DefaultTableModel(vdata1, vheader1));

    }

    public void loadban() throws ClassNotFoundException, SQLException {
        tinhtrangban = kn.in_tinhtrang_ban();
        if (tinhtrangban[0] == 0) //1 la da co khach o ban do, 0 la khong co khach
        {
            ban1.setEnabled(true);
        } else {
            ban1.setEnabled(false);
        }
        if (tinhtrangban[1] == 0) {
            ban2.setEnabled(true);
        } else {
            ban2.setEnabled(false);
        }
        if (tinhtrangban[2] == 0) {
            ban3.setEnabled(true);
        } else {
            ban3.setEnabled(false);
        }
        if (tinhtrangban[3] == 0) {
            ban4.setEnabled(true);
        } else {
            ban4.setEnabled(false);
        }
        if (tinhtrangban[4] == 0) {
            ban5.setEnabled(true);
        } else {
            ban5.setEnabled(false);
        }
        if (tinhtrangban[5] == 0) {
            ban6.setEnabled(true);
        } else {
            ban6.setEnabled(false);
        }
        if (tinhtrangban[6] == 0) {
            ban7.setEnabled(true);
        } else {
            ban7.setEnabled(false);
        }
        if (tinhtrangban[7] == 0) {
            ban8.setEnabled(true);
        } else {
            ban8.setEnabled(false);
        }
        if (tinhtrangban[8] == 0) {
            ban9.setEnabled(true);
        } else {
            ban9.setEnabled(false);
        }
        if (tinhtrangban[9] == 0) {
            ban10.setEnabled(true);
        } else {
            ban10.setEnabled(false);
        }
    }

    public float tinh_tong_tien(String ban) {
        float tong = 0;
        int n = this.jTable1.getRowCount();
        for (int i = 0; i < n; i++) {
            Vector<String> v = (Vector<String>) (vdata.get(i));
            if (v.get(0).equals(ban)) {
                tong += Float.valueOf(v.get(2)) * Float.valueOf(v.get(3));
            }

        }
        return tong;
    }

    public Vector in_danhsach_thucuong(String ban) {
        Vector ds = new Vector();
        int n = this.jTable1.getRowCount();
        for (int i = 0; i < n; i++) {
            Vector<String> v = (Vector<String>) (vdata.get(i));
            if (v.get(0).equals(ban)) {
                ds.add(v);
            }
        }
        return ds;
    }

    public void load_bang_tinh_tien() {
            try {
                kn.Open();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        String sql = "select soban,chitiethoadon.tendu,soluong,dongia from chitiethoadon,hoadon,thucuong where chitiethoadon.tendu=thucuong.tendu and chitiethoadon.mahd=hoadon.mahoadon and hoadon.tinhtrang=1";
        try {

           ResultSet rs = kn.executeQuery(sql);
            while (rs.next()) {
                Vector<String> v = new Vector<String>();
                v.add(rs.getString(1).trim());
                v.add(rs.getString(2).trim());
                v.add(rs.getString(3).trim());
                v.add(rs.getString(4).trim());
                vdata.add(v);
            }
        } catch (Exception e) {
            System.out.println("loi load bang tinh tien " + e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        ban1 = new javax.swing.JButton();
        ban2 = new javax.swing.JButton();
        ban3 = new javax.swing.JButton();
        ban4 = new javax.swing.JButton();
        ban5 = new javax.swing.JButton();
        ban6 = new javax.swing.JButton();
        ban7 = new javax.swing.JButton();
        ban8 = new javax.swing.JButton();
        ban9 = new javax.swing.JButton();
        ban10 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        douong = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ban = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        soluong = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        ban_can_tinh = new javax.swing.JComboBox<>();
        jButton10 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        nhapdouong = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        ton = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nhapdouong2 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        sl = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        douongmoi = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        soluongmoi = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        mamoi = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        dongia = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_HIENTHI = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_user_backup = new javax.swing.JTextField();
        txt_service_backup = new javax.swing.JTextField();
        txt_fileName_backup = new javax.swing.JTextField();
        btn_backup = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_dd = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_pass_backup = new javax.swing.JTextField();
        btn_recey = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUAN_LY_QUAN_CA_PHE");

        jPanel1.setLayout(new java.awt.GridLayout(5, 2));

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        ban1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/room.png"))); // NOI18N
        ban1.setText("1");
        ban1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban1ActionPerformed(evt);
            }
        });
        jPanel5.add(ban1);

        jPanel1.add(jPanel5);

        ban2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/room.png"))); // NOI18N
        ban2.setText("2");
        ban2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban2ActionPerformed(evt);
            }
        });
        jPanel1.add(ban2);

        ban3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/room.png"))); // NOI18N
        ban3.setText("3");
        ban3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban3ActionPerformed(evt);
            }
        });
        jPanel1.add(ban3);

        ban4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/room.png"))); // NOI18N
        ban4.setText("4");
        ban4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban4ActionPerformed(evt);
            }
        });
        jPanel1.add(ban4);

        ban5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/room.png"))); // NOI18N
        ban5.setText("5");
        ban5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban5ActionPerformed(evt);
            }
        });
        jPanel1.add(ban5);

        ban6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/room.png"))); // NOI18N
        ban6.setText("6");
        ban6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban6ActionPerformed(evt);
            }
        });
        jPanel1.add(ban6);

        ban7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/room.png"))); // NOI18N
        ban7.setText("7");
        ban7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban7ActionPerformed(evt);
            }
        });
        jPanel1.add(ban7);

        ban8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/room.png"))); // NOI18N
        ban8.setText("8");
        ban8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban8ActionPerformed(evt);
            }
        });
        jPanel1.add(ban8);

        ban9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/room.png"))); // NOI18N
        ban9.setText("9");
        ban9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban9ActionPerformed(evt);
            }
        });
        jPanel1.add(ban9);

        ban10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/room.png"))); // NOI18N
        ban10.setText("10");
        ban10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban10ActionPerformed(evt);
            }
        });
        jPanel1.add(ban10);

        jTabbedPane1.addTab("Table", jPanel1);

        jLabel1.setText("Chọn đồ uống:");

        jLabel2.setText("Chọn bàn:");

        jLabel3.setText("Chọn số lượng:");

        soluong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", " " }));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/THEM.png"))); // NOI18N
        jButton9.setText("Thêm");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ban, 0, 505, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(douong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(soluong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(douong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Drinks", jPanel2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setText("Chọn bàn cần tính tiền để xuất tổng tiền :");

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Cash.png"))); // NOI18N
        jButton10.setText("Tính Tiền");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/XOA.png"))); // NOI18N
        jButton13.setText("Xóa");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ban_can_tinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 428, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ban_can_tinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Bill", jPanel3);

        jLabel5.setText("Chọn đồ uống:");

        nhapdouong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        nhapdouong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapdouongActionPerformed(evt);
            }
        });

        jLabel6.setText("Số lượng tồn trong kho:");

        ton.setText("0");

        jLabel8.setText("Chọn đồ uống:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Nhập đồ uống");

        jLabel10.setText("Số lượng nhập:");

        jLabel11.setText("Nhập đồ uống mới:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Nhập đồ uống mới");

        jLabel13.setText("Số lượng nhập:");

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/THEM.png"))); // NOI18N
        jButton11.setText("Nhập kho");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel14.setText("Nhập mã đồ uống:");

        jLabel15.setText("Đơn giá:");

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/THEM.png"))); // NOI18N
        jButton12.setText("Nhập kho");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nhapdouong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nhapdouong2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton11)
                                .addGap(0, 394, Short.MAX_VALUE))
                            .addComponent(sl)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(douongmoi))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soluongmoi))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mamoi))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(dongia))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nhapdouong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nhapdouong2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(sl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mamoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(douongmoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(soluongmoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(dongia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton12)
                .addContainerGap(328, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Warehouse", jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setForeground(new java.awt.Color(255, 255, 51));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 153, 153));
        jButton2.setText("THÔNG TIN HỆ THỐNG");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 153, 153));
        jButton3.setText("THÔNG TIN SESSION");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 153, 153));
        jButton5.setText("THÔNG TIN POLICY, AUDIT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 153, 153));
        jButton4.setText("THÔNG TIN TABLESPACE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 153, 153));
        jButton6.setText("THÔNG TIN USER,DATAFILE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 153, 153));
        jButton7.setText("QUẢN LÝ USER");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("USER HIỆN ĐANG ĐĂNG NHẬP:");

        txt_HIENTHI.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txt_HIENTHI.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addGap(212, 212, 212)
                .addComponent(txt_HIENTHI)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_HIENTHI))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(60, 60, 60)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4))
                .addGap(49, 49, 49)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap(454, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("System", jPanel6);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("DATA_PUMP_DIR");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("User");

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Password");

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("File_Name");

        btn_backup.setText("BACK UP & RECOVERY");
        btn_backup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backupActionPerformed(evt);
            }
        });

        jLabel20.setText("expdp <user>/<password> dumpfile=<file_name>.dpdmp");

        jLabel21.setText("Mẫu Backup");

        jButton1.setText("Lấy Đường Dẫn Backup");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel22.setText("B1:Nhập thông tin và coppy đường dẫn");

        jLabel23.setText("B2:Nhấn Backup & recovery");

        jLabel24.setText("B3:  Paste đường dẫn");

        jLabel25.setText("impdp \\\"sys/<password>@<service_name> as sysdba\\\" file=<path_of_dump_file> full=y ");

        jLabel26.setText("Mẫu Recovery");

        jLabel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel27.setText("Service_Name");

        btn_recey.setText("Lấy Đường Dẫn Recovery");
        btn_recey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_receyActionPerformed(evt);
            }
        });

        jLabel28.setText("BACKUP");

        jLabel29.setText("RECOVERY");

        jLabel30.setText("B1:Nhập thông tin và coppy đường dẫn");

        jLabel31.setText("B2:Nhấn Backup & recovery");

        jLabel32.setText("B3:  Paste đường dẫn");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel27))
                                .addGap(28, 28, 28)
                                .addComponent(txt_service_backup, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(txt_user_backup, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addGap(42, 42, 42)
                                .addComponent(txt_pass_backup, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(txt_fileName_backup, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel23))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_backup)
                        .addGap(58, 58, 58))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel22))
                    .addComponent(txt_dd, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_recey)
                    .addComponent(jButton1))
                .addGap(31, 31, 31))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(txt_user_backup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fileName_backup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_pass_backup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txt_service_backup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_dd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28)
                .addGap(8, 8, 8)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_recey)
                    .addComponent(jLabel22))
                .addGap(25, 25, 25)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_backup, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel24)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel29)))
                .addGap(34, 34, 34)
                .addComponent(jLabel30)
                .addGap(28, 28, 28)
                .addComponent(jLabel31)
                .addGap(34, 34, 34)
                .addComponent(jLabel32)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Backup & Recovery", jPanel7);

        jButton8.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 153, 153));
        jButton8.setText("LOG OUT");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jTabbedPane1.addTab("Log Out", jButton8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        new QuanLy_User().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        new User().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new TableSpace().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new Policy().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new Sesion().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new HeThong().setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try {
            kn.nhapkho2(mamoi.getText(), douongmoi.getText(), soluongmoi.getText(), dongia.getText());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tendouong = kn.in_douong();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        douong.setModel(new javax.swing.DefaultComboBoxModel<>(tendouong));
        nhapdouong.setModel(new javax.swing.DefaultComboBoxModel<>(tendouong));
        nhapdouong2.setModel(new javax.swing.DefaultComboBoxModel<>(tendouong));
        try {
            soluongton = kn.in_soluongton();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        int b = nhapdouong.getSelectedIndex();
        ton.setText(soluongton[b]);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        String a = nhapdouong2.getSelectedItem().toString();
        try {
            kn.nhapkho1(a, sl.getText());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            soluongton = kn.in_soluongton();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        int b = nhapdouong.getSelectedIndex();
        ton.setText(soluongton[b]);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void nhapdouongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapdouongActionPerformed
        int a = nhapdouong.getSelectedIndex();
        ton.setText(soluongton[a]);
    }//GEN-LAST:event_nhapdouongActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        int pos = this.jTable1.getSelectedRow();
        if (pos >= 0) {
            vdata.remove(pos);
            jTable1.updateUI();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.dispose();
        try {
            kn.update_tinhtrang_ban3(ban_can_tinh.getSelectedItem().toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        soban = ban_can_tinh.getSelectedItem().toString();
        try {
            mahd = kn.in_hoadon_cantinh(ban_can_tinh.getSelectedItem().toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        tongtien = this.tinh_tong_tien(soban);
        jTable1.updateUI();
        try {
            kn.update_tinhtrang_hoadon(mahd);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        danhsach = in_danhsach_thucuong(soban);
        new Hoa_Don().setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            if (themhd == 0) {
                try {
                    kn.them_hoadon();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    tenhd = kn.in_hoadon_moitao();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            kn.them_cthoadon(tenhd, ban.getSelectedItem().toString(), douong.getSelectedItem().toString(), soluong.getSelectedItem().toString());
            vdata.removeAll(vdata);
            load_bang_tinh_tien();
            themhd = 1;
            jTable1.updateUI();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void ban10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban10ActionPerformed
        try {
            kn.update_tinhtrang_ban2("10");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tenban = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        try {
            bancantinh = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban_can_tinh.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        themhd = 0;
    }//GEN-LAST:event_ban10ActionPerformed

    private void ban9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban9ActionPerformed
        try {
            kn.update_tinhtrang_ban2("9");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tenban = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        try {
            bancantinh = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban_can_tinh.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        themhd = 0;
    }//GEN-LAST:event_ban9ActionPerformed

    private void ban8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban8ActionPerformed
        try {
            kn.update_tinhtrang_ban2("8");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tenban = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        try {
            bancantinh = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban_can_tinh.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        themhd = 0;
    }//GEN-LAST:event_ban8ActionPerformed

    private void ban7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban7ActionPerformed
        try {
            kn.update_tinhtrang_ban2("7");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tenban = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        try {
            bancantinh = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban_can_tinh.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        themhd = 0;
    }//GEN-LAST:event_ban7ActionPerformed

    private void ban6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban6ActionPerformed
        try {
            kn.update_tinhtrang_ban2("6");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tenban = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        try {
            bancantinh = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban_can_tinh.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        themhd = 0;
    }//GEN-LAST:event_ban6ActionPerformed

    private void ban5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban5ActionPerformed
        try {
            kn.update_tinhtrang_ban2("5");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tenban = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        try {
            bancantinh = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban_can_tinh.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        themhd = 0;
    }//GEN-LAST:event_ban5ActionPerformed

    private void ban4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban4ActionPerformed
        try {
            kn.update_tinhtrang_ban2("4");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tenban = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        try {
            bancantinh = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban_can_tinh.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        themhd = 0;
    }//GEN-LAST:event_ban4ActionPerformed

    private void ban3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban3ActionPerformed
        try {
            kn.update_tinhtrang_ban2("3");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tenban = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        try {
            bancantinh = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban_can_tinh.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        themhd = 0;
    }//GEN-LAST:event_ban3ActionPerformed

    private void ban2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban2ActionPerformed
        try {
            kn.update_tinhtrang_ban2("2");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tenban = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        try {
            bancantinh = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban_can_tinh.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        themhd = 0;
    }//GEN-LAST:event_ban2ActionPerformed

    private void ban1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban1ActionPerformed

        try {
            kn.update_tinhtrang_ban2("1");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tenban = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        try {
            bancantinh = kn.in_ban();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ban_can_tinh.setModel(new javax.swing.DefaultComboBoxModel<>(tenban));
        themhd = 0;
    }//GEN-LAST:event_ban1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
         try {
            new DANGNHAP().setVisible(true);
        } finally {
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btn_backupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backupActionPerformed
        // TODO add your handling code here:
        Runtime rt = Runtime.getRuntime();
    try {
        rt.exec(new String[]{"cmd.exe","/c","start"});

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }//GEN-LAST:event_btn_backupActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txt_dd.setText("expdp "+txt_user_backup.getText().toString()+"/"+txt_pass_backup.getText().toString()+" dumpfile="+txt_fileName_backup.getText().toString()+".dpdmp");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_receyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_receyActionPerformed
        // TODO add your handling code here:
        String a= "impdp \"sys/"+txt_pass_backup.getText().toString()+"@"+txt_service_backup.getText().toString()+ "as sysdba\"";
        String b="file=C:\\app\\Huy\\admin\\orcl\\dpdump\\"+txt_fileName_backup.getText().toString()+".dpdmp  full= y ";
         txt_dd.setText(a+b);
    }//GEN-LAST:event_btn_receyActionPerformed
///-----------------------------------------------------------------///
    public void load_data_dump_file() throws ClassNotFoundException, SQLException {
       kn.Open();

        String sql = "select * from dba_directories where directory_name='DATA_PUMP_DIR'";
        try {

            ResultSet rs = kn.executeQuery(sql);
            while (rs.next()) {
                Vector<String> v = new Vector<String>();
                v.add(rs.getString(1).trim());
                v.add(rs.getString(2).trim());
                v.add(rs.getString(3).trim());
              
                vdata1.add(v);
            }
               kn.Close();
        } catch (Exception e) {
            System.out.println("loi load dump_file " + e);
        }
    }
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
            java.util.logging.Logger.getLogger(Trang_Chu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trang_Chu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trang_Chu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trang_Chu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Trang_Chu().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Trang_Chu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ban;
    private javax.swing.JButton ban1;
    private javax.swing.JButton ban10;
    private javax.swing.JButton ban2;
    private javax.swing.JButton ban3;
    private javax.swing.JButton ban4;
    private javax.swing.JButton ban5;
    private javax.swing.JButton ban6;
    private javax.swing.JButton ban7;
    private javax.swing.JButton ban8;
    private javax.swing.JButton ban9;
    private javax.swing.JComboBox<String> ban_can_tinh;
    private javax.swing.JButton btn_backup;
    private javax.swing.JButton btn_recey;
    private javax.swing.JTextField dongia;
    private javax.swing.JComboBox<String> douong;
    private javax.swing.JTextField douongmoi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField mamoi;
    private javax.swing.JComboBox<String> nhapdouong;
    private javax.swing.JComboBox<String> nhapdouong2;
    private javax.swing.JTextField sl;
    private javax.swing.JComboBox<String> soluong;
    private javax.swing.JTextField soluongmoi;
    private javax.swing.JLabel ton;
    private javax.swing.JLabel txt_HIENTHI;
    private javax.swing.JTextField txt_dd;
    private javax.swing.JTextField txt_fileName_backup;
    private javax.swing.JTextField txt_pass_backup;
    private javax.swing.JTextField txt_service_backup;
    private javax.swing.JTextField txt_user_backup;
    // End of variables declaration//GEN-END:variables
}
