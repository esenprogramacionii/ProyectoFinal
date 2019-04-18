
package zepe.proyectofinal.objects;

public class DetailViewObj 
{
      private int m_iId;
      private String m_Name;
      private int m_piId;
      private String m_fprice;
      private int m_iQ;
      private float m_ftotal;
      private int m_iorder;

    public DetailViewObj(int p_iId, String p_Name, int p_piId, String p_fprice, int p_iQ, float p_ftotal, int p_iorder) {
        setId(p_iId);
        setName(p_Name);
        setpiId(p_piId);
        setprice(p_fprice);
        setiQ(p_iQ);
        settotal(p_ftotal);
        setiorder(p_iorder);
    }


    public int getId() {
        return m_iId;
    }

    public void setId(int p_iId) {
        m_iId = p_iId;
    }

    public String getName() {
        return m_Name;
    }

    public void setName(String p_Name) {
        m_Name = p_Name;
    }

    public int getpiId() {
        return m_piId;
    }

    public void setpiId(int p_piId) {
        m_piId = p_piId;
    }

    public String getprice() {
        return m_fprice;
    }

    public void setprice(String p_fprice) {
        m_fprice = p_fprice;
    }

    public int getiQ() {
        return m_iQ;
    }

    public void setiQ(int p_iQ) {
        m_iQ = p_iQ;
    }

    public float gettotal() {
        return m_ftotal;
    }

    public void settotal(float p_ftotal) {
        m_ftotal = p_ftotal;
    }

    public int getiorder() {
        return m_iorder;
    }

    public void setiorder(int p_iorder) {
        m_iorder = p_iorder;
    }
      
      
    
    
    
    
    
    
    
}
