package ua.study.awesome.androidlessons.testtask_skysoft.hierarchy;

public abstract class Bird implements Animals {

    protected int age = 8;

    protected abstract void fly();

    @Override
    public int age() {
        return this.age;
    }

    @Override
    public String weight() {
        return null;
    }
}