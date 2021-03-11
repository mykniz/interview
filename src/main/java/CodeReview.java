//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
///*
//Рекомендуется использовать CamelCase стиль в наименовании интерфейса.
//Рекомендуется использовать прилагательное в наименовании данного интерфейса,
//так как он отвечает только за поведение (обновление информации onChange), например - Observable.
//Для использования модификатора доступа public необходимо интерфейс расположить в отдельном файле
// */
//public interface observable_listener {
//    void onChange(byte[] key, byte[] value);
//}
//
//
///*
//Для использования модификатора доступа public необходимо интерфейс расположить в отдельном файле.
//Название класса подразумевает имплементацию Map, однако имплементации нет.
//Возможно, необходимо другое название, например ObserveService
// */
//public abstract class ObservableArrayMap {
//
//    /*
//    Так как поле Collection<observable_listener> listeners однозначно инициализируется как ArrayList,
//    и вместо инициализации в конструкторе без параметров можно инициализировать его непосредственно после инстансцирования класса.
//    */
//    Collection<observable_listener> listeners;
//
//    //Так как использоована явная типизация объекта valueMap, дженереки из правой части можно убрать,
//    //то есть Map<byte[], byte[]> valueMap = new HashMap<>();
//    Map<byte[], byte[]> valueMap = new HashMap<byte[], byte[]>();
//
//
//    protected ObservableArrayMap() {
//        listeners = createListenersContainer();
//    }
//
//    /*
//    createListenersContainer похоже на избыточный метод для инициализации поля Collection<observable_listener> listeners;
//     */
//    protected Collection<observable_listener> createListenersContainer() {
//        return new ArrayList<observable_listener>();
//    }
//
//
//    public synchronized void addListener(observable_listener x) {
//        listeners.add(x);
//    }
//
//    public synchronized void removeListener(observable_listener x) {
//        listeners.remove(x);
//    }
//
//    /*
//    судя по логике работы метода, он обновляет данные для объекта listener
//    в случае совпадения текущих данных и ранее записанных valueMap.
//    поэтому вмето названия put лучше заменить на updateListener
//    */
//    public synchronized void put(byte[] key, byte[] value) {
//
//        //некорректная запись, чтобы получить записанные значения
//        // нужно изменить на byte[] oldValue = valueMap.get(key);
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