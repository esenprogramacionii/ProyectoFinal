package mig.prografinal.objects;


public class ProductView
{
//variables de instancia
    
    private int m_iId;
    private String m_strName;
    private String m_strBrand;
    private String m_strDescription;
    private int m_intYear;
    private double m_dPrice;
    private String m_strCategory;
 
    //constructores
    public ProductView(int p_iId, String p_strName, String p_strBrand,
            String p_strCategory, String p_strDescription, int p_intYear, double p_dPrice) 
    {    
        setId(p_iId);
        setBrand(p_strName);
        setBrand(p_strBrand);
        setDescription(p_strDescription);
        setYear(p_intYear);
        setPrice(p_dPrice);
        setCategory(p_strCategory);
    }

    //getters y setters
    public int getId() {
        return m_iId;
    }

    private void setId(int p_iId) {
        m_iId = p_iId;
    }

    public String getName() {
        return m_strName;
    }

    public void setName(String p_strName) {
        m_strName = p_strName;
    }

    public String getBrand() {
        return m_strBrand;
    }

    private void setBrand(String p_strBrand) {
        m_strBrand = p_strBrand;
    }

    public String getDescription() {
        return m_strDescription;
    }

    private void setDescription(String p_strDescription) {
        m_strDescription = p_strDescription;
    }

    public int getYear() {
        return m_intYear;
    }

    private void setYear(int p_intYear) {
        m_intYear = p_intYear;
    }

    public double getPrice() {
        return m_dPrice;
    }

    private void setPrice(double p_dPrice) {
        m_dPrice = p_dPrice;
    }

    public String getCategory() {
        return m_strCategory;
    }

    private void setCategory(String p_strCategory) {
        m_strCategory = p_strCategory;
    }
    
    
}