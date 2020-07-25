package kattis.money_matters;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Friend {
	private int name;
	private int balance;
	private List<Friend> friends;
	
	public Friend(int name, int balance) {
		this.name = name;
		this.balance = balance;
		this.friends = new LinkedList<>();
	}

	public int getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}
	
	public void addFriend(Friend friend) {
		this.friends.add(friend);
	}
	
	public Iterator<Friend> getFriendsIterator(){
		return this.friends.iterator();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + balance;
		result = prime * result + name;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Friend other = (Friend) obj;
		if (balance != other.balance)
			return false;
		if (name != other.name)
			return false;
		return true;
	}

}
