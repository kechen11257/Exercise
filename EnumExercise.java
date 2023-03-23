

public class EnumExercise{
    public static void main(String[]args){
        Week[] weeks = Week.values();
        for(Week week : weeks){
            System.out.println("All the information of weeks are below");
            System.out.println(week);
        }
    }
}

enum Week{
    MONDAY("Monday"), TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"), THURSDAY("Thursday"),
    FRIDAY("Friday"), SATURDAY("Saturday"), SUNDAY("Sunday");
    private String name;

    Week(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}


