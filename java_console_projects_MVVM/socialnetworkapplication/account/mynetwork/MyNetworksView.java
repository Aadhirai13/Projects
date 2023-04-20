package com.zsgs.mvvm.socialnetworkapplication.account.mynetwork;

import java.util.ArrayList;
import java.util.Scanner;

public class MyNetworksView {
    private Scanner scanner = new Scanner(System.in);
    private MyNetworkViewModel myNetworkViewModel;

    public MyNetworksView(){
        myNetworkViewModel = new MyNetworkViewModel(this);
    }
    public void viewMyNetworkPage(String user){
        int choice = 0;
        boolean flag;
        do {
            try {
                System.out.println("1. Friends \n2. Request Sent \n3. Members List");
                choice = scanner.nextInt();
                if(choice < 1 || choice > 3)
                    throw new Exception("");
                flag = false;
            } catch (Exception e) {
                System.out.println("Enter only integer value between 1 to 3..");
                scanner.next();
                flag = true;
            }
        }while (flag);

        switch (choice){
            case 1:
            {
                viewMyFriends(user);
                break;
            }
            case 2:
            {
                viewRequestSent(user);
                break;
            }
            case 3:
            {
                getMembers(user);
                break;
            }
        }
    }

    private void getMembers(String user) {
        myNetworkViewModel.getMembers(user);
    }

    public void viewMyFriends(String user) {
        myNetworkViewModel.viewMyNetwork(user);
    }

    public void viewRequestSent(String user) {
        myNetworkViewModel.getRequestSent(user);
    }

    public void showMyNetwork(String myNetwork) {
        System.out.println(myNetwork);
    }

    public void viewRequestsSent(ArrayList<String> friendRequestSentNotifications) {
        if(friendRequestSentNotifications.size()==0)
            System.out.println("No requests sent");
        else{
            for(String friends : friendRequestSentNotifications)
                System.out.println(friends);
        }
    }

    public void noRequestsSent() {
        System.out.println("You didn't gave any request yet ... ");
    }

    public void viewMembers(String user,ArrayList<String> members) {
        for (String member : members) {
            System.out.println(member);
            System.out.println("Enter 1 to Give Request \nEnter anything to view next member");
            int choice = scanner.nextInt();
            if(choice == 1){
                myNetworkViewModel.giveFriendRequest(user,member);
                System.out.println("Requested !!");
            }
            else{
                return;
            }
        }
    }
}
