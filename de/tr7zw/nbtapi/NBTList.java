/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtapi;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTType;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import de.tr7zw.nbtapi.utils.nmsmappings.ReflectionMethod;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public abstract class NBTList<T>
implements List<T> {
    private String listName;
    private NBTCompound parent;
    private NBTType type;
    protected Object listObject;

    protected NBTList(NBTCompound owner, String name, NBTType type, Object list) {
        this.parent = owner;
        this.listName = name;
        this.type = type;
        this.listObject = list;
    }

    public String getName() {
        return this.listName;
    }

    public NBTCompound getParent() {
        return this.parent;
    }

    protected void save() {
        this.parent.set(this.listName, this.listObject);
    }

    protected abstract Object asTag(T var1);

    @Override
    public boolean add(T element) {
        try {
            this.parent.getWriteLock().lock();
            if (MinecraftVersion.getVersion().getVersionId() >= MinecraftVersion.MC1_14_R1.getVersionId()) {
                ReflectionMethod.LIST_ADD.run(this.listObject, this.size(), this.asTag(element));
            } else {
                ReflectionMethod.LEGACY_LIST_ADD.run(this.listObject, this.asTag(element));
            }
            this.save();
            boolean bl2 = true;
            return bl2;
        } catch (Exception ex) {
            throw new NbtApiException(ex);
        } finally {
            this.parent.getWriteLock().unlock();
        }
    }

    @Override
    public void add(int index, T element) {
        try {
            this.parent.getWriteLock().lock();
            if (MinecraftVersion.getVersion().getVersionId() >= MinecraftVersion.MC1_14_R1.getVersionId()) {
                ReflectionMethod.LIST_ADD.run(this.listObject, index, this.asTag(element));
            } else {
                ReflectionMethod.LEGACY_LIST_ADD.run(this.listObject, this.asTag(element));
            }
            this.save();
        } catch (Exception ex) {
            throw new NbtApiException(ex);
        } finally {
            this.parent.getWriteLock().unlock();
        }
    }

    @Override
    public T set(int index, T element) {
        try {
            this.parent.getWriteLock().lock();
            Object prev = this.get(index);
            ReflectionMethod.LIST_SET.run(this.listObject, index, this.asTag(element));
            this.save();
            Object e2 = prev;
            return (T)e2;
        } catch (Exception ex) {
            throw new NbtApiException(ex);
        } finally {
            this.parent.getWriteLock().unlock();
        }
    }

    @Override
    public T remove(int i2) {
        try {
            this.parent.getWriteLock().lock();
            Object old = this.get(i2);
            ReflectionMethod.LIST_REMOVE_KEY.run(this.listObject, i2);
            this.save();
            Object e2 = old;
            return (T)e2;
        } catch (Exception ex) {
            throw new NbtApiException(ex);
        } finally {
            this.parent.getWriteLock().unlock();
        }
    }

    @Override
    public int size() {
        try {
            this.parent.getReadLock().lock();
            int n2 = (Integer)ReflectionMethod.LIST_SIZE.run(this.listObject, new Object[0]);
            return n2;
        } catch (Exception ex) {
            throw new NbtApiException(ex);
        } finally {
            this.parent.getReadLock().unlock();
        }
    }

    public NBTType getType() {
        return this.type;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void clear() {
        while (!this.isEmpty()) {
            this.remove(0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean contains(Object o2) {
        try {
            this.parent.getReadLock().lock();
            for (int i2 = 0; i2 < this.size(); ++i2) {
                if (!o2.equals(this.get(i2))) continue;
                boolean bl2 = true;
                return bl2;
            }
            boolean bl3 = false;
            return bl3;
        } finally {
            this.parent.getReadLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int indexOf(Object o2) {
        try {
            this.parent.getReadLock().lock();
            for (int i2 = 0; i2 < this.size(); ++i2) {
                if (!o2.equals(this.get(i2))) continue;
                int n2 = i2;
                return n2;
            }
            int n3 = -1;
            return n3;
        } finally {
            this.parent.getReadLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean addAll(Collection<? extends T> c2) {
        try {
            this.parent.getWriteLock().lock();
            int size = this.size();
            for (T ele : c2) {
                this.add(ele);
            }
            boolean bl2 = size != this.size();
            return bl2;
        } finally {
            this.parent.getWriteLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean addAll(int index, Collection<? extends T> c2) {
        try {
            this.parent.getWriteLock().lock();
            int size = this.size();
            for (T ele : c2) {
                this.add(index++, ele);
            }
            boolean bl2 = size != this.size();
            return bl2;
        } finally {
            this.parent.getWriteLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean containsAll(Collection<?> c2) {
        try {
            this.parent.getReadLock().lock();
            for (Object ele : c2) {
                if (this.contains(ele)) continue;
                boolean bl2 = false;
                return bl2;
            }
            boolean bl3 = true;
            return bl3;
        } finally {
            this.parent.getReadLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int lastIndexOf(Object o2) {
        try {
            this.parent.getReadLock().lock();
            int index = -1;
            for (int i2 = 0; i2 < this.size(); ++i2) {
                if (!o2.equals(this.get(i2))) continue;
                index = i2;
            }
            int n2 = index;
            return n2;
        } finally {
            this.parent.getReadLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean removeAll(Collection<?> c2) {
        try {
            this.parent.getWriteLock().lock();
            int size = this.size();
            for (Object obj : c2) {
                this.remove(obj);
            }
            boolean bl2 = size != this.size();
            return bl2;
        } finally {
            this.parent.getWriteLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean retainAll(Collection<?> c2) {
        try {
            this.parent.getWriteLock().lock();
            int size = this.size();
            for (Object obj : c2) {
                for (int i2 = 0; i2 < this.size(); ++i2) {
                    if (obj.equals(this.get(i2))) continue;
                    this.remove(i2--);
                }
            }
            boolean bl2 = size != this.size();
            return bl2;
        } finally {
            this.parent.getWriteLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean remove(Object o2) {
        try {
            this.parent.getWriteLock().lock();
            int size = this.size();
            int id = -1;
            while ((id = this.indexOf(o2)) != -1) {
                this.remove(id);
            }
            boolean bl2 = size != this.size();
            return bl2;
        } finally {
            this.parent.getWriteLock().unlock();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            private int index = -1;

            @Override
            public boolean hasNext() {
                return NBTList.this.size() > this.index + 1;
            }

            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return NBTList.this.get(++this.index);
            }

            @Override
            public void remove() {
                NBTList.this.remove(this.index);
                --this.index;
            }
        };
    }

    @Override
    public ListIterator<T> listIterator() {
        return this.listIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(final int startIndex) {
        final NBTList list = this;
        return new ListIterator<T>(){
            int index;
            {
                this.index = startIndex - 1;
            }

            @Override
            public void add(T e2) {
                list.add(this.index, e2);
            }

            @Override
            public boolean hasNext() {
                return NBTList.this.size() > this.index + 1;
            }

            @Override
            public boolean hasPrevious() {
                return this.index >= 0 && this.index <= NBTList.this.size();
            }

            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return NBTList.this.get(++this.index);
            }

            @Override
            public int nextIndex() {
                return this.index + 1;
            }

            @Override
            public T previous() {
                if (!this.hasPrevious()) {
                    throw new NoSuchElementException("Id: " + (this.index - 1));
                }
                return NBTList.this.get(this.index--);
            }

            @Override
            public int previousIndex() {
                return this.index - 1;
            }

            @Override
            public void remove() {
                list.remove(this.index);
                --this.index;
            }

            @Override
            public void set(T e2) {
                list.set(this.index, e2);
            }
        };
    }

    @Override
    public Object[] toArray() {
        try {
            this.parent.getReadLock().lock();
            Object[] ar2 = new Object[this.size()];
            for (int i2 = 0; i2 < this.size(); ++i2) {
                ar2[i2] = this.get(i2);
            }
            Object[] objectArray = ar2;
            return objectArray;
        } finally {
            this.parent.getReadLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public <E> E[] toArray(E[] a2) {
        try {
            this.parent.getReadLock().lock();
            Object[] ar2 = Arrays.copyOf(a2, this.size());
            Arrays.fill(ar2, null);
            Class<?> arrayclass = a2.getClass().getComponentType();
            for (int i2 = 0; i2 < this.size(); ++i2) {
                Object obj = this.get(i2);
                if (!arrayclass.isInstance(obj)) {
                    throw new ArrayStoreException("The array does not match the objects stored in the List.");
                }
                ar2[i2] = this.get(i2);
            }
            Object[] objectArray = ar2;
            return objectArray;
        } finally {
            this.parent.getReadLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        try {
            this.parent.getReadLock().lock();
            ArrayList list = new ArrayList();
            for (int i2 = fromIndex; i2 < toIndex; ++i2) {
                list.add(this.get(i2));
            }
            ArrayList arrayList = list;
            return arrayList;
        } finally {
            this.parent.getReadLock().unlock();
        }
    }

    public String toString() {
        try {
            this.parent.getReadLock().lock();
            String string = this.listObject.toString();
            return string;
        } finally {
            this.parent.getReadLock().unlock();
        }
    }
}

