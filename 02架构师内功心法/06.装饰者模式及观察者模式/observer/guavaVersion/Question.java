package observer.guavaVersion;

public class Question {

    // 提问者姓名
    private String name;

    // 问题
    private String problem;

    //论坛名字
    private String comunityName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getComunityName() {
        return comunityName;
    }

    public void setComunityName(String comunityName) {
        this.comunityName = comunityName;
    }
}
