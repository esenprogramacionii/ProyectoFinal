
package Inventory.prografinal.objects;


public class StockObj 
{
    private int m_trans;
    private int m_IP;
    private int m_IStore;
    private int m_IStock;

    public StockObj(int p_trans, int p_IP, int p_IStore, int p_IStock) {
        settrans(p_trans);
        setIP(p_IP);
        setStore(p_IStore);
        setStock(p_IStock);
    }
    
    public int gettrans() {
        return m_trans;
    }

    private void settrans(int p_trans) {
        m_trans = p_trans;
    }

    public int getIP() {
        return m_IP;
    }

    private void setIP(int p_IP) {
        m_IP = p_IP;
    }

    public int getStore() {
        return m_IStore;
    }

    private void setStore(int p_IStore) {
        m_IStore = p_IStore;
    }

    public int getStock() {
        return m_IStock;
    }

    private void setStock(int p_IStock) {
        m_IStock = p_IStock;
    
    
    }
}
