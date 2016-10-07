
package com.wisnu_krn.retrofitexample.Models;

import java.util.HashMap;
import java.util.Map;

public class Models {

    private Admin admin;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The admin
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * 
     * @param admin
     *     The admin
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
