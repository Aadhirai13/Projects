package com.zsgs.personalexpensemanagement.personalexpense;

import com.zsgs.personalexpensemanagement.dto.MonthlyExpense;

public interface PersonalExpenseModelControllerCallBack {
    void monthlyLimitExceeded();

    void showMonthlyExpense(MonthlyExpense expense);
}
