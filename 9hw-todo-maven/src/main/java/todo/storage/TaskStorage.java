package todo.storage;
import todo.model.*;
import java.util.*;

public class TaskStorage{
    static List<Task> tasks=new ArrayList<>();
    static int nextId=1;
    public static List<Task> getAll() {return tasks;
    }
    public static Task findById(int id)
    {
        return tasks.stream().filter(t->t.getId()==id).findFirst().orElse(null);
    }
    public static boolean existsByName(String name,Integer exclude){
        for(Task t:tasks)
            if(t.getName().equalsIgnoreCase(name)&&(exclude==null||t.getId()!=exclude))return true;
        return false;
    }
    public static Task addTask(String n,Priority p){
        if(existsByName(n,null))
            return null;
        Task t=new Task(nextId++,n,p);
        tasks.add(t);
        return t;
    }
    public static boolean updateTask(int id,String n,Priority p)
    {
        if(existsByName(n,id))return false;
        Task t=findById(id);
        if(t==null)return false;
        t.setName(n);
        t.setPriority(p);
        return true;
    }
    public static void deleteTask(int id){tasks.removeIf(t->t.getId()==id);
    }
}