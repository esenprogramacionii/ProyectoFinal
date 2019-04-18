
package zepe.proyectofinal.objects;

public class StockObj 
{
    private int m_Iid;
    private int m_ISid;
    private int m_IStock;

    public StockObj(int p_Iid, int p_ISid, int p_IStock) {
        setid(p_Iid);
        setSid(p_ISid);
        setStock(p_IStock);
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
