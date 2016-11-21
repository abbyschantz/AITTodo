package aschantz.aittodo.adapter;

/**
 * Created by aschantz on 10/17/16.
 */

//interface just contains methods but we don't implement those methods
    //other classes implement the interface and then they implement the methods

//how we will get notified about the changes
public interface TodoTouchHelperAdapter {

    //don't need to implement the method because its an interface
    void onItemDismiss(int position);

    void onItemMove(int fromPosition, int toPosition);


}
