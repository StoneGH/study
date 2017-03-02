package com.stone.study.model;

import java.io.Serializable;

public class RoleFuncRelation implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table role_func_relation
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = -6918649940464851210L;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_func_relation.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_func_relation.role_id
     *
     * @mbggenerated
     */
    private String roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_func_relation.func_id
     *
     * @mbggenerated
     */
    private String funcId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_func_relation.id
     *
     * @return the value of role_func_relation.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_func_relation.id
     *
     * @param id the value for role_func_relation.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_func_relation.role_id
     *
     * @return the value of role_func_relation.role_id
     *
     * @mbggenerated
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_func_relation.role_id
     *
     * @param roleId the value for role_func_relation.role_id
     *
     * @mbggenerated
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_func_relation.func_id
     *
     * @return the value of role_func_relation.func_id
     *
     * @mbggenerated
     */
    public String getFuncId() {
        return funcId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_func_relation.func_id
     *
     * @param funcId the value for role_func_relation.func_id
     *
     * @mbggenerated
     */
    public void setFuncId(String funcId) {
        this.funcId = funcId == null ? null : funcId.trim();
    }
}