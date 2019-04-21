package Inventory.prografinal.objects;



public class CategoryObj_1 
{
    private int m_iId;
    private String m_strName;

    public CategoryObj_1(int p_iId, String p_strName) 
    {
        setId(p_iId);
        setName(p_strName);
    }

    public int getId() 
    {
        return m_iId;
    }

    private void setId(int p_iId) 
    {
        m_iId = p_iId;
    }

    public String getName() 
    {
        return m_strName;
    }

    private void setName(String p_strName) 
    {
        m_strName = p_strName;
    }

    
}
