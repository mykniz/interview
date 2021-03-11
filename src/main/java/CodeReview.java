//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//public class CodeReview {
//}
//
//
//public interface observable_listener {
//    void onChange(byte[] key, byte[] value);
//}
//
//public abstract class ObservableArrayMap {
//    Collection<observable_listener> listeners;
//    Map<byte[], byte[]> valueMap = new HashMap<byte[], byte[]>();
//
//    protected ObservableArrayMap() {
//        listeners = createListenersContainer();
//    }
//
//    protected Collection<observable_listener> createListenersContainer() {
//        return new ArrayList<observable_listener>();
//    }
//
//    public synchronized void addListener(observable_listener x) {
//        listeners.add(x);
//    }
//
//    public synchronized void removeListener(observable_listener x) {
//        listeners.remove(x);
//    }
//
//    public synchronized void put(byte[] key, byte[] value) {
//        byte[] oldValue = valueMap.put(key, value);
//        if (!hasChanges(oldValue, value)) {
//            for (observable_listener x : listeners) {
//                x.onChange(key, value);
//            }
//        }
//    }
//
//    protected abstract boolean hasChanges(byte[] oldValue, byte[] newValue);
//}