package com.zsgs.personalexpensemanagement.personalexpense;

import com.zsgs.personalexpensemanagement.dto.MonthlyExpense;

import java.time.LocalDate;

public class PersonalExpenseController implements PersonalExpenseViewControllerCallBack , PersonalExpenseModelControllerCallBack{
    private PersonalExpenseControllerViewCallBack personalExpenseView;
    private PersonalExpenseControllerModelCallBack personalExpenseModel;
    public PersonalExpenseController(PersonalExpenseView personalExpenseView) {
        this.personalExpenseView = personalExpenseView;
        personalExpenseModel = new PersonalExpenseModel(this);
    }

    public void storeInitialData(String name,int salary, int fixedExpenses, float expensePercentage) {
        personalExpenseModel.storeInitialData(name,salary,fixedExpenses,expensePercentage);
    }

    public void storeDailyExpenses(LocalDate now, float currDayExpense, String reason) {
        personalExpenseModel.storeDailyExpenses(now,currDayExpense,reason);
    }

    public void monthlyLimitExceeded() {
        personalExpenseView.monthlyLimitExceeded();
    }

    public void getThisMonthExpenditures() {
        personalExpenseModel.getThisMonthExpenditures();
    }


    public void showMonthlyExpense(MonthlyExpense expense) {
        personalExpenseView.showMonthlyExpense(expense);
    }

    public MonthlyExpense getExpenses() {
        return personalExpenseModel.getExpenses();
    }
}
