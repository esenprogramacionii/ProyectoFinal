package sales.objects;

public class SalesObj {
    
    private int m_iId;
    private String m_strFirstname;
    private String m_strLastname;
    private String m_strDate;

    public SalesObj(int p_iId, String p_strFirstname, String p_strLastname, String p_strDate) {
        setId(p_iId);
        setFirstname(p_strFirstname);
        setLastname(p_strLastname);
        setDate(p_strDate);
    }
    
    

    public int getId() {
        return m_iId;
    }

    private void setId(int p_iId) {
        m_iId = p_iId;
    }

    public String getFirstname() {
        return m_strFirstname;
    }

    private void setFirstname(String p_strFirstname) {
        m_strFirstname = p_strFirstname;
    }

    public String getLastname() {
        return m_strLastname;
    }

    private void setLastname(String p_strLastname) {
        m_strLastname = p_strLastname;
    }

    public String getDate() {
        return m_strDate;
    }

    private void setDate(String p_strDate) {
        m_strDate = p_strDate;
    }
    
    
    
    
}
