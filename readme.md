# Тестовый пример работы с Hibernate

##### В данном примере показан пример создания связи с БД на уровне Hibernate

- Отношения один ко многим, один к одному, многие к многим в Hibernate
- Каскадирование: пример session.persist() указанием в родительской сущности @OneToMany(cascade =CascadeType.PERSIST)
- Создание сущностей: родительской, дочерней (@GeneratedValue, @SequenceGenerator - на выбор, в зависимости от выбора
  стратегии выставления ключа (PK))
- Обновление/удаление сущностей(добываем объект из БД session.get(object) и с помощью сеттеров меняем данные у объекта,
  для удаления используем метод session.delete(object))