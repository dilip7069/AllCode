
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author VinayKumar
 */
public class FutureINC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        FutureINC fur = new FutureINC();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n WELCOME TO FUTURE INCORPORATION \n");
            System.out.println("\n ------------------------------- \n");
            System.out.println("1. Insertion of a new Employee \n");
            System.out.println("2. Inertion of a new Product associated with the person who made,repaired or checked the product \n");
            System.out.println("3. Insertion of a new Customer associated with products \n");
            System.out.println("4. Insertion of a new account associated with products \n");
            System.out.println("5. Insertion of a new Complaint associated with Customer and Product \n");
            System.out.println("6. Insertion of a new Accident associated with Employee and Product \n");
            System.out.println("7. Retrieving the date produced and the time spent to produce a particular product \n");
            System.out.println("8. Retrieving all products made by a particular worker \n");
            System.out.println("9. Retrieving the total number of errors made by a particular quality controller \n");
            System.out.println("10. Retrieving the total costs of the products in the product3 category,repaired at the request of a particular Quality controller \n");
            System.out.println("11. Retrieving all customers who purchased all products of a particular color \n");
            System.out.println("12. Retrieving the total number of work days lost due to accidents in repairing the products which got complaints \n");
            System.out.println("13. Retrieving all customers who are also workers \n");
            System.out.println("14. Retrieving all customers who have purchased the products made or certified or repaired by themselves \n");
            System.out.println("15. Retrieving the average cost of all products made in a particular year \n");
            System.out.println("16. Switch the position between a Technical Staff and a Quality controller \n");
            System.out.println("17. Deletion of accidents whose dates are in some range \n");
            System.out.println("18. IMPORT STATEMENT \n");
            System.out.println("19. EXPORT STATEMENT \n ");
            System.out.println("20. QUIT \n");
            System.out.println("-----Please Select any of the following options-----");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    fur.Query1();
                    break;
                case 2:
                    fur.Query2();
                    break;
                case 3: 
                    fur.Query3();
                    break;
                case 4:
                    fur.Query4();
                    break;
                case 5:
                    fur.Query5();;
                    break;
                case 6:
                    fur.Query6();
                    break;
                case 7:
                    fur.Query7();
                    break;
                case 8:
                    fur.Query8();
                    break;
                case 9:
                    fur.Query9();
                    break;
                case 10:
                    fur.Query9();
                    break;
                case 11:
                    fur.Query9();
                    break;
                case 12:
                    fur.Query9();
                    break;
                case 13:
                    fur.Query9();
                    break;
                case 14:
                    fur.Query9();
                    break;
                case 15:
                    fur.Query9();
                    break;
                case 16:
                    fur.Query9();
                    break;
                case 17:
                    fur.Query9();
                    break;
                case 18:
                    fur.Query9();
                    break;
                case 19:
                    fur.Query9();
                    break;
                case 20:
                    fur.Query9();
                    break;
                                                                
                        
            }
        } while (choice != 20);
        {
            System.out.println("Program Terminated");
        }
    }

    public void Query1() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu", "pari0738", "LDqv7Eo3");
            Statement st = con.createStatement();
            Scanner sc1 = new Scanner(System.in);
            String E_new;
            if (con != null) {
                System.out.println("Connected Successful");
                System.out.println("\n Enter the Name of the Employee");
                String name = sc1.nextLine();
                System.out.println("\n Enter the Address of the Employee");
                String Addr = sc1.nextLine();
                E_new = "insert into Employee values('"+name+"','"+Addr+"')";
                int E_insert = st.executeUpdate(E_new);
                System.out.println("---Enter Employee Type---");
                System.out.println("Please select any of the follwing options 1. Techical_Staff\n 2. Quality_Comtroller \n 3. Worker");
                int option;
                option = sc1.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Please Enter the technical Position \n");
                        String position = sc1.nextLine();
                        ///System.out.println("Enter the Degree level HE/SHE possess \n");
                        //String deg = tc.nextLine();
                        String T_new = "insert into Technical_staff values('"+name+"','"+Addr+"','"+position+"')";
                        st.executeUpdate(T_new);
                        System.out.println("Employee of type Techical_staff has been added successfully \n");
                        break;
                    case 2:
                        System.out.println("Please Enter the Type of the product \n");
                        String type = sc1.nextLine();
                        String Q_new = "insert into Quality_Controller values('"+name+"','"+Addr+"','"+type+"')";
                        st.executeUpdate(Q_new);
                        System.out.println("Employee of type Quality_Controller has been added Successfully \n");
                        break;
                    case 3:
                        System.out.println("Please Enter the MAX products produced per day");
                        int maxp = sc1.nextInt();
                        String W_new = "insert into Worker values('"+name+"','"+Addr+"','"+maxp+"')";
                        st.executeUpdate(W_new);
                        System.out.println("Employee of type Worker has been added Successfully \n");
                        break;
                }

                              ///System.out.println("Employee Details has been added successfully");
                //BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));   
            } else {
                System.out.println("Not connected");
                con.close();
            }
        } catch (Exception e) {
            System.out.println("Connection Error !!" + e);
        }
    }
    
    public void Query2()
    {
        try
        {
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu", "pari0738", "LDqv7Eo3");
            Statement stat = con.createStatement();
            Scanner sc2=new Scanner(System.in);
            if (con!= null)
            {
                System.out.println("Connected Successul");
                PreparedStatement Prep_Prod = con.prepareStatement("insert into Product values(?,?,?,?,?,?,?,?)");
                System.out.println("Please Enter the Product_Id");
                int p_id=Integer.parseInt(sc2.nextLine());
                Prep_Prod.setInt(1, p_id);
                System.out.println("Please Enter the manufatured date in this format(MM-DD-YYYY)");
                //System.out.println("aaaaa");
                String P_date=sc2.nextLine();
                //System.out.println(P_date);           
                java.util.Date date= new SimpleDateFormat("MM-dd-yyyy").parse(P_date); 
                long P_time = date.getTime();
                java.sql.Date date1= new java.sql.Date(P_time); 
                Prep_Prod.setDate(2, date1);
                System.out.print("Please Enter the total preparation time(Only Integer's please)");
                int prep_time=Integer.parseInt(sc2.nextLine());
               Prep_Prod.setInt(3, prep_time);
                System.out.println("-------->"+prep_time);
                System.out.println("Enter the Employee name,who Fixed/Repaired a problem");
                String TT_test=sc2.nextLine();
               Prep_Prod.setString(4, TT_test);
                //System.out.println("---------------->"+TT_test);
                System.out.println("Enter the Employee name,who Tested the Product");
                String Q_test=sc2.nextLine();
                
                //System.out.println("---->"+Q_test);
                Prep_Prod.setString(5, Q_test);
                System.out.println("Enter the Employee name,who produced the product");
                String W_name=sc2.nextLine();
                //System.out.println("---------->"+W_name);
               Prep_Prod.setString(6, W_name);
                System.out.println("Enter the Account_Number associated with the product");
                int AN_pro=Integer.parseInt(sc2.nextLine());
               Prep_Prod.setInt(7, AN_pro);
                System.out.println("Please Enter the Type of Certification Level Received");
                String C_test=sc2.next();
               Prep_Prod.setString(8, C_test);
              String P_insert="insert into Product values("+p_id+",'"+date1+"',"+prep_time+",'"+TT_test+"','"+Q_test+"','"+W_name+"',"+AN_pro+",'"+C_test+"')";
                System.out.println("------>"+P_insert);
              //Prep_Prod.executeUpdate(P_insert);
                Prep_Prod.executeUpdate();
              
                System.out.println("Please Enter the Product_type to be insert");
                System.out.println("------------------------------------------");
                System.out.println("1. Product1 \n ");
                System.out.println("2. Product2 \n ");
                System.out.println("3. Product3 \n ");
                System.out.println("--------------------------------------------");
                int P_choice=Integer.parseInt(sc2.nextLine());
                switch(P_choice)
                {
                    case 1: System.out.println("For Product_type1, Please Enter its Size");
                        String P_size=sc2.nextLine();
                        System.out.println("---->"+P_size);
                        System.out.println(" Enter the Software Used \n");
                        String P_soft=sc2.nextLine();
                        String P1_insert="insert into Product1 values("+p_id+",'"+date1+"',"+prep_time+",'"+TT_test+"','"+Q_test+"','"+W_name+"',"+AN_pro+",'"+C_test+"','"+P_size+"','"+P_soft+"')";
                        stat.executeUpdate(P1_insert);
                        break;
                    case 2: System.out.println("For Product_type2, Please Enter its Size");
                        String P1_size=sc2.nextLine();
                        System.out.println("Enter the Color:\n");
                        String P1_color=sc2.nextLine();
                        String P2_insert="insert into Product2 values('"+p_id+"','"+P_date+"','"+P_time+"','"+prep_time+"'"+W_name+"','"+Q_test+"','"+TT_test+"','"+AN_pro+"','"+C_test+"','"+P1_size+"','"+P1_color+"')";
                       stat.executeUpdate(P2_insert);
                        break;
                    case 3: System.out.println("For Product_type3, Please Enter its Size");
                        String P2_size=sc2.nextLine();
                        System.out.println("Enter the Weight of the product");
                        String P2_weight=sc2.nextLine();
                        String P3_insert="insert into Product3 values('"+p_id+"','"+P_date+"','"+P_time+"','"+prep_time+"'"+W_name+"','"+Q_test+"','"+TT_test+"','"+AN_pro+"','"+C_test+"','"+P2_size+"','"+P2_weight+"')";
                        stat.executeUpdate(P3_insert);
                        break;
                }
                System.out.println("Product_type details are added successfully !!");  
            }
        else
        {
                System.out.println("Not Connected");
                }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Connection Error !!" +e);
        }
    }
    
    
   /* public void Query2()
    {
        try
        {
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu", "pari0738", "LDqv7Eo3");
            Statement stat = con1.createStatement();
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            Scanner sc2=new Scanner(System.in);
            if (con1!= null)
            {
                System.out.println("Connected Successul");
                System.out.println("Please Enter the Product_Id");
                int id=Integer.parseInt(br.readLine());
                System.out.println("------>"+id);
                System.out.println("Please Enter the manufatured date in this format(MM-DD-YYYY)");
                //System.out.println("aaaaa");
                String p_date=br.readLine();
                //System.out.println(P_date);           
                java.util.Date date= new SimpleDateFormat("MM-dd-yyyy").parse(p_date); 
                long P_time = date.getTime();
                java.sql.Date date1= new java.sql.Date(P_time); 
                
                System.out.print("Please Enter the total preparation time(Only Integer's please)");
                int prep_time=Integer.parseInt(br.readLine());
              
                System.out.println("-------->"+prep_time);
                System.out.println("Enter the Employee ,who Fixed/Repaired a problem");
                String TT_test=br.readLine();
               
                System.out.println("---------------->"+TT_test);
                System.out.println("Enter the Employee name,who Tested the Product");
                String Q_test=br.readLine();
                
                System.out.println("---->"+Q_test);
               
                System.out.println("Enter the Employee name,who produced the product");
                String W_name=br.readLine();
                //System.out.println("---------->"+W_name);
               
                System.out.println("Enter the Account_Number associated with the product");
                int AN_pro=Integer.parseInt(br.readLine());               
                System.out.println("Please Enter the Type of Certification Level Received");
                String C_test=br.readLine();
                System.out.println("---->" +C_test);
               
                String P_insert="insert into Product values("+id+","+date1+","+prep_time+",'"+TT_test+"','"+Q_test+"','"+W_name+"',"+AN_pro+",'"+C_test+"')";
                System.out.println("----------->"+P_insert);
                stat.executeUpdate(P_insert);
                System.out.println("Product Details are added successfully");
              
                System.out.println("Please Enter the Product_type to be insert");
                System.out.println("------------------------------------------");
                System.out.println("1. Product1 \n ");
                System.out.println("2. Product2 \n ");
                System.out.println("3. Product3 \n ");
                System.out.println("--------------------------------------------");
                int P_choice;
                P_choice=sc2.nextInt();
                switch(P_choice)
                {
                    case 1: System.out.println("For Product_type1, Please Enter its Size");
                        String P_size=br.readLine();
                        System.out.println("---->"+P_size);
                        System.out.println(" Enter the Software Used \n");
                        String P_soft=br.readLine();
                        String P1_insert="insert into Product1 values('"+id+"','"+date1+"','"+P_time+"','"+prep_time+"'"+W_name+"','"+Q_test+"','"+TT_test+"','"+AN_pro+"','"+C_test+"','"+P_size+"','"+P_soft+"')";
                        stat.executeUpdate(P1_insert);
                        break;
                    case 2: System.out.println("For Product_type2, Please Enter its Size");
                        String P1_size=br.readLine();
                        System.out.println("Enter the Color:\n");
                        String P1_color=br.readLine();
                        String P2_insert="insert into Product2 values('"+id+"','"+date1+"','"+P_time+"','"+prep_time+"'"+W_name+"','"+Q_test+"','"+TT_test+"','"+AN_pro+"','"+C_test+"','"+P1_size+"','"+P1_color+"')";
                       stat.executeUpdate(P2_insert);
                        break;
                    case 3: System.out.println("For Product_type3, Please Enter its Size");
                        String P2_size=sc2.nextLine();
                        System.out.println("Enter the Weight of the product");
                        String P2_weight=sc2.nextLine();
                        String P3_insert="insert into Product3 values('"+id+"','"+date1+"','"+P_time+"','"+prep_time+"'"+W_name+"','"+Q_test+"','"+TT_test+"','"+AN_pro+"','"+C_test+"','"+P2_size+"','"+P2_weight+"')";
                        stat.executeUpdate(P3_insert);
                        break;
                }
                System.out.println("Product_type details are added successfully !!");  
                
                
            }
        }
        catch(Exception e)
                {
                    System.out.println("Connection Error"+e);
                }
    }
    */
    public void Query3()
    {
        try
        {
       Class.forName("oracle.jdbc.OracleDriver");
            Connection con2 = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu", "pari0738", "LDqv7Eo3");
            Statement st1 = con2.createStatement();
            Scanner sc3=new Scanner(System.in);
            if (con2!= null)
                
            {
                System.out.println("Connected Successul");
                System.out.println("Enter the Name of the Customer");
                String C_name=sc3.nextLine();
                System.out.println("Enter Customers Address");
                String C_addr=sc3.nextLine();
                System.out.println("Enter the Process_Id of the product the Customer Purchased");
                int Pc_id=sc3.nextInt();
                String Cust_prod="insert into Customer values('"+C_name+"','"+C_addr+"')";
                st1.executeUpdate(Cust_prod);
                System.out.println("-------------------------------------------------------");
                
                String Cust_pur="insert into Purchases values('"+C_name+"','"+Pc_id+"')";
                st1.executeUpdate(Cust_pur);
                System.out.println("Entered Values has been added Successfully !!");
            }
            else
            {
                System.out.println("Not Connected !!");
            }
            con2.close();
        }
        catch(Exception e)
        {
            System.out.println("Connection Error" +e);
        }
        
        
    }
    
     public void Query4()
    {
        try
        {
       Class.forName("oracle.jdbc.OracleDriver");
            Connection con2 = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu", "pari0738", "LDqv7Eo3");
            Statement st1 = con2.createStatement();
            Scanner sc3=new Scanner(System.in);
            if (con2!= null)   
            {
                System.out.println("Connected Successul");
                PreparedStatement Acc_Prod = con2.prepareStatement("insert into Account values(?,?,?)");
                System.out.println("Please Enter the Account_number of the Product");
                String Acc_num=sc3.nextLine();
                Acc_Prod.setString(1, Acc_num);
                System.out.println("Enter the Account_opened_date according to this format (MM-DD-YYYY)");
                String dat=sc3.next();
           //     System.out.println(P_date);           
                java.util.Date date= new SimpleDateFormat("MM-dd-yyyy").parse(dat); 
                long d = date.getTime();
                java.sql.Date date1= new java.sql.Date(d); 
                Acc_Prod.setDate(2, date1);
                System.out.println("Enter the Cost of the Product");
                int P_cost=sc3.nextInt();
                
                Acc_Prod.setInt(3, P_cost);  
                Acc_Prod.executeUpdate();
                System.out.println("Please Enter the Account_type associated with products needs to be inserted");
                System.out.println("------------------------------------------");
                System.out.println("1. Product1_Account \n");
                System.out.println("2. Product2_Account \n ");
                System.out.println("3. Product3_Account \n ");
                System.out.println("--------------------------------------------");
                int A_choice;
                A_choice=sc3.nextInt();
                switch(A_choice)
                {
                case 1: 
                    PreparedStatement Acc1_Prod = con2.prepareStatement("insert into Product1_Account values(?,?,?)");
                    Acc1_Prod.setString(1, Acc_num);
                    Acc1_Prod.setDate(2, date1);
                    Acc1_Prod.setInt(3, P_cost);
                    Acc1_Prod.executeUpdate();
                    System.out.println("Product1_Account Inserted");
                    break;
                case 2: 
                    PreparedStatement Acc2_Prod = con2.prepareStatement("insert into Product2_Account values(?,?,?)");
                    Acc2_Prod.setString(1, Acc_num);
                    Acc2_Prod.setDate(2, date1);
                    Acc2_Prod.setInt(3, P_cost);
                    Acc2_Prod.executeUpdate();
                    System.out.println("Product2_Account Inserted");
                    break;
                case 3: 
                    PreparedStatement Acc3_Prod = con2.prepareStatement("insert into Product3_Account values(?,?,?)");
                    Acc3_Prod.setString(1, Acc_num);
                    Acc3_Prod.setDate(2, date1);
                    Acc3_Prod.setInt(3, P_cost);
                    Acc3_Prod.executeUpdate();
                    System.out.println("Product3_Account Inserted");
                    break;
             
                }
                System.out.println("Product based accounts added successfully !!");
            }
            else
            {
                
            }
        }
                catch(Exception e)
                        {
                        System.out.println("Connection Error:"+e);
                        }
    }
     
     public void Query5()
    {
        try
        {
       Class.forName("oracle.jdbc.OracleDriver");
            Connection con3 = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu", "pari0738", "LDqv7Eo3");
            Statement st1 = con3.createStatement();
            Scanner sc3=new Scanner(System.in);
            if (con3!= null)   
            {
                System.out.println("Connected Successul"); 
                PreparedStatement Cust_comp = con3.prepareStatement("insert into Makes_a_comp values(?,?,?)");
                System.out.println("Enter the Complaint Identification Number");
                int C_id=sc3.nextInt();
                Cust_comp.setInt(1, C_id);
                System.out.println("Enter the Customer Name");
                String Cus_name=sc3.next();
                Cust_comp.setString(2, Cus_name);
                System.out.println("Enter the Process Id");
                int Proc_id=sc3.nextInt();
                Cust_comp.setInt(3, Proc_id);
                Cust_comp.executeUpdate();
                
                PreparedStatement Cust1_comp=con3.prepareStatement("insert into Complaint values((?,?,?,?)");
                Cust1_comp.setInt(1, C_id);
                System.out.println("Please Enter the Registered Complaint Date according to this format (MM-DD-YYYY)");
                String dat=sc3.next();
           //     System.out.println(P_date);           
                java.util.Date date= new SimpleDateFormat("MM-dd-yyyy").parse(dat); 
                long d = date.getTime();
                java.sql.Date date1= new java.sql.Date(d); 
                Cust1_comp.setDate(2, date1);
                System.out.println("Please Enter a brief note about the complaint");
                String cus_note=sc3.next();
                Cust1_comp.setString(3, cus_note);
                System.out.println("Enter the best possible treatment expected");
                String cus_tr=sc3.nextLine();
                Cust1_comp.setString(4, cus_tr);
                Cust1_comp.executeUpdate();
            }
            
            else
            {
                System.out.println("Not Connected !!");   
            }
            System.out.println("Complaint Deatils has been saved successfully");
        }
            catch(Exception e)
                    {
                    System.out.println("Connection Failed");
                    }
    }
     
     public void Query6()
     {
          try
        {
       Class.forName("oracle.jdbc.OracleDriver");
            Connection con3 = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu", "pari0738", "LDqv7Eo3");
            Statement st1 = con3.createStatement();
            Scanner sc3=new Scanner(System.in);
            if (con3!= null)   
            {
                System.out.println("Connected Successul"); 
                System.out.println("Please Enter the product ID number for retreiving the information");
                int pro_id=sc3.nextInt();
                String query="select Produced_date,Max_time from Product where P_id='"+pro_id+"'";
                st1.executeQuery(query);
                System.out.println("Values for the mentioned Id are retrived");
                 
            }
        }
          catch(Exception e)
          {
              System.out.println("Please check this error message-->" + e);
          }
     }
     
      public void Query7()
     {
          try
        {
       Class.forName("oracle.jdbc.OracleDriver");
            Connection con3 = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu", "pari0738", "LDqv7Eo3");
            Statement st1 = con3.createStatement();
           BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
           ResultSet rs;
            if (con3!= null)   
            {
                System.out.println("Please Enter the product ID number for retreiving the information");
                String p_id=buff.readLine();
                String query="select Produced_date,Make_time from Product where P_id='"+p_id+"'";
                rs=st1.executeQuery(query);
                 //System.out.println("----->"+p_id);
                 while(rs.next())
                 {
                    // int time=rs.getInt("time");
                     System.out.println("The Date Produced is----->"+ rs.getDate(1));
                     System.out.println("The Total Preparation_time taken to produce the product---->"+rs.getString(2));
                    //System.out.println("The Time taken to produce that product:"+rs.getInt(2));
                 }
                         
        }
        }
          catch(Exception e)
          {
              System.out.println("Please check this error message-->" + e);
          }
     }
      
       public void Query8()
     {
          try
        {
       Class.forName("oracle.jdbc.OracleDriver");
            Connection con3 = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu", "pari0738", "LDqv7Eo3");
            Statement st1 = con3.createStatement();
            BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
           ResultSet rs;
            if (con3!= null)   
            {
                System.out.println("Please Enter the Name of the Worker");
                String w_name=buff.readLine();
                String query="select P_id from Product where W_name='"+w_name+"'";
                rs=st1.executeQuery(query);
                 //System.out.println("----->"+p_id);
                 while(rs.next())
                 {
                    // int time=rs.getInt("time");
                     System.out.println("The Product_Id associated with " + w_name +" is " +rs.getString(1));
                     //System.out.println("The Total Preparation_time taken to produce the product---->"+rs.getString(2));
                    //System.out.println("The Time taken to produce that product:"+rs.getInt(2));
                 }
                         
        }
        }
          catch(Exception e)
          {
              System.out.println("Please check this error message-->" + e);
          }
     }
       
       public void Query9()
     {
          try
        {
       Class.forName("oracle.jdbc.OracleDriver");
            Connection con3 = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu", "pari0738", "LDqv7Eo3");
            Statement st1 = con3.createStatement();
            BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
           ResultSet rs;
            if (con3!= null)   
            {
                System.out.println("Please Enter the Name of Quality_Controller");
                String q_name=buff.readLine();
                String query="select count(*) from Product,Makes_a_comp where Product.P_id=Makes_a_comp.P_id and Product.Q_name='"+q_name+"'";
                rs=st1.executeQuery(query);
                
                //System.out.println("---->"+rs.getString(1));
                 //System.out.println("----->"+p_id);
                 while(rs.next())
                 {
                    // int time=rs.getInt("time");
                     System.out.println("The Total Number of error's made by Quality Controller " + q_name +" is " +rs.getString(1));
                     //System.out.println("The Total Preparation_time taken to produce the product---->"+rs.getString(2));
                    //System.out.println("The Time taken to produce that product:"+rs.getInt(2));
                 }
                         
        }
        }
          catch(Exception e)
          {
              System.out.println("Please check this error message-->" + e);
          }
     }
       
       public void Query10()
     {
          try
        {
       Class.forName("oracle.jdbc.OracleDriver");
            Connection con3 = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu", "pari0738", "LDqv7Eo3");
            Statement st1 = con3.createStatement();
            BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
           ResultSet rs;
            if (con3!= null)   
            {
                System.out.println("Please Enter the Name of Quality_Controller");
                String q_name=buff.readLine();
                String sum="select sum(Product3_Account.cost) from Product3_Account,Product,Request_for_repairs where Product3_Account.Account_Number=Product.Account_Number and Product.P_id=Request_for_repairs.P_id and Request_for_repairs.Q_name='"+q_name+"'";
                rs=st1.executeQuery(sum);
                
                //System.out.println("---->"+rs.getString(1));
                 //System.out.println("----->"+p_id);
                 while(rs.next())
                 {
                    // int time=rs.getInt("time");
                     System.out.println("The Total Number of error's made by Quality Controller " + q_name +" is " +rs.getString(1));
                     //System.out.println("The Total Preparation_time taken to produce the product---->"+rs.getString(2));
                    //System.out.println("The Time taken to produce that product:"+rs.getInt(2));
                 }
                         
        }
        }
          catch(Exception e)
          {
              System.out.println("Please check this error message-->" + e);
          }
     }
}
