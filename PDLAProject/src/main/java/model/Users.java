package model;

public class Users {

    protected String id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;

    public Users(String id,String firstName,String lastName,String email,String password){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
    }
    public String getId(){
        return id;
    }
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
}
