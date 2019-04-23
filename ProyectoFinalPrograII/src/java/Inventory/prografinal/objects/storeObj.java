/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory.prografinal.objects;

public class storeObj {

    public storeObj(int p_iId, String p_strName) {
        setId(p_iId);
        setName(p_strName);
    }
    
    
    private int m_iId;
    private String m_strName;

    public int getId() {
        return m_iId;
    }

    private void setId(int p_iId) {
        this.m_iId = p_iId;
    }

    public String getName() {
        return m_strName;
    }

    private void setName(String p_strName) {
        this.m_strName = p_strName;
    }
    
    
    
}
