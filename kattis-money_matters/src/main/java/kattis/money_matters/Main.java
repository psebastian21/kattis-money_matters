package kattis.money_matters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = reader.readLine();
        String[] values = firstLine.split(" ");
        int n = Integer.parseInt(values[0]);
        int m = Integer.parseInt(values[1]);
        Map<Integer, Friend> allFriends = new HashMap<>();
        for(int i = 0; i < n; i++) {
        	Friend friend = new Friend(i, Integer.parseInt(reader.readLine()));
        	allFriends.put(friend.getName(), friend);
        }
        for(int i = 0; i < m; i++) {
        	String[] friendship = reader.readLine().split(" ");
        	allFriends.get(Integer.valueOf(friendship[0])).addFriend(allFriends.get(Integer.valueOf(friendship[1])));
        	allFriends.get(Integer.valueOf(friendship[1])).addFriend(allFriends.get(Integer.valueOf(friendship[0])));
        }
        try {
        	Traverser traverser = new Traverser(allFriends);
        	traverser.traverse();
        	System.out.print("POSSIBLE");
        }catch(ImpossibleException e) {
        	System.out.print("IMPOSSIBLE");
        }
	}

}
