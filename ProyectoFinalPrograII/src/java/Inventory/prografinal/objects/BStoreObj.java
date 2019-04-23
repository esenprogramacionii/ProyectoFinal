
package Inventory.prografinal.objects;


public class BStoreObj {
    
    private String m_PName;
    private String m_SName;
    private int m_Sstock;

    public BStoreObj(String p_PName, String p_SName, int p_Sstock) {
        setName(p_PName);
        setSName(p_SName);
        setSstock(p_Sstock);
    }

    public String getName() {
        return m_PName;
    }

    private void setName(String p_PName) {
        m_PName = p_PName;
    }

    public String getSName() {
        return m_SName;
    }

    private void setSName(String p_SName) {
        m_SName = p_SName;
    }

    public int getSstock() {
        return m_Sstock;
    }

    private void setSstock(int p_Sstock) {
        m_Sstock = p_Sstock;
    }
    
    
    
}
