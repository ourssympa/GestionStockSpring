package com.example.gerstock.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
    private LocalDate date1;
    private LocalDate date2;

    public  Date(String date1,String date2){
       this.date2 = LocalDate.parse(date2);
       this.date1 = LocalDate.parse(date1);

    }
    public LocalDate getDate1(){
        return this.date1;
    }
  public   LocalDate getDate2(){
        return this.date2;
    }
}
