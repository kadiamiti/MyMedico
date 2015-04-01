import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Recommendation {
	 public static String jdbc_url="jdbc:mysql://meddbinstance.cozrev6gggap.us-west-1.rds.amazonaws.com/sharanyadb";
	  public static String jdbc_username="CMPE295B"; 
	  public static  String jdbc_password="rememberme";
	  public static String jdbc_driver="com.mysql.jdbc.Driver"; 
	
	public static void main(String args[]) throws Exception	{
		 Class.forName(jdbc_driver);
		 Connection con=DriverManager.getConnection(jdbc_url, jdbc_username,jdbc_password);
		 Statement stmt = null;
		 stmt = con.createStatement();
		 Statement stmt1 = null;
		 stmt1 = con.createStatement();
		 Scanner scan = new Scanner(System.in);
		 int j = scan.nextInt();
		 int min =Integer.MAX_VALUE;
   	  	 int id = Integer.MAX_VALUE;
		  ResultSet rs = stmt.executeQuery("select BMI,Age,Eating_Habits,Sleeping_Habits,Activity_Level,Smoking_Habits,Drinking_Habits,Caffeine_Intake,BP_Level,Cholestrol_Level,Sugar_Level,Haemoglobin_Content,Family_Hypertension,Family_Obesity,Family_Diabetes from recommender_data where id = "+j);
    	  rs.next();
    	  rs.getInt("BMI");
    	  for(int i=0;i<4;i++)	{
    		  ResultSet rs1 = stmt1.executeQuery("select BMI,Age,Eating_Habits,Sleeping_Habits,Activity_Level,Smoking_Habits,Drinking_Habits,Caffeine_Intake,BP_Level,Cholestrol_Level,Sugar_Level,Haemoglobin_Content,Family_Hypertension,Family_Obesity,Family_Diabetes from centroids where id = "+i);
        	  rs1.next();
        	  rs1.getInt("BMI");
        	  int mean = Math.abs((rs.getInt("BMI")-rs1.getInt("BMI"))+(rs.getInt("Age")-rs1.getInt("Age"))+(rs.getInt("Eating_Habits")-rs1.getInt("Eating_Habits"))+(rs.getInt("Sleeping_Habits")-rs1.getInt("Sleeping_Habits"))+(rs.getInt("Activity_Level")-rs1.getInt("Activity_Level"))+(rs.getInt("Smoking_Habits")-rs1.getInt("Smoking_Habits"))+(rs.getInt("Drinking_Habits")-rs1.getInt("Drinking_Habits"))+(rs.getInt("Caffeine_Intake")-rs1.getInt("Caffeine_Intake"))+(rs.getInt("BP_Level")-rs1.getInt("BP_Level"))+(rs.getInt("Cholestrol_Level")-rs1.getInt("Cholestrol_Level"))+(rs.getInt("Sugar_Level")-rs1.getInt("Sugar_Level"))+(rs.getInt("Haemoglobin_Content")-rs1.getInt("Haemoglobin_Content"))+(rs.getInt("Family_Hypertension")-rs1.getInt("Family_Hypertension"))+(rs.getInt("Family_Obesity")-rs1.getInt("Family_Obesity"))+(rs.getInt("Family_Diabetes")-rs1.getInt("Family_Diabetes")));
        	  if(min>mean)	{
        		  min = mean;
        		  id = i;
        	  }
    	  }
    	  id++;
    	  ResultSet rs2 = stmt.executeQuery("select recommend from recommendation where id = "+id);
    	  rs2.next();
    	  System.out.println(rs2.getString("recommend"));
	}
}
