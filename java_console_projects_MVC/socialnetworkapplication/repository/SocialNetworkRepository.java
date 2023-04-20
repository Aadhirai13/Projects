package com.zsgs.socialnetworkapplication.repository;

import com.zsgs.socialnetworkapplication.dto.FriendRequest;
import com.zsgs.socialnetworkapplication.dto.Posts;
import com.zsgs.socialnetworkapplication.dto.Profile;
import com.zsgs.socialnetworkapplication.dto.UserCredentials;

import java.util.ArrayList;

public class SocialNetworkRepository {
    String user = "";
    public static SocialNetworkRepository socialNetworkDbInstance;
    private ArrayList<UserCredentials> userCredential = new ArrayList<>();
    private ArrayList<Profile> userProfile = new ArrayList<>();
    private ArrayList<Posts> posts = new ArrayList<>();
    private ArrayList<FriendRequest> friendRequests = new ArrayList<>();
    private SocialNetworkRepository() {}
    public static SocialNetworkRepository getInstance() {
        if (socialNetworkDbInstance == null) {
            socialNetworkDbInstance = new SocialNetworkRepository();
        }
        return socialNetworkDbInstance;
    }
    public boolean createAccount(String userName, String password) {
        for (UserCredentials userCredential : userCredential) {
            if (userCredential.getUserName().equals(userName)) {
                return false;
            }
        }
        userCredential.add(new UserCredentials(userName,password));
        userProfile.add(new Profile(userName,0,0,null));
        String[] friendList = new String[userProfile.size() - 1];
        Boolean[] isFriend = new Boolean[userProfile.size() - 1];
        Boolean[] isRequestSent = new Boolean[userProfile.size() - 1];
        int i = 0;
        for(Profile profiles : userProfile){
            if(!profiles.getUserName().equals(userName)){
                friendList[i] = profiles.getUserName();
                isFriend[i] = false;
                isRequestSent[i] = false;
                i++;
            }
        }
        friendRequests.add(new FriendRequest(userName, friendList, isFriend, isRequestSent));
        addToOthersFriendsList(userName);

        return true;
    }

    public void addToOthersFriendsList(String userName){
        String[] friendList = new String[1];
        Boolean[] isFriend = new Boolean[1];
        Boolean[] isRequestSent = new Boolean[1];

        for(Profile profiles : userProfile){
            if(!profiles.getUserName().equals(userName)){
                friendList[0] = userName;
                isFriend[0] = false;
                isRequestSent[0] = false;
                friendRequests.add(new FriendRequest(profiles.getUserName(), friendList, isFriend, isRequestSent));
            }
        }
        System.out.println("members list");
        for(FriendRequest friendRequest : friendRequests){
//            if (friendRequest.getUserName().equals(userName)) {
                for(String f : friendRequest.getFriendList()){
                    System.out.println(friendRequest.getUserName() + " - " + f);
//                }
            }
        }
    }

    public String login(String userName, String password) {
        for (UserCredentials userCredential : userCredential) {
            if (!userCredential.getUserName().equals(userName) || !userCredential.getPassword().equals(password)) {
                return userName;
            }
        }
        user = userName;
        return userName;
    }

    public String getUserName(){
        return user;
    }

    public String getProfilePageInfo(String user) {
        String profileInfo = "";
        int postCount = 0;
        for(Posts post : posts){
            if(post.getUser().equals(user)){
                postCount++;
            }
        }
        int friendsCount = 0;
        for(FriendRequest friendRequest : friendRequests){
            if(friendRequest.getUserName().equals(user)){
                for(int i=0;i<friendRequest.getFriendList().size();i++){
                    if(friendRequest.isFriend().get(i) == true){
                        friendsCount++;
                    }
                }
            }
        }
        String bio = "";
        for(Profile profile : userProfile){
            if(profile.getUserName().equals(user)){
                bio = profile.getBio();
            }
        }
        profileInfo = "Name - " + user + "\nFriends - " + friendsCount + "\nPosts - " + postCount + "\nBio - " + bio;
        return profileInfo;
    }

    public String createPost(String userName , int postID, String content, String[] hashTags) {
        String postAttributes = "";
        posts.add(new Posts(userName,postID,content,hashTags,0,new ArrayList<>()));
        for(Posts posts : posts){
            if(posts.getPostID() == postID){
                postAttributes = "Likes - " + posts.getLikeCount() + "\n Comments - " + posts.getComments().size() ;
            }
        }
        return postAttributes;
    }

    public ArrayList<String> getNotifications(String user) {
        ArrayList<String> friendRequestNotifications = new ArrayList<>();

        for(FriendRequest friendRequest : friendRequests){
            if(!friendRequest.getUserName().equals(user)){
                for(int i=0;i<friendRequest.getFriendList().size();i++){
                    if(friendRequest.getFriendList().get(i).equals(user) && friendRequest.isFriend().get(i) == false && friendRequest.isRequestSent().get(i) == true){
                        friendRequestNotifications.add(friendRequest.getUserName());
                    }
                }
            }
        }
        return friendRequestNotifications;
    }

    public void acceptRequest(String user, String friend) {
        for(FriendRequest friendRequest : friendRequests){
            if(friendRequest.getUserName().equals(user)){
                int index = friendRequest.getFriendList().indexOf(friend);
                if(index == -1)
                    continue;
                friendRequest.getFriendList().remove(index);
                friendRequest.getFriendList().add(friend);
                friendRequest.isFriend().add(true);
                friendRequest.isRequestSent().add(false);
            }
        }
        for(FriendRequest friendRequest : friendRequests){
            if(friendRequest.getUserName().equals(friend)){
                int index = friendRequest.getFriendList().indexOf(user);
                if(index == -1)
                    continue;
                friendRequest.getFriendList().remove(index);
                friendRequest.getFriendList().add(friend);
                friendRequest.isFriend().add(true);
            }
        }
    }

    public void rejectRequest(String user, String friend) {
        for(FriendRequest friendRequest : friendRequests){
            if(friendRequest.getUserName().equals(user)){
                int index = friendRequest.getFriendList().indexOf(friend);
                friendRequest.isFriend().remove(index);
                friendRequest.getFriendList().remove(index);
            }
            if(friendRequest.getUserName().equals(friend)){
                int index = friendRequest.getFriendList().indexOf(user);
                friendRequest.isFriend().remove(index);
                friendRequest.getFriendList().remove(index);
            }
        }
    }

    public String getNetwork(String user) {
        String friendsNetwork = "";
        for(FriendRequest friendRequest : friendRequests){
            if(friendRequest.getUserName().equals(user)){
                for(int i=0;i<friendRequest.getFriendList().size();i++){
                    if(!friendRequest.getFriendList().get(i).equals(user))
                        friendsNetwork += friendRequest.getFriendList().get(i) + "\n";
                }
            }
        }
        return friendsNetwork;
    }

    public ArrayList<String> getRequestSent(String user) {
        ArrayList<String> friendRequestSent = new ArrayList<>();
        for(FriendRequest friendRequest : friendRequests){
            if(friendRequest.getUserName().equals(user)){
                for(int i=0;i<friendRequest.getFriendList().size();i++){
                    if(friendRequest.isFriend().get(i) == false && friendRequest.isRequestSent().get(i) == true){
                        friendRequestSent.add(friendRequest.getFriendList().get(i));
                    }
                }
            }
        }
        return friendRequestSent;
    }

    public ArrayList<String> getFriendsPost(String user) {
        ArrayList<String> allPosts = new ArrayList<>();
        for(Posts post : posts){
            if(!post.getUser().equals(user)){
                String hashtag = "";
                for(int i=0;i<post.getHashTags().length;i++){
                    hashtag += " #" + post.getHashTags()[i];
                }
                String singlePost = "Content - " + post.getContent() + "\nHashtags - " + hashtag;
                allPosts.add(singlePost);
            }
        }
        return allPosts;
    }

    public void addComment(String comment) {

    }

    public void addLikes() {

    }

    public ArrayList<String> getMembers(String user) {
        ArrayList<String> members = new ArrayList<>();
        for(FriendRequest friendRequest : friendRequests){
            if(!friendRequest.getUserName().equals(user)){
                members.add(friendRequest.getUserName());
            }
        }
        return members;
    }

    public void giveFriendRequest(String user, String member) {
        for(FriendRequest friendRequest : friendRequests){
            if(friendRequest.getUserName().equals(user)) {
                for (String friends : friendRequest.getFriendList()) {
                    if (friends.equals(member)) {
                        int index = friendRequest.getFriendList().indexOf(member);
                        friendRequest.isRequestSent().set(index, true);
                    }
                }
            }
        }
    }

    public void setBio(String user , String bio) {
        for (Profile profile : userProfile){
            if(profile.getUserName().equals(user)){
                profile.setBio(bio);
            }
        }
    }
}
