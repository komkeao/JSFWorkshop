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
import model.Media;

/**
 *
 * @author mewsha
 */
@ManagedBean(name = "BDM02MEDController")
@ViewScoped
public class BDM02MEDController implements Serializable {

    /**
     * Creates a new instance of BDM01USRController
     */
    @EJB
    private ejb.MediaEjb ejbLV1;
    private List<Media> itemLV1List;
    private Media selectedLV1One;

    public BDM02MEDController() {
    }

    /*method*/
    public void init() {
        this.onLv1Read();
    }

    public void onLv1Read() {
        this.itemLV1List = this.ejbLV1.findAll();
    }

    public void prepareLV1Create() {
        this.selectedLV1One = new Media();
    }

    public void AvaliableChecked(Media item) {
        this.selectedLV1One = item;
        this.onSaveLV1();
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
    public List<Media> getItemLV1List() {
        return itemLV1List;
    }

    public void setItemLV1List(List<Media> itemLV1List) {
        this.itemLV1List = itemLV1List;
    }

    public Media getSelectedLV1One() {
        return selectedLV1One;
    }

    public void setSelectedLV1One(Media selectedLV1One) {
        this.selectedLV1One = selectedLV1One;
    }

}
