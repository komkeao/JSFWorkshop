/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.MediaRentalMas;
import model.User;

/**
 *
 * @author mewsha
 */
@ManagedBean(name = "TSA01RENTController")
@ViewScoped
public class TSA01RENTController implements Serializable {

    /**
     * Creates a new instance of BDM01USRController
     */
    @EJB
    private ejb.MediaRentalMasEjb ejbLV1;
    private List<MediaRentalMas> itemLV1List;
    private MediaRentalMas selectedLV1One;

    @EJB
    private ejb.UserEjb ejbUser;
    private List<User> itemRentByList;
    private List<User> itemCrByList;

    public TSA01RENTController() {
    }

    /*method*/
    public void init() {
        this.onLv1Read();
        this.itemRentByList = this.ejbUser.findAll();
        this.itemCrByList = this.ejbUser.findByType(3);
        
        this.selectedLV1One = new MediaRentalMas();
    }

    public void onLv1Read() {
        this.itemLV1List = this.ejbLV1.findAll();
    }

    public void prepareLV1Create() {
        this.selectedLV1One = new MediaRentalMas();
    }

    public void onSaveLV1() {
        this.ejbLV1.edit(selectedLV1One);
        this.onLv1Read();
    }

    public void onDelete() {
        this.ejbLV1.remove(selectedLV1One);
        this.onLv1Read();
    }

    // ---------------------get/set-----------------------
    public List<MediaRentalMas> getItemLV1List() {
        return itemLV1List;
    }

    public void setItemLV1List(List<MediaRentalMas> itemLV1List) {
        this.itemLV1List = itemLV1List;
    }

    public MediaRentalMas getSelectedLV1One() {
        return selectedLV1One;
    }

    public void setSelectedLV1One(MediaRentalMas selectedLV1One) {
        this.selectedLV1One = selectedLV1One;
    }

    public List<User> getItemRentByList() {
        return itemRentByList;
    }

    public void setItemRentByList(List<User> itemRentByList) {
        this.itemRentByList = itemRentByList;
    }

    public List<User> getItemCrByList() {
        return itemCrByList;
    }

    public void setItemCrByList(List<User> itemCrByList) {
        this.itemCrByList = itemCrByList;
    }
    
}
