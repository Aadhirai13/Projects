package com.zsgs.personalexpensemanagement.repository;

import com.zsgs.personalexpensemanagement.dto.MonthlyExpense;

import java.time.LocalDate;
import java.util.ArrayList;

public class PersonalExpenseRepository {
    public static PersonalExpenseRepository personalExpenseRepository;
    private MonthlyExpense monthlyExpense;
    private PersonalExpenseRepository(){}

    public static PersonalExpenseRepository getInstance(){
        if(personalExpenseRepository == null){
            personalExpenseRepository = new PersonalExpenseRepository();
        }
        return personalExpenseRepository;
    }

    public void storeInitialData(String name,int salary, int fixedExpenses, float expensePercentage) {
        monthlyExpense = new MonthlyExpense(name,salary,fixedExpenses,expensePercentage,new ArrayList<>(),new ArrayList<>(),0);
    }

    public boolean storeDailyExpenses(LocalDate now, float currDayExpense,String reason) {
        if((monthlyExpense.getTotalDailyExpenditures() + currDayExpense) > (monthlyExpense.getSalary()-monthlyExpense.getFixedExpense())*(monthlyExpense.getExpensePercentage()/100))
            return false;
        ArrayList<Float> exp = monthlyExpense.getDailyExpenditures();
        exp.add(currDayExpense);
        ArrayList<String> reasons = monthlyExpense.getReason();
        reasons.add(reason);
        monthlyExpense.setDailyExpenditures(exp);
        monthlyExpense.setTotalDailyExpenditures(monthlyExpense.getTotalDailyExpenditures() + currDayExpense);
        monthlyExpense.setDate(now);
        return true;
    }

    public MonthlyExpense getThisMonthExpenditures() {
        return monthlyExpense;
    }

}
