package org.example;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddies;

    public AddressBook() {
        this.buddies = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addBuddy(BuddyInfo buddy) {
        buddies.add(buddy);
    }

    public boolean removeBuddy(BuddyInfo buddy) {
        return buddies.remove(buddy);
    }

    public BuddyInfo getBuddy(int index) {
        return buddies.get(index);
    }

    public BuddyInfo findByName(String name) {
        for (BuddyInfo b : buddies) {
            if (b.getName().equals(name)) {
                return b;
            }
        }
        return null;
    }

    public int size() {
        return buddies.size();
    }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AddressBook:\n");
        for (BuddyInfo b : buddies) {
            sb.append("  ").append(b.toString()).append("\n");
        }
        return sb.toString();
    }
}