import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.ArithmeticException;
public class Data {
    private
    String name,gender,status;
    double weight,height;
    int age;
    double bmr,bmi;

    public Data(){

    }

    public Data(String name, String gender,int age, double weight, double height,double bmr,double bmi, String status) {
        this.name=name;
        this.gender=gender;
        this.age=age;
        this.weight=weight;
        this.height=height;
        this.bmi=bmi;
        this.bmr=bmr;
        this.status=status;
    }
    public void setName(String name){
        this.name=name;
    }
    void setGender(String gender){
        this.gender=gender;
    }
    void setHeight(double height){
        this.height=height;
    }
    void setAge(int age){
        this.age=age;
    }
    void setWeight(double weight){
        this.weight=weight;
    }
    String getName(){
        return name;
    }
    String getGender(){
        return gender;
    }
    double getHeight(){
        return height;
    }
    double getWeight(){
        return weight;
    }
    int getAge(){
        return age;
    }
    String getStatus(){
        return status;
    }
    double getBmr(){
        return bmr;
    }
    double getBmi(){
        return bmi;
    }
  public void main_function(ArrayList <Data> list1,int n)throws InputMismatchException {
      String name,gender;
      double weight, height;
      int age;
      double totalBmrM = 0.0, totalBmrF = 0.0;
      double numOptimalWeightM = 0.0, numOptimalWeightF = 0.0;
      double avgBmrM=0.0, avgBmrF=0.0;
      double bmr, bmi;

      try {
          File file = new File("D://Advanced//data1.txt");
          FileWriter writer = new FileWriter(file,true);
          PrintWriter obj1=new PrintWriter(writer);
          obj1.println("Name\t\tAge\t\tWeight\t\tHeight\t\tGender\t\tBMR\t\t\tBMI\t\t\t\tStatus\n");
          for( int i=0;i<n;i++) {
              int j = i + 1;
              Scanner obj2 = new Scanner(System.in);
              System.out.println("entre the name " + j + ": ");
              name = obj2.next();
              System.out.println("entre the age " + j + ": ");
              age = obj2.nextInt();
              System.out.println("entre the gender " + j + ": ");
              gender = obj2.next();
              System.out.println("entre the weight " + j + ": ");
              weight = obj2.nextInt();
              System.out.println("entre the height " + j + ": ");
              height = obj2.nextInt();
              if (gender.equals("male")) {
                  bmr = 66 + 13.7 * weight + 5 * height - 6.8 * age;
              } else {
                  bmr = 655 + 9.6 * weight + 1.8 * height - 4.7 * age;
              }
              double lower=(height/100);
              double power=lower*lower;
              bmi = weight /power;

              String status;
              if (bmi < 18.5) {
                  status = "Underweight";
              }
              else if (bmi < 25) {
                  status = "Optimal weight";
                  if (gender.equals("male")) {
                      totalBmrM += bmr;
                      numOptimalWeightM++;

                  }
                  else {
                      totalBmrF += bmr;
                      numOptimalWeightF++;
                  } }
              else{
                      status = "overweight";
                  }

                  Data array1 = new Data(name, gender, age, weight, height, bmr, bmi, status);
                  list1.add(array1);
              }

              for (Data data : list1) {
                  obj1.println(data.getName() + "\t\t" + data.getAge() + "\t\t" + data.getWeight() + "\t\t\t" + data.getHeight() + "\t\t\t" + data.getGender() + "\t\t" + data.getBmr() + "\t" + data.getBmi() + "\t\t\t" + data.getStatus() + "\n");

              }
          obj1.close();

          FileOutputStream fout = new FileOutputStream("D://Advanced//report10.dat");
          DataOutputStream dout=new DataOutputStream(fout);
          double max_bmi=0;

          for (Data data : list1) {
              if(data.getBmi()>max_bmi) {
                  max_bmi= data.getBmi();
              }
          }
          for(Data data2:list1){
              if(data2.getBmi()==max_bmi){
                  System.out.println("the max BMI name is:"+data2.getName()+"\n"+"your age:"+data2.getAge()+"\n"+"the gender is:"+data2.getGender() +"\n"+"weight is:"+data2.getWeight()+"\n"+"height is:"+data2.getHeight());
                  dout.writeUTF(data2.getName() + "\t" + data2.getAge() + "\t" + data2.getGender() + "\t" + data2.getWeight() + "\t" + data2.getHeight() + "\n");
              }
          }

          if (numOptimalWeightM > 0) {
              avgBmrM = totalBmrM / numOptimalWeightM;
              dout.writeUTF("\nAverage BMR value for optimal weight males: \n"+ avgBmrM);
              System.out.println("the average BMR of the males are:"+avgBmrM);

          }
          if (numOptimalWeightF > 0) {
              avgBmrF = totalBmrF / numOptimalWeightF;
              dout.writeUTF("Average BMR value for optimal weight females: \n"+ avgBmrF);
            System.out.println("the average BMR of the Females are:"+avgBmrF);
          }
      }
      catch (IOException e) {
          System.out.println(e.getMessage());
      }
      catch (ArithmeticException t1){
          System.out.println(t1.toString());
      }

  }
}

