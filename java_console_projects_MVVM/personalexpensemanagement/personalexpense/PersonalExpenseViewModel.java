package com.zsgs.mvvm.personalexpensemanagement.personalexpense;

import com.zsgs.mvvm.personalexpensemanagement.dto.MonthlyExpenses;
import com.zsgs.mvvm.personalexpensemanagement.repository.PersonalExpenseRepository;

import java.time.LocalDate;

public class PersonalExpenseViewModel {
    private PersonalExpensesView personalExpenseView;
    public PersonalExpenseViewModel(PersonalExpensesView personalExpenseView) {
        this.personalExpenseView = personalExpenseView;
    }

    public void storeInitialData(String name,int salary, int fixedExpenses, float expensePercentage) {
        PersonalExpenseRepository.getInstance().storeInitialData(name,salary,fixedExpenses,expensePercentage);
    }

    public void storeDailyExpenses(LocalDate now, float currDayExpense,String reason) {
        boolean isWithinLimit = PersonalExpenseRepository.getInstance().storeDailyExpenses(now,currDayExpense,reason);
        if(!isWithinLimit)
            personalExpenseView.monthlyLimitExceeded();
    }

    public void getThisMonthExpenditures() {
        MonthlyExpenses expense = PersonalExpenseRepository.getInstance().getThisMonthExpenditures();
        personalExpenseView.showMonthlyExpense(expense);
    }

    public MonthlyExpenses getExpenses() {
        return PersonalExpenseRepository.getInstance().getThisMonthExpenditures();
    }
}
