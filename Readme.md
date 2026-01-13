# Task Tracker CLI (Java)

Простой консольный трекер задач, написанный на Java. Проект учебный и предназначен для практики работы с CLI, файлами и базовой архитектурой приложения.

---

## 📌 Возможности

* Добавление задачи
* Обновление задачи
* Удаление задачи
* Изменение статуса задачи (`todo`, `in-progress`, `done`)
* Просмотр всех задач
* Просмотр задач по статусу

Все задачи хранятся в файле `tasks.json` в текущей директории.

---

## 🧱 Структура проекта

```
TaskCli.java        // Точка входа, обработка CLI команд
TaskService.java    // Бизнес-логика
TaskStorage.java    // Работа с файлом tasks.json
Task.java           // Модель задачи
tasks.json          // Файл с задачами (создаётся автоматически)
```

---

## ⚙️ Требования

* Java 21+ (подойдёт Java 21–25)
* Консоль (Terminal / Command Prompt)

---

## 🚀 Сборка проекта

Перейдите в папку проекта и выполните:

```bash
javac *.java
```

---

## ▶️ Запуск

Общий формат команды:

```bash
java TaskCli <command> [arguments]
```

---

## 📖 Примеры использования

### Добавить задачу

```bash
java TaskCli add "Buy groceries"
```

Вывод:

```
Task added (ID: 1)
```

---

### Обновить задачу

```bash
java TaskCli update 1 "Buy groceries and cook dinner"
```

---

### Удалить задачу

```bash
java TaskCli delete 1
```

---

### Изменить статус

```bash
java TaskCli mark-in-progress 1
java TaskCli mark-done 1
```

---

### Показать все задачи

```bash
java TaskCli list
```

---

### Показать задачи по статусу

```bash
java TaskCli list todo
java TaskCli list in-progress
java TaskCli list done
```

---

## 📝 Формат задачи (tasks.json)

```json
{
  "id": 1,
  "description": "Buy groceries",
  "status": "todo",
  "createdAt": "2026-01-13T14:30:00",
  "updatedAt": "2026-01-13T14:30:00"
}
```

---

## ❗ Обработка ошибок

* Если команда или аргументы указаны неверно, программа выводит сообщение об ошибке
* Программа не падает при некорректном вводе
* Файл `tasks.json` создаётся автоматически при первом запуске

---

## 🎯 Цель проекта

Проект создан для: https://roadmap.sh/projects/task-tracker

* практики Java Core
* понимания работы CLI приложений
* работы с файлами
* базового разделения логики по классам

---
