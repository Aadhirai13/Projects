package com.zsgs.personalexpensemanagement.personalexpense;

import com.zsgs.personalexpensemanagement.dto.MonthlyExpense;

import java.time.LocalDate;

public interface PersonalExpenseControllerModelCallBack {
    void storeInitialData(String name, int salary, int fixedExpenses, float expensePercentage);

    void storeDailyExpenses(LocalDate now, float currDayExpense, String reason);

    void getThisMonthExpenditures();

    MonthlyExpense getExpenses();
}
