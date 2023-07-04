package ru.netology.tasks.services;

public class Epic extends Task {
    protected String[] subtasks = new String[0];

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (int i = 0; i < subtasks.length; i++) { // перебираем каждый элемент в массиве
            if (subtasks[i].contains(query)) {      // каждый элемент в массиве сравниваем с поисковым запросом
                return true;                        // если есть совпадение с одним из элементом в массиве, возвращаем положительный ответ
            }
        }
        return false;                               // если нет ни одного совпадения поискового запроса и элементами в масиве, возвращаем отрицательный ответ
    }
}
