import java.util.*;

//Note to run this program the file name of this class should be Solution



//this is student class
class Student {
    public String name;
    public double cgpa;
    public int id;
    //this is student class constructor
    public Student(String name, double cgpa, int id){
        this.name=name;
        this.cgpa=cgpa;
        this.id=id;
    }
    
    public String getName(){
        return this.name;
    }
}
/*
comprator for cgpa,name,id 
first  it compare the cgpa in Descending Order
then it compare the name in Ascending Order
then it compare id in acending order

*/
class SComparator implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        if(s1.cgpa<s2.cgpa){
            return 1;
        }else if(s1.cgpa>s2.cgpa){
            return -1;
        }else{
            if(s1.name.compareTo(s2.name)>0){
                return 1;
            }else if(s1.name.compareTo(s2.name)<0){
                return -1;
            }else{
                if(s1.id>s2.id){
                    return 1;
                }else if(s1.id<s2.id){
                    return -1;
                }else{
                    return 0;
                }
            }
        }
    }
}

// this is main class 
class Solution {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        //inbuild PriorityQueue in java
        PriorityQueue<Student> pq=new PriorityQueue<>(new SComparator());
        
//first take then input n
        int n;
        n=s.nextInt();
        String check;
        String name;
        double cgpa;
        int id;
//run the loop for n times
        while(n-->0){
            check=s.next();
            if(check.charAt(0)=='E'){
                name=s.next();
                cgpa=s.nextDouble();
                id=s.nextInt();
                Student st=new Student(name,cgpa,id);
                pq.add(st);
                
            }else{
                Student st2=pq.remove();
                //System.out.println(st2.getName());
            }
        }
    //print Empty if PriorityQueue is empty
        if(pq.isEmpty()){
            System.out.println("EMPTY");
        }else{
            while(!pq.isEmpty()){
                Student st2=pq.remove();
                //print the name of the student
                System.out.println(st2.getName());
            }
        }
    }
}