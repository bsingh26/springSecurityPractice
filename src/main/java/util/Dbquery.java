package util;
//class with all the queries used in backend operations
public class Dbquery {
    public Dbquery() {
    }

  
 
   //#private static final String postJob = "insert into jobs(title,location,url,description,company,recruiter) values(?,?,?,?,?,?)";
    private static final String insertUser = "INSERT INTO USERS (FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, PASSWORD, ROLE) VALUES (?,?,?,?,?,?)";



	public static String getInsertuser() {
		return insertUser;
	}
 
    
   
}