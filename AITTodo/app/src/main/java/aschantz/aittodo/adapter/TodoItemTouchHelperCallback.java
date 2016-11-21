package aschantz.aittodo.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by aschantz on 10/17/16.
 */
public class TodoItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private TodoTouchHelperAdapter todoTouchHelperAdapter;

    //wrote the private above then command n, constructor and implemented it
    public TodoItemTouchHelperCallback(TodoTouchHelperAdapter todoTouchHelperAdapter) {
        this.todoTouchHelperAdapter = todoTouchHelperAdapter;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //sets what directions are allowed
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;

        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

        //send back message to adapter that location of todo items has been changed
        todoTouchHelperAdapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());

        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        todoTouchHelperAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }
}
