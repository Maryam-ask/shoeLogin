package com.model.to;

import com.model.da.PersonDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maryam Askari
 * Date: 5/26/2021
 * Time: 2:10 PM
 * Project: IntelliJ IDEA
 */
public class IdSet {
    private List<Long> id = new ArrayList<>();

    public List<Long> getId() {
        return id;
    }

    public void setId(List<Long> id) {
        this.id = id;
    }

    //todo add id to person
    /*public void addIDToPerson(){
        int idSize=getId().size();
        for (int i=1;i<idSize;i++){
            getId().add(i,);
        }
    }

     */
}
