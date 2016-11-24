package com.nepovezet;

import com.nepovezet.entity.Driver;
import com.nepovezet.entity.Order;
import com.nepovezet.utilites.CarSelection;
import com.nepovezet.utilites.DataBase;
import com.nepovezet.utilites.Dialog;

/**
 * Created by N on 11.11.2016.
 */
public class main {
    public static void main(String[] args) throws Exception{

        Dialog dialog = Dialog.getInstance();
        CarSelection carSelection = CarSelection.getInstance();
        Driver needDriver;
        Order order;

        dialog.quLocale();

        while(true) {
            order = dialog.newOrder();
            needDriver = carSelection.search(order);
            if(needDriver == null){
                dialog.negativeAnswer();
                continue;
            }
            dialog.reserveCar(needDriver);
        }
    }
}
