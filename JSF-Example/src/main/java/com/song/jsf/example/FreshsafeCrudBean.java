package com.song.jsf.example;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.song.jsf.example.util.CommonUtils;

@ManagedBean
@SessionScoped
public class FreshsafeCrudBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Student> list;
    private Student item = new Student();
    private Student beforeEditItem = null;
    private boolean edit;

    @ManagedProperty(value="#{commonUtils}")
	private CommonUtils util;
	public void setUtil(CommonUtils util) {
		this.util = util;
	}

    @PostConstruct
    public void init() {
        list = new ArrayList<Student>();
    }

    public void add() {
    	// DAO save the add
        item.setId(list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1);
        list.add(item);
        item = new Student();

        util.redirectWithGet();
    }

    public void resetAdd() {
    	item = new Student();

    	util.redirectWithGet();
    }

    public void edit(Student item) {
    	beforeEditItem = item.clone();
        this.item = item;
        edit = true;

        util.redirectWithGet();
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Student();
        edit = false;

        util.redirectWithGet();
    }

    public void saveEdit() {
    	// DAO save the edit
        this.item = new Student();
        edit = false;

        util.redirectWithGet();
    }

    public void delete(Student item) throws IOException {
    	// DAO save the delete
        list.remove(item);

        util.redirectWithGet();
    }

    public List<Student> getList() {
        return list;
    }

    public Student getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }


}
