package fhict.org.nightofthenerds.UI;

import android.webkit.JavascriptInterface;

import java.util.ArrayList;

/**
 * Created by denis on 6/1/2018.
 */

public class BadgeList<E> extends ArrayList<E> {

    @JavascriptInterface
    @Override
    public int size() {
        return super.size();
    }

    @JavascriptInterface
    @Override
    public E get(int index) {
        return super.get(index);
    }

    @JavascriptInterface
    @Override
    public E set(int index, E element) {
        return super.set(index, element);
    }

    @JavascriptInterface
    @Override
    public boolean add(E e) {
        return super.add(e);
    }

    @JavascriptInterface
    @Override
    public void add(int index, E element) {
        super.add(index, element);
    }

    @Override
    public E remove(int index) {
        return super.remove(index);
    }
}
