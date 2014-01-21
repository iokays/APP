package com.iokays.app;

import java.util.Random;

/**
 * Created by andy on 14-1-19.
 */
public class R implements Comparable<R> {

    private static final Random RND = new Random();

    private Integer value;

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public int compareTo(R o) {
        return this.value - o.value;
    }


    public static R[] random() {
        R[] _arr = new R[100];
        for (int i = 0; i < _arr.length; ++i) {
            _arr[i] = new R();
            _arr[i].setValue(-1);
        }



        for (int i = 0; i < _arr.length; ++i) {
            int e = RND.nextInt(100);
            while (true) {
                if (-1 == _arr[e].getValue()) {
                    _arr[e].setValue(i);
                    break;
                }
                e = RND.nextInt(100);
            }
        }
        return _arr;
    }

    public static void print(R[] rs) {
        for (int i = 0; i < rs.length; ++i) {
            if (rs.length - 1 == i) {
                System.out.println(rs[i].getValue());
            } else {
                System.out.print(rs[i].getValue() + ", ");
            }

        }
    }

}
