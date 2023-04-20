package com.zsgs.personalexpensemanagement.personalexpense;

import com.zsgs.personalexpensemanagement.dto.MonthlyExpense;

public interface PersonalExpenseControllerViewCallBack {
    void monthlyLimitExceeded();

    void showMonthlyExpense(MonthlyExpense expense);
}
