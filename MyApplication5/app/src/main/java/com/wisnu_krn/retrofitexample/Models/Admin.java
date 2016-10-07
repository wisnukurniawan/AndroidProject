
package com.wisnu_krn.retrofitexample.Models;

import java.util.HashMap;
import java.util.Map;

public class Admin {
//progrmmer copas --> edit yang perlu-perlu aja
    private Integer id;
    private String nama;
    private String email;
    private String alamat;
    private String status;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * 
     * @param nama
     *     The nama
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * 
     * @return
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     The alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * 
     * @param alamat
     *     The alamat
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
