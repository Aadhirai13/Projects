package com.zsgs.mvvm.personalexpensemanagement.personalexpense;

import com.zsgs.mvvm.personalexpensemanagement.dto.MonthlyExpenses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class PersonalExpensesView {
    private Scanner scanner = new Scanner(System.in);
    private PersonalExpenseViewModel personalExpenseViewModel;
    private boolean canContinue = true;
    public PersonalExpensesView(){
        personalExpenseViewModel = new PersonalExpenseViewModel(this);
    }

    static public void main(String[] args){
        PersonalExpensesView personalExpenseView = new PersonalExpensesView();
        personalExpenseView.getInitializeDetails();
    }

    private void getInitializeDetails() {
        System.out.println("Haaaaiiiii");
        System.out.println("Enter your name");
        String name = scanner.next();
        System.out.println("Enter your this month salary");
        int salary = scanner.nextInt();
        System.out.println("Enter your monthly fixed expenses");
        int fixedExpenses = scanner.nextInt();
        System.out.println("Enter maximum expenditure percentage for daily expenses limit");
        float expensePercentage = scanner.nextFloat();
        personalExpenseViewModel.storeInitialData(name,salary,fixedExpenses,expensePercentage);
        getDailyExpenditure();
    }

    private void getDailyExpenditure() {
            if(!canContinue){
                System.out.println("You didn't have sufficient money to spend...");
            }
            else {
                while(canContinue) {
                    System.out.println("1.enter today spendings\t2.show expenditure\t3.end");
                    int choice = scanner.nextInt();
                    switch (choice){
                        case 1:
                        {
                            System.out.println("Enter today spending (amount)");
                            float currDayExpense = scanner.nextFloat();
                            scanner.nextLine();
                            System.out.println("Enter reason");
                            String reason = scanner.nextLine();
                            personalExpenseViewModel.storeDailyExpenses(LocalDate.now(), currDayExpense,reason);
                            break;
                        }
                        case 2:
                        {
                            personalExpenseViewModel.getThisMonthExpenditures();
                            break;
                        }
                        case 3:
                        {
                            //write in file
                            writeInFile();
                            System.exit(0);
                        }
                    }

                }
            }
            writeInFile();
    }

    private void writeInFile() {
        MonthlyExpenses expense = personalExpenseViewModel.getExpenses();
        String path = "D:\\ZSGS\\Personal_Expense\\" + expense.getName();
        System.out.println("File is created in " + path);
        File file = new File(path);
        file.mkdir();
        try{
            path += "\\"+expense.getDate()+".txt";
            File f = new File(path);
            f.createNewFile();
            if(f.exists()){
                FileWriter write = new FileWriter(path);
                write.write("Rs\tReasons" + "\n");
                for(int i = 0;i < expense.getDailyExpenditures().size();i++)
                    write.write(expense.getDailyExpenditures().get(i) + "\t" + expense.getReason().get(i) + "\n");
                write.write("Total daily expenditures - " + expense.getTotalDailyExpenditures() + "\n");
                write.write("Total expenditures  - " + (expense.getFixedExpense()+expense.getTotalDailyExpenditures()) + "\n");
                write.write("Remaining amount for savings - " + (expense.getSalary()-(expense.getFixedExpense()+expense.getTotalDailyExpenditures())) + "\n");
                write.close();
            }
        }
        catch (IOException e){
            System.out.println("Error occured while creating file");
        }
    }

    public void monthlyLimitExceeded() {
        System.out.println("Your monthly expenditure limit will exceed if you spend this much amount of money...So spend less....");
    }
    public void showMonthlyExpense(MonthlyExpenses expense) {
        System.out.println("________________________________________");
        System.out.println("Date - " + expense.getDate());
        System.out.println("Name - " + expense.getName());
        System.out.println("This month salary - " + expense.getSalary());
        System.out.println("Fixed Expenditure - " + expense.getFixedExpense());
        System.out.println("Remaining money in salary after fixed expenditure - " + (expense.getSalary() - expense.getFixedExpense()));
        System.out.println("This month daily expense limit percentage - " + expense.getExpensePercentage());
        System.out.println("Daily expense limit amount - " + ((expense.getSalary() - expense.getFixedExpense()) * (expense.getExpensePercentage()/100)));
        for(int i = 0;i < expense.getDailyExpenditures().size();i++)
            System.out.println("Expense - " + expense.getDailyExpenditures().get(i) + "\tReason - " + expense.getReason().get(i));
        System.out.println("Total daily expenditures - " + expense.getTotalDailyExpenditures());
        System.out.println("Total expenditures  - " + (expense.getFixedExpense()+expense.getTotalDailyExpenditures()));
        System.out.println("Remaining amount for savings - " + (expense.getSalary()-(expense.getFixedExpense()+expense.getTotalDailyExpenditures())));
    }
}
