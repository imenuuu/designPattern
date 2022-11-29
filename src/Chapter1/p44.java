package Chapter1;

class Professor{
    private Student student;
    public void setStudent(Student student){
        this.student = student;
        student.setAdvisor(this);
    }
    public void advise(){
        student.advise();
    }
}

class Student{
    private Professor advisor;

    public void advise() {
        System.out.println("상담중");
    }

    public void setAdvisor(Professor advisor) {
        this.advisor=advisor;
    }
}
public class p44 {
    public static void main(String[] args) {
        Professor HongGilDong=new Professor();
        Student Austin =new Student();

        HongGilDong.setStudent(Austin);
        HongGilDong.advise();
    }
}
