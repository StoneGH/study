package com.stone.study.model;

import java.io.Serializable;

public class Func implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table func
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = -231225491575064252L;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column func.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column func.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column func.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column func.flag
     *
     * @mbggenerated
     */
    private String flag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column func.id
     *
     * @return the value of func.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column func.id
     *
     * @param id the value for func.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column func.name
     *
     * @return the value of func.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column func.name
     *
     * @param name the value for func.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column func.remark
     *
     * @return the value of func.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column func.remark
     *
     * @param remark the value for func.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column func.flag
     *
     * @return the value of func.flag
     *
     * @mbggenerated
     */
    public String getFlag() {
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column func.flag
     *
     * @param flag the value for func.flag
     *
     * @mbggenerated
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }
}