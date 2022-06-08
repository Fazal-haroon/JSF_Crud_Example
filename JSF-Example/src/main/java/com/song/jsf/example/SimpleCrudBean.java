package com.song.jsf.example;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SimpleCrudBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Student> list;
    private Student item = new Student();
    private Student beforeEditItem = null;
    private boolean edit;

    @PostConstruct
    public void init() {
        list = new ArrayList<Student>();
    }

    public void add() {
    	// DAO save the add
        item.setId(list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1);
        list.add(item);
        item = new Student();
    }

    public void resetAdd() {
    	item = new Student();
    }

    public void edit(Student item) {
    	beforeEditItem = item.clone();
        this.item = item;
        edit = true;
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Student();
        edit = false;
    }

    public void saveEdit() {
    	// DAO save the edit
        this.item = new Student();
        edit = false;
    }

    public void delete(Student item) throws IOException {
    	// DAO save the delete
        list.remove(item);
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