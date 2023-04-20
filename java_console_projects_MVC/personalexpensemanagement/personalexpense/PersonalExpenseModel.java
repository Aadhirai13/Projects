package com.zsgs.personalexpensemanagement.personalexpense;

import com.zsgs.personalexpensemanagement.dto.MonthlyExpense;
import com.zsgs.personalexpensemanagement.repository.PersonalExpenseRepository;

import java.time.LocalDate;

public class PersonalExpenseModel implements PersonalExpenseControllerModelCallBack {
    private PersonalExpenseModelControllerCallBack personalExpenseController;
    public PersonalExpenseModel(PersonalExpenseController personalExpenseController) {
        this.personalExpenseController = personalExpenseController;
    }

    public void storeInitialData(String name,int salary, int fixedExpenses, float expensePercentage) {
        PersonalExpenseRepository.getInstance().storeInitialData(name,salary,fixedExpenses,expensePercentage);
    }

    public void storeDailyExpenses(LocalDate now, float currDayExpense,String reason) {
        boolean isWithinLimit = PersonalExpenseRepository.getInstance().storeDailyExpenses(now,currDayExpense,reason);
        if(!isWithinLimit)
            personalExpenseController.monthlyLimitExceeded();
    }

    public void getThisMonthExpenditures() {
        MonthlyExpense expense = PersonalExpenseRepository.getInstance().getThisMonthExpenditures();
        personalExpenseController.showMonthlyExpense(expense);
    }

    public MonthlyExpense getExpenses() {
        return PersonalExpenseRepository.getInstance().getThisMonthExpenditures();
    }
}
