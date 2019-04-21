
package Inventory.prografinal.objects;




public class DetailObj {
    
    private int m_Iidetail;
    private int m_product;
    private int m_quantity;
    private int m_relorder;

    public DetailObj(int p_Iidetail, int p_product, int p_quantity, int p_relorder) {
        setidetail(p_Iidetail);
        setproduct(p_product);
        setquantity(p_quantity);
        setrelorder(p_relorder);
    }


    public int getidetail() {
        return m_Iidetail;
    }

    private void setidetail(int p_Iidetail) {
        m_Iidetail = p_Iidetail;
    }

    public int getproduct() {
        return m_product;
    }

    private void setproduct(int p_product) {
        m_product = p_product;
    }

    public int getquantity() {
        return m_quantity;
    }

    private void setquantity(int p_quantity) {
        m_quantity = p_quantity;
    }

    public int getrelorder() {
        return m_relorder;
    }

    private void setrelorder(int p_relorder) {
        m_relorder = p_relorder;
    }

    

    
    
    
    
    
    
}
