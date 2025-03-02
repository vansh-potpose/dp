class EmployeeRecord implements Prototype{  
      
    private int id;  
    private String name, department;    
    private double salary;  
    private String address;  
      
    public EmployeeRecord(){        
    }  
  
    public  EmployeeRecord(int id, String name, String department, double salary, String address) {  
          
        //this();  
         
    }  
      
    public void showRecord(){  
        System.out.println("   Employee Records ");  
        System.out.println("---------------------------------------------");    
        
        System.out.println("Employee ID"+"\t"+"Ename"+"\t\t"+"Edepartment"+"\t"+"ESalary"+"\t\t"+"Eaddress");  
      
        System.out.println(id+"\t"+name+"\t"+department+"\t\t"+salary+"\t"+address);  
    }  
  
    @Override  
    public Prototype getClone() {   
        EmployeeRecord temp=new EmployeeRecord();
        temp.id = this.id;  
        temp.name=this.name;
        temp.salary=this.salary;
        temp.address=this.address;
        temp.department=this.department;      
        return temp;  
    }  
    void setSalary(double s)
    {
        this.salary = s; 
    }
}