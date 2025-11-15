package todo.model;

public class Task{
    int id;
    String name;
    Priority priority;
    public Task(int id,String name,Priority priority) {
        this.id=id;
        this.name=name;
        this.priority=priority;
    }
    public int getId(){return id;
    }
    public void setId(int id){this.id=id;
    }
    public String getName(){return name;
    }
    public void setName(String name){this.name=name;
    }
    public Priority getPriority(){return priority;
    }
    public void setPriority(Priority priority)
    {
        this.priority=priority;
    }
}