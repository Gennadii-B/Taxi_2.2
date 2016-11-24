package com.nepovezet.utilites;

import com.nepovezet.entity.Car;
import com.nepovezet.entity.Driver;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.nepovezet.tools.SOPrint.println;

/**
 * Created by N on 24.11.2016.
 */
public class Texts {
  //  private static Texts ourInstance = new Texts();

   // public static Texts getInstance(){
   //     return ourInstance;
   // }

   // private Texts(){}

    private static Locale ruLocale = new Locale("ru", "RU");
    private static Locale enLocale = new Locale("en", "EN");
    private static Locale needLocale = ruLocale;
    private String formatAnswer = "%n%s %d%n%s%n%s %s%n%s %s%n%s %s %s%n%s %d%n%n";

    ResourceBundle bundle = ResourceBundle.getBundle("com/nepovezet/lang", needLocale);

    public final String TEXT_START_POINT = bundle.getString("Text_Start_point");

    public final String TEXT_END_POINT = bundle.getString("Text_End_Point");

    public final String TEXT_QU_BABY_SEAT = bundle.getString("Text_Qu_Baby_Seat");

    public final String TEXT_QU_SMOKE = bundle.getString("Text_Qu_Smoke");

    public final String TEXT_QU_CLASS = bundle.getString("Text_Qu_Class");

    public final String TEXT_ANSWER_NEGATIVE = bundle.getString("Text_Answer_Negative");

    public  final String TEXT_EXC = bundle.getString("Text_Exc");

    public  final String TEXT_ANSWER_RESERVED_CAR_0 = bundle.getString("Text_Ans_Reserved_Car_0");
    public  final String TEXT_ANSWER_RESERVED_CAR_1 = bundle.getString("Text_Ans_Reserved_Car_1");
    public  final String TEXT_ANSWER_RESERVED_CAR_2 = bundle.getString("Text_Ans_Reserved_Car_2");
    public  final String TEXT_ANSWER_RESERVED_CAR_3 = bundle.getString("Text_Ans_Reserved_Car_3");
    public  final String TEXT_ANSWER_RESERVED_CAR_4 = bundle.getString("Text_Ans_Reserved_Car_4");
    public  final String TEXT_ANSWER_RESERVED_CAR_5 = bundle.getString("Text_Ans_Reserved_Car_5");
    public  final String TEXT_ = "";


    public void textAnswerReservedCar(Driver driver){
        System.out.printf(formatAnswer, TEXT_ANSWER_RESERVED_CAR_0, Dialog.getIdOrders(), TEXT_ANSWER_RESERVED_CAR_1,
                            TEXT_ANSWER_RESERVED_CAR_2, driver.getCar().getCarMark(), TEXT_ANSWER_RESERVED_CAR_3,
                            driver.getCar().getCarNumber(), TEXT_ANSWER_RESERVED_CAR_4, driver.getName(), driver.getSurname(),
                            TEXT_ANSWER_RESERVED_CAR_5, driver.getPhoneNumber());

    }

    public Locale getNeedLocale() {
        return needLocale;
    }

    public void setNeedLocale(Locale needLocale) {
        this.needLocale = needLocale;
    }

    public Locale getRuLocale() {
        return ruLocale;
    }

    public Locale getEnLocale() {
        return enLocale;
    }
}
