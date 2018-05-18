package com.konovalov;

/**
 * MAIN
 */
public class App {
    public static void main(String[] args) {
        DbFlat db = new DbFlat();
        //Создать таблицу если нужно
        db.createTable();

        //Добавление тестовых квартир если нужно
         addDB(db);

        //удалить таблицу если нужно
        //   db.deleteTable();

//фильтр выборки не стал расспиисывать все запросы. просто  поменяйте условие
        String condition="id>2";
        db.getCityFilter(condition);

    }

    //Заполнение базы
    public static void addDB(DbFlat dbFlat) {
        dbFlat.add(new Flat("Dnepr", "Mira 30", 64.5, 4, 34000));
        dbFlat.add(new Flat("Dnepr", "Mira 31", 64.5, 3, 33000));
        dbFlat.add(new Flat("Dnepr", "Mira 32", 64.5, 4, 34000));
        dbFlat.add(new Flat("Dnepr", "Mira 33", 64.5, 2, 32000));
        dbFlat.add(new Flat("Dnepr", "Mira 34", 64.5, 1, 31000));
    }
}
