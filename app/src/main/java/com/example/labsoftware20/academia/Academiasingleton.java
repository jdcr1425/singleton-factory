package com.example.labsoftware20.academia;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by labSoftware20 on 18/08/17.
 */
public class Academiasingleton {

    public Map<String, Object> memory ;

    private static Academiasingleton instance = null;

    private Academiasingleton() {
        memory = new HashMap<String,Object>();
    }

    public static Academiasingleton getInstance()
    {
        if (instance == null) {
            instance = new Academiasingleton();
        }
        return instance;
    }

}
