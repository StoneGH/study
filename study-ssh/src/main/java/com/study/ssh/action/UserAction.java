package com.study.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.study.ssh.entity.User;
import com.study.ssh.service.UserService;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by shitao on 2017/3/2.
 */
@Namespace("user")
public class UserAction extends ActionSupport implements ModelDriven<User>, Preparable {

    @Autowired
    private UserService userService;

    private List<User> users;

    @Override
    public String execute() throws Exception {
        users = userService.queryAll();
        return SUCCESS;
    }

    public User getModel() {
        return null;
    }

    public void prepare() throws Exception {

    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
