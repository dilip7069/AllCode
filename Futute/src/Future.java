import java.io.File;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.text.SimpleDateFormat;
//import java.util.*;

/**
 * @author ndilip
 */
public class Future {
   static Future f;
    
    public static void main(String[] args) {
    int option=0; 
    Connection conn=null;   
    Scanner sc=new Scanner(System.in);
    f=new Future();
    try
    {
         Class.forName("oracle.jdbc.OracleDriver");            
         conn= DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu","nadi1062","KBuo0Wg3");              
         if(conn!=null)
         {
           System.out.println("Connection Succeeded");
         }

      do
        {
    	  //Enter Option 
        System.out.println("--------------------------------------------");   
        System.out.println("1.Enter New Employee Details");
        System.out.println("2.Enter New Product Info");
        System.out.println("3.Enter Customer Purchase Details");
        System.out.println("4.Create Account Associated With the Product");
        System.out.println("5.Enter a Complaint");
        System.out.println("6.Enter Accident Details");
        System.out.println("7.Get Date Produced and Time Spend to Produce the Product");
        System.out.println("8.Get Details of Products Made by a Employee");
        System.out.println("9.Get Total No of Error a Particular Employee Made");
        System.out.println("10.Get the Total Costs of the Products in the Product3 Category Which were Repaired at the Request of a Particular Quality Controller");
        System.out.println("11.Get Customers Who Purchased all Products of a Particular Color");
        System.out.println("12.Get the Total Number of Work Days Lost Due to Accidents in Repairing the Products Which Got Complaints");
        System.out.println("13.Get All Customers Who are Also Workers");
        System.out.println("14.Get All the Customers Who Have Purchased the Products Made or Certified or Repaired by Themselves");
        System.out.println("15.Get the Average Cost of All Products Made in a Particular Year");
        System.out.println("16.Switch the Position Between a Technical Staff and a Quality Controller");
        System.out.println("17.Delete All Accidents Whose Dates are in Some Range");
        System.out.println("18.Import Customers Details from File");
        System.out.println("19.Retrieve All Customers Details and Output Them to File");
        System.out.println("20.Exit");
        System.out.println("--------------------------------------------");        
        System.out.println("Enter your Choice :");
  
        String s=sc.nextLine();
        option= Integer.parseInt(s);

        switch(option)
        {
            case 1: f.enterEmployee(sc,conn);                    
                    break;
            case 2: f.newProductInfo(sc,conn);
                    break;
            case 3: f.customerPurchaseDetails(sc,conn);
                    break;
            case 4: f.accountProduct(sc,conn);
                    break;
            case 5: f.createComplaint(sc,conn);
                    break;
            case 6: f.enterAccident(sc,conn); 
                    break;
            case 7: f.getProductDetails(sc,conn);
                    break;
            case 8: f.getProducedBy(sc,conn);
                    break;
            case 9: f.getNoErrorsMadeByController(sc,conn);
                    break;
            case 10: f.totalCost(sc,conn);
                    break;
            case 11: f.getColoredProducts(sc,conn);
                     break;
            case 12: f.daysLostDuetoAccidents(sc,conn);
                    break;
            case 13: f.getEmployeeCustomers(sc, conn);
                    break;
            case 14: f.getEmployeeCustomersofOwn(sc,conn);
                    break;
            case 15: f.avgCostofProduct(sc,conn);
                    break;
            case 16: f.switchTechQc(sc,conn);
                    break;
            case 17: f.deleteAccidentsBetween(sc, conn);
                    break;
            case 18: f.importCustomers(sc,conn);
            		break;
            case 19: f.getCustomerDetails(sc,conn);
            		break;     
            case 20:System.out.println("You have seleted to exit");
                   break;
            case 21: 
            	Statement s1=conn.createStatement();
            	s1.executeQuery("delete from products");
            default: System.out.println("You have entered wrong choice!!!");
                System.out.println("Please enter the right choice!!");               
        }
              
        }while(option!=20);//Program Exits when merchant enter option as 20.
         sc.close();
        }
    catch(Exception ce)
    {
        System.out.println("Error "+ce.getMessage());
        ce.printStackTrace();
    }
    finally
    {
        try
        { 
        if(conn!=null)
        {
            conn.close();
            sc.close();
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
 }
    
   
    public void enterEmployee(Scanner sc1, Connection conn1) 
    {
        
		String Name,Location,City,ISGraduate,Degree,TechPos,query,query1=null,Type=null;
		int Pin, MaxNo,choice,ProductType;
          try{
           Statement stmt =conn1.createStatement();
           System.out.println("Enter Unique Employee Name");
           Name=sc1.nextLine();
           System.out.println("Enter Location");
           Location=sc1.nextLine();
           System.out.println("Enter City");
           City=sc1.nextLine();
           System.out.println("Enter Pin Code");
           Pin=Integer.parseInt(sc1.nextLine());
           query="insert into employee  values('"+Name+"','"+Location+"','"+City+"',"+Pin+")";           
       	   System.out.println("Enter type of Employee\n 1.Quality Controller\n 2.Technical Staff\n 3.Worker");
           choice=Integer.parseInt(sc1.nextLine());
           switch(choice)
        	{
        	   case 1:System.out.println("Enter your choice for ProoductType for the QC\n 1.ProductType1\n 2.ProductType2\n 3:ProductType3");
        	   ProductType=Integer.parseInt(sc1.nextLine());
        	       switch(ProductType){
        	       case 1:Type="Type1";
        	       break;
        	       case 2:Type="Type2";
        	       break;
        	       case 3:Type="Type3";
        	       break;
        	       
        	   }
        	   query1="insert into QualityControllers values('"+Name+"','"+Type+"')";
        	   break;
        	   case 2:System.out.println("Enter Degrees");
        	   Degree=sc1.nextLine();
        	   System.out.println("Is Employee a Graduate? Y/N");
        	   ISGraduate=sc1.nextLine();
        	   System.out.println("Enter Position");
        	   TechPos=sc1.nextLine();
        	   query1="insert into TechnicalStaff values('"+Name+"','"+ISGraduate+"','"+Degree+"','"+TechPos+"')";
        	   break;
        	   case 3:System.out.println("Enter Maximum Number of Products Employee can Produce");
        	   MaxNo=Integer.parseInt(sc1.nextLine());
        	   query1="insert into Workers values('"+Name+"',"+MaxNo+")";
        	   break;
        	   }
        	   int update1=stmt.executeUpdate(query);
        	   int update2=stmt.executeUpdate(query1);
        	   if(update1==update2)
        	   System.out.println(update1+" records updated");

        }   
        catch(Exception ce)
        {
            System.out.println("Error "+ce.getMessage());
            ce.printStackTrace();
        }
    }       
    public void newProductInfo(Scanner sc, Connection conn1)
    {
		Statement stmt = null;
		String TestedBy,ISRepaired,RepairedBy,ProducedBy,Color,Software,temp,query,SizeofTheProduct;
		int Type,UID;
		float TimeSpentinHrs,Weight;
        try
        {                   
           stmt = conn1.createStatement();
           PreparedStatement ProdInfo = conn1.prepareStatement ("insert into Products values(?,?,?,?,?,?,?,?,?)");
           System.out.println("Unique Product No:");
           UID=Integer.parseInt(sc.nextLine());
           ProdInfo.setInt(1,UID);
           System.out.println("Enter Date Produced (MMM-dd-yyyy) :");
           temp=sc.nextLine();                     
           java.util.Date Dob= new SimpleDateFormat("MMM-dd-yyyy").parse(temp);          
           long ms = Dob.getTime();
           java.sql.Date sq= new java.sql.Date(ms); 
           ProdInfo.setDate(2, sq);          
           System.out.println("Time Spent");
           TimeSpentinHrs=Float.parseFloat(sc.nextLine());
           ProdInfo.setFloat(3, TimeSpentinHrs);
           System.out.println("Enter Employee Produced");
           ProducedBy=sc.nextLine();
           ProdInfo.setString(4, ProducedBy);
           System.out.println("Enter Quality Controller Name");
           TestedBy=sc.nextLine();
           ProdInfo.setString(5, TestedBy);
           System.out.println("Enter if Product has been repaired? Y/N");
           ISRepaired=sc.nextLine();
           ProdInfo.setString(6, ISRepaired);
           if(ISRepaired.equalsIgnoreCase("y"))
           {
        	   System.out.println("Enter the Employee repaired");
        	   RepairedBy=sc.nextLine();
           }
           else
           RepairedBy="null";
           ProdInfo.setString(8,RepairedBy);   
           System.out.println("Enter Size of the Product");
           SizeofTheProduct=sc.nextLine();
           ProdInfo.setString(7,SizeofTheProduct);                   
           System.out.println("Select  the Productype\n 1. ProductType1\n 2. ProductType2\n 3. ProductType3");
           Type=Integer.parseInt(sc.nextLine());
           switch(Type)
           {
               case 1: ProdInfo.setString(9,"Type1");        	   
        	   System.out.println("Enter S/W used");
        	   Software=sc.nextLine();
        	   ProdInfo.executeUpdate();
        	   query="insert into ProductType1 values("+UID+",'"+Software+"')";
        	   stmt.executeQuery(query);
        	   break;
               case 2: ProdInfo.setString(9,"Type2");               
        	   System.out.println("Enter Color of Product");
        	   Color=sc.nextLine();
        	   query="insert into ProductType2 values("+UID+",'"+Color+"')";
        	   ProdInfo.executeUpdate();
        	   stmt.executeQuery(query);
               break;
               case 3:ProdInfo.setString(9,"Type3");              
        	   System.out.println("Enter Weight of Product(Float value only)");
        	   Weight=Float.parseFloat(sc.nextLine());
        	   query="insert into ProductType3 values("+UID+","+Weight+")";
        	   System.out.println(query);
        	   ProdInfo.executeUpdate();
        	   stmt.executeQuery(query);
               break;
               default: System.out.println("You have entered wrong choice!!!");    
           }
        }           
        catch(Exception ce)
        {
            System.out.println("Error "+ce.getMessage());
            ce.printStackTrace();
        }     
    }
    public void customerPurchaseDetails(Scanner sc, Connection conn1)
    {
		Statement stmt = null;
		String Name,Location,City,Choice,query,query1=null;	
		int PIN,UID;		
        try
        {                        
           stmt = conn1.createStatement();                        
            System.out.println("Is the Customer an New Customer? Y/N");
            Choice=sc.nextLine();
            System.out.println("Enter Customer Unique Name");
            Name=sc.nextLine();
            if(Choice.equalsIgnoreCase("y"))
            {
            	System.out.println("Enter Location of Customer");
            	Location=sc.nextLine();
            	System.out.println("Enter City of Customer");
            	City=sc.nextLine();
            	System.out.println("Enter Pin No");
            	PIN=Integer.parseInt(sc.nextLine());
                query1=	"insert into Customer values('"+Name+"','"+Location+"','"+City+"',"+PIN+")";                 
                stmt.executeUpdate(query1);
            }
            System.out.println("Enter the UID of the Product Purchased by Merchant");
            UID=Integer.parseInt(sc.nextLine());
            query="insert into ProductDetails values('"+Name+"',"+UID+")";
            stmt.executeUpdate(query);
        }       
        catch(Exception ce)
        {
            System.out.println("Error "+ce.getMessage());
            ce.printStackTrace();
        }  
    }

    public void accountProduct(Scanner sc, Connection conn1)
    {	
		int AccNo,UID,Type;
		float COP;
		String temp;		
        try
        {                                       
           PreparedStatement Account1 = conn1.prepareStatement ("insert into Account1 values(?,?,?,?)");
           PreparedStatement Account2 = conn1.prepareStatement ("insert into Account2 values(?,?,?,?)");
           PreparedStatement Account3 = conn1.prepareStatement ("insert into Account3 values(?,?,?,?)");
           System.out.println("Enter Unique ID");
           UID=Integer.parseInt(sc.nextLine());
           System.out.println("Enter Unique Acc No");
           AccNo=Integer.parseInt(sc.nextLine());
           System.out.println("Enter Cost of the Product");
           COP=Float.parseFloat(sc.nextLine());
           System.out.println("Enter date of Account Created (MMM-dd-yyyy)");
           temp=sc.nextLine();
           System.out.println(temp);           
           java.util.Date Dob= new SimpleDateFormat("MMM-dd-yyyy").parse(temp);          
           long ms = Dob.getTime();
           java.sql.Date Adate= new java.sql.Date(ms); 
           System.out.println("Select  the Productype \n1. ProductType1\n 2. ProductType2 \n 3.3. ProductType3");
           Type=Integer.parseInt(sc.nextLine());
           switch(Type)
           {
           case 1: 
           Account1.setInt(1,UID);
           Account1.setInt(2,AccNo);
           Account1.setDate(3,Adate);
           Account1.setFloat(4,COP);
           Account1.executeUpdate();
           break;
           case 2: Account2.setInt(1,UID);
           Account2.setInt(2,AccNo);
           Account2.setDate(3,Adate);
           Account2.setFloat(4,COP);
           Account2.executeUpdate();
           break;
           case 3:Account3.setInt(1,UID);
           Account3.setInt(2,AccNo);
           Account3.setDate(3,Adate);
           Account3.setFloat(4,COP);
           Account3.executeUpdate();
           break;  
   		   default: System.out.println("Wrong Option");
           }   
        }    
        catch(Exception ce)
        {
            System.out.println("Error "+ce.getMessage());
            ce.printStackTrace();
        }         
     }
    
    public void createComplaint(Scanner sc, Connection conn1)
    {	
		String Name;
		int ComplaintID,UID;
		String temp,Description,TreatmentExpected;		
        try
        {                      
           PreparedStatement createComp = conn1.prepareStatement ("insert into Complaint values(?,?,?,?,?,?)");
           System.out.println("Enter Customer Name");
           Name=sc.nextLine();
           createComp.setString(1, Name);
           System.out.println("Enter Complaint ID");
           ComplaintID=Integer.parseInt(sc.nextLine());
           createComp.setInt(2, ComplaintID);
           System.out.println("Enter ProductID");
           UID=Integer.parseInt(sc.nextLine());
           createComp.setInt(3,UID);
           System.out.println("Enter date of Complaint (MMM-dd-yyyy)");
           temp=sc.nextLine();
           java.util.Date Dob= new SimpleDateFormat("MMM-dd-yyyy").parse(temp);          
           long ms = Dob.getTime();
           java.sql.Date Adate= new java.sql.Date(ms); 
           createComp.setDate(4,Adate);
           System.out.println("Enter Detailed Description of Complaint");
           Description=sc.nextLine();
           createComp.setString(5, Description);
           System.out.println("Enter Treatment Expected (MoneyBack/Replacement)");
           TreatmentExpected=sc.nextLine();
           createComp.setString(6,TreatmentExpected);
           createComp.executeQuery();
           
        }          
        catch(Exception ce)
        {
            System.out.println("Error "+ce.getMessage());
            ce.printStackTrace();
        }  
    }

    public void enterAccident(Scanner sc, Connection conn1)
    {	
		String Name;
		int UniqueAccidentNo,NoLostDays,UID,Choice;
		String temp;				
        try
        {
           PreparedStatement CreateAccident = conn1.prepareStatement ("insert into Accident values(?,?,?,?,?,?)");           
           System.out.println("Enter Name of the Employee caused Accident");
           Name=sc.nextLine();
           CreateAccident.setString(1,Name);
           System.out.println("Enter UniqueAccidentNo");
           UniqueAccidentNo=Integer.parseInt(sc.nextLine());
           CreateAccident.setInt(2,UniqueAccidentNo);
           System.out.println("Enter Number of days Lost due to Accident");
           NoLostDays=Integer.parseInt(sc.nextLine());
           CreateAccident.setInt(4,NoLostDays);
           System.out.println("Enter Date of Accident Caused (MMM-dd-yyyy) :");
           temp=sc.nextLine();
           System.out.println(temp);           
           java.util.Date Dob= new SimpleDateFormat("MMM-dd-yyyy").parse(temp);          
           long ms = Dob.getTime();
           java.sql.Date sq= new java.sql.Date(ms); 
           CreateAccident.setDate(3,sq);
           System.out.println("Enter ProductID ");
           UID=Integer.parseInt(sc.nextLine());
           CreateAccident.setInt(5, UID);
           System.out.println("Enter Cause of Accident\n1.Production\n2.Repair");
           Choice=Integer.parseInt(sc.nextLine());
           switch(Choice)
           {
           case 1:CreateAccident.setString(6, "production");
                  CreateAccident.executeUpdate();
                  break;
           case 2:CreateAccident.setString(6, "repair");
                  CreateAccident.executeUpdate();
                  break;
           default: System.out.println("You have entered wrong choice!!!");                            
           }
        }            
        catch(Exception ce)
        {
            System.out.println("Error "+ce.getMessage());
            ce.printStackTrace();
        }       
    }
    
    public void getProductDetails(Scanner sc, Connection conn1)
    {
    	int Uid;
        try
        {
           ResultSet rs;
           PreparedStatement getProDetails = conn1.prepareStatement ("select DateofProduced, TimeSpentinHrs from Products where UniqueID=?");           
           System.out.println("Enter Unique Id ");
           Uid=Integer.parseInt(sc.nextLine());
           getProDetails.setInt(1,Uid);
           rs=getProDetails.executeQuery();
           while(rs.next())
           {
        	   System.out.println("Date Produced  "+rs.getString(1)+"\nTime Spent "+rs.getString(2));
           }
        }            
        catch(Exception ce)
        {
            System.out.println("Error "+ce.getMessage());
            ce.printStackTrace();
        }  
    	
    }
    
    public void getProducedBy(Scanner sc, Connection conn1)
    {
    	String ProducedBy;
        try
        {
           ResultSet rs;
           PreparedStatement getProducts = conn1.prepareStatement ("select UniqueID, DateofProduced from Products where Producedby=?");           
           System.out.println("Enter Employee for Which you Need Complete Production Details ");
           ProducedBy=sc.nextLine();
           getProducts.setString(1,ProducedBy);
           rs=getProducts.executeQuery();
           while(rs.next())
           {
        	   System.out.println("UniqueID  "+rs.getString(1)+" Date Produced "+rs.getString(2));
           }
        }            
        catch(Exception ce)
        {
            System.out.println("Error "+ce.getMessage());
            ce.printStackTrace();
        }  
    	
    }   
    
    public void getNoErrorsMadeByController(Scanner sc, Connection conn1)
    {
    	String TestedBy;
        try
        {
           ResultSet rs;
           PreparedStatement getProducts = conn1.prepareStatement ("select count(Products.UniqueID) from Products, Complaint where (Products.UniqueID=Complaint.UniqueID and Products.TestedBy=?)");           
           System.out.println("Enter QualityCotroller");
           TestedBy=sc.nextLine();
           getProducts.setString(1,TestedBy);
           rs=getProducts.executeQuery();
           while(rs.next())
           {
        	   System.out.println("Total No of Errors Made by "+TestedBy+"  :"+rs.getString(1));
           }
        }            
        catch(Exception ce)
        {
            System.out.println("Error "+ce.getMessage());
            ce.printStackTrace();
        }  
    	
    }   
    
    public void totalCost(Scanner sc, Connection conn1)
    {
    	String Name;
        try
        {
           ResultSet rs;
           PreparedStatement getProducts = conn1.prepareStatement ("select sum(CostofProduct) from Account3 where UniqueID in (select UniqueID from Products where ((IsRepaired='y' and ProductType='Type3') and TestedBy=?))");           
           System.out.println("Enter QualityController Name");
           Name=sc.nextLine();
           getProducts.setString(1,Name);
           rs=getProducts.executeQuery();
           while(rs.next())
           {
        	   System.out.println("Total Cost Caused by Repair Request of  "+Name+"  :"+rs.getString(1));
           }
        }            
        catch(Exception ce)
        {
            System.out.println("Error "+ce.getMessage());
            ce.printStackTrace();
        }  
    	
    } 
    
    public void getColoredProducts(Scanner sc, Connection conn1)
    {
    	String Color;
        try
        {
           ResultSet rs;
           PreparedStatement getProducts = conn1.prepareStatement ("Select Unique Name from ProductDetails Where UniqueID in (select UniqueID From ProductType2 where Color=?)");           
           System.out.println("Enter Color of the Product");
           Color=sc.nextLine();
           getProducts.setString(1,Color);
           rs=getProducts.executeQuery();
           System.out.println("Here are the list of Customers");
           while(rs.next())
           {
        	   System.out.println(rs.getString(1));
           }
        }            
        catch(Exception ce)
        {
            System.out.println("Error "+ce.getMessage());
            ce.printStackTrace();
        }  
    	
    } 
    
    public void daysLostDuetoAccidents(Scanner sc, Connection conn1)
    {
        try
        {
           ResultSet rs;
           PreparedStatement getProducts = conn1.prepareStatement ("Select sum(NoLostDays) from Accident Where UniqueID in (select UniqueID from Complaint where causedby='repair')");           
           rs=getProducts.executeQuery();
           while(rs.next())
           {
        	   System.out.println("No of Workdays Lost due to accidents caused by repairig the "+rs.getString(1));
           }
        }            
        catch(Exception ce)
        {
            System.out.println("Error "+ce.getMessage());
            ce.printStackTrace();
        }  
    	
    } 
    
    public void getEmployeeCustomers(Scanner sc, Connection conn1)
    {
        try
        {
           ResultSet rs;
           PreparedStatement getProducts = conn1.prepareStatement ("select W.Name from Workers W, Customer C where W.Name=C.Name");           
           rs=getProducts.executeQuery();
           System.out.println("Here are the Employees who are Customers");
           while(rs.next())
           {
        	   System.out.println(rs.getString(1));
           }
        }            
        catch(Exception ce)
        {
            System.out.println("Error "+ce.getMessage());
            ce.printStackTrace();
        }  
    	
    } 
    
    public void getEmployeeCustomersofOwn(Scanner sc, Connection conn1)
    {
        try
        {
           ResultSet rs;
           PreparedStatement getEmployeeCustomers = conn1.prepareStatement ("select p.Name from ProductDetails p, Products pd where ((pd.uniqueid=p.uniqueid)and (pd.TestedBy=p.Name or (pd.ProducedBy=p.Name or pd.RepairedBy=p.Name)))");           
           rs=getEmployeeCustomers.executeQuery();
           System.out.println("Employee Customers");
           while(rs.next())
           {
        	   System.out.println(rs.getString(1));
           }
        }            
        catch(Exception ce)
        {
            System.out.println("Error "+ce.getMessage());
            ce.printStackTrace();
        }  
    	
    } 
  
    public void avgCostofProduct(Scanner sc, Connection conn1)
    {
    	int Year,Choice;
    	 try
         {
            ResultSet rs=null;
            PreparedStatement p1 = conn1.prepareStatement ("select avg (costofproduct) from Account1 where uniqueid in(select uniqueid from Products where extract(year from dateofproduced)=?)");
            PreparedStatement p2 = conn1.prepareStatement ("select avg (costofproduct) from Account2 where uniqueid in(select uniqueid from Products where extract(year from dateofproduced)=?)");
            PreparedStatement p3 = conn1.prepareStatement ("select avg (costofproduct) from Account3 where uniqueid in(select uniqueid from Products where extract(year from dateofproduced)=?)");
            System.out.println("Enter  the year");
            Year=Integer.parseInt(sc.nextLine());
            System.out.println("Choose the Product Type \n1. ProductType1\n2. ProductType2\n3. ProductType3");
            Choice=Integer.parseInt(sc.nextLine());
            switch(Choice)
            {
            case 1:p1.setInt(1, Year);
                   rs=p1.executeQuery();
                   break;
            case 2:p2.setInt(1, Year);
                   rs=p2.executeQuery();
                   break;
            case 3:p3.setInt(1, Year);
                   rs=p3.executeQuery();
                   break; 
            default: System.out.println("Wrongoption");
            }
           System.out.print("Avg Cost of Producttype"+Choice+" in Year "+Year +" is ");
 
            while(rs.next())
            {
         	   System.out.println(rs.getString(1));
           }
         }            
         catch(Exception ce)
         {
             System.out.println("Error "+ce.getMessage());
             ce.printStackTrace();
         }  
    }

    public void switchTechQc(Scanner sc, Connection conn1)
    
    {
    	String TS,QC,Query1,Query2,Type,Degrees,ISGraduate,Pos;
    	ResultSet rs1,rs2;   	
    	try
    	{
        Statement stmt =conn1.createStatement();
        Statement stmt1=conn1.createStatement();
    	System.out.println("Enter Technical Staff");
    	TS=sc.nextLine();
    	System.out.println("Enter Quality Controller");
    	QC=sc.nextLine();
    	Query1="Select Name from TechnicalStaff where Name='"+TS+"'";
    	Query2="Select Name from QualityControllers where Name='"+QC+"'";
    	rs1=stmt.executeQuery(Query1);
    	rs2=stmt1.executeQuery(Query2);
    	if(rs1.next()&&rs2.next())
    	{    			
    		System.out.println("Enter ProductType for the new Technical Staff");
        	Type=sc.nextLine();
        	System.out.println("Enter degrees for QC");
        	Degrees=sc.nextLine();
        	System.out.println("Is a Graduate (y/n)");
        	ISGraduate=sc.nextLine();
        	System.out.println("Enter Technical Position");
        	Pos=sc.nextLine();
        	Query1="insert into TechnicalStaff values('"+QC+"','"+ISGraduate+"','"+Degrees+"','"+Pos+"')";
        	Query2="insert into QualityControllers values('"+TS+"','"+Type+"')"; 
            stmt.executeUpdate(Query1);
            stmt.executeUpdate(Query2);
            System.out.println("Swapped Successfully");
    	}    		           
      }            
         catch(Exception ce)
         {
             System.out.println("Error "+ce.getMessage());
             ce.printStackTrace();
         }  
    }

    public void deleteAccidentsBetween(Scanner sc,Connection conn1)
    {
    	String start,end;
    	try
    	{
    	PreparedStatement del = conn1.prepareStatement ("Delete  from Accident WHERE Accidentdate BETWEEN ? AND ?");    	
    	System.out.println("Enter Start Date  (MM-dd-yyyy) :");
        start=sc.nextLine();               
        java.util.Date StartD= new SimpleDateFormat("MM-dd-yyyy").parse(start);          
        long ms = StartD.getTime();
        java.sql.Date StartDate= new java.sql.Date(ms); 
        System.out.println("Enter End Date  (MM-dd-yyyy) :");
        end=sc.nextLine();               
        java.util.Date EndD= new SimpleDateFormat("MM-dd-yyyy").parse(end);          
        ms = EndD.getTime();
        java.sql.Date EndDate= new java.sql.Date(ms); 
		del.setDate(1, StartDate);
		del.setDate(2, EndDate);		   
        int update=0;
        update=del.executeUpdate();
        System.out.println(update+" rows updated");
    	}
    	catch(Exception ce)
        {
            System.out.println("Error "+ce.getMessage());
            ce.printStackTrace();
        }
    }
    public void getCustomerDetails(Scanner sc, Connection conn1)
    {
		Statement stmt = null;
		String Fname;		
		String query;				
        try
        {            
           stmt = conn1.createStatement();
           query="Select * from Customer";              
           ResultSet rs=stmt.executeQuery(query);                 
           System.out.println("Enter the File Name");
           Fname=sc.nextLine()+".txt";
           File f= new File("C:\\",Fname);
           f.createNewFile();
          PrintWriter pw = new PrintWriter(f);
          pw.println("Name	Location  City   Pin");
          while(rs.next())
          {        	  
        	pw.println(rs.getString(1)+"  "+rs.getString(2)+ "  " + rs.getString(3)+"  "+ rs.getInt(4));  
          }          
          pw.flush();
        }             
        catch(Exception ce)
        {
            System.out.println("Error "+ce.getMessage());
            ce.printStackTrace();
        }

    }
    
    public void importCustomers(Scanner sc, Connection conn1)
    {

		String Fname;
        try
        {
           int count=0; 
           PreparedStatement updateemp = conn1.prepareStatement ("insert into Customer values(?,?,?,?)");                                   
           System.out.println("Enter the File Name to import Customer Details from C:\\");
           Fname=sc.nextLine();
           File f= new File("C:\\",Fname);
           FileReader fw=new FileReader(f);
           BufferedReader br=new BufferedReader(fw);
           String line=br.readLine();  
           
           while(line!=null)
           {
        	   int i=1;
        	  String[] s= line.split("\t");
        	  for(String s1:s)
        	  {   
        		  if(i!=4)
        		  updateemp.setString(i, s1);
        		  else
        		  {
        			  updateemp.setInt(i,Integer.parseInt(s1));
        		  }
        		  i++;
        	  }
        	  count=count+updateemp.executeUpdate();       	  
        	  line=br.readLine();
           }           
           System.out.println(count+" rows updated");
         }   
        catch(Exception ce)
        {
            System.out.println("Error "+ce.getMessage());
            ce.printStackTrace();
        }
    }       
 } 
    
    
    

