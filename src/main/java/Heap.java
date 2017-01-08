import java.util.Objects;

/**
 * Created by Ryan on 2017-01-07.
 */
public class Heap {

    private Object[] heap = new Object[256];
    private int size;

    public Heap(){
        size = 0;
    }

    public Heap(Object cargo){
        heap[0] = cargo;
        size = 1;
    }

    public Heap(Object[] cargo){
        for(int i = 0;i < cargo.length;i++){
            heap[i] = cargo[i];
        }
        reheapify(0);
    }

    public Object getCargo(int index){
        return heap[index];
    }

    public void setCargo(int index, Object cargo){
        heap[index] = cargo;
    }

    public int getSize(){
        return size;
    }

    public Object[] getHeap(){
        return heap;
    }

    public int getLeft(int index){
        return index * 2 + 1;
    }

    public int getRight(int index){
        return index * 2 + 2;
    }

    public int getParent(int index){
        return index / 2;
    }

    public void add(Object cargo){
        heap[size] = cargo;
        reheapify(0);
        size++;
    }

    private void reheapAdd(int index){
        if(((Task)heap[index]).compareTo(heap[getParent(index)]) < 0){
            swap(index, getParent(index));
            if(getParent(index) != 0){
                reheapAdd(getParent(index));
            }
        }
    }

    private void reheapify(int index){
        if(((Task)heap[getLeft(index)]).compareTo(heap[getRight(index)]) < 0) {
            if (((Task)heap[index]).compareTo(heap[getLeft(index)]) < 0) {
                swap(index, getLeft(index));
            }
        } else {
            if(((Task)heap[index]).compareTo(heap[getRight(index)]) < 0){
                swap(index, getRight(index));
            }
        }

        if(index != size - 1 || index != size -2) {
            reheapify(getLeft(index));
            reheapify(getRight(index));
        }
    }

    public Object remove(){
        swap(0, size - 1);
        size--;
        reheapify(0);
        return heap[size];
    }

    private void swap(int index1, int index2){
        Object temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public void sort(){
        for(int i = 0;i < this.size;i++){
            remove();
        }
    }
}
