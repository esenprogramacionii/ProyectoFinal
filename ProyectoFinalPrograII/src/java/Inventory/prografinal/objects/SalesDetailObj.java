package Inventory.prografinal.objects;

public class SalesDetailObj 
{
    private int m_iId;
    private int m_iProduct;
    private int m_iSales;
    private int m_iQuantity;

    public SalesDetailObj(int p_iId, int p_iProduct, int p_iSales, int p_iQuantity) 
    {
        setId(p_iId);
        setProduct(p_iProduct);
        setSales(p_iSales);
        setQuantity(p_iQuantity);
    }
    
    

    public int getId() {
        return m_iId;
    }

    private void setId(int p_iId) 
    {
        m_iId = p_iId;
    }

    public int getProduct() 
    {
        return m_iProduct;
    }

    private void setProduct(int p_iProduct) 
    {
        m_iProduct = p_iProduct;
    }

    public int getSales() 
    {
        return m_iSales;
    }

    private void setSales(int p_iSales) 
    {
        m_iSales = p_iSales;
    }

    public int getQuantity() 
    {
        return m_iQuantity;
    }

    private void setQuantity(int p_iQuantity) 
    {
        m_iQuantity = p_iQuantity;
    }
    
    
    
}
