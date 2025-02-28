// java.util.LinkedHashMap#get
public V get(Object key) {
    Node<K,V> e;
    if ((e = getNode(hash(key), key)) == null)
        return null;
    if (accessOrder)
        afterNodeAccess(e); // <-- [Here] : map.get( ) 호출 시 afterNodeAccess( ) 호출
    return e.value;
}

// java.util.LinkedHashMap#afterNodeAccess
void afterNodeAccess(Node<K,V> e) { // move node to last
    LinkedHashMap.Entry<K,V> last;
    if (accessOrder && (last = tail) != e) {
        ...
        ++modCount; // <-- [Here] : modCount 값을 증가시킨다.
    }
}

// java.util.LinkedHashMap.LinkedValueIterator#next
final class LinkedKeyIterator extends LinkedHashIterator
    implements Iterator<K> {
    public final K next() { return nextNode().getKey(); }  // <-- [Here] : nextNode( ) 호출
}

// java.util.LinkedHashMap.LinkedHashIterator#nextNode
final LinkedHashMap.Entry<K,V> nextNode() {
    LinkedHashMap.Entry<K,V> e = next;
    if (modCount != expectedModCount) // <-- [Here] : 증가된 modCount로 인해 Exception 발생
        throw new ConcurrentModificationException();
    if (e == null)
        throw new NoSuchElementException();
    current = e;
    next = e.after;
    return e;
}
