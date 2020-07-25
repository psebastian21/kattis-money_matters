package kattis.money_matters;

import java.util.HashSet;
import java.util.Set;

public class Friend {
	private String name;
	private int balance;
	private Set<Friend> friends;
	
	public Friend(String name, int balance) {
		this.name = name;
		this.balance = balance;
		this.friends = new HashSet<>();
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}
	
	public void addFriend(Friend friend) {
		this.friends.add(friend);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + balance;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
