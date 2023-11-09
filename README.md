# REST API для вычисления частоты символов в строке

Этот REST API вычисляет частоту символов в заданной строке и возвращает результат, отсортированный по убыванию вхождений символов.

## API Endpoints

### Вычисление частоты символов

- **URL:** `/TestJobMG/charInStr`
- **Метод:** `GET`
- **Параметры:**
    - `inputString`: Строка для анализа частоты символов.

### Пример использования

Отправьте GET запрос на `http://localhost:8080/TestJobMG/charInStr?inputString=aaaaabcccc` для получения частоты символов.

### Ответ

API возвращает JSON ответ, содержащий частоту символов, отсортированную по убыванию, в формате:
"a":5, "c":4, "b":1

## Предварительные требования

- Java 8 или выше
- Spring Boot 2 или выше

## Как запустить

1. Клонируйте репозиторий: `git clone https://github.com/GlebMat/RestAPI.git`
2. Перейдите в директорию проекта.
3. Запустите приложение Spring Boot используя предпочтительный способ (например, через IDE или командой `./mvnw spring-boot:run` в терминале).

## Запуск тестов

- Для контроллеров и сервисных слоев доступны тесты.
- Для запуска тестов воспользуйтесь вашей IDE или выполните команду `./mvnw test` в директории проекта.