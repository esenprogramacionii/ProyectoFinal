package zepe.proyectofinal.objects;

public class FinalObj {
    
    private String m_Prod;
    private int m_ProdID;
    private int m_Stock;

    public FinalObj(String p_Prod, int p_ProdID, int p_Stock) {
        setProd(p_Prod);
        setProdID(p_ProdID);
        setStock(p_Stock);
    }
    
    
    

    public String getProd() {
        return m_Prod;
    }

    public void setProd(String p_Prod) {
        m_Prod = p_Prod;
    }

    public int getProdID() {
        return m_ProdID;
    }

    public void setProdID(int p_ProdID) {
        m_ProdID = p_ProdID;
    }

    public int getStock() {
        return m_Stock;
    }

    public void setStock(int p_Stock) {
        m_Stock = p_Stock;
    }
    
    
    
}
