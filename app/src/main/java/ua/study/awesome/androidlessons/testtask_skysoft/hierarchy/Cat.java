package ua.study.awesome.androidlessons.testtask_skysoft.hierarchy;

public abstract class Cat implements Animals {

    protected int age = 10;

    protected abstract void meow();

    @Override
    public int age() {
        return this.age;
    }

    @Override
    public String weight() {
        return null;
    }
}