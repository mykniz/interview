import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NameStream {
    public static void main(String[] args) {

        List<WorkerClass> workerClassList1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            workerClassList1.add(new WorkerClass("Peter"));
        }
        for (int i = 0; i < 5; i++) {
            workerClassList1.add(new WorkerClass("lena"));
        }

        List<WorkerClass> workerClassList2 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            workerClassList2.add(new WorkerClass("Adolf"));
        }
        for (int i = 0; i < 2; i++) {
            workerClassList2.add(new WorkerClass("Leopold"));
        }

//---------------------------------first task---------------------------------------------------------------//

//        Organization organization1 = new OrgClass(workerClassList1);
//        Organization organization2 = new OrgClass(workerClassList2);
//        Stream<Organization> organizationStream = Stream.of(organization1, organization2);
//        uniqueNameStream(organizationStream).forEach(System.out::println);

//        static Stream<String> uniqueNameStream(Stream<Organization> organizationStream) {
//            return organizationStream.filter(l -> l.getWorkers().size() > 7)
//                    .flatMap(o -> o.getWorkers().stream())
//                    .map(Worker::getName)
//                    .distinct();
//
//        }

//---------------------------------second task---------------------------------------------------------------//

//        Organization organization1 = new OrgClass(1);
//        Organization organization2 = new OrgClass(2);
//        List<Organization> organizations = List.of(organization1, organization2);
//        Map<Integer, Organization> actual = organizations
//                .stream()
//                .collect(Collectors.toMap(Organization::getId, o -> o));
//
//        System.out.println(actual);

//---------------------------------third task---------------------------------------------------------------//

//        List<Worker> workers = new ArrayList<>();
//
//        for (int i = 1; i < 11; i++) {
//            workers.add(new WorkerClass("Peter", i));
//        }
//
//        String actual = workers.stream()
//                .sorted(Comparator.comparing(Worker::getPoints).reversed())
//                .limit(3)
//                .map(Worker::getName)
//                .collect(Collectors.joining(", "));
//
//        System.out.println(actual);
//    }

//---------------------------------forth task---------------------------------------------------------------//

//        List<Worker> workers = new ArrayList<>();
//
//        workers.add(new WorkerClass("Peter", "manager"));
//        workers.add(new WorkerClass("Sam", "manager"));
//        workers.add(new WorkerClass("John", "manager"));
//        workers.add(new WorkerClass("Manuel", "chef"));
//        workers.add(new WorkerClass("Rita", "accountant"));
//        workers.add(new WorkerClass("Alyona", "accountant"));


//        Map<String, List<Worker>> actual = workers.stream()
//                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.toList()));
//        System.out.println(actual);

//---------------------------------fifth task---------------------------------------------------------------//

//        Map<String, Long> actual2 = workers.stream()
//                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.counting()));
//        System.out.println(actual2);

//    }

//---------------------------------sixth task---------------------------------------------------------------//

        List<Worker> workers = new ArrayList<>();

        workers.add(new WorkerClass("manager", 10.5));
        workers.add(new WorkerClass( "chef",100.7));
        workers.add(new WorkerClass( "accountant",20.0));
        workers.add(new WorkerClass( "accountant",10.0));


        Map<String, Double> actual = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,Collectors.averagingDouble(Worker::getSalary)));
        System.out.println(actual);

    }

}


//*****************************************************************************************************//
interface Organization {

    int getId();

    List<Worker> getWorkers();
}


class OrgClass implements Organization {
    List workers;
    int id;

    public OrgClass(List workers) {
        this.workers = workers;
    }

    public OrgClass(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public List<Worker> getWorkers() {
        return workers;
    }
}

//********************************************************************************************//
interface Worker {

    String getName();

    int getPoints();

    String getPosition();

    double getSalary();
}


class WorkerClass implements Worker {

    String name;
    int points;
    String position;
    double salary;



    public WorkerClass(String name) {
        this.name = name;
    }

    public WorkerClass(int points) {
        this.points = points;
    }

    public WorkerClass(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public WorkerClass(String name, int points, String position) {
        this.name = name;
        this.points = points;
        this.position = position;
    }

    public WorkerClass(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public WorkerClass(String position, double salary) {
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
