/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Ket_Noi_Oracle {
    //driver của HQT Oracle
    String driver="oracle.jdbc.OracleDriver";
    //Dường dẫn kết nối port, tên DB
    String urlConnection="jdbc:oracle:thin:@localhost:1521:orcl";
    String name="admin";
    String pass="sys";
    
    public Connection connection=null;
     public Connection cn;
    //Phương thức mở kết nối
    public void Open() throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        connection=DriverManager.getConnection(urlConnection,name,pass);
        System.err.println("Ket Noi ORACLE Thanh Cong");
    }
    //Phương thức đóng kết nối
    public void Close() throws SQLException{
        connection.close();
        System.err.println("Da Dong Ket Noi");
    }
    //Phương thức Thực thi câu lệnh dạng select và trả về table
    public ResultSet executeQuery(String sql) throws SQLException 
    {
        Statement statement=connection.createStatement();
        ResultSet rs =statement.executeQuery(sql);
        return rs;
    }
    //Phương thức Thực thi câu lệnh dạng insert, update, delete và trả về số dòng đã thực thi
     public int executeUpdate(String sql) throws SQLException
    {
        int n=-1;
        Statement stm=connection.createStatement();
        n=stm.executeUpdate(sql);
        return n;
    }
     
     
     
     ////////////////////////////////////////////////////////
      public String[] in_ban() throws ClassNotFoundException, SQLException {
        int bien = 0;
        String[] tenban = new String[20];
         this.Open();
        
        String sql = "select soban from ban where tinhtrang=1";
        try {
            ResultSet rs = this.executeQuery(sql);
            while (rs.next()) {
                tenban[bien] = rs.getString(1).trim();
                bien++;
            }
            return tenban;
        } catch (Exception e) {
            System.out.println("loi in_ban  " + e);
            return null;
        }
    }

    public String[] in_douong() throws ClassNotFoundException, SQLException {
        int bien = 0;
        String[] tendouong = new String[20];
           this.Open();
       
        String sql = "select tendu from thucuong";
        try {
             ResultSet rs = this.executeQuery(sql);
            while (rs.next()) {
                tendouong[bien] = rs.getString(1).trim();
                bien++;
            }
            return tendouong;
        } catch (Exception e) {
            System.out.println("loi in_douong " + e);
            return null;
        }
    }

    public int[] in_tinhtrang_ban() throws ClassNotFoundException, SQLException {
        int bien = 0;
        int[] tinhtrang = new int[20];
        this.Open();
       
        String sql = "select tinhtrang from ban";
        try {
            ResultSet rs = this.executeQuery(sql);
            while (rs.next()) {
                tinhtrang[bien] = Integer.valueOf((rs.getString(1).trim()));
                bien++;
            }
            return tinhtrang;
        } catch (Exception e) {
            System.out.println("loi in_tinhtrang_ban " + e);
            return null;
        }
    }

    public String[] in_soluongton() throws ClassNotFoundException, SQLException {
        int bien = 0;
        String[] tendouong = new String[20];
            this.Open();
        String sql = "select soluongton from thucuong";
        try {
           ResultSet rs = this.executeQuery(sql);
            while (rs.next()) {
                tendouong[bien] = rs.getString(1).trim();
                bien++;
            }
            return tendouong;
        } catch (Exception e) {
            System.out.println("loi in_soluongton " + e);
            return null;
        }
        
    }

    public void nhapkho1(String tendouong, String soluong) throws ClassNotFoundException, SQLException {
            this.Open();
        String sql = "update thucuong set soluongton=soluongton+" + soluong + " where tendu=" + "'" + tendouong + "'";
        try {
           ResultSet rs = this.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("loi nhapkho1 " + e);
        }
         this.Close();
    }

    public void nhapkho2(String madouong, String tendouong, String soluong, String dongia) throws ClassNotFoundException, SQLException {
       this.Open();
        String sql = "insert into thucuong values('" + madouong + "','" + tendouong + "'," + dongia + "," + soluong + ")";
        try {
             ResultSet rs = this.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("loi nhapkho2 " + e);
        }
         this.Close();
    }

    public void update_tinhtrang_ban2(String soban) throws ClassNotFoundException, SQLException {
          this.Open();
        String sql = "update ban set tinhtrang=1 " + "where soban='" + soban + "'";
        try {
            ResultSet rs = this.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("loi update_tinhtrang_ban2 " + e);
        }
    }

    public void update_tinhtrang_ban3(String soban) throws ClassNotFoundException, SQLException {
          this.Open();
        String sql = "update ban set tinhtrang=0 " + "where soban='" + soban + "'";
        try {
             ResultSet rs = this.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("loi update_tinhtrang_ban3i " + e);
        }
         this.Close();
    }

    public void them_hoadon() throws ClassNotFoundException, SQLException {
          this.Open();
        Statement sm = null;
        String sql = "INSERT INTO HOADON(MAHOADON,TINHTRANG,TongTien) values(" +"null"+","+ 1 + "," + 0 + ")"; //1 LÀ TÌNH TRẠNG HÓA ĐƠN CHƯA TÍNH TIỀN TÍNH TIỀN 
        try {
            sm = cn.createStatement();
            int rs = sm.executeUpdate(sql);
            this.Close();
        } catch (Exception e) {
            System.out.println("loi Them hoa hon " + e);
        }
    }

    public void them_cthoadon(String mahd, String ban, String madu, String soluong) throws ClassNotFoundException, SQLException {
         this.Open();
       
        String sql = "INSERT INTO CHITIETHOADON(MAHD,SOBAN,TENDU,SOLUONG) values(" + mahd + ",'" + ban + "','" + madu + "'," + soluong + ",getdate()" + ")";
        try {
             int rs = this.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("loithem_cthoadon!!" + e);
        }
         this.Close();
    }

    public String in_hoadon_moitao() throws ClassNotFoundException, SQLException {
        String in_hd = "";
         this.Open();
       
        String sql = "select MAHOADON from hoadon where mahd>=(select max(MAHOADON) from hoadon)";
        try {
            ResultSet rs = this.executeQuery(sql);
            while (rs.next()) {
                in_hd = rs.getString(1).trim();
            }
             this.Close();
            return in_hd;
        } catch (Exception e) {
            System.out.println("loi In hoa don moi tao!!!" + e);
            return null;
        }
        
    }

    public String in_hoadon_cantinh(String ban) throws ClassNotFoundException, SQLException {
        String in_hd = "";
              this.Open();
        String sql = "select DISTINCT hoadon.MAHOADON from hoadon,chitiethoadon where hoadon.MAHOADON=chitiethoadon.mahd and tinhtrang=1 and soban='" + ban + "'";
        try {
                ResultSet rs = this.executeQuery(sql);
            while (rs.next()) {
                in_hd = rs.getString(1).trim();
            }
             this.Close();
            return in_hd;
        } catch (Exception e) {
            System.out.println("loiin_hoadon_cantinh!!!" + e);
            return null;
        }
    }

    public void xoa_hd() throws ClassNotFoundException, SQLException {
             this.Open();
        String sql = "TRUNCATE table hoadon";
        try {
           ResultSet rs = this.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("loi xoa_hd " + e);
        }
         this.Close();
    }

    public void update_tinhtrang_hoadon(String mahd) throws ClassNotFoundException, SQLException {
             this.Open();
        Statement sm = null;
        String sql = "update hoadon set tinhtrang=0 " + "where mahd=" + mahd; // 0 là đã tính tiền rồi.
        try {
            sm = cn.createStatement();
            int rs = sm.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("loi update_tinhtrang_hoadon " + e);
        }
         this.Close();
    }

    public void update_tongtien(String mahd, String tongtien) throws ClassNotFoundException, SQLException {
              this.Open();
        String sql = "update hoadon set tongtien=" + tongtien + "where MaHoaDon=" + mahd; // 0 là đã tính tiền rồi.
        try {
           ResultSet rs = this.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("loiupdate_tongtien " + e);
        }
         this.Close();
    }
     ////////////////////////////////////////////////////////////////////////
//      public String[] in_ban() throws ClassNotFoundException, SQLException {
//        int bien = 0;
//        String[] tenban = new String[20];
//        this.Open();
//        
//        String sql = "select soban from ban where tinhtrang=1";
//        try {
//           
//           ResultSet rs = this.executeQuery(sql);
//            while (rs.next()) {
//                tenban[bien] = rs.getString(1).trim();
//                bien++;
//            }
//            return tenban;
//        } catch (Exception e) {
//            System.out.println("loi gi do roi " + e);
//            return null;
//        }
//    }
//
//    public String[] in_douong() throws ClassNotFoundException, SQLException {
//        int bien = 0;
//        String[] tendouong = new String[20];
//        this.Open();
//        Statement sm = null;
//        ResultSet rs = null;
//        String sql = "select tendu from thucuong";
//        try {
//            sm = cn.createStatement();
//            rs = sm.executeQuery(sql);
//            while (rs.next()) {
//                tendouong[bien] = rs.getString(1).trim();
//                bien++;
//            }
//            return tendouong;
//        } catch (Exception e) {
//            System.out.println("loi gi do roi " + e);
//            return null;
//        }
//    }
//
//    public int[] in_tinhtrang_ban() throws ClassNotFoundException, SQLException {
//        int bien = 0;
//        int[] tinhtrang = new int[20];
//        this.Open();
//        Statement sm = null;
//        ResultSet rs = null;
//        String sql = "select tinhtrang from ban";
//        try {
//            sm = cn.createStatement();
//            rs = sm.executeQuery(sql);
//            while (rs.next()) {
//                tinhtrang[bien] = Integer.valueOf((rs.getString(1).trim()));
//                bien++;
//            }
//            return tinhtrang;
//        } catch (Exception e) {
//            System.out.println("loi gi do roi " + e);
//            return null;
//        }
//    }
//
//    public String[] in_soluongton() throws ClassNotFoundException, SQLException {
//        int bien = 0;
//        String[] tendouong = new String[20];
//        this.Open();
//        Statement sm = null;
//        ResultSet rs = null;
//        String sql = "select soluongton from thucuong";
//        try {
//            sm = cn.createStatement();
//            rs = sm.executeQuery(sql);
//            while (rs.next()) {
//                tendouong[bien] = rs.getString(1).trim();
//                bien++;
//            }
//            return tendouong;
//        } catch (Exception e) {
//            System.out.println("loi gi do roi " + e);
//            return null;
//        }
//    }
//
//    public void nhapkho1(String tendouong, String soluong) throws ClassNotFoundException, SQLException {
//        this.Open();
//        Statement sm = null;
//        String sql = "update thucuong set soluongton=soluongton+" + soluong + " where tendu=" + "'" + tendouong + "'";
//        try {
//            sm = cn.createStatement();
//            int rs = sm.executeUpdate(sql);
//        } catch (Exception e) {
//            System.out.println("loi gi do roi " + e);
//        }
//    }
//
//    public void nhapkho2(String madouong, String tendouong, String soluong, String dongia) throws ClassNotFoundException, SQLException {
//       this.Open();
//        Statement sm = null;
//        String sql = "insert into thucuong values('" + madouong + "','" + tendouong + "'," + dongia + "," + soluong + ")";
//        try {
//            sm = cn.createStatement();
//            int rs = sm.executeUpdate(sql);
//        } catch (Exception e) {
//            System.out.println("loi gi do roi " + e);
//        }
//    }
//
//    public void update_tinhtrang_ban2(String soban) throws ClassNotFoundException, SQLException {
//        this.Open();
//        Statement sm = null;
//        String sql = "update ban set tinhtrang=1 " + "where soban='" + soban + "'";
//        try {
//            sm = cn.createStatement();
//            int rs = sm.executeUpdate(sql);
//        } catch (Exception e) {
//            System.out.println("loi gi do roi " + e);
//        }
//    }
//
//    public void update_tinhtrang_ban3(String soban) throws ClassNotFoundException, SQLException {
//        this.Open();
//        Statement sm = null;
//        String sql = "update ban set tinhtrang=0 " + "where soban='" + soban + "'";
//        try {
//            sm = cn.createStatement();
//            int rs = sm.executeUpdate(sql);
//        } catch (Exception e) {
//            System.out.println("loi gi do roi " + e);
//        }
//    }
//
//    public void them_hoadon() throws ClassNotFoundException, SQLException {
//       this.Open();
//        Statement sm = null;
//        String sql = "insert into hoadon(MAHOADON,TINHTRANG,TONGTIEN) values(" + 1 + "," + 0 + ")"; //1 LÀ TÌNH TRẠNG HÓA ĐƠN CHƯA TÍNH TIỀN TÍNH TIỀN 
//        try {
//            sm = cn.createStatement();
//            int rs = sm.executeUpdate(sql);
//        } catch (Exception e) {
//            System.out.println("loi gi do roi " + e);
//        }
//    }
//
//    public void them_cthoadon(String mahd, String ban, String madu, String soluong) throws ClassNotFoundException, SQLException {
//       this.Open();
//        Statement sm = null;
//        String sql = "insert into chitiethoadon(MAHD,SOBAN,TENDU,SOLUONG) values(" + mahd + ",'" + ban + "','" + madu + "'," + soluong + ",getdate()" + ")";
//        try {
//            sm = cn.createStatement();
//            int rs = sm.executeUpdate(sql);
//        } catch (Exception e) {
//            System.out.println("loi gi do roi nhe!!!" + e);
//        }
//    }
//
//    public String in_hoadon_moitao() throws ClassNotFoundException, SQLException {
//        String in_hd = "";
//       this.Open();
//        Statement sm = null;
//        ResultSet rs = null;
//        String sql = "select mahoadon from hoadon where mahoadon>=(select max(mahoadon) from hoadon)";
//        try {
//            sm = cn.createStatement();
//            rs = sm.executeQuery(sql);
//            while (rs.next()) {
//                in_hd = rs.getString(1).trim();
//            }
//            return in_hd;
//        } catch (Exception e) {
//            System.out.println("loi gi do roi ne!!!" + e);
//            return null;
//        }
//    }
//
//    public String in_hoadon_cantinh(String ban) throws ClassNotFoundException, SQLException {
//        String in_hd = "";
//       this.Open();
//        Statement sm = null;
//        ResultSet rs = null;
//        String sql = "select DISTINCT hoadon.mahoadon from hoadon,chitiethoadon where hoadon.mahoadon=chitiethoadon.mahd and tinhtrang=1 and soban='" + ban + "'";
//        try {
//            sm = cn.createStatement();
//            rs = sm.executeQuery(sql);
//            while (rs.next()) {
//                in_hd = rs.getString(1).trim();
//            }
//            return in_hd;
//        } catch (Exception e) {
//            System.out.println("loi gi do roi ne!!!" + e);
//            return null;
//        }
//    }
//
//    public void xoa_hd() throws ClassNotFoundException, SQLException {
//       this.Open();
//        Statement sm = null;
//        String sql = "TRUNCATE table hoadon";
//        try {
//            sm = cn.createStatement();
//            int rs = sm.executeUpdate(sql);
//        } catch (Exception e) {
//            System.out.println("loi gi do roi " + e);
//        }
//    }
//
//    public void update_tinhtrang_hoadon(String mahd) throws ClassNotFoundException, SQLException {
//       this.Open();
//        Statement sm = null;
//        String sql = "update hoadon set tinhtrang=0 " + "where mahoadon=" + mahd; // 0 là đã tính tiền rồi.
//        try {
//            sm = cn.createStatement();
//            int rs = sm.executeUpdate(sql);
//        } catch (Exception e) {
//            System.out.println("loi gi do roi " + e);
//        }
//    }
//
//    public void update_tongtien(String mahd, String tongtien) throws ClassNotFoundException, SQLException {
//       this.Open();
//        Statement sm = null;
//        String sql = "update hoadon set tongtien=" + tongtien + "where mahoadon=" + mahd; // 0 là đã tính tiền rồi.
//        try {
//            sm = cn.createStatement();
//            int rs = sm.executeUpdate(sql);
//        } catch (Exception e) {
//            System.out.println("loi gi do roi " + e);
//        }
//    }

}
