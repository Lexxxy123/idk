/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtapi.plugin.tests.compounds;

import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTList;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.plugin.tests.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorTest
implements Test {
    @Override
    public void test() throws Exception {
        NBTList<Integer> testList = this.initIntegerList();
        IteratorTest.testIterator(testList.iterator());
        testList = this.initIntegerList();
        IteratorTest.testIterator(testList.listIterator());
    }

    private NBTList<Integer> initIntegerList() {
        NBTContainer comp = new NBTContainer();
        NBTList<Integer> list = comp.getIntegerList("test");
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        return list;
    }

    private static void testIterator(Iterator<Integer> iterator) {
        IteratorTest.assertTrue(iterator.hasNext());
        IteratorTest.assertTrue(iterator.next() == 1);
        IteratorTest.assertTrue(iterator.hasNext());
        IteratorTest.assertTrue(iterator.next() == 2);
        iterator.remove();
        IteratorTest.assertTrue(iterator.hasNext());
        IteratorTest.assertTrue(iterator.next() == 3);
        IteratorTest.assertTrue(iterator.hasNext());
        IteratorTest.assertTrue(iterator.next() == 4);
        IteratorTest.testNoMoreElements(iterator);
    }

    private static void testNoMoreElements(Iterator<Integer> iterator) {
        IteratorTest.assertTrue(!iterator.hasNext());
        try {
            iterator.next();
        } catch (NoSuchElementException expected) {
            return;
        } catch (Exception e2) {
            throw new NbtApiException("iterator threw wrong exception: " + e2.toString());
        }
        throw new NbtApiException("iterator did not throw exception");
    }

    private static void assertTrue(boolean condition) {
        if (!condition) {
            throw new NbtApiException("iterator test failed");
        }
    }
}

