package com.example.model;

/**
 * @author hellscorpion
 * @date 2017-04-23
 * @version 1.0
 */
public class ISBN {

    private String code;

    public ISBN(String code) {
        this.code = code;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

}
