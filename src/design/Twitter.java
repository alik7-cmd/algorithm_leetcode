package design;

import java.util.*;


public class Twitter {

    private List<Tweet> list;
    private Map<Integer, Set<Integer>> mapWithFollower;

    public Twitter() {
        mapWithFollower = new HashMap<>();
        list = new ArrayList<>();

    }

    public void postTweet(int userId, int tweetId) {
        list.add(new Tweet(userId, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {

        Set<Integer> listOfFollower = mapWithFollower.get(userId);
        List<Integer> ll = new ArrayList<>();

        if(listOfFollower != null && !listOfFollower.isEmpty()){
            int tg = 10;
            for(int i = list.size()-1; i>= 0; i--){
                if(tg == 0){
                    break;
                }
                Tweet tweet = list.get(i);
                if(listOfFollower.contains(tweet.getOwnerId())){
                    ll.add(tweet.getId());
                }
                tg--;
            }
        }
        return ll;

    }

    public void follow(int followerId, int followeeId) {

        mapWithFollower.putIfAbsent(followerId, new HashSet<>());
        mapWithFollower.get(followerId).add(followeeId);

        /*if(mapWithFollower.containsKey(followerId)){
            List<Integer> list = mapWithFollower.getOrDefault(followerId, new ArrayList<>());
            list.add(followeeId);
            mapWithFollower.put(followerId, list);

        }else {
            List<Integer> list = new ArrayList<>();
            list.add(followeeId);
            mapWithFollower.put(followerId, list);
        }*/

    }

    public void unfollow(int followerId, int followeeId) {

        if(mapWithFollower.containsKey(followerId)) {
            mapWithFollower.get(followerId).remove(followeeId);
        }
        /*if(mapWithFollower.containsKey(followerId)){
            List<Integer> list = mapWithFollower.getOrDefault(followerId, new ArrayList<>());
            if(list != null){
                list.remove(followeeId);
            }

            mapWithFollower.put(followerId, list);

        }*/
    }


    class Tweet{

        private int id;
        private int ownerId;

        public Tweet(int id, int ownerId) {
            this.id = id;
            this.ownerId = ownerId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(int ownerId) {
            this.ownerId = ownerId;
        }
    }
}
