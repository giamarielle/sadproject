class patient {
    private final int patient_id;
    private int age;
    private String firstname,midname,lastname,address,gender;
    
    public patient(int patient_id, String firstname, String midname, String lastname, String address, String gender, int age){
        this.patient_id = patient_id;
        this.firstname = firstname;
        this.midname = midname;
        this.lastname = lastname;
        this.address = address;
        this.gender = gender;
        this.age = age;
    }

    public int getpatient_id(){
        return patient_id;
    }
    
    public String getfirstname(){
        return firstname;
    }
    
    public String getmidname(){
        return midname;
    }
    
    public String getlastname(){
        return lastname;
    }
    
    public String getaddress(){
        return address;
    }
    
    public String getgender(){
        return gender;
    }
    
    public int getage(){
        return age;
    }
}
