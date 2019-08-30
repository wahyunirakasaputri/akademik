package akademik;
import java.sql.*;
public class Koneksi
{
    private Connection konek;
    public Connection Getkoneksidatabase()
    {
        if(konek==null)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Jdbc Tersedia");
                try
                {
                    konek=DriverManager.getConnection("jdbc:mysql://localhost/akademik","root","root");
                    System.out.println("Koneksi Berhasil");
                }
                catch(SQLException ex)
                {
                    System.out.println("Koneksi Gagal " +ex.toString());
                }
            }
            catch(ClassNotFoundException ex)
            {                        
                System.out.println("Jdbc Driver Tidak Tersedia");
            }
        }
        return konek;
    }
}
