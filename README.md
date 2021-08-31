# SimpleVkBot

Для развертывания бота на локальной машине необходимо:

1. Зарегистрировать уникальный ключ сообщества Вконтакте, Сообщество -> Настройки -> Работа с API
2. Установить ngrok и зарегистрировать аккаунт (подробнее тут https://tproger.ru/articles/ngrok-tutorial/)
3. В классе ApiConfig в поле FILE_PATH написать путь до директории с файлом config.txt
4. Создать артефакт проекта с помощью любого IDE или запустить напрямую из IDE
5. В файле config.txt заполнить поле с ключом и проверочным токеном полученным из Вконтакте, выбрать рабочий порт.
   Дополнительный текст заполнить по необходимости. Не используйте пробелы, параметры вписывайте внутри ковычек.
6. Запустить ngrok, настроить порты в соответствии с файлом config.txt
7. Вставить ссылку из ngrok в настройки группы вконтакте (Работа с API -> Callback API), выбрать версию API 5.101
8. Подтвердить адрес сервера
9. Выбрать пункт "Входящие сообщения" в настройках сервера вконтакте
10. Написать в личку группы, проверить его работоспособность
