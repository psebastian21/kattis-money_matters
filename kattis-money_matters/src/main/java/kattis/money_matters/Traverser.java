package kattis.money_matters;

import java.util.Iterator;
import java.util.Map;

public class Traverser {

	private Map<Integer, Friend> allFriends;
	private Integer balance;
	
	public Traverser(Map<Integer, Friend> allFriends) {
		this.allFriends = allFriends;
	}
	
	public void traverse() throws ImpossibleException {
		do {
			Friend friend = allFriends.values().iterator().next();
			balance = 0;
			this.traverse(friend);
			if (balance != 0)
				throw new ImpossibleException();
		}while(!allFriends.isEmpty());
	}

	private void traverse(Friend friend) {
		if(!allFriends.containsKey(friend.getName()))
			return;
		allFriends.remove(friend.getName());
		balance += friend.getBalance();
		Iterator<Friend> innerFriends = friend.getFriendsIterator();
		while(innerFriends.hasNext()) {
			this.traverse(innerFriends.next());
		}
		
	}

}
