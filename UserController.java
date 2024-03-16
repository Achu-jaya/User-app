package org.jsp.userapp.controller;
import java.util.List;
import java.util.Scanner;
import org.jsp.userapp.dao.UserDao;
import org.jsp.userapp.dto.User;
public class UserController {
	static Scanner s = new Scanner(System.in);
	static UserDao dao=new UserDao();
	public static void main(String[] args) {
		System.out.println("1. Save User");
		System.out.println("2. Update user");
		System.out.println("3. Find user by Id");
		System.out.println("4. Verify user by phone and password");
		System.out.println("5. Verify user by Email and Password");
		System.out.println("6. Verify user by Id and password");
		System.out.println("7. Find user by Name");
		System.out.println("8. Find user by Age");
		System.out.println("9. Find user by gender");
		System.out.println("10. Delete user");
		
		switch(s.nextInt())
		{
		case 1: {
			save();
			break;
		}
		case 2: {
			update();
			break;
		}
		case 3:{
			findUserById();
			break;
		}
		case 4: {
			verifyUserByPhone();
			break;
		}
		case 5:
		{
			verifyUserByEmail();
			break;
			}
		case 6:
		{
			verifyUserById();
			break;
		}
		case 7:
		{
			findByName();
			break;
		}
		case 8:
		{
			findByAge();
			break;
		}
		case 9:
		{
			findByGender();
			break;
		}
		case 10:
		{
			delete();
			break;
		}
		case 11:
		{
			findNameByAge();
			break;
		}
		
		default :
		{
			System.out.println("Invalid choice");
		}
		}
	}
	public static void save()
	{
		System.out.println("Enter the name , phone,email,age,gender and password to save user");
		User u=new User();
		u.setName(s.next());
		u.setPhone(s.nextLong());
		u.setEmail(s.next());
		u.setAge(s.nextInt());
		u.setGender(s.next());
		u.setPassword(s.next());
		u=dao.saveUser(u);
		System.out.println("User saved with id:"+u.getId());
	}
	public static void update() {
		System.out.println("Enter user Id to update");
		int id=s.nextInt();
		System.out.println("Enter the name , phone,email,age,gender and password to save user");
		User u=new User();
		u.setName(s.next());
		u.setGender(s.next());
		u.setAge(s.nextInt());
		u.setPhone(s.nextLong());
		u.setEmail(s.next());
		u.setPassword(s.next());
		u=dao.saveUser(u);
		if(u!=null) {
			System.out.println("User updated with id"+u.getId());
		}
		else {
			System.out.println("Can't update user as Entered Id is invalid");
		}
	}
	public static void findUserById()
	
	{
		System.out.println("Enter User Id to Display details");
		int id=s.nextInt();
		User u=dao.findUserById(id);
		if(u!=null) {
			
			System.out.println("Verification successsfuly");
			System.out.println("User Id:"+u.getId());
			System.out.println("User Name: "+u.getName());
			System.out.println("Phone: "+u.getPhone());
			System.out.println("Age:"+u.getAge());
			System.out.println("Email id: "+u.getEmail());
			System.out.println("Gender:"+u.getGender());
			
		}
		else
		{
			System.err.println("Invalid Id");
		}
		
	}
	public static void verifyUserByPhone() {
		System.out.println("Enter the phone number and password to verify");
		long phone=s.nextLong();
		String password=s.next();
		User u=dao.verifyUser(phone, password);
		if(u!=null) {
			System.out.println("Verification successsfuly");
			System.out.println("User Id:"+u.getId());
			System.out.println("User Name: "+u.getName());
			System.out.println("Phone: "+u.getPhone());
			System.out.println("Age:"+u.getAge());
			System.out.println("Email id: "+u.getEmail());
			System.out.println("Gender:"+u.getGender());
			
		}
		else
		{
			System.err.println("Invalid Phone and password");
		}
		
		
	}
	public static void verifyUserByEmail() {
		System.out.println("Enter Email and password to verify Details");
		String email=s.next();
		String pasword=s.next();
		User u=dao.verifyUser(email, pasword);
		if(u!=null) {
			
			System.out.println("Verification successsfuly");
			System.out.println("User Id:"+u.getId());
			System.out.println("User Name: "+u.getName());
			System.out.println("Phone: "+u.getPhone());
			System.out.println("Age:"+u.getAge());
			System.out.println("Email id: "+u.getEmail());
			System.out.println("Gender:"+u.getGender());
			
		}
		else
		{
			System.err.println("Invalid Email and password");
		}
		
	}
	public static void verifyUserById() {
		System.out.println("Eneter Id and Password to verify user");
		int id=s.nextInt();
		String password=s.next();
		User u=dao.verifyUser(id,password);
		if(u!=null) {
			
			System.out.println("Verification successsfuly");
			System.out.println("User Id:"+u.getId());
			System.out.println("User Name: "+u.getName());
			System.out.println("Phone: "+u.getPhone());
			System.out.println("Age:"+u.getAge());
			System.out.println("Email id: "+u.getEmail());
			System.out.println("Gender:"+u.getGender());
			
		}
		else
		{
			System.err.println("Invalid Id or password");
		}
	}
	
	public static void verifyByName() {
		
	}
	public static void verifyByAge() {
		
	}
	public static void findByName() {
		
	}
	public static void findNameByAge() {
		System.out.println("Enter the age to display user names");
		int age=s.nextInt();
		List<String> names=dao.findNameByAge(age);
		if(names.size()>0) {
			for(String name:names)
			System.out.println(name);
		}
		else
		{
			System.out.println("No user with the Age: "+age);
		}
		
	}
	public static void findByAge() {
		
	}
	public static void findByGender() {

}
	public static void delete() {
		System.out.println("Enter user Id to delete");
		int id=s.nextInt();
		boolean deleted=dao.deleteUser(id);
		if(deleted) {
			System.out.println("User deleted");
		}
		else {
			System.err.println("cannot delete user as Id is invalid");
		}
		
	}
	
}
