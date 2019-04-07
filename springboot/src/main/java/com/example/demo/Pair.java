package com.example.demo;


class Pair<T1,T2>
{
private T1 first;
private T2 second;
public Pair<T1,T2>father=null;

public Pair(){ first = null; second = null;}
public Pair(T1 first, T2 second) { this.first = first; this.second = second; }
public T1 getFirst() { return first; }
public T2 getSecond() { return second; }
public void setFirst(T1 newValue) { first = newValue; }
public void setSecond(T2 newValue) { second = newValue; }
public void setfather(Pair<T1,T2>temp) {father=temp; }

}