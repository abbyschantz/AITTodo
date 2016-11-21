package aschantz.aittodo.data;

import com.orm.SugarRecord;

/**
 * Created by aschantz on 10/13/16.
 */
public class Todo extends SugarRecord {

    private String todoTitle;
    private boolean done;

    //empty constructor
    public Todo() {

    }

    //command n, constructor, then select all.
    public Todo(String todoTitle, boolean done) {
        this.todoTitle = todoTitle;
        this.done = done;
    }

    //command n and then getters and settlers. Select all.
    public String getTodoTitle() {
        return todoTitle;
    }

    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
