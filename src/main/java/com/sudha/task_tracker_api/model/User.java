package com.sudha.task_tracker_api.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")

public class User {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role = "USER";

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();

    //Constructor
    public User() {}

    public User(String name, String email, String password, String role){
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
//getter and Setter
public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getEmail(){
    return email;
}
public void setEmail(String email){
    this.email = email;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public String getRole() {
    return role;
}
public void setRole(String role) {
    this.role = role;
}
//helper methods to manage the relationship
public void addTask(Task task) {
    tasks.add(task);
    task.setUser(this);

}
public void removeTask(Task task){
    tasks.remove(task);
    task.setUser(null);
}


}
