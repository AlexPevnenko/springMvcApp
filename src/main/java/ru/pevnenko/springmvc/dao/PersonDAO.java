package ru.pevnenko.springmvc.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import ru.pevnenko.springmvc.models.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Alex Pevnenko <Alex.pevnenko@gmail.com>
 * @version: v 1.0
 * @date: 14.05.2022
 */
@Component
public class PersonDAO{
    private static int PEOPLE_COUNT ;
    private final List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", 24, "tom@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 52, "bob@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 18, "mike@yahoo.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy", 34, "katy@gmail.com"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT );
        people.add(person);
    }

    public void update(int id,Person person){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
    }

    public void delete(int id){
        people.removeIf(p->p.getId() == id);
    }

}
