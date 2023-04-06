package com.sxw.learn.base;

public class Notepad <K, V>{
    private K key;
    private V val;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getVal() {
        return val;
    }

    public void setVal(V val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Notepad{" +
                "key=" + key +
                ", val=" + val +
                '}';
    }

    public static void main(String[] args) {
        Notepad<String, Integer> notepad = new Notepad<>();
        notepad.setKey("sxw");
        notepad.setVal(1);
        System.out.println(notepad);

        Notepad<Long, Long> notepad1 = new Notepad<>();
        notepad1.setKey(2L);
        notepad1.setVal(2L);
        System.out.println(notepad1);

    }
}
