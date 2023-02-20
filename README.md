# Описание работы с Appium + java + TestNg + Page Object

## Установка необходимого окружения на MacOS
* Качаем отсюда - https://github.com/appium/appium-inspector/releases программу для инспектора элементов для  iOS. Эта 
программа нужна, чтобы определить как получить доступ к тому или иному документу.

* Устанавливаем если нет Node js. Можно скачать по ссылке - https://nodejs.org/ru/#home-downloadhead
* Установить сам Appium 2 выполнив команду - npm i -g appium@next
* Установить Appium doctor для проверки всех зависимостей npm install -g appium-doctor 
* Проверить что еще не установлено командой appium-doctor --ios(--android для Android). Команда также скажет как
 что установить
* Обязательно установить драйвер для работы с appium - xcuitest. Это можно сделать командой appium driver install xcuitest
* Запускаем сервер Appium командой - appium server в консоле. Тогда по умолчанию он развернется по адресу:
 0.0.0.0:4723/wd/hub . Если нужно стартануть на своем адересе и порте то можно запустить команду:
 appium server -p 4723 -a 0.0.0.0 -pa /wd/hub . Сервер нужно стартовать каждый раз после запуска компьютера.
 * Проверить, что установлена самая последняя версия xCode
 * Инсепктор элементов нужно запустить из списка программ и далее прописать конфиг в программе до вашего Appium сервера
  и приложения с эмулятором. Параемтры конфига для дефолтного сервера:
   - Remote host: 127.0.0.1
   - Remote Path: wd/hub
   - Remote Port: 4723
   - Desired Capabilities:  
   {
                             "platformName": "iOS", 
                             "appium:platformVersion": "16.1", // версия iOs на эмуляторе
                             "appium:deviceName": "iPhone 14 Pro", // название эмулятора в xCode 
                             "appium:app": "/<path>/TestApp.app", // путь до тестового приложения
                             "appium:automationName": "xcuitest" // какой драйвер использовать для управления устр-ом
                           } 
* Тестовое приложение находится в папке app в корне проекта

* Основной тест написан в классе IOSCreateSessionTest . 

* Запуск Appium на реальном устройстве. 
Для этого понадобится само устройство, Xcode и действующая учетная запись разработчика Apple developer. (https://developer.apple.com/account)
* Прописываем Desired Capabilities для связи с телефоном:
{
  "platformName": "iOS",
  "appium:platformVersion": "15.7", // Версия реального устройства
  "appium:deviceName": "00008030-0018709E1166666", // UDID телефона
  "appium:automationName": "xcuitest",
  "appium:bundleId": "com.apple.mobilecal",// бандел тестируемого приложения. Или можно использовать проект в формате .ipa
  "appium:xcodeOrgId": "Y85X9MSDAR", //номер аккаунта разработчика (вязть отсюда https://developer.apple.com/account)
  "appium:xcodeSigningId": "iPhone Developer", //Можно что угодно прописать
  "appium:udid": "00008030-0018709E1166666"// UDID телефона
}

## Running Tests

* Can be run from IntelliJ the way tests normally are run
 
## Дополнительная информация
https://github.com/appium/java-client/blob/master/docs/Page-objects.md - тут расписано как для Java описывать элеиенты для PageObject (посик по элементу или найти все вхождения)
https://blog.testproject.io/2018/07/31/page-object-model-appium-java-android/ -  статья как правильно создать Page Object c примерами

Тут примеры кода на appium - https://github.com/appium/appium/tree/1.x/sample-code

Тут список свободно распрот=раняемых приложений для iOs, которые можно собрать в xCode и протестировать -
https://github.com/dkhamsing/open-source-ios-apps
