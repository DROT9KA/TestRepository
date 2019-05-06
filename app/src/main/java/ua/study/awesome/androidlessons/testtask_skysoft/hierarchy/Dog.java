package ua.study.awesome.androidlessons.testtask_skysoft.hierarchy;

public abstract class Dog implements Animals {

    protected int age = 5;

    protected abstract void gav();

    @Override
    public int age() {
        return this.age;
    }

    @Override
    public String weight() {
        return null;
    }
}