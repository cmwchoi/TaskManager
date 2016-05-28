package models;

/**
 * Created by Christian on 5/27/16.
 */
public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private Task tasks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Task getTasks() {
        return tasks;
    }

    public void setTasks(Task tasks) {
        this.tasks = tasks;
    }

}
