
package zepe.proyectofinal.objects;

public class OrderObj 

{
    
    int m_Iid;
    int m_ISupplier;
    String m_date;

    public OrderObj(int p_Iid, int p_ISupplier, String p_date) {
        setid(p_Iid);
        setSupplier(p_ISupplier);
        setdate(p_date);
    }
    
    

    public int getid() {
        return m_Iid;
    }

    private void setid(int p_Iid) {
        m_Iid = p_Iid;
    }

    public int getSupplier() {
        return m_ISupplier;
    }

    private void setSupplier(int p_ISupplier) {
        m_ISupplier = p_ISupplier;
    }

    public String getdate() {
        return m_date;
    }

    private void setdate(String p_date) {
        m_date = p_date;
    }
    
    
    
}
