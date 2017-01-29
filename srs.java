// usage:  1. compile: javac mydemo1.java
//         2. execute: java mydemo1
import java.sql.*; 
import oracle.jdbc.*;
import java.math.*;
import java.io.*;
import java.awt.*;
import oracle.jdbc.pool.OracleDataSource;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.sql.ArrayDescriptor;
import oracle.sql.ARRAY;
import oracle.sql.StructDescriptor;
import oracle.sql.STRUCT;
import oracle.jdbc.OracleTypes;

public class srs {

   public static void main (String args []) throws SQLException {
    try
    {
      int option, choice;
      //Connecting to Oracle server
      OracleDataSource ds = new oracle.jdbc.pool.OracleDataSource();
      ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
      Connection conn = ds.getConnection("jsivaku1", "Qwerty1207");
      System.out.println("\n\nSTUDENT REGISTRATION SYSTEM");
      System.out.println("==============================");
      do
      {
      System.out.println("\n\n1.Display table info");
      System.out.println("2.Classes of a student");
      System.out.println("3.Students of the class");
      System.out.println("4.Enroll a student");
      System.out.println("5.Drop a student from class");
      System.out.println("6.Delete a student");
      System.out.println("7.Show prerequisites");
      System.out.println("8.Exit\n\n");
      System.out.println("Enter the choice: ");
      BufferedReader  ch = new BufferedReader(new InputStreamReader(System.in)); 
      option=Integer.parseInt(ch.readLine());
      switch (option)
      {
      case 1:
            {
            do{
              System.out.println("1.display students");
              System.out.println("2.display courses");
              System.out.println("3.display courses_credit");
              System.out.println("4.display classes");
              System.out.println("5.display enrollments");
              System.out.println("6.display grades");
              System.out.println("7.display prerequsities");
              System.out.println("8.display logs");
              System.out.println("9.Exit");
              System.out.println("Enter the choice: ");
              BufferedReader  ch1 = new BufferedReader(new InputStreamReader(System.in));
              choice=Integer.parseInt(ch1.readLine());
               switch (choice)
               {
                  case 1:
                  {
                  //Prepare to call stored procedure:
                        CallableStatement cs = conn.prepareCall("call show_students(?)");
                        //register the out parameter (the first parameter)
                        cs.registerOutParameter(1, OracleTypes.CURSOR);

                        // execute and retrieve the result set
                        cs.executeUpdate();
                        ResultSet rs = (ResultSet)cs.getObject(1);
                        System .out.println("B#\tFIRSTNAME\tLASTNAME\tSTATUS\tGPA\tEMAIL\tBDATE\tDEPTNAME");
                        // print the results
                        while (rs.next()) {
                            System.out.println(rs.getString(1) + "\t" +
                                rs.getString(2) + "\t\t" + rs.getString(3) +
                                rs.getString(4) +
                                "\t" + rs.getDouble(5) + "\t" +
                                rs.getString(6)+ "\t" + rs.getString(7)+ "\t" + rs.getString(8));
                          }
                    break;
                    }
                      case 2:
                      {
                      //Prepare to call stored procedure:
                              CallableStatement cs = conn.prepareCall("call show_courses(?)");
                              //register the out parameter (the first parameter)
                              cs.registerOutParameter(1, OracleTypes.CURSOR);

                              // execute and retrieve the result set
                              cs.executeUpdate();
                              ResultSet rs = (ResultSet)cs.getObject(1);
                              System.out.println("DEPT_CODE\tCOURSE#\tTITLE");
                              // print the results
                              while (rs.next()) {
                                  System.out.println(rs.getString(1) + "\t" +
                                      rs.getString(2) + "\t" + rs.getString(3));
                              }
                      break;
                      }
                      case 3:
                      {
                      //Prepare to call stored procedure:
                              CallableStatement cs = conn.prepareCall("call show_course_credit(?)");
                              //register the out parameter (the first parameter)
                              cs.registerOutParameter(1, OracleTypes.CURSOR);

                              // execute and retrieve the result set
                              cs.executeUpdate();
                              ResultSet rs = (ResultSet)cs.getObject(1);
                              System.out.println("COURSE#\tCREDITS");
                              // print the results
                              while (rs.next()) {
                                  System.out.println(rs.getString(1) + "\t" +
                                      rs.getString(2));
                              }
                      break;
                      }
                      case 4:
                      {
                      //Prepare to call stored procedure:
                              CallableStatement cs = conn.prepareCall("call show_classes(?)");
                              //register the out parameter (the first parameter)
                              cs.registerOutParameter(1, OracleTypes.CURSOR);

                              // execute and retrieve the result set
                              cs.executeUpdate();
                              ResultSet rs = (ResultSet)cs.getObject(1);
                              System.out.println("CLASSID\tDEPT_CODE\tCOURSE#\tSECT#\tYEAR\tSEMESTER\tLIMIT\tCLASS_SIZE");
                              // print the results
                              while (rs.next()) {
                                  System.out.println(rs.getString(1) + "\t" +
                                      rs.getString(2) + "\t" + rs.getString(3) +
                                      rs.getString(4) +
                                      "\t" + rs.getString(5) + "\t" +
                                      rs.getString(6)+ "\t" + rs.getString(7)+ "\t" + rs.getString(8));
                              }
                      break;
                      }
                      case 5:
                      {
                      //Prepare to call stored procedure:
                              CallableStatement cs = conn.prepareCall("call show_enrollments(?)");
                              //register the out parameter (the first parameter)
                              cs.registerOutParameter(1, OracleTypes.CURSOR);

                              // execute and retrieve the result set
                              cs.executeUpdate();
                              ResultSet rs = (ResultSet)cs.getObject(1);
                              System.out.println("B#\tCLASSID\tLGRADE");
                              // print the results
                              while (rs.next()) {
                              System.out.println(rs.getString(1) + "\t" +
                                  rs.getString(2) + "\t" + rs.getString(3));
                                      }
                    break;
                    }
                    case 6:
                    {
                    //Prepare to call stored procedure:
                            CallableStatement cs = conn.prepareCall("call show_grades(?)");
                            //register the out parameter (the first parameter)
                            cs.registerOutParameter(1, OracleTypes.CURSOR);

                            // execute and retrieve the result set
                            cs.executeUpdate();
                            ResultSet rs = (ResultSet)cs.getObject(1);
                            System.out.println("LGRADE\tNGRADE");
                            // print the results
                            while (rs.next()) {
                                System.out.println(rs.getString(1) + "\t" +
                                    rs.getString(2));
                            }
                    break;
                    }
                    case 7:
                    {
                    //Prepare to call stored procedure:
                            CallableStatement cs = conn.prepareCall("call show_prerequisites(?)");
                            //register the out parameter (the first parameter)
                            cs.registerOutParameter(1, OracleTypes.CURSOR);

                            // execute and retrieve the result set
                            cs.executeUpdate();
                            ResultSet rs = (ResultSet)cs.getObject(1);
                            System.out.println("DEPT_CODE\tCOURSE#\tPRE_DEPT_CODE\tPRE_COURSE#");
                            // print the results
                            while (rs.next()) {
                                System.out.println(rs.getString(1) + "\t" +
                                    rs.getString(2) + "\t" + rs.getString(3) +
                                    rs.getString(4));
                            }
                    break;
                    }
                    case 8:
                    {
                    //Prepare to call stored procedure:
                            CallableStatement cs = conn.prepareCall("call show_logs(?)");
                            //register the out parameter (the first parameter)
                            cs.registerOutParameter(1, OracleTypes.CURSOR);

                            // execute and retrieve the result set
                            cs.executeUpdate();
                            ResultSet rs = (ResultSet)cs.getObject(1);
                            System.out.println("LOGID\t"+"WHO\t"+"TIME\t"+"TABLE_NAME\t\t"+"OPERATION\t"+"KEY_VALUE\t");
                            // print the results
                            while (rs.next()) {
                                System.out.println(rs.getString(1) + "\t" +
                                    rs.getString(2) + "\t" + rs.getString(3) +
                                    rs.getString(4) +
                                    "\t" + rs.getString(5) + "\t" +
                                    rs.getString(6));
                            }
                    break;
                    }
                    case 9: break;
                    default:
                    {
                      System.out.println("Invalid choice");
                      break;
                    }
                  }
            }while(choice != 9); 
            break;
      }
      
      case 2:
      {
              String student;
             BufferedReader  read_input = new BufferedReader(new InputStreamReader(System.in));
             System.out.println("Enter Student B# to check classes:");
              student = read_input.readLine();
              CallableStatement cs = conn.prepareCall("call disp_class(?,?,?)");
                        //register the out parameter (the first parameter)
                        cs.setString(1,student);
                        
                        cs.registerOutParameter(2, OracleTypes.CURSOR);
                        cs.registerOutParameter(3, OracleTypes.INTEGER);
                        // execute and retrieve the result set
                        cs.executeUpdate();
                        int output = cs.getInt(3);
                        if(output == 1)
                            System.out.println("The B# is invalid");
                        else if(output == 2)
                            System.out.println("The student has not taken any course");
                        ResultSet rs = (ResultSet)cs.getObject(2);
                        
                        
                        // print the results
                        while (rs.next()) {
                            System.out.println(rs.getString(1) + "\t" +
                                rs.getString(2) + "\t\t" + rs.getString(3) +
                                rs.getString(4) +
                                "\t" + rs.getDouble(5) + "\t" +
                                rs.getString(6)+ "\t" + rs.getString(7)+ "\t" + rs.getString(8));
                        }
                        break;
        }
      
      case 3:
        {
              String classid;
             BufferedReader  read_input = new BufferedReader(new InputStreamReader(System.in));
             System.out.println("Enter ClassID to check students Enrollment:");
              classid = read_input.readLine();
              CallableStatement cs = conn.prepareCall("call disp_stud(?,?,?)");
                        //register the out parameter (the first parameter)
                        cs.setString(1,classid);
                        cs.registerOutParameter(2, OracleTypes.CURSOR);
                        cs.registerOutParameter(3, OracleTypes.INTEGER);

                        // execute and retrieve the result set
                        cs.executeUpdate();
                        int output = cs.getInt(3);
                        if(output == 1)
                            System.out.println("The class ID is invalid");
                        else if(output == 2)
                            System.out.println("No Student has enrolled in the class");
                        ResultSet rs = (ResultSet)cs.getObject(2);
                        
                        
                        // print the results
                        while (rs.next()) {
                            System.out.println(rs.getString(1) + "\t" +
                                rs.getString(2) + "\t" + rs.getString(3) + "\t" +
                                rs.getString(4));
                        }
                
                        break;
          }
          case 4:
          {
            String classid, student;
            BufferedReader  read_input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Student B#:");
            student = read_input.readLine();
            System.out.println("Enter ClassID:");
            classid = read_input.readLine();

            CallableStatement cs = conn.prepareCall("call enroll_stu(?,?,?)");
                        //register the out parameter (the first parameter)
                        cs.setString(1,student);
                        cs.setString(2,classid);
                        cs.registerOutParameter(3, OracleTypes.INTEGER);
                        // execute and retrieve the result set
                        cs.executeUpdate();
                        //ResultSet rs = (ResultSet)cs.getObject(2);
                        int output = cs.getInt(3);
                        if(output == 1)
                            System.out.println("The B# is invalid");
                        else if(output == 2)
                            System.out.println("The classID is invalid");
                        else if(output == 3)
                            System.out.println("The class is full");
                        else if(output == 4)
                            System.out.println("The student is already in the class");
                        else if(output == 5)
                            System.out.println("You are overloaded");        
                        else if(output == 6)
                            System.out.println("The student cannot be enrolled in more than 4 courses");
                        else if(output == 7)
                            System.out.println("Prerequisite not satisfied");                         
                        else
                            System.out.println("Insertion successful");
            break;

          }
          case 5:
          {
            String classid, student; 
            
            BufferedReader  read_input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Student B#:");
            student = read_input.readLine();

            System.out.println("Enter ClassID:");
            classid = read_input.readLine();

            CallableStatement cs = conn.prepareCall("call drop_stu_class(?,?,?)");
                        //register the out parameter (the first parameter)
                        cs.setString(1,student);
                        cs.setString(2, classid);
                        cs.registerOutParameter(3, OracleTypes.INTEGER);

                        // execute and retrieve the result set
                        cs.executeUpdate();
                        int output = cs.getInt(3);
                        if(output == 1)
                            System.out.println("The B# is invalid");
                        else if(output == 2)
                            System.out.println("The classID is invalid");
                        else if(output == 3)
                            System.out.println("The student is not enrolled in the class");
                        else if(output == 4)
                            System.out.println("The drop is not permiitted because another class uses it as a prerequisite");
                        else if(output == 51){
                            System.out.println("The deletion was successful");
                            System.out.println("This student is now not enrolled in any classes");
                          }
                        else {
                            System.out.println("The deletion was successful");
                            System.out.println("The class now has no students");
                          }



                            

            break;
          }
          case 6:
          {
            String student; 
            BufferedReader  read_input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Student B#:");
            student = read_input.readLine();
            CallableStatement cs = conn.prepareCall("call drop_all_stu(?,?)");
                        //register the out parameter (the first parameter)
                        cs.setString(1,student);
                       
                        cs.registerOutParameter(2, OracleTypes.INTEGER);

                        // execute and retrieve the result set
                        cs.executeUpdate();
                        int output = cs.getInt(2);
                        if(output == 1)
                            System.out.println("The B# is invalid");
                        else 
                            System.out.println("Deletion successful for the student from all the tables");
                        
            break;
          }
          case 7:
          {
            String dept_code;
            int course_num; 
            BufferedReader  read_input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Department Code:");
            dept_code = read_input.readLine();
            System.out.println("Enter course#:");
            course_num = Integer.parseInt(read_input.readLine());
            CallableStatement cs = conn.prepareCall("call return_courses(?,?,?)");
                        //register the out parameter (the first parameter)
                        cs.setString(1,dept_code);
                       cs.setInt(2,course_num);
                        cs.registerOutParameter(3, OracleTypes.ARRAY,"PREARRAY");

                        // execute and retrieve the result set
                        cs.executeUpdate();
                        Array output = cs.getArray(3); 
                        String [] outCourses = (String [])(output.getArray());
                        System.out.println("\nThese courses have this as Prerequisites");
                        for(int i=0; i<=outCourses.length; i++) {
                             System.out.println(outCourses[i]);   
                      }
                        
            break;
          }
          case 8: break;
      default:
      {
        System.out.println("Invalid option");
        return;
      }
    }
  }while(option != 8);
}



     catch (SQLException ex) { System.out.println (ex.getMessage());}
     catch (Exception e) {System.out.println (e.getMessage());}
  }
} 

