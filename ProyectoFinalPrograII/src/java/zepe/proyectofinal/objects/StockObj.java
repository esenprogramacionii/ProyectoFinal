package zepe.proyectofinal.objects;

public class StockObj 
{
    private int m_iId;
    private int m_iIdStore;
    private int m_iStock;

    public StockObj(int p_iId, int p_iIdStore, int p_iStock) {
        setId(p_iId);
        setIdStore(p_iIdStore);
        setStock(p_iStock);
    }

    public int getId() {
        return m_iId;
    }

    private void setId(int p_iId) {
        m_iId = p_iId;
    }

    public int getIdStore() {
        return m_iIdStore;
    }

    private void setIdStore(int p_iIdStore) {
        m_iIdStore = p_iIdStore;
    }

    public int getStock() {
        return m_iStock;
    }

    private void setStock(int p_iStock) {
        m_iStock = p_iStock;
    }
    
    
    
}
