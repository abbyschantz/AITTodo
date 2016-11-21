package aschantz.aittodo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aschantz.aittodo.R;
import aschantz.aittodo.data.Todo;

/**
 * Created by aschantz on 10/13/16.
 */
public class TodoRecyclerAdapter extends RecyclerView.Adapter<TodoRecyclerAdapter.ViewHolder> implements TodoTouchHelperAdapter {

    private List<Todo> todoList;

    public TodoRecyclerAdapter() {
        //for sugar
        todoList = Todo.listAll(Todo.class);

        //from before
//        todoList = new ArrayList<Todo>();
//
//        //populate the list with something
//        for (int i = 0; i < 20; i++){
//            todoList.add(new Todo("Todo" + i, false));
//        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //use the layout inflator and return a new holder with the inflator view
        View todoRow = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.todo_row, null, false);
        return new ViewHolder(todoRow);
    }

    //where we add the data to the rows
    //called by the system as many items Android wants to load in the memory
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cbDone.setChecked(todoList.get(holder.getAdapterPosition()).isDone());
        holder.tvTodo.setText(todoList.get(holder.getAdapterPosition()).getTodoTitle());

    }

    //returns how many items we have
    //if you leave this at 0, you will always have an empty list
    @Override
    public int getItemCount() {
        return todoList.size();
    }


    //remove item from object list and refresh recycler view with its location
    @Override
    public void onItemDismiss(int position) {
        //for sugar
        todoList.get(position).delete();

        todoList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
       // USING A FOR LOOP FOR POSITIONS
        //moves item down
//        if (fromPosition < toPosition) {
//            for (int i = fromPosition; i < toPosition; i++) {
//                Collections.swap(todoList, i, i + 1);
//            }
//        //otherwise
//        } else {
//            for (int i = fromPosition; i > toPosition; i--) {
//                Collections.swap(todoList, i, i - 1);
//            }
//        }

        //same as above but using add and remove
        todoList.add(toPosition, todoList.get(fromPosition));
        todoList.remove(fromPosition);

        notifyItemMoved(fromPosition, toPosition);

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private CheckBox cbDone;
        private TextView tvTodo;

        public ViewHolder(View itemView) {
            super(itemView);
            cbDone = (CheckBox) itemView.findViewById(R.id.cbDone);
            tvTodo = (TextView) itemView.findViewById(R.id.tvTodo);
        }
    }

    public void addTodo(Todo todo){
        todo.save(); //sugar
        todoList.add(0, todo);

        //refresh the whole list is:
        //notifyDataSetChanged();

        //if we were adding to bottom of the list, then it would be this:
        //notifyItemInserted(todoList.size()-1);
        notifyItemInserted(0);
    }
}
