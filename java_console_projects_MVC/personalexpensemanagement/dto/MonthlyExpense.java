package com.zsgs.personalexpensemanagement.dto;

import java.time.LocalDate;
import java.util.ArrayList;

public class MonthlyExpense {
    String name;
    int salary;
    int fixedExpense;
    float expensePercentage;
    ArrayList<Float> dailyExpenditures;
    ArrayList<String> reason;
    float totalDailyExpenditures;
    LocalDate date;

    public MonthlyExpense(String name,int salary, int fixedExpense, float expensePercentage, ArrayList<Float> dailyExpenditures, ArrayList<String> reasons, float totalDailyExpenditures) {
        setName(name);
        setSalary(salary);
        setFixedExpense(fixedExpense);
        setExpensePercentage(expensePercentage);
        setDailyExpenditures(dailyExpenditures);
        setReason(reasons);
        setTotalDailyExpenditures(totalDailyExpenditures);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getFixedExpense() {
        return fixedExpense;
    }

    public void setFixedExpense(int fixedExpense) {
        this.fixedExpense = fixedExpense;
    }

    public float getExpensePercentage() {
        return expensePercentage;
    }

    public void setExpensePercentage(float expensePercentage) {
        this.expensePercentage = expensePercentage;
    }

    public ArrayList<Float> getDailyExpenditures() {
        return dailyExpenditures;
    }

    public void setDailyExpenditures(ArrayList<Float> dailyExpenditures) {
        this.dailyExpenditures = dailyExpenditures;
    }

    public ArrayList<String> getReason() {
        return reason;
    }

    public void setReason(ArrayList<String> reason) {
        this.reason = reason;
    }

    public float getTotalDailyExpenditures() {
        return totalDailyExpenditures;
    }

    public void setTotalDailyExpenditures(float totalDailyExpenditures) {
        this.totalDailyExpenditures = totalDailyExpenditures;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
