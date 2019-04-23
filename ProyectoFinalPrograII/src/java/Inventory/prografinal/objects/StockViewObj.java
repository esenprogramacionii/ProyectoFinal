
package Inventory.prografinal.objects;



public class StockViewObj 
{
    private int m_ITrans;
    private String m_prod;
    private String m_store;
    private int m_IStock;

    public StockViewObj(int p_ITrans, String p_prod, String p_store, int p_IStock) {
        setTrans(p_ITrans);
        setprod(p_prod);
        setstore(p_store);
        setStock(p_IStock);
    }

    
    //Constructor para la tabla View del inventario: una de las tablas más importantes

    public int getTrans() {
        return m_ITrans;
    }

    private void setTrans(int p_ITrans) {
        m_ITrans = p_ITrans;
    }

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

    public int getStock() {
        return m_IStock;
    }

    private void setStock(int p_IStock) {
        m_IStock = p_IStock;
    }

    
}
