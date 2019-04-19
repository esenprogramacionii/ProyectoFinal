
package zepe.proyectofinal.objects;

public class StockViewObj 
{
    private int m_ITrans;
    private String m_prod;
    private int m_Iid;
    private String m_store;
    private int m_ISid;
    private int m_IStock;

    public StockViewObj(int p_ITrans, String p_prod, int p_Iid, String p_store, int p_ISid, int p_IStock) {
        setTrans(p_ITrans);
        setprod(p_prod);
        setid(p_Iid);
        setstore(p_store);
        setSid(p_ISid);
        setStock(p_IStock);
    }

    
    //Constructor para la tabla View del inventario: una de las tablas más importantes

    public String getprod() {
        return m_prod;
    }

    private void setprod(String p_prod) {
        m_prod = p_prod;
    }

    public String getstore() {
        return m_store;
    }

    private void setstore(String p_store) {
        m_store = p_store;
    }
  
    public int getTrans() {
        return m_ITrans;
    }

    private void setTrans(int p_ITrans) {
        m_ITrans = p_ITrans;
    }
 
    public int getid() {
        return m_Iid;
    }

    private void setid(int p_Iid) {
        m_Iid = p_Iid;
    }

    public int getSid() {
        return m_ISid;
    }

    private void setSid(int p_ISid) {
        m_ISid = p_ISid;
    }

    public int getStock() {
        return m_IStock;
    }

    private void setStock(int p_IStock) {
        m_IStock = p_IStock;
    }
    
    
    
}
