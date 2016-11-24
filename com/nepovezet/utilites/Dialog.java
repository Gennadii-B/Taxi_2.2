package com.nepovezet.utilites;

import com.nepovezet.entity.Car;
import com.nepovezet.entity.Driver;
import com.nepovezet.entity.Order;
import com.nepovezet.tools.TaxiException;

import static com.nepovezet.tools.SOPrint.println;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * Created by N on 12.11.2016.
 * этот класс ведет диалог с пользователем, помогает создать заявку на автомобиль и
 * дает ответы на его запрос
 */
public class Dialog {
    private static Dialog ourInstance = new Dialog();

    public static Dialog getInstance() {
        return ourInstance;
    }

    private Dialog() {
    }

    DataBase dataBase = DataBase.getInstance();
    static int idOrders = -1;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public Texts texts = new Texts();
    Order needOrder;

    public void quLocale () throws Exception{
        println("1. Русский\n2. English");
        String answerLocale = reader.readLine();
        if(answerLocale.equals("1"))texts.setNeedLocale(texts.getRuLocale());
        else if(answerLocale.equals("2"))texts.setNeedLocale(texts.getEnLocale());
        texts = new Texts();
    }

    public Order newOrder() throws Exception {

        String start;
        String end;
        boolean answerBabySeat;
        boolean answerNeedSmoke;
        int answerCarClass;

        println(texts.TEXT_START_POINT);
        start = reader.readLine();

        println(texts.TEXT_END_POINT);
        end = reader.readLine();

        println(texts.TEXT_QU_BABY_SEAT);
        answerBabySeat = setAnswerBool();

        println(texts.TEXT_QU_SMOKE);
        answerNeedSmoke = setAnswerBool();

        println(texts.TEXT_QU_CLASS);
        answerCarClass = setAnswerCarClass();

        idOrders++;

        needOrder = new Order(idOrders,
                start, end, answerBabySeat,
                answerNeedSmoke, answerCarClass);
        dataBase.baseOrders.add(needOrder);

        return needOrder;
    }

    //вызывается в случае несоответствия ни одного авто
    public void negativeAnswer(){
        println(texts.TEXT_ANSWER_NEGATIVE);
    }
    //дает всю инфу о нужном авто
    public void reserveCar(Driver driver){
        driver.getCar().setStatus(Car.STATUS_RESERVED);
        needOrder.setNeedDriver(driver);
        texts.textAnswerReservedCar(driver);
    }
    //следующие два метода обрабатывают запросы пользователя
    private int setAnswerCarClass() throws Exception{
        String answer;
        try{
            answer = reader.readLine();
            if(answer.equals("Y") || answer.equals("N"));
            else throw new TaxiException();
            if(answer.equals("Y"))return Car.CLASS_BUSYNESS;
            else return Car.CLASS_ECONOMIC;

        }catch(TaxiException exc){
            System.out.println(exc);
            return Car.CLASS_ECONOMIC;
        }
    }

    private boolean setAnswerBool() throws Exception{
        String answer;
        try{
            answer = reader.readLine();
            if(answer.equals("Y") || answer.equals("N"));
            else throw new TaxiException();
            if(answer.equals("Y"))return true;
            else return false;

        }catch(TaxiException exc){
            System.out.println(exc);
            return false;
        }
    }

    public static int getIdOrders() {
        return idOrders;
    }

}


