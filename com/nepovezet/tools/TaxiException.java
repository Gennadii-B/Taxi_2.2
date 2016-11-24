package com.nepovezet.tools;

import com.nepovezet.utilites.Dialog;
import com.nepovezet.utilites.Texts;

/**
 * Created by N on 13.11.2016.
 */
public class TaxiException extends Exception {

    Dialog dialog = Dialog.getInstance();
    Texts texts = dialog.texts;

    public String toString(){
        return  texts.TEXT_EXC;}
}
